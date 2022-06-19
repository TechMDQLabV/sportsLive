package com.garguir.sportsLive.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketballGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Match ID")
    private Integer id;
    @JsonProperty("Away Score")
    private Integer awayScore;
    @JsonProperty("Away Team")
    private String awayTeam;
    @JsonProperty("Home Score")
    private Integer homeScore;
    @JsonProperty("Home Team")
    private String homeTeam;
    @JsonProperty("Initial Away Odd")
    private Float initialAwayOdd;
    @JsonProperty("Initial Home Odd")
    private Float initialHomeOdd;
    @JsonProperty("League")
    private String league;
    @JsonProperty("League ID")
    private Integer leagueId;
    @JsonProperty("Live Away Odd")
    private Float liveAwayOdd;
    @JsonProperty("Live Home Odd")
    private Float liveHomeOdd;
    @JsonProperty("Period 1 Away")
    private String periodOneAway;
    @JsonProperty("Period 1 Home")
    private String periodOneHome;
    @JsonProperty("Period 2 Away")
    private String periodTwoAway;
    @JsonProperty("Period 2 Home")
    private String periodTwoHome;
    @JsonProperty("Period 3 Away")
    private String periodThreeAway;
    @JsonProperty("Period 3 Home")
    private String periodThreeHome;
    @JsonProperty("Status")
    private String status;
}
