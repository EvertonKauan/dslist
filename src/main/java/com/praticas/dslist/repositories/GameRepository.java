package com.praticas.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.praticas.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
