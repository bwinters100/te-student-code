package com.techelevator.controller;

import com.techelevator.dao.UserGameDao;
import com.techelevator.model.Summary;
import com.techelevator.model.UserGame;
import com.techelevator.service.ChatService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SummaryController {


    private final UserGameDao userGameDao;
    private final ChatService chatService;

    public SummaryController(UserGameDao userGameDao, ChatService chatService) {
        this.userGameDao = userGameDao;
        this.chatService = chatService;
    }


    @RequestMapping(path="/users/{id}/summary", method= RequestMethod.GET)
    public Summary getSummaryForUser(@PathVariable int id) {
        List<UserGame> games = userGameDao.getUserGamesByUserId(id, null , null);
        Summary summary = new Summary();
        summary.setGames(games);
        String analysis = chatService.getUserGameAnalysis(games);
        summary.setAnalysis(analysis);
        return summary;
    }
}
