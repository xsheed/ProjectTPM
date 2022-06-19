package com.example.proyektpmsportapidatabase.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyektpmsportapidatabase.R;
import com.example.proyektpmsportapidatabase.adapter.SportAdapter;
import com.example.proyektpmsportapidatabase.model.sport.SportsItem;
import com.example.proyektpmsportapidatabase.view.viewmodel.SportViewModel;

import java.util.ArrayList;

public class SportFragment extends Fragment {
    private RecyclerView rvSport;
    private SportAdapter sportAdapter;
    private SportViewModel viewModelSport;

    public SportFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSport = view.findViewById(R.id.rv_sport);
        rvSport.setLayoutManager(new LinearLayoutManager(getActivity()));

        sportAdapter = new SportAdapter();
        sportAdapter.notifyDataSetChanged();

        viewModelSport = new ViewModelProvider(this).get(SportViewModel.class);
        viewModelSport.setSportDiscover();
        viewModelSport.getSportDiscover().observe(getActivity(), getSportDiscover);

        rvSport.setAdapter(sportAdapter);
        //rvSport.setLayoutManager(new LinearLayoutManager(view.getContext()));

    }

    private Observer<ArrayList<SportsItem>> getSportDiscover = new Observer<ArrayList<SportsItem>>() {
        @Override
        public void onChanged(ArrayList<SportsItem> sportsItems) {
            if (sportsItems != null) {
                sportAdapter.setData(sportsItems);
            }
        }
    };
}