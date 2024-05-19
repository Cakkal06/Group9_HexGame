package com.example.group9_hexgame.Controllers;

import com.example.group9_hexgame.Models.Game;
import com.example.group9_hexgame.Models.Player;
import com.example.group9_hexgame.Views.MenuView;

import javafx.scene.paint.Color;

public class SettingsController {
    public static void setPlayerProperties(Player p,String n, Color c){
        p.setName(n);
        p.setPlayerColor(c);
    }
    public static void setMapSize(int s){
        Game.mapSize=s;
    }
    public static void  closeSettingsView(){
        MenuView.setMenuView();
        MenuView.stageMenu.show();
    }

}
