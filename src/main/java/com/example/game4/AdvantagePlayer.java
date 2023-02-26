package com.example.game4;

class AdvantagePlayer implements ResultProvider {
    private final TennisGame4 game;
    private int player1Score;
    private int player2Score;

    public AdvantagePlayer(TennisGame4 game, int player1Score, int player2Score) {
        this.game = game;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    @Override
    public TennisResult getResult() {
        // if (hasAdvantage())
            return new TennisResult("Advantage " + getAdvantage(), "");
        // return null;
    }

    // boolean hasAdvantage() {
    //     return (player1Score >= 4 || player2Score >= 4) && Math.abs(player1Score - player2Score) < 2;

    // }

    String getAdvantage() {
        String Advantage = (player1Score > player2Score) ? game.player1 : game.player2;
        return Advantage;

    }
}
