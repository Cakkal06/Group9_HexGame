package com.example.group9_hexgame.Controllers;

import com.example.group9_hexgame.Models.Game;
import com.example.group9_hexgame.Models.Grid;
import com.example.group9_hexgame.Models.Player;
import com.example.group9_hexgame.Views.GameView;

public class GameController {
    private void chanceCurrentPlayer() {
        if(Game.currentPlayer==Game.playerA) Game.currentPlayer=Game.playerB;
        else Game.currentPlayer=Game.playerA;
    }

    public void putStone(Grid grid, Player player) {
        grid.playerOnGrid = player;
        if (chackeIfPlayerWon(player)) {
            //PLAYER WON ANIMATION




            closeGameArea();
        }
        if (Game.amountOfRound==Game.mapSize*Game.mapSize){
            //No winner animation




            closeGameArea();
        }

        chanceCurrentPlayer();
    }

    private boolean chackeIfPlayerWon(Player player) {
        return true;
    }

    public void closeGameArea() {
        //Eğer oyun kapatıldıktan sonra yeni oyun açınca kaldığı yerden devam ediyorsa sıfırlama işlemi yap

        GameView.stageGame.close();
    }
}
