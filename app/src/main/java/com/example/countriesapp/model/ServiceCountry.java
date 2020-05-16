package com.example.countriesapp.model;

import com.example.countriesapp.dependencyInjection.DaggerCountryAPIComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class ServiceCountry {

    private static ServiceCountry serviceCountryInstance;

    @Inject
    public CountryAPI apiURL;   //dagger injection


    public ServiceCountry() {
        //here we make the connection between the Module and the @Inject annotation.
        DaggerCountryAPIComponent.create().connect(this);
    }

    //singleton
    public static ServiceCountry getInstance(){
        if (serviceCountryInstance == null){
            serviceCountryInstance = new ServiceCountry();
        }
        return serviceCountryInstance;
    }

    //info fetch from serve is store in this method called "getCountries"
    public Single<List<CountryModel>> getCountries(){
        return apiURL.getInfo();
    }



}
