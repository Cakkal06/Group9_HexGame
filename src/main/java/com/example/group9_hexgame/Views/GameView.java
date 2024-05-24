package com.example.group9_hexgame.Views;

import com.example.group9_hexgame.Controllers.GameController;
import com.example.group9_hexgame.Controllers.SettingsController;
import com.example.group9_hexgame.HexGameG9;
import com.example.group9_hexgame.Models.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static com.example.group9_hexgame.Models.Game.currentPlayer;

public class GameView {
    public static VBox sum = new VBox();
    public static Stage stageGame = HexGameG9.globalStage;          //acaba sürekli yeni stageler üretmek yerine her stage bir gtage gösterne nasıl olur
    public static void setGameView(){

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #d7ead9");

        // create game area
        Pane gameAreaPane = new Pane();
        GameController.getGameArea(gameAreaPane);
        gameAreaPane.setPadding(new Insets(80,80,80,80));
        root.setCenter(gameAreaPane);

        // create summary

        getSum();

        root.setTop(sum);

        // create exit button

        SettingsView.setCloseButton(root);//ufak bir hile





        // Scene and Stage
        Scene scene = new Scene(root);
        stageGame.setScene(scene);
        stageGame.setFullScreen(true);
        stageGame.setFullScreenExitHint("");
        stageGame.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

    }

    public static void getSum() {
        sum.getChildren().clear();
        sum.setSpacing(10);
        //oynayan oyuncu bilgisi
        Label currentPlayerLbl = new Label("Oyanyan oyuncu :"+ currentPlayer.getName());
        currentPlayerLbl.setFont(Font.font("Arial", 30));
        //hamle sayısı
        Label round = new Label("Hamle sayısı :"+Game.amountOfRound);
        round.setFont(Font.font("Arial", 15));

//        Game.amountOfRoundProperty().addListener((observable, oldValue, newValue) -> {
//            round.setText("Hamle sayısı: " + newValue);
//        });

        sum.setBackground(Background.fill(currentPlayer.getPlayerColor()));
        sum.getChildren().addAll(currentPlayerLbl,round);
        sum.setAlignment(Pos.CENTER);
        sum.setPadding(new Insets(10,10,10,10));



    }
    public static void getSum(VBox sum){

    }
}
