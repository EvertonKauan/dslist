package com.praticas.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;


import com.praticas.dslist.repositories.GameListRepository;
import com.praticas.dslist.dto.GameListDTO;
import java.util.List;
import com.praticas.dslist.entities.GameList;
@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> list = result.stream().map(GameListDTO::new).collect(Collectors.toList());
    return list;}
}
