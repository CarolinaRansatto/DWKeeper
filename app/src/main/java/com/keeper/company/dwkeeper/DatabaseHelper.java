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
    public static final String TABLE_NAME_3 = "CLASSE";
    public static final String TABLE_NAME_4 = "RAÇA";
    public static final String TABLE_NAME_5 = "ALINHAMENTO";
    public static final String TABLE_NAME_6 = "FICHA";
    public static final String TABLE_NAME_7 = "PODE_SER_DE";
    public static final String TABLE_NAME_8 = "POSSUI_MOVIMENTOS";
    public static final String COL_1_1 = "LADOS";
    public static final String COL_2_1 = "NOME_TESTE";
    public static final String COL_1_2 = "MOV_ID";
    public static final String COL_2_2 = "NOME";
    public static final String COL_3_2 = "DESCRICAO";
    public static final String COL_4_2 = "CLASSE_FK";
    public static final String COL_1_3 = "CLASSE_ID";
    public static final String COL_2_3 = "NOME";
    public static final String COL_1_4 = "RAÇA_ID";
    public static final String COL_2_4 = "NOME";
    public static final String COL_1_5 = "ALI_ID";
    public static final String COL_1_6 = "FICHA_ID";
    public static final String COL_2_6 = "CLASSE_FK";
    public static final String COL_3_6 = "RAÇA_FK";
    public static final String COL_4_6 = "ATRIBUTOS";
    public static final String COL_5_6 = "NOME";
    public static final String COL_6_6 = "EXP";
    public static final String COL_7_6 = "NIVEL";
    public static final String COL_8_6 = "DADO_FK";
    public static final String COL_9_6 = "ARMADURA"; //SMALLINT
    public static final String COL_10_6 = "PV_ATUAL"; //SMALLINT
    public static final String COL_11_6 = "PV_TOTAL"; //SMALLINT
    public static final String COL_12_6 = "ALI_FK";
    public static final String COL_13_6 = "CARGA";
    public static final String COL_14_6 = "IMG_PATH";
    public static final String COL_1_7 = "CLASSE_FK";
    public static final String COL_2_7 = "RAÇA_FK";
    public static final String COL_3_7 = "BENEFICIO";
    public static final String COL_1_8 = "FICHA_FK";
    public static final String COL_2_8 = "MOVI_FK";

    // dados
    public static final String QUERY_1 = "CREATE TABLE " + TABLE_NAME_1 +
            " (" + COL_1_1 + " INTEGER PRIMARY KEY, " +
            COL_2_1 + " INTEGER ); "; //pk
    //classe
    public static final String QUERY_2 = "CREATE TABLE " + TABLE_NAME_3 +
            " (" + COL_1_3 + "INTEGER PRIMARY KEY AUTO_INCREMENT," +// pk
             COL_2_3 + "VARCHAR(30));"; //nome
    //movimento
    public static final String QUERY_3 = "CREATE TABLE " + TABLE_NAME_2 + " ( "
            + COL_1_2 + " INTEGER PRIMARY KEY AUTO_INCREMENT, " //pk
            + COL_2_2 + " VARCHAR(20) NOT NULL, " //nome
            + COL_3_2 + " VARCHAR(255), " // descricao
            + COL_4_2 + " INTEGER NOT NULL," + // classe_fk
            " FOREIGN KEY (" + COL_4_2 + ") REFERENCES " + TABLE_NAME_3 + " (ficha_id)" +
            " ON UPDATE CASCADE ON DELETE CASCADE); ";
    //raça
    public static final String QUERY_4 = "CREATE TABLE " + TABLE_NAME_4 +
            " (" + COL_1_4 + " INTEGER PRIMARY KEY AUTO_INCREMENT, " +  ///pk
             COL_2_4 + " VARCHAR(50)); "; //nome
    //alinhamento
    public static final String QUERY_5 = "CREATE TABLE " + TABLE_NAME_5 +
            " (" + COL_1_5 + " INTEGER PRIMARY KEY ATUO_INCREMENT); "; //pk
    //ficha
    public static final String QUERY_6 = "CREATE TABLE " + TABLE_NAME_6 +
            " (" + COL_1_6 + " INTEGER PRIMARY KEY, " +
            COL_2_6 +" INTEGER, " + // classe fk
            COL_3_6 +" INTEGER, " + // raça fk
            COL_4_6 + " VARCHAR(20), " + // atributos( EX: 10/2/8/3/8/6/5/3/2/9)
            COL_5_6 + " VARCHAR(30), " + // NOME
            COL_6_6 + " INTEGER, " + // EXP
            COL_7_6 + " SMALLINT, " + // NIVEL
            COL_8_6 + " INTEGER, " + // DADO_FK
            COL_9_6 + " SMALLINT, " + // ARMADURA
            COL_10_6 + " SMALLINT, " + // PV ATUAL
            COL_11_6 + " SMALLINT, " + // PV TOTAL
            COL_12_6 + " INTEGER, " + // ALINHAMENTO FK
            COL_13_6 + " INTEGER, " + // CARGA
            COL_14_6 + " VARCHAR(255), " + // IMG_PATH
            "FOREIGN KEY (" +COL_2_6 + ") REFERENCES " + TABLE_NAME_3 + " (" + COL_1_3 + ")" +
            " ON DELETE SET NULL ON UPDATE CASCADE, " +
            "FOREIGN KEY (" +COL_3_6 + ") REFERENCES " + TABLE_NAME_4 + " (" + COL_1_4 + ")" +
            " ON DELETE SET NULL ON UPDATE CASCADE, " +
            "FOREIGN KEY (" +COL_8_6 + ") REFERENCES " + TABLE_NAME_1 + " (" + COL_1_1 + ")" +
            " ON DELETE SET NULL ON UPDATE CASCADE, " +
            "FOREIGN KEY (" +COL_12_6 + ") REFERENCES " + TABLE_NAME_5 + " (" + COL_1_5 + ")" +
            " ON DELETE SET NULL ON UPDATE CASCADE ); ";
    // pode_ser_de
    public static final String QUERY_7 = "CREATE TABLE " + TABLE_NAME_7 +
            " (" + COL_1_7 + " INTEGER, " + //classe fk
            COL_2_7 + " INTEGER, " + //raça fk
            COL_3_7 + " VARCHAR(255), " + //beneficio
            "FOREIGN KEY (" + COL_1_7 + ") REFERENCES " + TABLE_NAME_3 + "( " + COL_1_3 + ") " +
            " ON UPDATE CASCADE ON DELETE CASCADE," +
            "FOREIGN KEY (" + COL_2_7 + ") REFERENCES " + TABLE_NAME_4 + "( " + COL_1_4 + ") " +
            " ON UPDATE CASCADE ON DELETE CASCADE); ";

    // possui_movimentos
    public static final String QUERY_8 = "CREATE TABLE " + TABLE_NAME_8 +
            " (" + COL_1_8 + " INTEGER, " + // ficha_fk
            COL_2_8 + " INTEGER, " + // movimento fk
            "FOREIGN KEY (" + COL_1_8 + ") REFERENCES " + TABLE_NAME_6 + "( " + COL_1_6 + ") " +
            " ON UPDATE CASCADE ON DELETE CASCADE," +
            "FOREIGN KEY (" + COL_2_8 + ") REFERENCES " + TABLE_NAME_2 + "( " + COL_1_2 + ") " +
            " ON UPDATE CASCADE ON DELETE CASCADE); ";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( QUERY_1 );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME_1);
        onCreate(sqLiteDatabase);
    }

    public boolean insertInitialData(){

        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues();

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);
        db.execSQL( QUERY_1 );

        // Todos os dados necessários
        contentValues.put(COL_1_1, 4);  // D4
        contentValues.put(COL_2_1, 14); // dados de teste
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 6);  //D6
        contentValues.put(COL_2_1, 14); // dados de teste
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 8);  //D8
        contentValues.put(COL_2_1, 14); // dados de teste
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 10);  //D10
        contentValues.put(COL_2_1, 14);
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 12);  //D12
        contentValues.put(COL_2_1, 14);
        db.insert(TABLE_NAME_1, null, contentValues);

        contentValues.put(COL_1_1, 20);  //D20
        contentValues.put(COL_2_1, 14);
        db.insert(TABLE_NAME_1, null, contentValues);

        return true;
    }

    public void insertInitialDataFicha(){
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues();

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_6);
        db.execSQL( QUERY_6 );

        // Todos os dados necessários
        contentValues.put(COL_1_6, 1);  // ID
        contentValues.put(COL_5_6, "teste");  // NOME
        contentValues.put(COL_6_6, 666);  // EXP
        contentValues.put(COL_7_6, 10);  // NIVEL
        contentValues.put(COL_9_6, 7);  // ARMADURA
        contentValues.put(COL_10_6, 19);  // PV_ATUAL
        contentValues.put(COL_11_6, 21);  // PV_TOTAL
        contentValues.put(COL_13_6, 3);  // CARGA
        db.insert(TABLE_NAME_6, null, contentValues);

    }

    public Cursor viewAllData(){
        SQLiteDatabase db = this.getWritableDatabase ();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME_1, null);
        return res;
    }

    public Cursor viewFichas(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME_6,  null);
        return res;
    }

    public Cursor viewCustomData(String column, String table){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + column + " from " + table, null);
        return res;
    }

    public void deleteAllDatabase(){
        SQLiteDatabase db = this.getWritableDatabase ();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);
        onCreate(db);
    }

}
