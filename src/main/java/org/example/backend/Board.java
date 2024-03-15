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
}
