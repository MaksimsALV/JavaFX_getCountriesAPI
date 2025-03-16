package com.restcountries;


import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Run {
    public static void main(String[] args) {
        Platform.startup(() -> { //seems that it doesnt work without try/catch block, so had to add that one
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Run.class.getResource("/com/restcountries/application/window.fxml"));
                Parent root = fxmlLoader.load();

                Stage primaryStage = new Stage();
                primaryStage.setScene(new Scene(root, 600, 400)); //setting the window size
                primaryStage.setTitle("Countries API");
                primaryStage.show(); //shows the window
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
