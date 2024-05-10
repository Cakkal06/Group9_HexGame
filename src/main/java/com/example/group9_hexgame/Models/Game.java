package com.example.group9_hexgame.Models;

public class Game {

    static public int mapSize;
    public static int amountOfRound;
    static public Player playerA;
    static public Player playerB;
    static public Grid[][] grids = new Grid[mapSize][mapSize];
    static public Player currentPlayer;


    public Game(int mapSize) {
        this.mapSize = mapSize;

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                grids[i][j] = new Grid();
                if(i==0&&i==mapSize-1) grids[i][j].isBaseOfPlayerA = true;
                if(j==0&&j==mapSize-1) grids[i][j].isBaseOfPlayerB = true;
            }
        }

        currentPlayer = playerA;
    }
}
