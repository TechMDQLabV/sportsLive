package com.garguir.sportsLive.utils;

import com.garguir.sportsLive.models.BasketballGame;

import org.springframework.http.HttpHeaders;

public class BackUpMatchUtil {

    public static BasketballGame getNewGame(){
            return new BasketballGame().builder()
                .id(1)
                .awayScore(15)
                .awayTeam("Peñarol")
                .homeScore(10)
                .homeTeam("Quilmes")
                .initialAwayOdd(1.15f)
                .initialHomeOdd(1.10f)
                .league("Liga Nacional")
                .leagueId(1)
                .liveAwayOdd(0.15f)
                .liveHomeOdd(0.10f)
                .periodOneAway("1A")
                .periodOneHome("1H")
                .periodTwoAway("2A")
                .periodTwoHome("2H")
                .periodThreeAway("3A")
                .periodThreeHome("3H")
                .status("GOOD")
                .build();
    }

    public static HttpHeaders setResponseHeader(Boolean ok){
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("apiResponseOk", ok.toString());
        return responseHeader;
    }
}
