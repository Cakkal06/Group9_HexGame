package com.example.group9_hexgame.Controllers;

import com.example.group9_hexgame.Models.Game;
import com.example.group9_hexgame.Models.Player;
import com.example.group9_hexgame.Views.MenuView;
import javafx.scene.control.Menu;
import javafx.scene.paint.Color;

public class SettingsController {
    public void changePlayerName(Player p,String n){
        p.setName(n);
    }
    public void changePlayerColor(Player p, Color c){
        p.setPlayerColor(c);
    }
    public void setMapSize(int s){
        Game.mapSize=s;
    }
    public void closeSettingsView(){
        MenuView.stageMenu.show();
    }

}
