package com.garguir.sportsLive.services;

import com.garguir.sportsLive.models.BasketballGame;

import java.io.IOException;
import java.util.List;

public interface SportsService {

    List<BasketballGame> getSportGame() throws IOException, InterruptedException;
}
