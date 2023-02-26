package com.example.game4;

import com.example.TennisGame;

public class TennisGame4 implements TennisGame {

    int player1Score;
    int player2Score;
    String player1;
    String player2;

    public TennisGame4(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void wonPoint(String playerName) {
        if (player1.equals(playerName))
            this.player1Score += 1;
        else
            this.player2Score += 1;
    }

    /**
     * 
     * Each method checks its conditions.
     * If it matches it returns the results
     * 
     */

    @Override
    public String getScore() {
        TennisResult result = null;
        result = (isDeuce()) ? new Deuce(this, player1Score, player2Score).getResult()
                : (hasWinner()) ? new WinPlayer(this, player1Score, player2Score).getResult()
                        : (hasAdvantage()) ? new AdvantagePlayer(this, player1Score, player2Score).getResult()
                                : new DefaultResult(this).getResult();

        return result.format();
    }

    boolean hasAdvantage() {
        return (player1Score >= 4 || player2Score >= 4) && Math.abs(player1Score - player2Score) < 2;

    }

    boolean hasWinner() {
        return (player1Score >= 4 || player2Score >= 4) && Math.abs(player1Score - player2Score) >= 2;
    }

    boolean isDeuce() {
        return player1Score >= 3 && player2Score >= 3 && (player1Score == player2Score);
    }
}
