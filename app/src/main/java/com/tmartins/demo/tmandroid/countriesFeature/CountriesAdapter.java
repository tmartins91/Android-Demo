package com.tmartins.demo.tmandroid.countriesFeature;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tmartins.demo.tmandroid.R;
import com.tmartins.demo.tmandroid.models.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {

    private final Picasso picasso;
    private List<Country> resultList = new ArrayList<>();


    public CountriesAdapter(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public CountriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_country,
                parent, false);
        return new CountriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountriesViewHolder holder, int position) {
        Country country = resultList.get(position);

        holder.countryNameTv.setText(country.getName());
        holder.countryRegionTv.setText(String.format("Region: %s", country.getRegion()));
        holder.countryAreaTv.setText(String.format(Locale.getDefault(), "Area: %d km2", country.getArea()));
        holder.countryCurrencyTv.setText(String.format("Currency code: %s", country.getCurrencyCode()));

        picasso.with(holder.countryImage.getContext())
                .load(country.getFlagPng())
                .fit().centerCrop()
                .into(holder.countryImage);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setItems(List<Country> results) {
        resultList.clear();
        resultList.addAll(results);
        notifyDataSetChanged();
    }

    public class CountriesViewHolder extends RecyclerView.ViewHolder {
        public TextView countryNameTv;
        public ImageView countryImage;
        public TextView countryRegionTv;
        public TextView countryAreaTv;
        public TextView countryCurrencyTv;

        public CountriesViewHolder(View itemView) {
            super(itemView);
            countryNameTv = itemView.findViewById(R.id.country_name);
            countryImage = itemView.findViewById(R.id.country_image);
            countryRegionTv = itemView.findViewById(R.id.country_region);
            countryAreaTv = itemView.findViewById(R.id.country_area);
            countryCurrencyTv = itemView.findViewById(R.id.country_currency);
        }
    }

}
