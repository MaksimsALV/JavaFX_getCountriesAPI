package com.restcountries;


import com.restcountries.api.API;

public class Run {
    public static void main(String[] args) {
        API api = new API();
        api.getRequest();
    }
}
