package com.example.proyektpmsportapidatabase.model.note;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notesport")
public class NoteModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idNote")
    private int idNote;

    @ColumnInfo(name = "sportNote")
    private String sportNote;

    @ColumnInfo(name = "textNote")
    private String textNote;

    @ColumnInfo(name = "dateNote")
    private String dateNote;

    public NoteModel(String sportNote, String textNote, String dateNote) {
        this.sportNote = sportNote;
        this.textNote = textNote;
        this.dateNote = dateNote;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getSportNote() {
        return sportNote;
    }

    public String getTextNote() {
        return textNote;
    }

    public String getDateNote() {
        return dateNote;
    }

}
