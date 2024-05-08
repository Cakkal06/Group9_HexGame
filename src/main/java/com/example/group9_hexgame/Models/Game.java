package com.example.group9_hexgame.Models;

public class Game {

    static public int mapSize;
    static int amountOfRound;
    static public Player playerA ;
    static public Player playerB;
    static public Grid[][] grids = new Grid[mapSize][mapSize];
    static public Player currentPlayer;


    public Game(int mapSize) {
        this.mapSize = mapSize;

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                grids[i][j] = new Grid();
                grids[0][j].isBaseOfPlayerA = true;
            }
        }

        currentPlayer = playerA;
    }
}
