package com.example.group9_hexgame.Models;

import com.example.group9_hexgame.Controllers.GameController;
import com.example.group9_hexgame.Views.GameView;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

import static com.example.group9_hexgame.Views.SettingsView.stageSettings;

public class Grid extends Polygon {
    public boolean isBaseOfPlayerA;
    public boolean isBaseOfPlayerB;
    public Player playerOnGrid = null;
    Color gridColor = Color.WHITE;
    public int[] locationRowCol = new int[2];
    public boolean isOccupiedBy(Player player) {
        return playerOnGrid ==player;
    }

    public Grid(double centerX, double centerY, double radius, boolean baseA, boolean baseB, int row, int col) {
        setFill(Color.WHITE);
        isBaseOfPlayerA = baseA;
        isBaseOfPlayerB = baseB;

        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i + 90);
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            getPoints().addAll(x, y);
        }
        setStroke(Color.BLACK);
        if (isBaseOfPlayerA) setStroke(Game.playerA.getPlayerColor());
        if (isBaseOfPlayerB) setStroke(Game.playerB.getPlayerColor());
        if (isBaseOfPlayerB && isBaseOfPlayerA) {
            setStroke(Game.playerB.getPlayerColor());
        }
        //location atama
        locationRowCol = new int[]{row, col};

        // tıklayınca olacaklar
        setOnMouseClicked(event -> {
            if (playerOnGrid == null) {
                setFill(Game.currentPlayer.getPlayerColor());
                GameController.putStone(this);
            } else {
                //haznenin dolu olduğu mesajını ver
                Popup popup = new Popup();
                Label label = new Label("                  "+"Hazne Dolu"+"                  ");
                label.setStyle("-fx-background-color: rgba(35,42,44,0.7);");
                label.setTextFill(Color.WHITE);
                label.setFont(Font.font(25));
                label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(5), new BorderWidths(1))));
                popup.getContent().add(label);

                Window window = getScene().getWindow();
                if (window instanceof Stage) {
                    popup.show(window);
                }
                PauseTransition delay = new PauseTransition(Duration.seconds(0.8));
                delay.setOnFinished(e -> popup.hide());
                delay.play();
            }
        });
    }
    public List<Grid> getNeighbors(Grid[][] grid) {
        List<Grid> neighbors = new ArrayList<>();
        int row = locationRowCol[0];
        int col = locationRowCol[1];

        int[][] directions = {
                {-1, 0}, {-1, 1}, {0, -1},
                {0, 1}, {1, -1}, {1, 0}
        };

        for (int[] director : directions) {
            int newRow = row + director[0];
            int newCol = col + director[1];
            if (newRow >= 0 && newRow < Game.mapSize && newCol >= 0 && newCol < Game.mapSize) {
                neighbors.add(grid[newRow][newCol]);
            }
        }

        return neighbors;
    }



}
