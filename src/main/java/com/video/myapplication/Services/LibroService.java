package com.video.myapplication.Services;

import com.video.myapplication.Entities.Libro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LibroService {
    @GET("Libro")
    Call<List<Libro>> all();
    @GET("Libro/{id}")
    Call<Libro> get(@Path("id") int id);
    @POST("Libro")
    Call<Void> create(@Body Libro libro);
    @PUT("Libro/{id}")
    Call<Libro> update(@Body Libro libro, @Path("id") int id);
    @DELETE("Libro/{id}")
    Call<Void> delete(@Path("Libro") int id);
}
