package com.tmartins.demo.tmandroid.countriesFeature;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class CountriesActivityModule {

    private final CountriesActivity countriesActivity;

    public CountriesActivityModule(CountriesActivity countriesActivity) {
        this.countriesActivity = countriesActivity;
    }

    @Provides
    @CountriesActivityScope
    public CountriesAdapter countriesAdapter(Picasso picasso){
        return new CountriesAdapter(picasso);
    }
}
