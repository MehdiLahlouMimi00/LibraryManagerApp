package com.example.librairie;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {


    Button supprimer;
    EditText id;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = new DatabaseHelper(this);

        supprimer = findViewById(R.id.supprimerLivre);
        id = findViewById(R.id.idelete);

        // Builder pour les alertes
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        supprimer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String sql = "DELETE FROM " + db.TableName + " WHERE " + db.idCol + " = " + id.getText().toString();
                        db.getWritableDatabase().execSQL(sql);

                        builder.setTitle("success");
                        builder.setMessage("Information supprimée avec success");
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }
        );

    }
}
