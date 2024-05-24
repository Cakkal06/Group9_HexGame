package com.example.group9_hexgame.Models;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;

public class Game {


    static public int mapSize=7;
    public static int amountOfRound=1;
    static public Player playerA = new Player("Player A",Color.BLUE);
    static public Player playerB = new Player("Player B" ,Color.RED);


    //
    private static Grid[][] grids;

    public static void initializeGrid(int gridSize) {
        grids = new Grid[gridSize][gridSize];
    }

    public static void setGrid(Grid hexagon, int row, int col) {
        grids[row][col] = hexagon;
    }

    public static Grid[][] getGrid() {
        return grids;
    }
    //


    static public Player currentPlayer=playerA;





}
