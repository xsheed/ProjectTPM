package com.example.proyektpmsportapidatabase.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.proyektpmsportapidatabase.R;
import com.example.proyektpmsportapidatabase.view.fragment.NoteFragment;
import com.example.proyektpmsportapidatabase.view.fragment.SportFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView btmNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmNav = findViewById(R.id.btm_nav);
        btmNav.setOnNavigationItemSelectedListener(this);

        loadFragment(new SportFragment());
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .show(fragment)
                    .commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sport_ico:
                loadFragment(new SportFragment());
                break;
            case R.id.note_ico:
                Log.d("Fragment","Masuk Fragment");
                loadFragment(new NoteFragment());
                break;

        }
        return false;
    }
}
