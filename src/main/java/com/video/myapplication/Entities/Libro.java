package com.video.myapplication.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Libros")
public class Libro {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="Titulo")
    public String Titulo;
    @ColumnInfo(name="Autor")
    public String Autor;
}
