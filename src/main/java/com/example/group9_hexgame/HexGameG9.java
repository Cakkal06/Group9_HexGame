package com.example.group9_hexgame;

import com.example.group9_hexgame.Views.MenuView;
import com.example.group9_hexgame.Views.SettingsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class HexGameG9 extends Application {
    public static Stage menuStage = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
        MenuView.stageMenu.show();
    }

}
