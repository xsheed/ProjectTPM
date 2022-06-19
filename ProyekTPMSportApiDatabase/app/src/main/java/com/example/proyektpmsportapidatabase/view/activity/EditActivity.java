package com.example.proyektpmsportapidatabase.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyektpmsportapidatabase.R;
import com.example.proyektpmsportapidatabase.data.local.AppDatabase;
import com.example.proyektpmsportapidatabase.model.note.NoteModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditActivity extends AppCompatActivity {
    private EditText etEdit;
    private Button btnEdit;
    private TextView tvTitle;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etEdit = findViewById(R.id.et_editnote);
        tvTitle = findViewById(R.id.t_title_editnote);
        btnEdit = findViewById(R.id.btn_done_editnote);

        int id = getIntent().getIntExtra("idNote", 0);
        String sportname = getIntent().getStringExtra("sportname");
        tvTitle.setText(sportname);
        String textNote = getIntent().getStringExtra("textNote");
        etEdit.setText(textNote);

        appDatabase = AppDatabase.getInstance(this);

        btnEdit.setOnClickListener(v -> {

            String textEdit = etEdit.getText().toString();
            String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

            if (textEdit.isEmpty()) {
                etEdit.setError("Can't Save Empty Note");
            }
            else {

                NoteModel noteModel = new NoteModel(sportname, textEdit, date);
                noteModel.setIdNote(id);
                appDatabase.noteDao().update(noteModel);

                this.finish();
            }

        });
    }
}