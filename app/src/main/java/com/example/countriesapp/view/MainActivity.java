package com.example.countriesapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.countriesapp.R;
import com.example.countriesapp.viewmodel.ListCountryViewModel;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //UI
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recyclerViewID)
    RecyclerView recyclerView;
    @BindView(R.id.loadingBarID)
    ProgressBar loadingBar;
    @BindView(R.id.errorMessageID)
    TextView errorMessage;
    // vars
    private ListCountryViewModel viewModel;
    private CountryAdapter adapter = new CountryAdapter(new ArrayList<>());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initRecycler();
        initViewModel();
        observeViewModel();
    }

    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(ListCountryViewModel.class);
        //we call method in ViewModel in charge of refreshing the data coming from the server
        viewModel.refresh();
    }

    /**
     * this method observes the three MutableLiveData variables in ViewModel that are in charge
     * of retrieving the data from the server through an API
     */
    private void observeViewModel() {
        viewModel.countriesList.observe(this, countryModels -> {
            if (countryModels != null){
                recyclerView.setVisibility(View.VISIBLE);
                adapter.updateCountryList(countryModels);
            }
        });

        viewModel.loadingError.observe(this, error -> {
            if ( error != null){
                errorMessage.setVisibility( error ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.loading.observe(this, loadingProcess -> {
            if (loadingProcess != null ){
                loadingBar.setVisibility( loadingProcess ? View.VISIBLE : View.GONE);
                if (loadingProcess){
                    errorMessage.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                }
            }
        });
    }

}
