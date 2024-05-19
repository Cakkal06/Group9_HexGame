package com.example.group9_hexgame.Controllers;

import com.example.group9_hexgame.Views.GameView;
import com.example.group9_hexgame.Views.SettingsView;

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
