package com.example.proyektpmsportapidatabase.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyektpmsportapidatabase.R;
import com.example.proyektpmsportapidatabase.adapter.NoteAdapter;
import com.example.proyektpmsportapidatabase.data.local.AppDatabase;
import com.example.proyektpmsportapidatabase.model.note.NoteModel;

import java.util.List;

public class NoteFragment extends Fragment {

    RecyclerView rvNote;
    NoteAdapter noteAdapter;
    AppDatabase appDatabase;

    public NoteFragment() {
        // Required empty public constructor
    }
    @Override
    public void onResume() {
        super.onResume();
        List<NoteModel> noteList = appDatabase.noteDao().getAll();
        noteAdapter.setData(noteList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvNote = view.findViewById(R.id.rv_note);
        rvNote.setLayoutManager(new LinearLayoutManager(getActivity()));

        appDatabase = AppDatabase.getInstance(getActivity());
        noteAdapter = new NoteAdapter();
        List<NoteModel> noteList = appDatabase.noteDao().getAll();
        noteAdapter.setData(noteList);

        rvNote.setAdapter(noteAdapter);

        Log.d("rv note",noteList.toString());
    }

}