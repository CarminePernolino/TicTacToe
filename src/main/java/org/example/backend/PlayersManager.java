package org.example.backend;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Scanner;

@Getter
public class PlayersManager {
    private Player playerOne;
    private Player playerTwo;
    private ArrayList<Player> playersList;

    public PlayersManager() {
        playersList = new ArrayList<>();
    }

    public final void setPlayerOneName(String nameOne) {
        playerOne = new Player(nameOne, 'X', 1, 0);
        playersList.add(playerOne);
    }

    public void setPlayerTwoName(String nameTwo) {
        playerTwo = new Player(nameTwo, '0', 2, 0);
        playersList.add(playerTwo);
    }

    public Player getPlayer(int index) {
        return playersList.get(index);
    }
}
