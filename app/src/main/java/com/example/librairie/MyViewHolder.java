package com.example.librairie;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView titre, auteur, genre, date, id;

    public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);
        titre = itemView.findViewById(R.id.titreA);
        auteur = itemView.findViewById(R.id.auteurA);
        genre = itemView.findViewById(R.id.genreA);
        date = itemView.findViewById(R.id.dateA);
        id = itemView.findViewById(R.id.idA);
    }

}
