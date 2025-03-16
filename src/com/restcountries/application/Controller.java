package com.restcountries.application;

import com.restcountries.api.API;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.List;

public class Controller {

    @FXML
    private Button run;

    @FXML
    private ListView<String> countryNameList;

    public void buttonClick() {
        API api = new API();
        List<String> countries = API.getCountryNames();
        ObservableList<String> countryNamesList = FXCollections.observableArrayList(countries);
        countryNameList.setItems(countryNamesList);
    }

}
