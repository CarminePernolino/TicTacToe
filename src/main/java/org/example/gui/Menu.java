package org.example.gui;

import org.example.backend.Board;
import org.example.backend.PlayersManager;

import java.util.Scanner;

public class Menu {
    PlayersManager playersManager;
    Board board;

    public Menu() {
        this.playersManager = new PlayersManager();
        this.board = new Board();
        this.inputNameScanner();

        while(playersManager.getPlayer(0).getWin() == 0 || playersManager.getPlayer(1).getWin() == 0) {
            this.printBoard();
        }
    }

    private void printBoard() {
        int contCell = 1;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                if(board.getValueCell(i,j) == -1)
                    System.out.print("[" + "-" + "]");

                if(board.getValueCell(i,j) == 1)
                    System.out.print("[" + playersManager.getPlayer(0).getIcon() + "]");

                if(board.getValueCell(i,j) == 2)
                    System.out.print("[" + playersManager.getPlayer(1).getIcon() + "]");
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
