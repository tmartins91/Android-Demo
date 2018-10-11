package com.tmartins.demo.tmandroid.modules;

import android.content.Context;

import com.tmartins.demo.tmandroid.interfaces.ApplicationContext;
import com.tmartins.demo.tmandroid.interfaces.CountriesApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @ApplicationContext
    @CountriesApplicationScope
    @Provides
    public Context context(){
        return context.getApplicationContext();
    }

}
