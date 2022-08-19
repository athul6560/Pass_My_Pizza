package com.zeezaglobal.passmypizza.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.zeezaglobal.passmypizza.Data.Pizza;

@Database(entities = {Pizza.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract pizzaDao pizzaDao();

    private static AppDatabase INSTANCE;

   public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class,
                                    "pizza_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

}