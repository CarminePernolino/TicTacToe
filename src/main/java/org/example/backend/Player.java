package org.example.backend;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player {
    /**
     * Name.
     */
    private String name;
    /**
     * Icon.
     */
    private char icon;
    /**
     * Value.
     */
    private int value;
    /**
     * Win.
     */
    private int win;

    /**
     * Costruttore di Player.
     * @param newName
     * @param newIcon
     * @param newValue
     * @param newWin
     */
    public Player(final String newName, final char newIcon,
                  final int newValue, final int newWin) {
        this.name = newName;
        this.icon = newIcon;
        this.value = newValue;
        this.win = newWin;
    }
}
