package com.example.group9_hexgame;

import com.example.group9_hexgame.Models.Game;
import com.example.group9_hexgame.Views.MenuView;
import com.example.group9_hexgame.Views.SettingsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;
public class HexGameG9 extends Application {
    public static Stage globalStage = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(Game.playerA.getName());
        MenuView.setMenuView();
        globalStage.show();
    }
}
