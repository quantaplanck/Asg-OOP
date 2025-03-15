package board;

import player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    char[] symbols = {'O', 'X', 'V', 'M'};                  // 4 players symbol determine
    public ArrayList<Player> players = new ArrayList<>();   // list of players
    public ArrayList<String> square = new ArrayList<>();    // square
    public int size;                                        // size of square
    public int to_win;                                      // n symbols aligned to win
    public int max_players;                                 // max players determined by board size
    public int number_player;                               // players

    // constructor
    public Board() {
        Scanner sc = new Scanner(System.in);

        // user input board size
        do {
            System.out.print("Enter board size [3-15]: ");
            this.size = sc.nextInt();
        } while (size < 3 || size > 15);

        // set max player and win condition
        if (size <= 4) {
            this.max_players = 2;
            this.to_win = 3;
        } else if (size <= 7) {
            this.max_players = 3;
            this.to_win = 4;
        } else {
            this.max_players = 4;
            this.to_win = 5;
        }

        // user input players number
        if (this.max_players == 2) this.number_player = 2;
        else {
             do {
                System.out.print("Enter number of players [2 - " + this.max_players + "]: ");
                this.number_player = sc.nextInt();
            } while (this.number_player < 2 || this.number_player > this.max_players);
        }

        for (int i = 0; i < this.number_player; i++) {
            this.players.add(new Player(this.symbols[i]));
        }
    }

    // clear the board and set the default
    public void reset() {
        this.square.clear();
        for (int i = 0; i < this.size; i++) {
            this.square.add("-".repeat(this.size));
        }
    }

    public void display_board() {
        for (String row: this.square) {
            System.out.println(row);
        }

        System.out.println("Place " + this.to_win + " in a row to wins!");
    }

    // player's turn to fill the board
    public void fill_board(int x, int y, char symbol) {
        String row = this.square.get(y);
        StringBuilder modifiedRow = new StringBuilder(row);
        modifiedRow.setCharAt(x, symbol);
        this.square.set(y, modifiedRow.toString());
    }

    boolean validate_x_axis(int x, int y, char symbol) {
        int count = 0;
        String row = this.square.get(y);
        for (int i = x - this.to_win; i <= x + this.to_win; i++) {
            if (i < 0 || i >= this.size) continue;
            if (row.charAt(i) == symbol) count++;
            else count = 0;

            if (count == this.to_win) return true;
        }

        return false;
    }

    boolean validate_y_axis(int x, int y, char symbol) {
        int count = 0;
        for (int i = y - this.to_win; i <= y + this.to_win; i++) {
            if (i < 0 || i >= this.size) continue;
            String row = this.square.get(i);
            if(row.charAt(x) == symbol) count++;
            else count = 0;

            if (count == this.to_win) return true;
        }

        return false;
    }

    boolean validate_diag(int x, int y, char symbol) {
        int count = 0;
        for (int i = x - this.to_win, j = y - this.to_win; i <= x + this.to_win; i++, j++) {
            if (i < 0 || i >= this.size || j < 0 || j >= this.size) continue;
            String row = this.square.get(j);
            if (row.charAt(i) == symbol) count++;
            else count = 0;

            if (count == this.to_win) return true;
        }

        count = 0;
        for (int i = x - this.to_win, j = y + this.to_win; i <= x + this.to_win; i++, j--) {
            if (i < 0 || i >= this.size || j < 0 || j >= this.size) continue;
            String row = this.square.get(j);
            if (row.charAt(i) == symbol) count++;
            else count = 0;

            if (count == this.to_win) return true;
        }

        return false;
    }

    // validate the win
    public boolean validate(int x, int y, char symbol) {
        return validate_x_axis(x, y, symbol) || validate_y_axis(x, y, symbol) || validate_diag(x, y, symbol);
    }

    public void display_score() {
        System.out.print("Score: ");
        for (int i = 0; i < this.number_player; i++) {
            if (i != 0) System.out.print(" - ");
            System.out.print(this.players.get(i).score);
        }
        System.out.println();
    }
}
