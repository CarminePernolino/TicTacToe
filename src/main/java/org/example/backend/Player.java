package org.example.backend;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player {
    private String name;
    private char icon;
    private int value;
    private int win;

    public Player(String name, char icon, int value, int win){
        this.name = name;
        this.icon = icon;
        this.value = value;
        this.win = win;
    }
}
