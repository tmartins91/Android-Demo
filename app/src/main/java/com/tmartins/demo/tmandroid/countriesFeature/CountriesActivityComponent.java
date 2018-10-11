package com.tmartins.demo.tmandroid.countriesFeature;

import com.tmartins.demo.tmandroid.components.CountriesComponent;

import dagger.Component;

@Component(modules = CountriesActivityModule.class, dependencies = CountriesComponent.class)
@CountriesActivityScope
public interface CountriesActivityComponent {

    void injectCountriesActivity(CountriesActivity countriesActivity);

}
