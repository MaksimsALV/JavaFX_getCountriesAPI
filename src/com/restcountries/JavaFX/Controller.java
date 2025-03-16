package com.restcountries.JavaFX;

import com.restcountries.api.API;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button run;

    public void buttonClick() {
        API api = new API();
        API.getRequest();
    }

}
