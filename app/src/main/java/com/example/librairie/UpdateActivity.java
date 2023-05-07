package com.example.librairie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity  extends AppCompatActivity {

    EditText id, titre, auteur, genre, date;
    Button maj;

    DatabaseHelper db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        id = findViewById(R.id.idB);
        titre = findViewById(R.id.titreB);
        auteur = findViewById(R.id.auteurB);
        genre = findViewById(R.id.genreB);
        date = findViewById(R.id.dateB);

        maj = findViewById(R.id.maj);

        db = new DatabaseHelper(this);

        // Builder pour les alertes
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        maj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String sql = "UPDATE " + db.TableName + " SET " + db.titreCol + " = " + titre.getText().toString() + " SET " + db.auteurCol + " = " + auteur.getText().toString() + " SET " + db.genreCol + " = " + genre.getText().toString() + " SET " + db.dateCol + " = " + date.getText().toString() + "WHERE " + db.idCol + " = " +id.getText().toString();
                        db.getWritableDatabase().execSQL(sql);

                        builder.setTitle("success");
                        builder.setMessage("Information modifiée avec success");
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }
        );

    }
}
