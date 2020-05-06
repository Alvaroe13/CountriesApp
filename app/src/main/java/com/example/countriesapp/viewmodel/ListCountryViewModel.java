package com.example.countriesapp.viewmodel;

import android.util.Log;

import com.example.countriesapp.model.CountryModel;
import com.example.countriesapp.model.ServiceCountry;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ListCountryViewModel extends ViewModel {

    public MutableLiveData<List<CountryModel>> countriesList = new MutableLiveData<List<CountryModel>>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loadingError = new MutableLiveData<Boolean>();

    private ServiceCountry serviceCountry = ServiceCountry.getInstance();
    private CompositeDisposable disposableData = new CompositeDisposable();



    //this is UI entry point to the ViewModel
    public void refresh(){
        fetchInfoFromDB();
    }

    //here's where the fetching from the server happens to be pass to the UI in refresh method
    private void fetchInfoFromDB() {
        //while fetching info we show the loading bar
        loading.setValue(true);
        disposableData.add(
                serviceCountry.getCountries()   //here we retrieve countries from the service file created
                .subscribeOn(Schedulers.newThread())    //open a new background thread to fetch the info
                .subscribeWith(new DisposableSingleObserver<List<CountryModel>>() {
                    @Override
                    public void onSuccess(List<CountryModel> countryModels) {
                        countriesList.setValue(countryModels);
                        loadingError.setValue(false);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadingError.setValue(true);
                        loading.setValue(false);
                        e.printStackTrace();
                        Log.i(TAG, "onError: error: " + e.getMessage() );

                    }
                })

        );


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposableData.clear();
    }
}
