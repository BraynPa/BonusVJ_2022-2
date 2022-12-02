package com.video.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.video.myapplication.Database.AppDataBase;
import com.video.myapplication.Entities.Libro;
import com.video.myapplication.Factories.RetrofitFactory;
import com.video.myapplication.Services.LibroService;

import java.util.List;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Button btnLista,btnBd,btnSinc;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("com.example.Libros.MyAPPVJ", MODE_PRIVATE);

        String credentials = Credentials.basic("1", "321");

        SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
        sharedEditor.putString("AUTHORIZATION", credentials);
        sharedEditor.apply();
        AppDataBase db = AppDataBase.getInstance(this);
        Retrofit retrofit = new RetrofitFactory(this).build();
        LibroService service = retrofit.create(LibroService.class);
        btnLista = findViewById(R.id.btnLista);
        btnBd = findViewById(R.id.btnBd);
        btnSinc = findViewById(R.id.btnSinc);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormLibroActivity.class);
                startActivity(intent);
            }
        });
        btnBd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListsLibroActivity.class);
                startActivity(intent);
            }
        });
        btnSinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.all().enqueue(new Callback<List<Libro>>() {
                    @Override
                    public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {
                        List<Libro> data = response.body();
                        List<Libro> info = db.libroDao().getAll();

                        if(data.size() > info.size()){
                            for(int i=info.size(); i<data.size();i++){
                                Libro contactAux = data.get(i);
                                if(contactAux != null){
                                    Libro dataaux = new Libro();
                                    dataaux.Titulo = contactAux.Titulo;
                                    dataaux.Autor = contactAux.Autor;
                                    db.libroDao().create(dataaux);
                                }
                            }
                        }
                        Toast.makeText(MainActivity.this,"Sincronizado correctamente",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<List<Libro>> call, Throwable t) {

                    }
                });

            }
        });
    }
}