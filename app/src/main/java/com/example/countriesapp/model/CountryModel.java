package com.example.countriesapp.model;

public class CountryModel {
    String name;
    String capitalCity;
    String flag;

    public CountryModel(String name, String capitalCity, String flag) {
        this.name = name;
        this.capitalCity = capitalCity;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public String getFlag() {
        return flag;
    }
}
