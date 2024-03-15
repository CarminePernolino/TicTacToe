package org.example.gui;

import org.example.backend.Board;

public class Menu {
    Board board;

    public Menu() {
        this.board = new Board();
        this.printBoard();
    }

    private void printBoard() {
        int contCell = 1;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print("[" + "-" + "]");
            }

            if(i == 1)
                System.out.print("     ->     ");
            else
                System.out.print("            ");

            for(int j = 0; j < 3; j++) {
                System.out.print("[" + contCell + "]");
                contCell++;
            }

            System.out.print("\n");
        }
    }
}
