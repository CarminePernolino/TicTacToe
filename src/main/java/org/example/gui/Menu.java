package org.example.gui;

import org.example.backend.Board;
import org.example.backend.Player;
import org.example.backend.PlayersManager;
import org.example.exceptions.CellValueExpection;
import org.example.exceptions.EmptyNameException;
import org.example.exceptions.OutOfRangeNumberException;

import java.util.Scanner;



public class Menu {
    /**
     * PlayesManager.
     */
    private PlayersManager playersManager;
    /**
     * GamePlayer.
     */
    private Player gamePlayer;
    /**
     * Board.
     */
    private Board board;
    /**
     * Ciclo.
     */
    private  boolean cicle = true;
    /**
     * Number 3.
     */
    private static final int THREE = 3;
    /**
     * Number 9.
     */
    private static final int NINE = 9;

    /**
     * Classe Menu.
     */
    public Menu() {
        this.playersManager = new PlayersManager();
        this.board = new Board();

        while (cicle) {
            try {
                this.inputNameScanner();
                cicle = false;
            } catch (EmptyNameException e) {
                System.out.println("! The name is empty !");
                System.out.println("! Try Again !");
            }
        }

        int turn = 0;

        while (playersManager.getPlayer(0).getWin() == 0
                && playersManager.getPlayer(1).getWin() == 0) {

            if (turn >= playersManager.getPlayersList().size()) {
                turn = 0;
                gamePlayer = playersManager.getPlayer(turn);
            } else {
                gamePlayer = playersManager.getPlayer(turn);
            }

            this.printBoard(gamePlayer);
            try {
                this.inputPlayerMove(gamePlayer);
                turn++;
            } catch (OutOfRangeNumberException e) {
                System.out.println("\n! Insert a number between 1 and 9 !");
                System.out.println("! Try Again !");
            } catch (CellValueExpection e) {
                System.out.println("! You cannot overwrite the cell value !");
                System.out.println("! Try again !");
            }
        }

        System.out.println(gamePlayer.getName() + " win the game!");
    }

    private void printBoard(final Player player) {
        int contCell = 1;

        System.out.println("\nPlayer round: " + player.getName());

        for (int i = 0; i < THREE; i++) {
            for (int j = 0; j < THREE; j++) {

                if (board.getValueCell(i, j) == -1) {
                    System.out.print("[" + "-" + "]");
                }

                if (board.getValueCell(i, j) == 1) {
                    System.out.print("[" + playersManager.getPlayer(0)
                            .getIcon() + "]");
                }

                if (board.getValueCell(i, j) == 2) {
                    System.out.print("[" + playersManager.getPlayer(1)
                            .getIcon() + "]");
                }
            }

            if (i == 1) {
                System.out.print("     ->     ");
            } else {
                System.out.print("            ");
            }

            for (int j = 0; j < THREE; j++) {
                System.out.print("[" + contCell + "]");
                contCell++;
            }

            System.out.print("\n");
        }
    }

    private void inputNameScanner() throws EmptyNameException {
        if (playersManager.getPlayerOne() == null) {
            Scanner nameOne = new Scanner(System.in);
            System.out.print("Enter Player 1 name: ");
            String namePlayerOne = nameOne.nextLine();

            if (namePlayerOne.isEmpty()) {
                throw new EmptyNameException();
            }

            playersManager.setPlayerOneName(namePlayerOne);
        }

        Scanner nameTwo = new Scanner(System.in);
        System.out.print("Enter Player 2 name: ");
        String namePlayerTwo = nameTwo.nextLine();

        if (namePlayerTwo.isEmpty()) {
            throw new EmptyNameException();
        }

        playersManager.setPlayerTwoName(namePlayerTwo);
    }

    private void inputPlayerMove(final Player player) throws
            OutOfRangeNumberException, CellValueExpection {
        Scanner playerMove = new Scanner(System.in);
        System.out.print("\nEnter the value of the chosen box: ");
        String playerFinalMove = playerMove.nextLine();

        if (playerFinalMove.isEmpty() || !playerFinalMove.matches("[1-9]+")
                || Integer.parseInt(playerFinalMove) < 1
                || Integer.parseInt(playerFinalMove) > NINE) {
            throw new OutOfRangeNumberException();
        }

        board.setCell(Integer.parseInt(playerFinalMove), player);
    }
}
