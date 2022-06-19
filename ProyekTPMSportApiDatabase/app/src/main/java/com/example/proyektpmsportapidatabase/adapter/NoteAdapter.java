package com.example.proyektpmsportapidatabase.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyektpmsportapidatabase.R;
import com.example.proyektpmsportapidatabase.data.local.AppDatabase;
import com.example.proyektpmsportapidatabase.model.note.NoteModel;
import com.example.proyektpmsportapidatabase.view.activity.AddActivity;
import com.example.proyektpmsportapidatabase.view.activity.EditActivity;

import java.util.List;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{
    private List<NoteModel> noteList;

    public void setData(List<NoteModel> list) {
        Log.d("Set Data Adapter","Data set");
        noteList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_note, parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(noteList.get(position));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView sportNote, textNote, dateNote;
        Button btnEdit, btnDelete;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            sportNote = itemView.findViewById(R.id.t_title_note);
            textNote = itemView.findViewById(R.id.t_overview_note);
            dateNote = itemView.findViewById(R.id.t_d_date_note);
            btnEdit = itemView.findViewById(R.id.btn_edit_note);
            btnDelete = itemView.findViewById(R.id.btn_delete_note);
        }

        public void bind(NoteModel noteModel) {
            Log.d("Detail","Masuk");

            sportNote.setText(noteModel.getSportNote());
            dateNote.setText(noteModel.getDateNote());
            textNote.setText(noteModel.getTextNote());

            btnEdit.setOnClickListener(v -> {
                Intent editNote = new Intent(itemView.getContext(), EditActivity.class);
                editNote.putExtra("idNote", noteModel.getIdNote());
                editNote.putExtra("sportname", noteModel.getSportNote());
                editNote.putExtra("textNote", noteModel.getTextNote());
                itemView.getContext().startActivity(editNote);
            });

            btnDelete.setOnClickListener(v -> {
                AppDatabase appDatabase = AppDatabase.getInstance(itemView.getContext());
                appDatabase.noteDao().delete(noteModel);
                List<NoteModel> noteList = appDatabase.noteDao().getAll();
                setData(noteList);
            });
        }
    }
}
