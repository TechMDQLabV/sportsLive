package com.garguir.sportsLive.utils;

public enum SportUrl {
    FOOTBALL_LIVE("https://sports-live-scores.p.rapidapi.com/football/live"),
    BASKETBALL_LIVE("https://sports-live-scores.p.rapidapi.com/basketball/live");

    private String description;

    SportUrl(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
