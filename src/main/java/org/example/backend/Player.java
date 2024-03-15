package org.example.backend;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player {
    private String name;
    private char icon;
    private int win;

    public Player(String name, char icon, int win){
        this.name = name;
        this.icon = icon;
        this.win = win;
    }
}
