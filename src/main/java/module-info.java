module com.example.group9_hexgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.group9_hexgame to javafx.fxml;
    exports com.example.group9_hexgame;
    exports com.example.group9_hexgame.Views;
    exports com.example.group9_hexgame.Controllers;
    exports com.example.group9_hexgame.Models;
}