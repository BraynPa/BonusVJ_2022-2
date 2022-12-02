package com.video.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.video.myapplication.Adapter.LibroAdapter;
import com.video.myapplication.Database.AppDataBase;
import com.video.myapplication.Entities.Libro;

import java.util.List;

public class ListsLibroActivity extends AppCompatActivity {
    RecyclerView rvContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists_libro);
        AppDataBase db = AppDataBase.getInstance(this);
        List<Libro> data = db.libroDao().getAll();
        rvContact = findViewById(R.id.rvContact);
        rvContact.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvContact.setAdapter(new LibroAdapter((data)));
    }
}