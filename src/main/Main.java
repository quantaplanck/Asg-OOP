package main;

import board.Board;

import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);

    public Main() {

        // game set up
        Board board = new Board();
        char isPlay = 'y';
        int max_moves = board.size * board.size;

        while (isPlay == 'y') {

            // round set up
            board.reset();
            boolean tied = true;
            int moves = 0;

            while (moves < max_moves) {

                // determine player's turn
                int turn = (moves % board.number_player) + 1;
                char symbol = board.players.get(turn - 1).symbol;

                // move set up
                board.display_board();
                int x, y;
                String row;

                do {
                    System.out.println("Player " + turn + " turn");
                    System.out.print("Enter move [x, y]: ");
                    x = sc.nextInt();
                    y = sc.nextInt();
                    row = board.square.get(y);

                // validate board is filled or out of bounds
                } while (row.charAt(x) != '-' || x < 0 || x >= board.size || y < 0 || y >= board.size);

                // fill board
                board.fill_board(x, y, symbol);

                // validate win
                if (board.validate(x, y, symbol)) {
                    System.out.println("Congratulations!! Player " + turn + " wins");
                    board.players.get(turn - 1).score++;
                    tied = false;
                    break;
                }

                moves++;
            }

            // end of round
            board.display_board();
            board.display_score();

            if (tied) System.out.println("No one wins!! All players TIED");

            do {
                System.out.print("Do you want to play again? [y/n]: ");
                isPlay = sc.next().charAt(0);
            } while (isPlay != 'y' && isPlay != 'n');
        }

        // end of game
        sc.close();
        System.out.print("Final ");
        board.display_score();
    }

    public static void main(String[] args) {
        new Main();
    }
}
