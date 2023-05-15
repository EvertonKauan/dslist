package com.praticas.dslist.services;

import com.praticas.dslist.projections.GameMinProjection;
import com.praticas.dslist.repositories.GameRepository;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> list = result.stream().map(GameListDTO::new).collect(Collectors.toList());
    return list;
    }


    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i<= max; i ++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
