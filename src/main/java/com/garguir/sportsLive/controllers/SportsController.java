package com.garguir.sportsLive.controllers;

import com.garguir.sportsLive.models.BasketballGame;
import com.garguir.sportsLive.services.BackUpMatchesService;
import com.garguir.sportsLive.services.SportsService;
import com.garguir.sportsLive.utils.BackUpMatchUtil;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.garguir.sportsLive.utils.BackUpMatchUtil.setResponseHeader;

@RestController
@RequestMapping("/sports")
public class SportsController {

    private final SportsService sportsService;
    private final BackUpMatchesService backUpMatchesService;

    @Autowired
    public SportsController(SportsService sportsService, BackUpMatchesService backUpMatchesService){
        this.sportsService = sportsService;
        this.backUpMatchesService = backUpMatchesService;
    }

    @GetMapping("/basket")
    @Retry(name = "service2", fallbackMethod = "service1Fallback")
    @Operation(summary = "Find matches live")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",  description = "Found matches live", content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = BasketballGame.class))
            )),
            @ApiResponse(responseCode = "204", description = "No live matches", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content()})
    })
    public ResponseEntity<List<BasketballGame>> getData() throws IOException, InterruptedException{
        List<BasketballGame> matches = sportsService.getSportGames();
        if(matches.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        backUpMatchesService.addGame(matches.get(matches.size()-1));
        System.out.println(backUpMatchesService.findLast());

        return ResponseEntity.ok()
                .headers(setResponseHeader(Boolean.TRUE))
                .body(matches);
    }

    @GetMapping("/failed")
    @Retry(name = "service1", fallbackMethod = "service1Fallback")
    public ResponseEntity<List<BasketballGame>> failedRequest() throws IOException, InterruptedException{
        List<BasketballGame> matches = sportsService.getDataIfApiOff();
        if(matches.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok()
                .headers(setResponseHeader(Boolean.TRUE))
                .body(matches);
    }

    public ResponseEntity<List<BasketballGame>> service1Fallback(Exception e){
        List<BasketballGame> matches = new ArrayList<>();
        BasketballGame basketballGame = Optional.ofNullable(backUpMatchesService.findLast())
                .orElse(BackUpMatchUtil.getNewGame());

        matches.add(basketballGame);
        if(matches.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok()
                .headers(setResponseHeader(Boolean.FALSE))
                .body(matches);
    }
}
