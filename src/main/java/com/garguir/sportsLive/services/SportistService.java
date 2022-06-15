package com.garguir.sportsLive.services;

import com.garguir.sportsLive.exceptions.NotFoundException;
import com.garguir.sportsLive.models.Sportist;
import com.garguir.sportsLive.repositories.SportistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportistService {

    @Autowired
    private SportistRepository sportistRepository;

    public Sportist addSportist(Sportist sportist){
        return sportistRepository.save(sportist);
    }

    public Sportist findById(Integer id){
        return sportistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not exist"));
    }

    public List<Sportist> findAll(){
        return sportistRepository.findAll();
    }
}
