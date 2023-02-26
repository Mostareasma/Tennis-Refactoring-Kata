package com.example.game4;

class WinPlayer implements ResultProvider {
    private final TennisGame4 game;
    private int player1Score;
    private int player2Score;

    public WinPlayer(TennisGame4 game, int player1Score, int player2Score) {
        this.game = game;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    @Override
    public TennisResult getResult() {
        // if (hasWinner())
            return new TennisResult("Win for " + getWinner(), "");
        // return null;
    }

    // boolean hasWinner() {
    //     return (player1Score >= 4 || player2Score >= 4) && Math.abs(player1Score - player2Score) >= 2;

    // }

    String getWinner() {
        String winner = (player1Score > player2Score) ? game.player1 : game.player2;
        return winner;

    }
}
