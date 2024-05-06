package com.example.group9_hexgame.Models;

public class Game {
     int mapSize;
     int amountOfRound;
     Player playerA;
     Player playerB;
    Grid[][] grids = new Grid[mapSize][mapSize];
    Player currentPlayer;


    void Game(int mapSize){

        this.mapSize=mapSize;

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                grids[i][j] = new Grid();
            }
        }

        currentPlayer = playerA;
    }
}
