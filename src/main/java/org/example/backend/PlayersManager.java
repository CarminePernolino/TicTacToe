package org.example.backend;

import java.util.ArrayList;

public class PlayersManager {
    Player player;
    ArrayList<Player> playersList;

    public PlayersManager(Player player) {
        this.player = player;
        playersList = new ArrayList<>();
    }
}
