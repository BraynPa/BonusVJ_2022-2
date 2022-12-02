package com.video.myapplication.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.video.myapplication.Entities.Libro;

import java.util.List;

@Dao
public interface LibroDao {
    @Query("SELECT * FROM Libros")
    List<Libro> getAll();

    @Query("SELECT * FROM Libros WHERE id = :id")
    Libro find(int id);

    @Insert
    void create(Libro libro);

    @Update
    void update(Libro libro);
    @Delete
    void delete(Libro libro);
}
