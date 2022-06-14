package com.garguir.sportsLive.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.garguir.sportsLive.models.enums.GoalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("SOCCERPLAYER")
@Entity
public class SoccerPlayer extends Sportist{
    private Integer headerGoal;
    private Integer penaltyGoal;
    private Integer freeKickGoal;

    public Integer totalGoals(){
        return this.headerGoal + this.penaltyGoal + this.freeKickGoal;
    }

    public void addGoal(Integer goal, String type){
        if(type.equals(GoalType.HEADER_GOAL.getDescription())){
            this.headerGoal++;
        }else if(type.equals(GoalType.HEADER_GOAL.getDescription())){
            this.headerGoal++;
        }else{
            this.freeKickGoal++;
        }
    }
}
