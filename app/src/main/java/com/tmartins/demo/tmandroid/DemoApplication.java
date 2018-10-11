package com.tmartins.demo.tmandroid;

import android.app.Activity;
import android.app.Application;

import com.tmartins.demo.tmandroid.components.CountriesComponent;
import com.tmartins.demo.tmandroid.components.DaggerCountriesComponent;
import com.tmartins.demo.tmandroid.modules.ContextModule;

import timber.log.Timber;

public class DemoApplication extends Application {

    private CountriesComponent countriesApplicationComponent;

    public static DemoApplication get(Activity activity){
        return (DemoApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initTimber();
        initComponents();
    }

    public CountriesComponent getCountriesApplicationComponent() {
        return countriesApplicationComponent;
    }

    private void initTimber(){
        Timber.plant(new Timber.DebugTree());
    }

    private void initComponents(){
        countriesApplicationComponent = DaggerCountriesComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

}
