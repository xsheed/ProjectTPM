package com.example.convertnilai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit;
    private TextView tvNama, tvNim, tvPredikat;
    private EditText etNama, etNim, etNilai;
    private LinearLayout lyMain;
    private RelativeLayout lyHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = findViewById(R.id.Btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                try {
                    //if (dNilai >= 1.00 && dNilai <= 4.00) {
                    //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    //startActivity(intent);
                    //} else {
                    //}
                    etNama = findViewById(R.id.ET_nama);
                    etNim = findViewById(R.id.ET_nim);
                    etNilai = findViewById(R.id.ET_nilai);
                    tvNama = findViewById(R.id.TV_vnama);
                    tvNim = findViewById(R.id.TV_vnim);
                    tvPredikat = findViewById(R.id.TV_vnilai);
                    lyMain = findViewById(R.id.layout_main);
                    lyHasil = findViewById(R.id.layout_hasil);

                    String sNama = etNama.getText().toString();
                    String sNim = etNim.getText().toString();
                    String sNilai = etNilai.getText().toString();
                    double dNilai = Double.parseDouble(sNilai);
                    String sPredikat;

                    if (dNilai == 1) {
                        sPredikat = "D";
                    } else if (dNilai < 1.00 && dNilai <= 1.33) {
                        sPredikat = "D+";
                    } else if (dNilai < 1.33 && dNilai <= 1.66) {
                        sPredikat = "C-";
                    } else if (dNilai < 1.66 && dNilai <= 2.00) {
                        sPredikat = "C";
                    } else if (dNilai < 2.00 && dNilai <= 2.33) {
                        sPredikat = "C+";
                    } else if (dNilai < 2.33 && dNilai <= 2.66) {
                        sPredikat = "B-";
                    } else if (dNilai < 2.66 && dNilai <= 3.00) {
                        sPredikat = "B";
                    } else if (dNilai < 3.00 && dNilai <= 3.33) {
                        sPredikat = "B+";
                    } else if (dNilai < 3.33 && dNilai <= 3.66) {
                        sPredikat = "A-";
                    } else if (dNilai < 3.66 && dNilai <= 4.00) {
                        sPredikat = "A";
                    } else {
                        //System.out.println("rentang nilai 1 - 4");
                        sPredikat = "Rentang Nilai 1-4!";
                        etNilai.setText("");
                        etNilai.setHint(sPredikat);
                        return;
                    }

                    tvPredikat.setText(sPredikat);
                    tvNama.setText(sNama);
                    tvNim.setText(sNim);

                    lyMain.setVisibility(View.GONE);
                    lyHasil.setVisibility(View.VISIBLE);
                    //setContentView(R.layout.display_activity);
                } catch (NumberFormatException nfe) {
                    Toast.makeText(getApplicationContext(),"Field Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
