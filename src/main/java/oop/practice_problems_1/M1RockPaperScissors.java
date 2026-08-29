package oop.practice_problems_1;

import java.util.Random;
import java.util.Scanner;

public class M1RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    static String generateComputerMove() {

        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        return moves[random.nextInt(3)];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        for (int i = 0; i < rounds; i++) {

            System.out.print("Round " + (i + 1)
                    + " - Enter Rock, Paper, or Scissors: ");

            playerMoves[i] = scanner.nextLine();

            computerMoves[i] = generateComputerMove();

            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);
            System.out.println();
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("--------- Final Summary ---------");
        System.out.println("Round | Player Move | Computer Move | Result");

        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + "     | "
                    + playerMoves[i] + "       | "
                    + computerMoves[i] + "        | "
                    + results[i]);
        }

        System.out.println("--------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        scanner.close();
    }
}