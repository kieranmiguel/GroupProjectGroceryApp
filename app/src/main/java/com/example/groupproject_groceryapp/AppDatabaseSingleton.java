package com.example.groupproject_groceryapp;

import android.content.Context;
import androidx.room.Room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Room;
import androidx.room.migration.Migration;
import android.content.Context;
import androidx.annotation.NonNull;

public class AppDatabaseSingleton {

    private static AppDatabase db;

    public static AppDatabase getDatabase(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "sample-database")
            .build();
        }

        return db;
    }
}

