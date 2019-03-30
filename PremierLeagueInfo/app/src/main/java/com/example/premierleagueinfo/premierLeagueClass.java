package com.example.premierleagueinfo;

public class premierLeagueClass {
    private String teamName;
    private long clubValue;
    private String homeKitColour;
    private String awayKitColour;
    private String thirdKitColour;
    private int premierLeague;
    private int championsLeague;
    private int faCup;
    private int europaLeague;
    private int leagueCup;


    public String toString()
    {
        return "Team Name: "+teamName + "\n"
                +"Home Kit: "+ homeKitColour+"\n"
                +"Away Kit: "+ awayKitColour+"\n"
                +"Third Kit: "+thirdKitColour+"\n"
                +"Club Value: £ "+ clubValue+"\n"
                +"Premier League's won: "+ premierLeague+"\n"
                +"Champions League's won:"+ championsLeague+"\n"
                +"Fa Cup Titles: "+ faCup+"\n"
                +"Europa League's won: "+ europaLeague+"\n"
                +"League cups won: "+ leagueCup+"\n";





    }

}
