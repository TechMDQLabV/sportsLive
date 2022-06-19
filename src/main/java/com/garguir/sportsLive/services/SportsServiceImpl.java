package com.garguir.sportsLive.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garguir.sportsLive.models.BasketballGame;
import com.garguir.sportsLive.models.Matches;
import com.garguir.sportsLive.utils.JsonBodyHandler;
import com.garguir.sportsLive.utils.SportUrl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class SportsServiceImpl implements SportsService{

    @Override
    public HttpResponse<Matches> getSportGame() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SportUrl.BASKETBALL_LIVE.getDescription()))
                .header("X-RapidAPI-Key", "6047eaae07msh707eef4158d3589p15ac15jsn0974713630df")
                .header("X-RapidAPI-Host", "sports-live-scores.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Matches> response = HttpClient.newHttpClient().send(request, new JsonBodyHandler<>(Matches.class));

        return response;
    }
}
