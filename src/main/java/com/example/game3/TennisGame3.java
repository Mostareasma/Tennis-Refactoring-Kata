package com.example.game3;

import com.example.TennisGame;

public class TennisGame3 implements TennisGame {
    private int player1point;
    private int player2point;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (isDeuce()) {
            score = "Deuce";
        } else if (hasWinner()) {
            score = getWinner();
        } else if (hasAdvantage()) {
            score = getAdvantage();
        } else {
            score = getRegularScore();
        }
        return score;
    }

    private boolean isDeuce() {
        return player1point == player2point && player1point >= 3;
    }

    private boolean hasWinner() {
        return (player1point >= 4 || player2point >= 4) && Math.abs(player1point - player2point) >= 2;
    }

    private String getWinner() {
        return player1point > player2point ? "Win for " + player1Name : "Win for " + player2Name;
    }

    private boolean hasAdvantage() {
        return (player1point >= 4 || player2point >= 4) && Math.abs(player1point - player2point) == 1;
    }

    private String getAdvantage() {
        return player1point > player2point ? "Advantage " + player1Name : "Advantage " + player2Name;
    }

    private String getRegularScore() {
        String[] scores = new String[] { "Love", "Fifteen", "Thirty", "Forty" };
        String player1Score = scores[player1point];
        String player2Score = scores[player2point];
        return player1Score.equals(player2Score) ? player1Score + "-All" : player1Score + "-" + player2Score;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1point++;
        } else if (playerName.equals(player2Name)) {
            player2point++;
        }
    }
}
