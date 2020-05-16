package com.example.countriesapp.dependencyInjection.API;

import com.example.countriesapp.model.ServiceCountry;

import dagger.Component;

@Component(modules = {CountryAPIModule.class})  // here we specify what we're going to inject
public interface CountryAPIComponent {

    //this interface is the connection between the Module and the object to be Injected.

    void connect(ServiceCountry service); // here we specify where we're going to do the injection.
                                          // aka, where the @Inject annotation is


}
