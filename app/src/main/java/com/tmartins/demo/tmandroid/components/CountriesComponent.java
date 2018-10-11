package com.tmartins.demo.tmandroid.components;

import com.squareup.picasso.Picasso;
import com.tmartins.demo.tmandroid.interfaces.CountriesApi;
import com.tmartins.demo.tmandroid.interfaces.CountriesApplicationScope;
import com.tmartins.demo.tmandroid.modules.CountriesModule;
import com.tmartins.demo.tmandroid.modules.PicassoModule;

import dagger.Component;

@CountriesApplicationScope
@Component(modules = {CountriesModule.class, PicassoModule.class})
public interface CountriesComponent {

    CountriesApi getCountriesService();

    Picasso getPicasso();

}
