package com.example.countriesapp.model;

public class CountryModel {
    String name;
    String capital;
    String flag;

    public CountryModel(String name, String capital, String flag) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getFlag() {
        return flag;
    }
}
