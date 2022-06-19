package com.example.proyektpmsportapidatabase.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyektpmsportapidatabase.data.remote.ApiMain;
import com.example.proyektpmsportapidatabase.model.sport.SportResponse;
import com.example.proyektpmsportapidatabase.model.sport.SportsItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<SportsItem>> listSport = new MutableLiveData<>();

    public void setSportDiscover() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiSport().getSportDiscover().enqueue(new Callback<SportResponse>() {
            @Override
            public void onResponse(Call<SportResponse> call, Response<SportResponse> response) {
                SportResponse discoverResponse = response.body();
                if (discoverResponse != null && discoverResponse.getSports() != null) {
                    ArrayList<SportsItem> leaguesItems = discoverResponse.getSports();
                    listSport.postValue(leaguesItems);
                }
            }

            @Override
            public void onFailure(Call<SportResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<SportsItem>> getSportDiscover() {
        return listSport;
    }
}
