package com.restcountries.api;

import com.restcountries.extractor.Extractor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

//todo call api to get all countries (https://restcountries.com/v3.1/all), parse only country names as a list, find interested one to do another get, to call another to see cities!
public class API {
    public static void getRequest() {
        HttpClient httpClient = HttpClient.newHttpClient();
        String allCountriesEndpoint = "https://restcountries.com/v3.1/all";
        String countryEndpoint = "https://restcountries.com/v3.1/name/Latvia"; //todo variable in country
        //String capitalEndpoint = "https://restcountries.com/v3.1/capital/{capital}" //todo need to add this later. I want to call country name first -> get capital name from there to UI -> call the capital using name from UI

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(allCountriesEndpoint))
                .GET()
                .build();

        try { //todo add validation to 200, else error
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = getResponse.body();

            //parse JSON String into proper JSON Object using JSONObject library (pretty print indicator 4)
            //apparently response was bricking due to JSON objects and arrays mix, so I had to add if/else statement to handle both cases
            String formatJSON;
            if (responseBody.startsWith("[")) {
                formatJSON = new JSONArray(responseBody).toString(4);
            } else {
                formatJSON = new JSONObject(responseBody).toString(4);
            }
            String formattedJSON = formatJSON; //additional variable just for readability (because formatJSON does the formatting, but we writeToFile already formattedJSON
            System.out.println(formattedJSON);

            //todo temporary disabling: Extractor.writeToFile(formattedJSON);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
