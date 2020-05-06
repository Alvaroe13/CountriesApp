package com.example.countriesapp.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCountry {

    private static final String TAG = "Service";

    public static final String BASE_URL = "https://raw.githubusercontent.com/";
    private static ServiceCountry serviceCountryInstance;

    private CountryAPI apiURL = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())         //Gson
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //rxJava
            .build()
            .create(CountryAPI.class);


    public ServiceCountry() {
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
