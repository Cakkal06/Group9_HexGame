package com.example.group9_hexgame.Controllers;

import com.example.group9_hexgame.Models.Game;
import com.example.group9_hexgame.Models.Grid;
import com.example.group9_hexgame.Models.Player;
import com.example.group9_hexgame.Views.GameView;
import com.example.group9_hexgame.Views.MenuView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.*;

public class GameController {
    private static void chanceCurrentPlayer() {
        if (Game.currentPlayer == Game.playerA) Game.currentPlayer = Game.playerB;
        else Game.currentPlayer = Game.playerA;
    }


    public static void putStone(Grid grid) {

        Player currPlayer = Game.currentPlayer;
        grid.playerOnGrid = currPlayer;

        if (chackeIfPlayerWon(currPlayer)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText(currPlayer.getName()+" Kazandı");

            Window window = GameView.stageGame.getScene().getWindow();
            if (window instanceof Stage) {
                alert.initOwner(window);
            }

            alert.showAndWait();


            closeGameArea();
        }


        if (Game.amountOfRound == Game.mapSize * Game.mapSize) {

            closeGameArea();
        }

        Game.amountOfRound++;




        chanceCurrentPlayer();

        GameView.getSum();
    }


    private static boolean chackeIfPlayerWon(Player player) {
        int gridSize = Game.mapSize;
        Grid[][] grid = Game.getGrid();
        //check for playerA
        if (player.equals(Game.playerA)) {
            for (int col = 0; col < gridSize; col++) {
                if (grid[0][col].isOccupiedBy(player)) {
                    if (bfs(grid, player, 0, col)) {
                        return true;
                    }
                }
            }
        }
        // check for playerB
        if (player.equals(Game.playerB)) {
            for (int row = 0; row < gridSize; row++) {
                if (grid[row][0].isOccupiedBy(player)) {
                    if (bfs(grid, player, row, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    private static boolean bfs(Grid[][] grids, Player player, int startRow, int startCol) {
        int gridSize = grids.length;
        boolean[][] visited = new boolean[gridSize][gridSize];
        Queue<Grid> queue = new LinkedList<>();
        queue.add(grids[startRow][startCol]);
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Grid current = queue.poll();
            int row = current.locationRowCol[0];
            int col = current.locationRowCol[1];

            // Oyuncu A için bitiş satırı
            if (player.equals(Game.playerA) && row == gridSize - 1) {


                return true;
            }

            // Oyuncu B için bitiş sütunu
            if (player.equals(Game.playerB) && col == gridSize - 1) {
                return true;
            }

            for (Grid neighbor : current.getNeighbors(grids)) {
                int nRow = neighbor.locationRowCol[0];
                int nCol = neighbor.locationRowCol[1];
                if (!visited[nRow][nCol] && neighbor.isOccupiedBy(player)) {
                    visited[nRow][nCol] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }


    public static void closeGameArea() {
        //Eğer oyun kapatıldıktan sonra yeni oyun açınca kaldığı yerden devam eden şeyler varsa sıfırlama işlemi yap
        Game.amountOfRound = 1;
        Game.currentPlayer = Game.playerA;
        MenuView.setMenuView();
        MenuView.stageMenu.show();

    }

    public static void getGameArea(Pane stackPane) {
        int gridSize = Game.mapSize;
        double radius = 340 / gridSize;
        double hexHeight = 2 * radius;
        double hexWidth = Math.sqrt(3) * radius;
        Game.initializeGrid(gridSize);
        for (int row = 0; row < gridSize; row++) {

            for (int col = 0; col < gridSize; col++) {

                boolean BaseOfPlayerA = false;
                boolean BaseOfPlayerB = false;
                if (row == 0 || row == gridSize - 1) BaseOfPlayerA = true;
                if (col == 0 || col == gridSize - 1) BaseOfPlayerB = true;
                double xOffset = col * hexWidth + row * hexWidth / 2 + 400;//+500 ve +100 sayesinde ortaya alabildim
                double yOffset = hexWidth * row * 0.87 + 100;
                Grid hexagon = new Grid(xOffset, yOffset, radius, BaseOfPlayerA, BaseOfPlayerB, row, col);
                stackPane.getChildren().add(hexagon);
                Game.setGrid(hexagon, row, col);
            }
        }
    }
//    private static void makeBiggerWay(Grid[] grids){
//        System.out.println(Arrays.toString(grids));
//        System.out.println(grids.length);
//    }
//

}
