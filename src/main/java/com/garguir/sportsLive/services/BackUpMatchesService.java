package com.garguir.sportsLive.services;

import com.garguir.sportsLive.exceptions.NotFoundException;
import com.garguir.sportsLive.models.BasketballGame;
import com.garguir.sportsLive.repositories.BackUpMatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackUpMatchesService {
    @Autowired
    private BackUpMatchesRepository backUpMatchesRepository;

    public BasketballGame addGame(BasketballGame basketballGame){
        return backUpMatchesRepository.save(basketballGame);
    }

    public BasketballGame findLast(){
        return backUpMatchesRepository.findTopByOrderByIdDesc()
                .orElse(null);
                //.orElseThrow(() -> new NotFoundException("Not found match"));
    }
}
