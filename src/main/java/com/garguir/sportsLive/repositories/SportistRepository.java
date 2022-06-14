package com.garguir.sportsLive.repositories;

import com.garguir.sportsLive.models.Sportist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SportistRepository extends JpaRepository<Sportist, Integer> {

    Sportist save(Sportist sportist);

    Optional<Sportist> findById(Integer id);

    List<Sportist> findAll();
}
