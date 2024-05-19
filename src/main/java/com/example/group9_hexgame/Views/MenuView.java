package com.example.group9_hexgame.Views;

import com.example.group9_hexgame.Controllers.MenuController;
import com.example.group9_hexgame.HexGameG9;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuView {
    public static Stage stageMenu = HexGameG9.globalStage;

    public static void setMenuView() {
        Insets buttonInsets =new Insets(8, 80, 8, 80);
        String buttonStyle = "-fx-font-size: 24px; -fx-background-color: #923586; -fx-text-fill: white;";

        //create root
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #d7ead9");


        // create logo
        Text logotxt = new Text("HexGame");
        logotxt.setFont(Font.font("Arial", FontWeight.BOLD, 64));
        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("#ffd700")), new Stop(1, Color.RED)
        );
        logotxt.setFill(gradient);


        //create play button
        Button playButton = new Button("Oyna");
        playButton.setStyle(buttonStyle);
        playButton.setOnAction(e -> {
            MenuController.openGameArea();
        });
        playButton.setOnMouseEntered(e -> playButton.setCursor(Cursor.HAND));
        playButton.setPadding(buttonInsets);

        //create settings button
        Button settingsButton = new Button("Ayarlar");
        settingsButton.setStyle(buttonStyle);
        settingsButton.setOnAction(e -> {
            MenuController.openSettings();
        });
        settingsButton.setOnMouseEntered(e -> settingsButton.setCursor(Cursor.HAND));
        settingsButton.setPadding(buttonInsets);
        //create escape button
        Button closeButton = new Button("Çıkış");
        closeButton.setStyle(buttonStyle);
        closeButton.setOnAction(e -> {
            Platform.exit();
        });
        closeButton.setOnMouseEntered(e -> closeButton.setCursor(Cursor.HAND));
        closeButton.setPadding(buttonInsets);

        // set root
        root.getChildren().addAll(logotxt,playButton, settingsButton,  closeButton);

        // add VBox
        VBox vBox = new VBox( logotxt, playButton, settingsButton, closeButton);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(0,0,150,0));


        // add VBox to root
        root.getChildren().add(vBox);
        Scene scene = new Scene(root);
        //stage scene settings
        stageMenu.setScene(scene);
        stageMenu.setFullScreen(true);
        stageMenu.setFullScreenExitHint("");
        stageMenu.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);


    }
}
