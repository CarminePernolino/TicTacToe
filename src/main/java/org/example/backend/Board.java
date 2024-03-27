package org.example.backend;

import org.example.exceptions.CellValueExpection;

public class Board {
    /**
     * Board.
     */
    private int[][] board = new int[THREE][THREE];
    /**
     * THREE.
     */
    private static final int THREE = 3;

    /**
     * Costruttore per Board.
     */
    public Board() {
        this.createBoard();
    }

    private void createBoard() {
        for (int i = 0; i < THREE; i++) {
            for (int j = 0; j < THREE; j++) {
                board[i][j] = -1;
            }
        }
    }

    /**
     * Funzione per prendere il valore di una cella.
     * @param i
     * @param j
     * @return cella in posizione i,j
     */
    public int getValueCell(final int i, final int j) {
        return board[i][j];
    }

    /**
     * Funzione per impostare la cella.
     * @param inputMove
     * @param player
     * @throws CellValueExpection
     */
    public void setCell(final int inputMove, final Player player)
            throws CellValueExpection {
        int tempInputMove = inputMove;
        int i = 0;

        while (tempInputMove > THREE) {
            tempInputMove -= THREE;
            i++;
        }

        if (board[i][tempInputMove - 1] != -1) {
            throw new CellValueExpection();
        }

        board[i][tempInputMove - 1] = player.getValue();

        this.checkWin(player, i, tempInputMove - 1);
    }

    /**
     * Funzione per controllare la vittoria.
     * @param player
     * @param i
     * @param j
     */
    public void checkWin(final Player player, final int i, final int j) {
        if (Math.abs(i - j) != 1 && board[1][1] == player.getValue()
                && (board[0][0] == player.getValue()
                && board[2][2] == player.getValue()
                || board[2][0] == player.getValue()
                && board[0][2] == player.getValue())) {
            player.setWin(1);
        }

        int count = 0;

        for (int x = 0; x < THREE; x++) {
            if (board[i][x] == player.getValue()) {
                count++;
            }
        }

        if (count == THREE) {
            player.setWin(1);
        }

        count = 0;

        for (int x = 0; x < THREE; x++) {
            if (board[x][j] == player.getValue()) {
                count++;
            }
        }

        if (count == THREE) {
            player.setWin(1);
        }
    }
}
