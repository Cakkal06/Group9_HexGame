package com.example.group9_hexgame.Controllers;

import com.example.group9_hexgame.HexGameG9;
import com.example.group9_hexgame.Views.GameView;
import com.example.group9_hexgame.Views.MenuView;
import com.example.group9_hexgame.Views.SettingsView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.group9_hexgame.HexGameG9.globalStage;

public class MenuController {
    public static void openGameArea() {
        GameView.setGameView();
        GameView.stageGame.show();
        
    }

    public static void openSettings() {
        SettingsView.setSettingsView();
        SettingsView.stageSettings.show();

    }

}
