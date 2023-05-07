package com.example.librairie;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/*
Made by Mehdi LAHLOU MIMI
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DbName = "bdd";
    public static final String TableName = "livres";
    public static final String idCol = "id";
    public static final String titreCol = "titre";
    public static final String auteurCol = "auteur";
    public static final String dateCol = "date";
    public static final String genreCol = "genre";

    public DatabaseHelper(Context context) {
        super(context, DbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String query = "CREATE TABLE " + TableName + " (" + idCol + " INTEGER PRIMARY KEY AUTOINCREMENT, " + titreCol + " VARCHAR, " + auteurCol + " VARCHAR, " + dateCol +" INT, " + genreCol + " VARCHAR)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        String query = "DROP TABLE IF EXISTS " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }


    public boolean addEntry(String titre, String auteur, int date, String genre)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(titreCol, titre);
        contentValues.put(auteurCol, auteur);
        contentValues.put(dateCol, date);
        contentValues.put(genreCol, genre);


        if (sqLiteDatabase.insert(TableName, null, contentValues) ==-1)
            return false;
        return true;

    }

    public List<Livre> readData() {

        List<Livre> resultat = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TableName, null);


        while (cursor.moveToNext()) {

            int id = cursor.getInt(cursor.getColumnIndex(idCol));
            String titre = cursor.getString(cursor.getColumnIndex(titreCol));
            String auteur = cursor.getString(cursor.getColumnIndex(auteurCol));
            int date = cursor.getInt(cursor.getColumnIndex(dateCol));
            String genre = cursor.getString(cursor.getColumnIndex(genreCol));

            resultat.add(new Livre(id, titre, auteur, date, genre));

        }

        return resultat;
    }





}
