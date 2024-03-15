package org.example.backend;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Scanner;

@Getter
public class PlayersManager {
    Player playerOne;
    Player playerTwo;
    ArrayList<Player> playersList;

    public PlayersManager() {
        playersList = new ArrayList<>();
    }

    public void setPlayerOneName(String nameOne) {
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
