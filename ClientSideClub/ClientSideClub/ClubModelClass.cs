using System.Runtime.Serialization;
namespace ApplicationBackend.Models
{
    [DataContract]
    public class ClubModelClass
    {
        [DataMember(Name = "id")]
        public int Id { get; set; }

        [DataMember(Name = "teamName")]
        public string TeamName { get; set; }

        [DataMember(Name = "clubValue")]
        public double ClubValue { get; set; }

        [DataMember(Name = "homeKitColour")]
        public string HomeKitColour { get; set; }

        [DataMember(Name = "awayKitColour")]
        public string AwayKitColour { get; set; }

        [DataMember(Name = "thirdKitColour")]
        public string ThirdKitColour { get; set; }

        [DataMember(Name = "premierLeague")]
        public int PremierLeague { get; set; }

        [DataMember(Name = "championsLeague")]
        public int ChampionsLeague { get; set; }

        [DataMember(Name = "faCup")]
        public int FaCup { get; set; }

        [DataMember(Name = "europaLeague")]
        public int EuropaLeague { get; set; }

        [DataMember(Name = "leagueCup")]
        public int LeagueCup { get; set; }


        public override string ToString()
        {
            return "Team Name: " + TeamName +
                   "\nClub Value: " + ClubValue +
                   "\nHome Kit: " + HomeKitColour +
                   "\nAway Kit: " + AwayKitColour +
                   "\nThird Kit: " + ThirdKitColour +
                   "\nPremier League: " + PremierLeague +
                   "\nChampions League: " + ChampionsLeague +
                   "\nFa Cup: " + FaCup +
                   "\nEuropa League: " + EuropaLeague +
                   "\nLeague Cup: " + LeagueCup + "\n";
        }


    }
}
