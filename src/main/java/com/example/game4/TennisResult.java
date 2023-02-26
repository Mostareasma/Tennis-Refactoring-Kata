package com.example.game4;

class TennisResult {
    String player1Score;
    String player2Score;

    TennisResult(String player1Score, String player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    String format() {
        if ("".equals(this.player2Score))
            return this.player1Score;
        if (player1Score.equals(player2Score))
            return player1Score + "-All";
        return this.player1Score + "-" + this.player2Score;
    }
}
