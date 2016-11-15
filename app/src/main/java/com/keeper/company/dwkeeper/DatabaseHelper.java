package com.keeper.company.dwkeeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by gustavo on 09/11/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "KEEPER.db";
    public static final String TABLE_NAME_1 = "DADO";
    public static final String TABLE_NAME_2 = "MOVIMENTO";
    public static final String TABLE_NAME_3 = "FICHA";
    public static final String TABLE_NAME_4 = "RAÇA";
    public static final String COL_1_1 = "LADOS";
    public static final String COL_1_2 = "MOV_ID";
    public static final String COL_2_2 = "NOME";
    public static final String COL_3_2 = "DESCRICAO";
    public static final String COL_4_2 = "CLASSE_FK";
    public static final String COL_1_3 = "FICHA_ID";
    public static final String COL_1_4 = "RACA_ID";



    public static final String QUERY_1 = "CREATE TABLE " + TABLE_NAME_1 +
            " (" + COL_1_1 + " INTEGER PRIMARY KEY); ";
    public static final String QUERY_2 = "CREATE TABLE " + TABLE_NAME_3 +
            " (" + COL_1_3 + "INTEGER PRIMARY KEY AUTO_INCREMENT);";
    public static final String QUERY_3 = "CREATE TABLE " + TABLE_NAME_2 + " ( "
            + COL_1_2 + " INTERGER PRIMARY KEY AUTO_INCREMENT, "
            + COL_2_2 + " VARCHAR(20) NOT NULL, "
            + COL_3_2 + " VARCHAR(255), "
            + COL_4_2 + " INTEGER NOT NULL," +
            " FOREIGN KEY (" + COL_4_2 + ") REFERENCES " + TABLE_NAME_3 + " (ficha_id)); ";
    public static final String QUERY_4 = "CREATE TABLE " + TABLE_NAME_4 +
            " (" + COL_1_4 + "INTEGER PRIMARY KEY); ";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( QUERY_1 + QUERY_2 + QUERY_3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME_1);
        onCreate(sqLiteDatabase);
    }

    public boolean insertInitialData(){
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues();

        // Todos os dados necessários
        contentValues.put(COL_1_1, 4);  // D4
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 6);  //D6
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 8);  //D8
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 10);  //D10
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 12);  //D12
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 20);  //D20
        db.insert(TABLE_NAME_1, null, contentValues);

        return true;
    }

    public Cursor viewAllData(){
        // Somente os dados vão funcionar por enquanto
        SQLiteDatabase db = this.getWritableDatabase ();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME_1, null);
        return res;
    }

    public void deleteAllDatabase(){
        SQLiteDatabase db = this.getWritableDatabase ();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);
        onCreate(db);
    }

}
