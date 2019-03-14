using Microsoft.AspNetCore.Mvc;
using ApplicationBackend.Models;
using System.Collections.Generic;
using System.Linq;

// Add-Migration InitialCreate
// Update-Database

namespace ApplicationBackend.Controllers
{
    [Produces("application/json")]
    [Route("api/Club")]
    [ApiController]										
    public class ClubController : ControllerBase
    {
        private readonly ClubContext _context;          

        public ClubController(ClubContext context)
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


        // GET: api/Club/TotalTrophyCount/Liverpool
        [HttpGet("TotalTrophyCount/{teamName:alpha}")]
        [ProducesResponseType(404)]
        [ProducesResponseType(200)]
        public ActionResult<double> GetTotalNumberOfTrophies(string teamName)
        {

            var team = _context.ClubModelClass.FirstOrDefault(p => (p.TeamName == teamName.ToUpper()));
            var prem = team.PremierLeague;
            var champ = team.ChampionsLeague;
            var facup = team.FaCup;
            var europa = team.EuropaLeague;
            var leaguecup = team.LeagueCup;

            double TrophyCount = prem + champ + facup + europa + leaguecup;
            if (team != null)
            {
                return Ok(TrophyCount);
            }
            else
            {
                return NotFound();
            }
        }

        // GET: api/Club/PremierLeagueCount/Liverpool
        [HttpGet("PremierLeagueCount/{teamName:alpha}")]
        [ProducesResponseType(404)]
        [ProducesResponseType(200)]
        public ActionResult<double> GetTotalPremierLeague(string teamName)
        {

            var team = _context.ClubModelClass.FirstOrDefault(p => (p.TeamName == teamName.ToUpper()));
            var prem = team.PremierLeague;

            if (team != null)
            {
                return Ok(prem);
            }
            else
            {
                return NotFound();
            }
        }


        // GET: api/Club/ChampionsLeagueCount/Liverpool
        [HttpGet("ChampionsLeagueCount/{teamName:alpha}")]
        [ProducesResponseType(404)]
        [ProducesResponseType(200)]
        public ActionResult<double> GetTotalChampionsLeague(string teamName)
        {

            var team = _context.ClubModelClass.FirstOrDefault(p => (p.TeamName == teamName.ToUpper()));
            var champ = team.ChampionsLeague;

            if (team != null)
            {
                return Ok(champ);
            }
            else
            {
                return NotFound();
            }
        }


        // GET: api/Club/FaCupCount/Liverpool
        [HttpGet("FaCupCount/{teamName:alpha}")]
        [ProducesResponseType(404)]
        [ProducesResponseType(200)]
        public ActionResult<double> GetTotalFaCup(string teamName)
        {

            var team = _context.ClubModelClass.FirstOrDefault(p => (p.TeamName == teamName.ToUpper()));
            var facup = team.FaCup;

            if (team != null)
            {
                return Ok(facup);
            }
            else
            {
                return NotFound();
            }
        }


        // GET: api/Club/EuropaLeagueCount/Liverpool
        [HttpGet("EuropaLeagueCount/{teamName:alpha}")]
        [ProducesResponseType(404)]
        [ProducesResponseType(200)]
        public ActionResult<double> GetTotalEuropaLeague(string teamName)
        {

            var team = _context.ClubModelClass.FirstOrDefault(p => (p.TeamName == teamName.ToUpper()));
            var europa = team.EuropaLeague;
 
            if (team != null)
            {
                return Ok(europa);
            }
            else
            {
                return NotFound();
            }
        }

        // GET: api/Club/LeagueCupCount/Liverpool
        [HttpGet("LeagueCupCount/{teamName:alpha}")]
        [ProducesResponseType(404)]
        [ProducesResponseType(200)]
        public ActionResult<double> GetTotalLeagueCup(string teamName)
        {

            var team = _context.ClubModelClass.FirstOrDefault(p => (p.TeamName == teamName.ToUpper()));
            var leaguecup = team.LeagueCup;

            if (team != null)
            {
                return Ok(leaguecup);
            }
            else
            {
                return NotFound();
            }
        }

    }
}
