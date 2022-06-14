package com.garguir.sportsLive.controllers;

import com.garguir.sportsLive.services.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/sports")
public class SportsController {

    private final SportsService sportsService;

    @Autowired
    public SportsController(SportsService sportsService){
        this.sportsService = sportsService;
    }

    @GetMapping("/")
    public void getData() throws IOException, InterruptedException{
        this.sportsService.getSportGame();
    }
}
