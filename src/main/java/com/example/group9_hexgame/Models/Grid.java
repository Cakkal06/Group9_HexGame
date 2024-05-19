package com.example.group9_hexgame.Models;
import com.example.group9_hexgame.Controllers.GameController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import java.util.Arrays;

public class Grid extends Polygon {
    int size;
    public boolean isBaseOfPlayerA;
    public boolean isBaseOfPlayerB;
    public Player playerOnGrid=null;
    Color gridColor= Color.WHITE;
    int[] locationRowCol=new int[2];
    public Grid(double centerX, double centerY, double radius,boolean baseA,boolean baseB,int row,int col) {
        setFill(Color.WHITE);
        isBaseOfPlayerA=baseA;
        isBaseOfPlayerB=baseB;

        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i + 90);
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            getPoints().addAll(x, y);
        }
        setStroke(Color.BLACK);
        if (isBaseOfPlayerA) setStroke(Game.playerA.getPlayerColor());
        if (isBaseOfPlayerB) setStroke(Game.playerB.getPlayerColor());
        if (isBaseOfPlayerB&&isBaseOfPlayerA) {
            setStroke(Game.playerB.getPlayerColor());
        }
        //location atama
        locationRowCol = new int[]{row, col};


        //tıklayınca olacaklar
        setOnMouseClicked(event -> {
            if(playerOnGrid==null) {
                setFill(Game.currentPlayer.getPlayerColor());
                GameController.putStone(this);
            }
            else {
                System.out.println("dolu kardeş");
            }
//            System.out.println("taş koyuldu");
//            if(baseA) System.out.println("basea");
//            if(isBaseOfPlayerB) System.out.println("baseB");
//            System.out.println(locationRowCol[0]);
//            System.out.println(locationRowCol[1]);
        });

    }

}
