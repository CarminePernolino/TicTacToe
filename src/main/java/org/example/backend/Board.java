package org.example.backend;

public class Board {
    private int board[][] = new int[3][3];

    public Board() {
        this.createBoard();
    }

    private void createBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = -1;
            }
        }
    }

    public int getValueCell(int i, int j) {
        return board[i][j];
    }

    public void setCell(int inputMove, Player player) {
        int i = 0;

        while(inputMove > 3) {
            inputMove -= 3;
            i++;
        }

        board[i][inputMove-1] = player.getValue();
    }
}
