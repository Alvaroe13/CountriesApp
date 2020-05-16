package com.example.countriesapp.dependencyInjection.Service;


import com.example.countriesapp.viewmodel.ListCountryViewModel;

import dagger.Component;

@Component(modules = ServiceCountryModule.class)
public interface ServiceCountryComponent {

    void setConnection(ListCountryViewModel viewModel);
}
