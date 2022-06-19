package com.example.proyektpmsportapidatabase.data.local;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proyektpmsportapidatabase.model.note.NoteModel;

@Database(entities = {NoteModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();

    private static final String DB_NAME = "db_notesport";
    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {
        Log.d("Database","succes access");
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
