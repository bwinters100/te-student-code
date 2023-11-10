package com.techelevator.model;

import java.util.List;

public class Summary {

    private List<UserGame> games;
    private String analysis;


    public Summary() {
    }


    public List<UserGame> getGames() {
        return games;
    }

    public void setGames(List<UserGame> games) {
        this.games = games;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}
