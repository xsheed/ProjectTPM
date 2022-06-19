package com.example.proyektpmsportapidatabase.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.proyektpmsportapidatabase.model.note.NoteModel;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM Notesport")
    List<NoteModel> getAll();

    @Insert
    void insert(NoteModel noteModel);

    @Update
    void update(NoteModel noteModel);

    @Delete
    void delete(NoteModel noteModel);

}
