package com.example.proyektpmsportapidatabase.data.remote;

import com.example.proyektpmsportapidatabase.model.sport.SportResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SportRepository {
    @GET("all_sports.php")
    Call<SportResponse> getSportDiscover();
}
