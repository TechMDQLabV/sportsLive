package com.garguir.sportsLive.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garguir.sportsLive.models.BasketballGame;
import com.garguir.sportsLive.models.enums.SportUrl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SportsServiceImpl implements SportsService{

    @Override
    public List<BasketballGame> getSportGame() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SportUrl.BASKETBALL_LIVE.getDescription()))
                .header("X-RapidAPI-Key", "6047eaae07msh707eef4158d3589p15ac15jsn0974713630df")
                .header("X-RapidAPI-Host", "sports-live-scores.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        List<BasketballGame> games = Arrays.asList(mapper.readValue(response.body(), BasketballGame[].class));
        System.out.println(response.body());
        return games;
    }
}
