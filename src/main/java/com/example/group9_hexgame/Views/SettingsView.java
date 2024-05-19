package com.example.group9_hexgame.Views;

import com.example.group9_hexgame.Controllers.GameController;
import com.example.group9_hexgame.Controllers.SettingsController;
import com.example.group9_hexgame.HexGameG9;
import com.example.group9_hexgame.Models.Game;
import com.example.group9_hexgame.Models.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCombination;

import java.util.Set;


public class SettingsView {
    public static Stage stageSettings = HexGameG9.globalStage;

    public static void setSettingsView() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #d7ead9;");

        setMapSettings(root);
        setPlayerSettings(root);
        setCloseButton(root);

        Scene scene = new Scene(root);
        stageSettings.setScene(scene);
        stageSettings.setFullScreen(true);
        stageSettings.setFullScreenExitHint("");
        stageSettings.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
    }

    private static void setMapSettings(BorderPane root) {
        int mapSizeValue = Game.mapSize;
        VBox mapSettingsVBox = new VBox(10);
        mapSettingsVBox.setAlignment(Pos.CENTER);
        mapSettingsVBox.setSpacing(30);

        Text logotxt = new Text("HexGame");
        logotxt.setFont(Font.font("Arial", FontWeight.BOLD, 64));
        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("#ffd700")), new Stop(1, Color.RED)
        );
        logotxt.setFill(gradient);


        Label mapSizeLabel = new Label("Harita Boyutu:");
        mapSizeLabel.setFont(Font.font("Arial", 20));
        mapSizeLabel.setTextFill(Color.BLUE);

        Label valueLabel = new Label(mapSizeValue + "x" + mapSizeValue);
        valueLabel.setFont(Font.font("Arial", 20));
        valueLabel.setTextFill(Color.BLUE);

        ScrollBar mapSizeScrollBar = new ScrollBar();
        mapSizeScrollBar.setMaxWidth(500);
        mapSizeScrollBar.setMin(5);
        mapSizeScrollBar.setMax(20);
        mapSizeScrollBar.setValue(mapSizeValue);
        mapSizeScrollBar.setPrefHeight(17); // Scrollbar boyutunu ayarla
        mapSizeScrollBar.setStyle("-fx-background-color: rgba(53,146,146,0.4);"); // Scrollbar rengini ayarla

        mapSizeScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            valueLabel.setText(String.valueOf((int) newValue.intValue()) + "x" + String.valueOf((int) newValue.intValue()));
            
            SettingsController.setMapSize(newValue.intValue());
        });

        mapSettingsVBox.getChildren().addAll(logotxt,mapSizeLabel, valueLabel, mapSizeScrollBar);
        root.setTop(mapSettingsVBox);
    }

    private static void setPlayerSettings(BorderPane root) {
        VBox player1Box = createPlayerSettingsBox(Game.playerA);
        root.setLeft(player1Box);

        VBox player2Box = createPlayerSettingsBox(Game.playerB);
        root.setRight(player2Box);
    }

    private static VBox createPlayerSettingsBox(Player player) {
        String playerName = player.getName();
        VBox playerBox = new VBox(10);
        playerBox.setAlignment(Pos.CENTER);

        Label playerLabel = new Label(playerName);
        playerLabel.setFont(Font.font("Arial", 20));
        playerLabel.setTextFill(player.getPlayerColor());

        TextField playerNameField = new TextField(playerName);

        ColorPicker playerColorPicker = new ColorPicker();
        playerColorPicker.setPromptText(playerName+" Rengi");
        playerColorPicker.setValue(player.getPlayerColor());

        Button savePlayerButton = new Button("Kaydet");
        savePlayerButton.setStyle("-fx-font-size: 24px; -fx-background-color: #3279de; -fx-text-fill: white;");
        savePlayerButton.setOnMouseEntered(e->savePlayerButton.setCursor(Cursor.HAND));
        savePlayerButton.setOnAction(e -> {
            String name = playerNameField.getText();
            Color color = playerColorPicker.getValue();
            SettingsController.setPlayerProperties(player, name, color);
            playerLabel.setText(name);
            playerLabel.setTextFill(color);
        });

        playerBox.getChildren().addAll(playerLabel, playerNameField, playerColorPicker, savePlayerButton);
        playerBox.setPadding(new Insets(0, 100, 60, 100));

        return playerBox;
    }

     static void setCloseButton(BorderPane root) {
        Button closeButton = new Button("Kapat");
        closeButton.setStyle("-fx-font-size: 24px; -fx-background-color: #3279de; -fx-text-fill: white;");
        closeButton.setOnMouseEntered(e->closeButton.setCursor(Cursor.HAND));
        closeButton.setPadding(new Insets(10));

        closeButton.setOnAction(e -> {
            GameController.closeGameArea();//?
        });

        HBox buttonHbx = new HBox();
        buttonHbx.setAlignment(Pos.CENTER);
        buttonHbx.getChildren().add(closeButton);
        buttonHbx.setPadding(new Insets(0, 0, 60, 0));

        root.setBottom(buttonHbx);

    }
}
