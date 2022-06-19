package com.garguir.sportsLive.services;

import com.garguir.sportsLive.models.BasketballGame;
import com.garguir.sportsLive.models.Matches;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public interface SportsService {

    HttpResponse<Matches> getSportGame() throws IOException, InterruptedException;
}
