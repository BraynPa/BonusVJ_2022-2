package com.video.myapplication.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.video.myapplication.Dao.LibroDao;
import com.video.myapplication.Entities.Libro;

@Database(entities = {Libro.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract LibroDao libroDao();
    public static AppDataBase getInstance(Context context){
        return Room.databaseBuilder(context, AppDataBase.class, "Bonus_db").allowMainThreadQueries().build();
    }
}
