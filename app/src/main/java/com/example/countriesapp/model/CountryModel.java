package com.example.countriesapp.model;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("name")
    String name;

    @SerializedName("capital")  //this is it's key name in the json file
    String capitalCity;

    @SerializedName("flagPNG")
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
