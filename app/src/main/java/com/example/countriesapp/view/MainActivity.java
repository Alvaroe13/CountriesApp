package com.example.countriesapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.countriesapp.R;
import com.example.countriesapp.viewmodel.ListCountryViewModel;

import java.util.ArrayList;

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

        viewModel = new ViewModelProvider(this).get(ListCountryViewModel.class);

    }


}
