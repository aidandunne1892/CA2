using Microsoft.AspNetCore.Mvc;
using ApplicationBackend.Models;
using System.Collections.Generic;
using System.Linq;

namespace ApplicationBackend.Controllers
{
    [Produces("application/json")]
    [Route("api/Club")]
    [ApiController]										
    public class StockController : ControllerBase
    {
        private readonly ClubContext _context;          

        public StockController(ClubContext context)
        {
            _context = context;
        }

        // GET api/club/all
        [HttpGet("all")]
        public IEnumerable<ClubModelClass> GetAllClubs()
        {
            return _context.ClubModelClass.OrderBy(s => s.TeamName);
        }

        // GET: api/Club/Liverpool
        [HttpGet("{teamName:alpha}", Name = "GetClubByName")]
        [ProducesResponseType(400)]
        [ProducesResponseType(200)]
        public ActionResult<ClubModelClass> GetClubByName([FromRoute] string teamName)
        {
            // LINQ query, find matching club (case-insensitive) or default value (null) if none matching
            ClubModelClass club = _context.ClubModelClass.SingleOrDefault(l => l.TeamName.ToUpper() == teamName.ToUpper());
            if (club == null)
            {
                return NotFound();
            }
            else
            {
                return Ok(club);
            }
        }


        // DELETE api/Club/Chelsea
        [HttpDelete("{name:alpha}")]
        [ProducesResponseType(200)]             
        [ProducesResponseType(404)]             
        public ActionResult<ClubModelClass> DeleteClub([FromRoute] string name)
        {
            var team = _context.ClubModelClass.SingleOrDefault(l => l.TeamName.ToUpper() == name.ToUpper());
            if (team != null)
            {
                _context.ClubModelClass.Remove(team);
                _context.SaveChanges();            
                return Ok(team);                  
            }
            else
            {
                return NotFound();
            }
        }
    }
}
