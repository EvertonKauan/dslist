package com.praticas.dslist.controllers;

import com.praticas.dslist.dto.GameMinDTO;
import com.praticas.dslist.dto.ReplacementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.praticas.dslist.services.GameService;
import com.praticas.dslist.dto.GameListDTO;
import com.praticas.dslist.services.GameListService;
import java.lang.Long;
import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findGames(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByGameList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getSourceIndex());
    }
}
