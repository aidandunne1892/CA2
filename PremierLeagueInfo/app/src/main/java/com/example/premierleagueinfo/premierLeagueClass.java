package com.example.premierleagueinfo;

public class premierLeagueClass {
    private String teamName;
    private int clubValue;
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
        return "Team Name: "+teamName + "\n "
                +"Home Kit: "+ homeKitColour+"\n"
                +"Away Kit: "+ awayKitColour+"\n"
                +"Club Value: "+ clubValue+"\n";
    }

}
