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
    static public Grid[][] grids = new Grid[mapSize][mapSize];
    static public Player currentPlayer=playerA;

    public static void getGrids(){

//        for (int i = 0; i < mapSize; i++) {
//            for (int j = 0; j < mapSize; j++) {
//                grids[i][j] = new Grid(1,1,1);
//                if(i==0&&i==mapSize-1) grids[i][j].isBaseOfPlayerA = true;
//                if(j==0&&j==mapSize-1) grids[i][j].isBaseOfPlayerB = true;
//            }
//        }
        currentPlayer = playerA;
    }





}
