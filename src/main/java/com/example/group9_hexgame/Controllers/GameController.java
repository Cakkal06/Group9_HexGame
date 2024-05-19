package com.example.group9_hexgame.Controllers;

import com.example.group9_hexgame.Models.Game;
import com.example.group9_hexgame.Models.Grid;
import com.example.group9_hexgame.Models.Player;
import com.example.group9_hexgame.Views.GameView;
import com.example.group9_hexgame.Views.MenuView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class GameController {
    private static void chanceCurrentPlayer() {
        if(Game.currentPlayer==Game.playerA) Game.currentPlayer=Game.playerB;
        else Game.currentPlayer=Game.playerA;
    }

    public static void putStone(Grid grid) {

        Player currPlayer = Game.currentPlayer;
        grid.playerOnGrid = currPlayer;

        if (chackeIfPlayerWon(currPlayer)) {
            //PLAYER WON ANIMATION
            System.out.println(currPlayer.getName()+"won");


            closeGameArea();
        }


        if (Game.amountOfRound==Game.mapSize*Game.mapSize){
            System.out.println("no winner");
            closeGameArea();
        }

        chanceCurrentPlayer();
        System.out.println(Game.amountOfRound++);
    }

    private static boolean chackeIfPlayerWon(Player player) {
        return false;
    }

    public static void closeGameArea() {
        //Eğer oyun kapatıldıktan sonra yeni oyun açınca kaldığı yerden devam eden şeyler varsa sıfırlama işlemi yap
        Game.currentPlayer = Game.playerA;
        MenuView.setMenuView();
        MenuView.stageMenu.show();

    }
    public static Pane getGameArea(Pane stackPane) {
        int gridSize = Game.mapSize;
        double radius = 340 / gridSize;
        double hexHeight = 2 * radius;
        double hexWidth = Math.sqrt(3) * radius;

        for (int row = 0; row < gridSize; row++) {

            for (int col = 0; col < gridSize; col++) {

                boolean BaseOfPlayerA=false;
                boolean BaseOfPlayerB=false;
                if(row==0||row==gridSize-1) BaseOfPlayerA=true;
                if(col==0||col==gridSize-1) BaseOfPlayerB=true;
                double xOffset = col * hexWidth + row*hexWidth/2    +400 ;//+500 ve +100 sayesinde ortaya alabildim
                double yOffset =hexWidth*row*0.87         +100 ;
                Grid hexagon = new Grid(xOffset, yOffset, radius,BaseOfPlayerA,BaseOfPlayerB,row,col);
                stackPane.getChildren().add(hexagon);
            }
        }
        return stackPane;
    }
}
