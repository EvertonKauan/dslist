package com.praticas.dslist.services;

import com.praticas.dslist.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praticas.dslist.repositories.GameListRepository;
import com.praticas.dslist.dto.GameListDTO;
import com.praticas.dslist.entities.GameList;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
        //List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
