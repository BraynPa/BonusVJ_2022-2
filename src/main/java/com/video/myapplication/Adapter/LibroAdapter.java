package com.video.myapplication.Adapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.video.myapplication.Entities.Libro;
import com.video.myapplication.R;

import java.util.List;

public class LibroAdapter extends RecyclerView.Adapter{
    List<Libro> data;
    private SharedPreferences sharedPreferences;
    public LibroAdapter(List<Libro> data){
        this.data = data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_libro, parent, false);
        return new LibroAdapter.LibroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvNameC = holder.itemView.findViewById(R.id.tvNameC);
        tvNameC.setText(data.get(position).Titulo);
        TextView tvAutorC = holder.itemView.findViewById(R.id.tvAutorC);
        tvAutorC.setText(data.get(position).Autor);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class LibroViewHolder extends RecyclerView.ViewHolder{

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
