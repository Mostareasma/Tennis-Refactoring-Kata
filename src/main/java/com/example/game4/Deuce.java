package com.example.game4;

class Deuce implements ResultProvider {
    private final TennisGame4 game;
    private int player1Score;
    private int player2Score;

    public Deuce(TennisGame4 game, int player1Score, int player2Score) {
        this.game = game;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    @Override
    public TennisResult getResult() {
    //     if (isDeuce())
            return new TennisResult("Deuce", "");
        // return null;
    }

    // boolean isDeuce() {
    //     return player1Score >= 3 && player2Score >= 3 && (player1Score == player2Score);
    // }
}
