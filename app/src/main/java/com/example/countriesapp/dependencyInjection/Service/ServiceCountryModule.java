package com.example.countriesapp.dependencyInjection.Service;

import com.example.countriesapp.model.ServiceCountry;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceCountryModule {


    @Provides
    public ServiceCountry provideServiceInstance() {
        return ServiceCountry.getInstance();
    }

}
