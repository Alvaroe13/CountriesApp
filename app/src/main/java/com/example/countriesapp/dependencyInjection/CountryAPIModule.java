package com.example.countriesapp.dependencyInjection;

import com.example.countriesapp.model.CountryAPI;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class CountryAPIModule {

    private static final String BASE_URL = "https://raw.githubusercontent.com/";

    @Provides   //annotation to use in code to be provided in the injection
    public CountryAPI provideCountryAPI() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())         //Gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //rxJava
                .build()
                .create(CountryAPI.class);
    }


}
