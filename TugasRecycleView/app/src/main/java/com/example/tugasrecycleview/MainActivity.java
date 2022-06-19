package com.example.tugasrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv1;
    private OlshopAdapter olshopAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = findViewById(R.id.rv1);
        olshopAdapter = new OlshopAdapter();

        ArrayList<Olshop> listData = Data.getOlshopData();
        olshopAdapter.setData(listData);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1.setAdapter(olshopAdapter);
    }

}