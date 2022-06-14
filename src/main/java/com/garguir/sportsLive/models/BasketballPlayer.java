package com.garguir.sportsLive.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("SOCCERPLAYER")
@Entity
public class BasketballPlayer extends Sportist{
    private Integer points;
    private Integer rebounds;

    public void addPoints(Integer points){
        this.points+=points;
    }
}
