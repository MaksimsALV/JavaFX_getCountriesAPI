package com.restcountries.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    public String endpointURL = "https://restcountries.com/v3.1/name/latvia"; //todo variable in country
    public String getRequestHeader = "Content-Type";
    public String getRequestHeaderValue = "application/json";

    public void getRequest() {

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(endpointURL))
                .header(getRequestHeader, getRequestHeaderValue)
                .GET()
                .build();

        try {
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = getResponse.body();
            System.out.println(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
