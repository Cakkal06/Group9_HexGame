package com.example.group9_hexgame.Views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MenuView {
    public Scene getMenuView(){
        Pane root = new Pane(new Button("densmk"));
        return new Scene(root);
    }
}
