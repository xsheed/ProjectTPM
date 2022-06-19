package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView iv;
    private TextView tvtitle, tvdesk;

    SessionManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        iv = findViewById(R.id.iv_detail);
        tvtitle = findViewById(R.id.tv_titledetail);
        tvdesk = findViewById(R.id.tv_deskdetail);
        sm = new SessionManager(this);
        if (!sm.isUserLogin()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        Olshop data = getIntent().getParcelableExtra("extra");

        tvtitle.setText(data.getNama());
        tvdesk.setText(data.getDeskripsi());
        Glide.with(this).load(data.getLogo()).into(iv);
    }
}