package com.video.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.video.myapplication.Entities.Libro;
import com.video.myapplication.Factories.RetrofitFactory;
import com.video.myapplication.Services.LibroService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FormLibroActivity extends AppCompatActivity {
    Button btnGuardarC;
    EditText etNombreC,etAutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_libro);
        Retrofit retrofit = new RetrofitFactory(this).build();
        LibroService service = retrofit.create(LibroService.class);
        btnGuardarC = findViewById(R.id.btnGuardarC);
        etNombreC = findViewById(R.id.etMotivo);
        etAutor = findViewById(R.id.etAutor);
        btnGuardarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNombreC.getText().toString().equals("") || etAutor.getText().toString().equals("")){
                    if(etNombreC.getText().toString().equals("") && !etAutor.getText().toString().equals("") ){
                        Toast.makeText(FormLibroActivity.this,"Ingresar Titulo",Toast.LENGTH_LONG).show();
                    }else if(!etNombreC.getText().toString().equals("") && etAutor.getText().toString().equals("") ){
                        Toast.makeText(FormLibroActivity.this,"Ingresar Autor",Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(FormLibroActivity.this,"Campos Vacios",Toast.LENGTH_LONG).show();
                }else{
                    Libro libro = new Libro();
                    libro.Titulo = etNombreC.getText().toString();
                    libro.Autor = etAutor.getText().toString();

                    service.create(libro).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Toast.makeText(FormLibroActivity.this,"Libro Api Creado",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(FormLibroActivity.this, MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });
                }

            }
        });
    }
}