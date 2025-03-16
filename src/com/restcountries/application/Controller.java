package com.restcountries.application;

import com.restcountries.api.API;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    @FXML
    private Button run;

    @FXML
    private ListView<String> countryNameList;

    public void buttonClick() {
        List<String> countries = API.getCountryNames();
        List<String> sortByName = countries.stream()
                .sorted()
                .collect(Collectors.toList());
        ObservableList<String> countryNamesList = FXCollections.observableArrayList(sortByName);
        countryNameList.setItems(countryNamesList);
    }

}
