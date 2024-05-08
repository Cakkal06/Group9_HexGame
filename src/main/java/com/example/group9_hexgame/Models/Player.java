package com.example.group9_hexgame.Models;

import javafx.scene.paint.Color;

public class Player {
    private Color playerColor;
    private String name;
    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
