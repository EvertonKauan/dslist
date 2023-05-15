package com.praticas.dslist.repositories;

import com.praticas.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying //não é select, chama modify
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
