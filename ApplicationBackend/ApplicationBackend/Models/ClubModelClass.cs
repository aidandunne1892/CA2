using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

/// <summary>
/// This Class is just a base class for us to use,
/// I've put everything that I think we may have in every model class we will have.
/// 
/// </summary>


namespace ApplicationBackend.Models
{
    public class ClubModelClass
    {
        [Required]
        [Key] //primary key
        public int Id { get; set; }
        
        [Required]
        public string TeamName { get; set; }

        public double ClubValue { get; set; }

        [Required]
        public string HomeKitColour { get; set; }

        [Required]
        public string AwayKitColour { get; set; }

        public string ThridKitColour { get; set; }

        [Required]
        [Range(0,30)]
        public int PremierLeague { get; set; }

        [Required]
        [Range(0, 30)]
        public int ChampionsLeague { get; set; }
        [Required]
        [Range(0, 30)]
        public int FaCup { get; set; }

        [Required]
        [Range(0, 30)]
        public int EuropaLeague { get; set; }


        [Required]
        [Range(0, 30)]
        public int LeagueCup { get; set; }


    }
}
