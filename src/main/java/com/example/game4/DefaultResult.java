package com.example.game4;

class DefaultResult implements ResultProvider {

    private static final String[] scores = { "Love", "Fifteen", "Thirty", "Forty" };

    private final TennisGame4 game;

    public DefaultResult(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult(scores[game.player1Score], scores[game.player2Score]);
    }
}