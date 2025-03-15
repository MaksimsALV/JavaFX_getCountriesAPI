package com.restcountries.api;

import com.restcountries.extractor.Extractor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    public void getRequest() {
        HttpClient httpClient = HttpClient.newHttpClient();
        String endpointURL = "https://restcountries.com/v3.1/name/Latvia"; //todo variable in country
        //https://restcountries.com/v3.1/capital/{capital} //todo need to add this later

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(endpointURL))
                .GET()
                .build();

        try {
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = getResponse.body();
            Extractor.writeToFile(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
