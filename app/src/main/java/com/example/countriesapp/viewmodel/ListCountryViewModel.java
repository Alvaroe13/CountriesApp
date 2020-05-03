package com.example.countriesapp.viewmodel;

import com.example.countriesapp.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListCountryViewModel extends ViewModel {

    public MutableLiveData<List<CountryModel>> countriesList = new MutableLiveData<List<CountryModel>>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loadingError = new MutableLiveData<Boolean>();

    //this is UI entry point to the ViewModel
    public void refresh(){
        fetchInfoFromDB();
    }

    //here's where the fetching from the server happens to be pass to the UI in refresh method
    private void fetchInfoFromDB() {
        //fake info for now
        CountryModel country1 = new CountryModel("Argentina", "Buenos Aires", "");
        CountryModel country2 = new CountryModel("Bolivia", "La Paz", "");
        CountryModel country3 = new CountryModel("Colombia", "Bogota", "");

        List<CountryModel> listOfCountries = new ArrayList<>();
        listOfCountries.add(country1);
        listOfCountries.add(country2);
        listOfCountries.add(country3);

        countriesList.setValue( listOfCountries );
        //these next two are false since we're not fetching info from a server just yet.
        loading.setValue(false);
        loadingError.setValue(false);

    }


}
