package com.example.tugasrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView iv;
    private TextView tvtitle, tvdesk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        iv = findViewById(R.id.iv_detail);
        tvtitle = findViewById(R.id.tv_titledetail);
        tvdesk = findViewById(R.id.tv_deskdetail);

        Olshop data = getIntent().getParcelableExtra("extra");

        tvtitle.setText(data.getNama());
        tvdesk.setText(data.getDeskripsi());
        Glide.with(this).load(data.getLogo()).into(iv);
    }
}