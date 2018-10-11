package com.tmartins.demo.tmandroid.interfaces;

import com.tmartins.demo.tmandroid.models.CountriesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CountriesApi {

    @GET("getCountries")
    Call<CountriesResult> getAllCountries();

    @GET("getCountries")
    Call<CountriesResult> getCountriesByRegion(@Query("pRegion") String region);

}
