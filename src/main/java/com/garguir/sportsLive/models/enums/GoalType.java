package com.garguir.sportsLive.models.enums;

public enum GoalType {
    HEADER_GOAL("Cabeza"),
    PENALTY_GOAL("Penal"),
    FREE_KICK_GOAL("Tiro Libre");

    private String description;

    GoalType(String description){
        this.description = description;
    }

    public static GoalType find(final String value){
        for(GoalType v:values()){
            if(v.toString().equalsIgnoreCase(value)){
                return v;
            }
        }
        throw new IllegalArgumentException((String.format("Invalid TypeGoal: %s", value)));
    }

    public String getDescription(){
        return description;
    }
}
