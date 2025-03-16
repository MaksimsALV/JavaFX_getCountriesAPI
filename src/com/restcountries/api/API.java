package com.restcountries.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

//todo call api to get all countries (https://restcountries.com/v3.1/all), parse only country names as a list, find interested one to do another get, to call another to see cities!
public class API {
    public static List<String> getCountryNames() {
        HttpClient httpClient = HttpClient.newHttpClient();
        String allCountriesEndpoint = "https://restcountries.com/v3.1/all";

        //todo this must be moved to different method each
        //String countryEndpoint = "https://restcountries.com/v3.1/name/Latvia"; //todo variable in country
        //String capitalEndpoint = "https://restcountries.com/v3.1/capital/{capital}"; //todo need to add this later. I want to call country name first -> get capital name from there to UI -> call the capital using name from UI
        //todo end

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(allCountriesEndpoint)) //sets url
                .GET() //sets GET request method
                .build(); //executing the request (mandatory step)

        List<String> countryNames = new ArrayList<>();
        try { //todo add validation to 200, else error
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = getResponse.body();

            //response parser (extracting only country names in a string using JSON Array format for next API request. This is better because the list is properly structured as arrayslist)
            JSONArray countriesArray = new JSONArray(responseBody);
                for (int i = 0; i < countriesArray.length(); i++) { //adding indicator to every country name
                    countryNames.add(countriesArray.getJSONObject(i).getJSONObject("name").getString("common")); //exact path what to look at: name.common: value
                }
            System.out.println(countryNames); //analysis for the output
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryNames;
    }

    public static List<String> getCountryData(String selectedCountry) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String countryEndpoint = "https://restcountries.com/v3.1/name/" + selectedCountry;

        //String capitalEndpoint = "https://restcountries.com/v3.1/capital/{capital}"; //todo need to add this later. I want to call country name first -> get capital name from there to UI -> call the capital using name from UI
        //todo end

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(countryEndpoint)) //sets url
                .GET() //sets GET request method
                .build(); //executing the request (mandatory step)

        List<String> countryData = new ArrayList<>();
        try { //todo add validation to 200, else error
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = getResponse.body();

            //parse JSON String into proper JSON Object using JSONObject library (pretty print indicator 4)
            //apparently response was bricking due to JSON objects and arrays mix, so I had to add if/else statement to handle both cases
            if (responseBody.startsWith("[")) {
                JSONArray countryArray = new JSONArray(responseBody);
                for (int i = 0; i < countryArray.length(); i++) {
                    countryData.add(countryArray.getJSONObject(i).toString(4));
                }
            } else {
                countryData.add(new JSONObject(responseBody).toString(4));
            }
            System.out.println(countryData); //analysis for the output
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryData;
    }
}
