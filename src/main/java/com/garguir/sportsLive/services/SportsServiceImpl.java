package com.garguir.sportsLive.services;

import com.garguir.sportsLive.models.BasketballGame;
import com.garguir.sportsLive.utils.JsonBodyHandler;
import com.garguir.sportsLive.utils.SportUrl;
import com.garguir.sportsLive.utils.SportsResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class SportsServiceImpl implements SportsService{

    @Override
    public List<BasketballGame> getSportGames() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SportUrl.BASKETBALL_LIVE.getDescription()))
                .header("X-RapidAPI-Key", "6047eaae07msh707eef4158d3589p15ac15jsn0974713630df")
                .header("X-RapidAPI-Host", "sports-live-scores.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<SportsResponse> response = HttpClient.newHttpClient().send(request, new JsonBodyHandler<>(SportsResponse.class));

        return response.body().getMatches();
    }

    @Override
    public List<BasketballGame> getDataIfApiOff() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SportUrl.BASKETBALL_LIVE.getDescription()))
                .header("X-RapidAPI-Key", "6047eaae07msh707eef4158d3589p15ac15jsn0974713630dfa")
                .header("X-RapidAPI-Host", "sports-live-scores.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<SportsResponse> response = HttpClient.newHttpClient().send(request, new JsonBodyHandler<>(SportsResponse.class));

        return response.body().getMatches();
    }
}
