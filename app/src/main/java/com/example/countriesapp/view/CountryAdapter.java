package com.example.countriesapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.countriesapp.R;
import com.example.countriesapp.model.CountryModel;
import com.example.countriesapp.model.Util;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>{

    private List<CountryModel> countriesList;

    public CountryAdapter(List<CountryModel> countriesList) {
        this.countriesList = countriesList;
    }

    public void updateCountryList( List<CountryModel> newCountries){
        countriesList.clear();
        countriesList.addAll(newCountries);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_individual_layout, viewGroup, false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

        holder.bind(countriesList.get(position));   //bind  method from ViewHolder class
    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }


    public class  CountryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.flagImage)
        ImageView countryFlag;

        @BindView(R.id.countryName)
        TextView countryName;

        @BindView(R.id.capitalCity)
        TextView capitalCity;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            //here we bind the UI elements
            ButterKnife.bind(this, itemView);
        }

        void bind( CountryModel countryModel){
            countryName.setText(countryModel.getName());
            capitalCity.setText(countryModel.getCapitalCity());
            //here we pass the flags
            Util.loadPicture(countryFlag, countryModel.getFlag(), Util.getProgressBar(countryFlag.getContext()));
        }


    }
}
