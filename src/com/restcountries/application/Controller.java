package com.restcountries.application;

import com.restcountries.api.API;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.JSONArray;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    @FXML
    private Button tryMe;

    @FXML
    private ListView<String> countryNameList;

    @FXML
    private Button exportToJSON;

    @FXML
    private Button getCapitalData;

    @FXML
    private Button getCountryData;

    @FXML
    private TextArea countryData;

    public void tryMeClick() { //this calls my API getCountryNames method from API class, then filters endresult from there and returns as ObservableList
        List<String> countries = API.getCountryNames();
        List<String> sortByName = countries.stream()
                .sorted()
                .collect(Collectors.toList());
        ObservableList<String> countryNamesList = FXCollections.observableArrayList(sortByName);
        countryNameList.setItems(countryNamesList);
    }

    public void getCountryDataClick() {
        String selectedCountry = countryNameList.getSelectionModel().getSelectedItem();
        countryData.setText(API.getCountryData(selectedCountry).toString()); //retrieving the data from countryData, setting it as text (needed for textarea field). this is one step that executes getCountryData method too
    }
}
