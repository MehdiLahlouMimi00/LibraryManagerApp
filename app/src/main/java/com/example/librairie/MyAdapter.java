package com.example.librairie;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {


    public MyAdapter(Context context, List<Livre> livres) {
        this.context = context;
        this.livres = livres;
    }

    Context context;
    List<Livre> livres;



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(Integer.toString(livres.get(position).id));
        holder.date.setText(Integer.toString(livres.get(position).date));
        holder.genre.setText(livres.get(position).genre);
        holder.titre.setText(livres.get(position).titre);
        holder.auteur.setText(livres.get(position).auteur);
    }

    @Override
    public int getItemCount() {
        return livres.size();
    }
}
