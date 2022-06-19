package com.example.proyektpmsportapidatabase.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;
    String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    public SportRepository getApiSport() {
        if (retrofit == null) {
            retrofit = new  Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(SportRepository.class);
    }
}
