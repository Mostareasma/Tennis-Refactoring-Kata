package com.example.game1;

import com.example.TennisGame;

public class TennisGame1 implements TennisGame {

    private int player1score = 0;
    private int player2score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName))
            player1score += 1;
        else
            player2score += 1;
    }

    public String getScore() {
        String score = "";
        if (player1score == player2score) {
            score = checkScoreIfDraw(player1score);
        } else if (player1score >= 4 || player2score >= 4) {
            score = handleAdvantageOrWinner();
        } else {
            score = scoreTextBuilder();
        }
        return score;
    }

    /**
     * Checks if the current score is Love-all , Fifteen-All , Thirty-All , or Deuce
     * and returns a string representation
     * 
     * @return a string representation
     */
    public String checkScoreIfDraw(int player1score) {
        switch (player1score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    /**
     * Handles the scoring when one player has an advantage over the other
     * 
     * And figures out the winner based on the given score
     * 
     * @return a String representing either advantage or winning depending on who
     *         has an advantage
     */

    public String handleAdvantageOrWinner() {
        int minusResult = player1score - player2score;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    /**
     * Returns a textual representation of the current score
     * 
     * @return a text version of the current score
     */
    public String scoreTextBuilder() {
        String scoreString = "";

        int tempScore = 0;
        for (int i = 1; i < 3; i++) {

            if (i == 1) {
                tempScore = player1score;
            } else {
                scoreString += '-';
                tempScore = player2score;
            }

            switch (tempScore) {
                case 0:
                    scoreString += "Love";
                    break;
                case 1:
                    scoreString += "Fifteen";
                    break;
                case 2:
                    scoreString += "Thirty";
                    break;
                case 3:
                    scoreString += "Forty";
                    break;
            }
        }

        return scoreString;
    }

}