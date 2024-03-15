package org.example.backend;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayersManager {
    Player playerOne;
    Player playerTwo;
    ArrayList<Player> playersList;

    public PlayersManager() {
        playersList = new ArrayList<>();
    }

    public void setPlayerOneName(Scanner nameOne) {
        playerOne = new Player(nameOne.nextLine(), 'X', 0);
        playersList.add(playerOne);
    }

    public void setPlayerTwoName(Scanner nameTwo) {
        playerTwo = new Player(nameTwo.nextLine(), 'X', 0);
        playersList.add(playerTwo);
    }

    public Player getPlayer(int index) {
        return playersList.get(index);
    }
}
