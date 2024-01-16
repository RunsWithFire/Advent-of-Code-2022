import java.util.*;

class Day2 {
    public static void day2(List<String> input) {
        int score = 0;
        int gamescore;
        int playscore;
        for (String input_line : input) {
            gamescore = getGameScorePart2(input_line.charAt(2));
            playscore = determinePlayScore(input_line.charAt(0), input_line.charAt(2));
            score = score + gamescore + playscore;
        }
        System.out.println("Final Score: " + score);
    }

    // Used for Part 2
    private static int determinePlayScore(char player1, char player2) {
        switch (player1) {
            case 'A': //rock
                if (player2 == 'X') { //lose
                    return 3;
                } else if (player2 == 'Y') { //draw
                    return 1;
                } else { //win
                    return 2;
                }
            case 'B': //paper
                if (player2 == 'X') { //lose
                    return 1;
                } else if (player2 == 'Y') { //draw
                    return 2;
                } else { //win
                    return 3;
                }
            case 'C': //scissors
                if (player2 == 'X') { //lose
                    return 2;
                } else if (player2 == 'Y') { //draw
                    return 3;
                } else { //win
                    return 1;
                }
        }

        return 0;
    }

    // Used for Part 2
    private static int getGameScorePart2(char option) {
        switch (option) {
            case 'X':
                return 0; //lose
            case 'Y':
                return 3; //draw
            case 'Z':
                return 6; //win
        }
        return 0;
    }

    // Used for Part 1
    private static int getGameScore(char player1, char player2) {
        switch (player1) {
            case 'A':
                if (player2 == 'X') {
                    return 3;
                } else if (player2 == 'Y') {
                    return 6;
                } else {
                    return 0;
                }
            case 'B':
                if (player2 == 'X') {
                    return 0;
                } else if (player2 == 'Y') {
                    return 3;
                } else {
                    return 6;
                }
            case 'C':
                if (player2 == 'X') {
                    return 6;
                } else if (player2 == 'Y') {
                    return 0;
                } else {
                    return 3;
                }
        }

        return 0;
    }

    // Used for Part 1
    private static int getPlayScore(char choice) {
        switch (choice) {
            case 'X':
                return 1;
            case 'Y':
                return 2;
            case 'Z':
                return 3;
        }
        return 0;
    }
}