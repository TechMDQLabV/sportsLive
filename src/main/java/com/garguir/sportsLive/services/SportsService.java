package com.garguir.sportsLive.services;

import com.garguir.sportsLive.models.BasketballGame;

import java.io.IOException;
import java.util.List;

public interface SportsService {

    public List<BasketballGame> getSportGames() throws IOException, InterruptedException;

    public BasketballGame getDataIfApiOff() throws IOException, InterruptedException;
}
