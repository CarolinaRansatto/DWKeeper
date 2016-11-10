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

    public static final String DATABASE_NAME = "keeper.db";
    public static final String TABLE_NAME_1 = "dado";
    public static final String COL_1_1 = "lados";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME_1 +
                " (" + COL_1_1 + " INTEGER PRIMARY KEY);");
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
