package com.tmartins.demo.tmandroid.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tmartins.demo.tmandroid.Constants;
import com.tmartins.demo.tmandroid.interfaces.CountriesApi;
import com.tmartins.demo.tmandroid.interfaces.CountriesApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpClientModule.class)
public class CountriesModule {

    @Provides
    public CountriesApi countriesApi(Retrofit retrofit){
        return retrofit.create(CountriesApi.class);
    }

    @CountriesApplicationScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient,
                             GsonConverterFactory gsonConverterFactory, Gson gson){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

}