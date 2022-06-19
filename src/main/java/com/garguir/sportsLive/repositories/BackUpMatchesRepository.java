package com.garguir.sportsLive.repositories;

import com.garguir.sportsLive.models.BasketballGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackUpMatchesRepository extends JpaRepository<BasketballGame, Integer> {

    BasketballGame save(BasketballGame basketballGame);
    Optional<BasketballGame> findTopByOrderByIdDesc();
}
