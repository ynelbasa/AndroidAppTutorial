package com.apps.a11_noteapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    // Singleton database instance
    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        // Instantiate database only once when it has no value yet
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    // tells room to wait for schema changes, avoids illegalStateException during migration
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}