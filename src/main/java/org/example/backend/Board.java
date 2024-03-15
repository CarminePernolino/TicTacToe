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
        this.checkWin(player,i,inputMove-1);
    }
    public void checkWin(Player player, int i, int j) {
        if( Math.abs(i-j)!=1 && board[1][1]== player.getValue() && (board[0][0]== player.getValue()
                && board[2][2]== player.getValue() || board[2][0]== player.getValue()
                && board[0][2]== player.getValue()))
            player.setWin(1);

        int count=0;

        for(int x=0; x<3;x++){
            if(board[i][x]==player.getValue())
                count++;
        }

        if(count==3)
            player.setWin(1);

        count=0;

        for(int x=0; x<3;x++){
            if(board[x][j]==player.getValue())
                count++;
        }

        if(count==3)
            player.setWin(1);
    }
}
