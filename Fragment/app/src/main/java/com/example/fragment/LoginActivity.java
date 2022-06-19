package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText username, pass;

    SessionManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);

        sm = new SessionManager(this);
        if (sm.isUserLogin()) {
            moveActivity();
        }

        btnLogin.setOnClickListener(v -> {
            String sUsername = username.getText().toString();
            String sPass = pass.getText().toString();

            if (sUsername.isEmpty()) {
                username.setError("Tidak Boleh Kosong");
            } else if (sPass.isEmpty()) {
                pass.setError("Tidak Boleh Kosong");
            } else {
                if (sUsername.equals("123180039") && sPass.equals("iffatuz")) {
                    saveSession();
                } else {
                    Toast.makeText(this, "Password atau Username Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void moveActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void saveSession() {
        sm.createLoginSession();
        moveActivity();
    }
}