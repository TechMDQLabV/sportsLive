package com.garguir.sportsLive.controllers;

import com.garguir.sportsLive.models.Sportist;
import com.garguir.sportsLive.services.SportistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sportist")
public class SportistController {

    @Autowired
    private SportistService sportistService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Sportist addSportist(@RequestBody final Sportist sportist){
        return sportistService.addSportist(sportist);
    }

    public Sportist getById(@PathVariable("id") Integer id){
        return sportistService.findById(id);
    }

    @GetMapping("/")
    public List<Sportist> getAll(){
        return sportistService.findAll();
    }
}
