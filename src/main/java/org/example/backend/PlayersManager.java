package org.example.backend;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class PlayersManager {
    /**
     * Giocatore uno.
     */
    private Player playerOne;
    /**
     * Giocatore due.
     */
    private Player playerTwo;
    /**
     * Lista di giocatori.
     */
    private ArrayList<Player> playersList;

    /**
     * Costruttore.
     */
    public PlayersManager() {
        playersList = new ArrayList<>();
    }

    /**
     * Imposta il nome del primo giocatore.
     * @param nameOne
     */
    public final void setPlayerOneName(final String nameOne) {
        playerOne = new Player(nameOne, 'X', 1, 0);
        playersList.add(playerOne);
    }

    /**
     * Imposta il nome del secondo giocatore.
     * @param nameTwo
     */
    public void setPlayerTwoName(final String nameTwo) {
        playerTwo = new Player(nameTwo, '0', 2, 0);
        playersList.add(playerTwo);
    }

    /**
     * Funzione per prendere il giocatore.
     * @param index
     * @return il giocatore
     */
    public Player getPlayer(final int index) {
        return playersList.get(index);
    }
}
