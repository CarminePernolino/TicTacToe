package org.example.gui;

import org.example.backend.Board;
import org.example.backend.Player;
import org.example.backend.PlayersManager;

import java.util.Scanner;

public class Menu {
    PlayersManager playersManager;
    Board board;

    public Menu() {
        this.playersManager = new PlayersManager();
        this.board = new Board();
        this.printBoard();
        this.inputNameScanner();
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

    private void inputNameScanner() {
        Scanner nameOne = new Scanner(System.in);
        System.out.print("Enter Player 1 name: ");
        playersManager.setPlayerOneName(nameOne);

        Scanner nameTwo = new Scanner(System.in);
        System.out.print("Enter Player 2 name: ");
        playersManager.setPlayerTwoName(nameTwo);
    }
}
