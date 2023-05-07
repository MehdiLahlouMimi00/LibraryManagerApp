package com.example.librairie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private DatabaseHelper db;

    Button liste;
    Button ajouter;
    Button supprimer;
    Button modifier;
    EditText titre;
    EditText auteur;
    EditText anne;
    EditText genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);


        // Boutons
        ajouter = findViewById(R.id.ajouter);
        liste = findViewById(R.id.liste);
        supprimer = findViewById(R.id.supprimer);
        modifier = findViewById(R.id.modifier);


        // Entrées
        titre = findViewById(R.id.titre);
        auteur = findViewById(R.id.anne);
        anne = findViewById(R.id.anne);
        genre = findViewById(R.id.genre);

        // Builder pour les alertes
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        // Quand on appuie sur ajouter
        ajouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String titre_ = titre.getText().toString();
                        String auteur_ = auteur.getText().toString();
                        int anne_ = Integer.parseInt(anne.getText().toString());
                        String genre_ = genre.getText().toString();

                        db.addEntry(titre_, auteur_, anne_, genre_);


                        // Envoyer un message quand c'est bon
                        builder.setTitle("success");
                        builder.setMessage("Information saisie avec success");
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }
        );

        // Quand on appuie sur liste
        liste.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, NewActivity.class);
                        startActivity(intent);
                    }
                }
        );

        // Quand on appuie sur supprimer
        supprimer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                        startActivity(intent);
                    }
                }
        );


        // Quand on appuie sur modifier
        modifier.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}