package com.example.game2;

import com.example.TennisGame;

public class TennisGame2 implements TennisGame {
    private int player1point = 0;
    private int player2point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String player) {
        if (player.equals("player1")) {
            player1point++;
        } else {
            player2point++;
        }
    }

    public String getScore() {
        if (player1point == player2point) {
            return getEvenScore();
        } else if (player1point >= 4 || player2point >= 4) {
            return getAdvantageOrWin();
        } else {
            return getPlayerScore(player1point) + "-" + getPlayerScore(player2point);
        }
    }

    private String getEvenScore() {
        if (player1point < 3) {
            return getPlayerScore(player1point) + "-All";
        } else {
            return "Deuce";
        }
    }

    private String getAdvantageOrWin() {
        int scoreDiff = player1point - player2point;
        String leadingPlayer = (scoreDiff > 0) ? player1Name : player2Name;
        if (Math.abs(scoreDiff) == 1) {
            return "Advantage " + leadingPlayer;
        } else {
            return "Win for " + leadingPlayer;
        }
    }

    private String getPlayerScore(int playerPoint) {
        switch (playerPoint) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                throw new IllegalArgumentException("Invalid player point: " + playerPoint);
        }
    }
}
