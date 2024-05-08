package com.example.group9_hexgame.Controllers;

import com.example.group9_hexgame.HexGameG9;
import com.example.group9_hexgame.Views.GameView;
import com.example.group9_hexgame.Views.MenuView;
import com.example.group9_hexgame.Views.SettingsView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.group9_hexgame.HexGameG9.menuStage;

public class MenuController {
    public void openGameArea(){
        GameView.stageGame.show();
    }
    public void openSettings(){
        SettingsView.stageSettings.show();
    }
}
