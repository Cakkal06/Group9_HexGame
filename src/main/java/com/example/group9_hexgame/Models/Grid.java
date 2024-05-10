package com.example.group9_hexgame.Models;
import javafx.scene.paint.Color;

public class Grid extends javafx.scene.layout.Pane {
    int size;
    boolean isBaseOfPlayerA;
    boolean isBaseOfPlayerB;
    public Player playerOnGrid;
    Color gridColor= Color.WHITE;

    public void drawGrid(){
        if (playerOnGrid!=null) playerOnGrid.getPlayerColor();

    }
}
