package com.tmartins.demo.tmandroid.countriesFeature;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tmartins.demo.tmandroid.DemoApplication;
import com.tmartins.demo.tmandroid.R;
import com.tmartins.demo.tmandroid.interfaces.CountriesApi;
import com.tmartins.demo.tmandroid.models.CountriesResult;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class CountriesActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Inject
    CountriesApi countriesApi;

    @Inject
    CountriesAdapter countriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        buildComponent();
        initViews();
        fillCountries();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void buildComponent() {
        CountriesActivityComponent countriesActivityComponent = DaggerCountriesActivityComponent.builder()
                .countriesActivityModule(new CountriesActivityModule(this))
                .countriesComponent(DemoApplication.get(this).getCountriesApplicationComponent())
                .build();
        countriesActivityComponent.injectCountriesActivity(this);
    }

    private void fillCountries() {
        Call<CountriesResult> countriesCall = getCountriesApi().getCountriesByRegion("Europe");
        countriesCall.enqueue(new Callback<CountriesResult>() {
            @Override
            public void onResponse(Call<CountriesResult> call, @NonNull Response<CountriesResult> response) {
                if(response.isSuccessful()) {
                    CountriesResult result = response.body();
                    if (result.getSuccess()){
                        countriesAdapter.setItems(response.body().getCountryList());
                        recyclerView.setAdapter(countriesAdapter);
                    }else {
                        Timber.i(String.format("Countries api response failed... Message: %s", result.getTechnicalMessage()));
                    }
                }else {
                    Timber.i(String.format("Response failed... Message: %s", response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<CountriesResult> call, Throwable t) {
                Timber.i(t.getMessage());
            }
        });
    }

    public CountriesApi getCountriesApi() {
        return countriesApi;
    }

}
