package org.example.gui;

import org.example.backend.Board;
import org.example.backend.Player;
import org.example.backend.PlayersManager;

import java.util.Scanner;

public class Menu {
    PlayersManager playersManager;
    Player gamePlayer;
    Board board;

    public Menu() {
        this.playersManager = new PlayersManager();
        this.board = new Board();
        this.inputNameScanner();

        int turn = 0;

        while(playersManager.getPlayer(0).getWin() == 0 || playersManager.getPlayer(1).getWin() == 0) {

            if(turn >= playersManager.getPlayersList().size()) {
                turn = 0;
                gamePlayer = playersManager.getPlayer(turn);
            } else
                gamePlayer = playersManager.getPlayer(turn);

            this.printBoard(gamePlayer);
            this.inputPlayerMove(gamePlayer);

            turn++;
        }
    }

    private void printBoard(Player player) {
        int contCell = 1;

        System.out.println("Player round: " + player.getName());

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

    private void inputPlayerMove(Player gamePlayer) {
        Scanner playerMove = new Scanner(System.in);
        System.out.print("Enter the value of the chosen box: ");
        int inputMove = playerMove.nextInt();

        board.setCell(inputMove, gamePlayer);

    }
}
