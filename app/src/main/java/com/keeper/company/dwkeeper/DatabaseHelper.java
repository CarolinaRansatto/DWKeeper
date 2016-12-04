package com.keeper.company.dwkeeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

/**
 * Created by gustavo on 09/11/16.
 *
 * Apesar de que usaremos apensar a tabela "ficha" e outras auxiliares inicialmente,
 * t0do restante está preparado para aplicarmos em uma verdadeira aplicação onde
 * escolhas poderão ser feitas diferentemente da representação no papel
 *
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
    public static final String COL_1_3 = "NOME";
    public static final String COL_1_4 = "RAÇA_ID";
    public static final String COL_2_4 = "NOME";
    public static final String COL_1_5 = "ALI_ID";
    public static final String COL_2_5 = "DESCRICAO";
    public static final String COL_1_6 = "FICHA_ID";
    public static final String COL_2_6 = "CLASSE";
    public static final String COL_3_6 = "RAÇA";
    public static final String COL_4_6 = "ATRIBUTOS";
    public static final String COL_5_6 = "NOME";
    public static final String COL_6_6 = "EXP";
    public static final String COL_7_6 = "NIVEL";
    public static final String COL_8_6 = "DANO";
    public static final String COL_9_6 = "ARMADURA"; //SMALLINT
    public static final String COL_10_6 = "PV_ATUAL"; //SMALLINT
    public static final String COL_11_6 = "PV_TOTAL"; //SMALLINT
    public static final String COL_12_6 = "ALINHAMENTO";
    public static final String COL_13_6 = "CARGA";
    public static final String COL_14_6 = "IMG_PATH";
    public static final String COL_15_6 = "APARENCIA";
    public static final String COL_16_6 = "BACKGROUND";
    public static final String COL_17_6 = "VINCULOS";
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
             COL_1_3 + "VARCHAR(30) PRIMARY KEY);"; //nome

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
            " (" + COL_1_5 + " INTEGER PRIMARY KEY AUTO_INCREMENT," +
             COL_2_5 + " VARCHAR(50)); "; //pk

    //ficha
    public static final String QUERY_6 = "CREATE TABLE " + TABLE_NAME_6 +
            " (" + COL_1_6 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_2_6 +" VARCHAR(8), " + // CLASSE
            COL_3_6 +" VARCHAR(8), " + // RAÇA
            COL_4_6 + " CHAR(20), " + // atributos( EX: 10/2/8/3/8/6/5/3/2/9)
            COL_5_6 + " VARCHAR(30), " + // NOME
            COL_6_6 + " INTEGER, " + // EXP
            COL_7_6 + " SMALLINT, " + // NIVEL
            COL_8_6 + " INTEGER, " + // DANO
            COL_9_6 + " SMALLINT, " + // ARMADURA
            COL_10_6 + " SMALLINT, " + // PV ATUAL
            COL_11_6 + " SMALLINT, " + // PV TOTAL
            COL_12_6 + " VARCHAR(100), " + // ALINHAMENTO
            COL_13_6 + " INTEGER, " + // CARGA
            COL_14_6 + " VARCHAR(255), " + // IMG_PATH
            COL_15_6 + " VARCHAR(255), " + // APARENCIA
            COL_16_6 + " VARCHAR(255), " +// BACKGROUND
            COL_17_6 + " VARCHAR(255)); ";  // VINCULOS


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
        db.execSQL( QUERY_6 );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME_1);
        onCreate(sqLiteDatabase);
    }

    public FichaHelper loadFicha(int id){
        SQLiteDatabase bd = this.getWritableDatabase();

        FichaHelper ficha = new FichaHelper();
        ficha.setId(id);

        Cursor cursorFicha = bd.rawQuery("select * FROM " + TABLE_NAME_6 + " WHERE " + COL_1_6 + " = " + id + " ;", null);

        if (cursorFicha.getCount() == 0){
            insertInitialDataFicha();
            cursorFicha = bd.rawQuery("select * FROM " + TABLE_NAME_6 + " WHERE " + COL_1_6 + " = " + id + " ;", null);
        }

        //Cursor cursorClasse = bd.rawQuery("select " + COL_2_3 + " FROM " + TABLE_NAME_3 + "WHERE " + COL_1_3 + " = " + cursorFicha.getInt(1), null);
        //Cursor cursorRaça = bd.rawQuery("select " + COL_2_4 + " FROM " + TABLE_NAME_4 + "WHERE " + COL_1_4 + " = " + cursorFicha.getInt(2), null);
        //Cursor cursorAlinhamento = bd.rawQuery("select " + COL_2_5 + " FROM " + TABLE_NAME_5 + "WHERE " + COL_1_5 + " = " + cursorFicha.getInt(11), null);

        cursorFicha.moveToNext();
        // destrincha os atributos
        String [] auxArrayAtr = cursorFicha.getString(3).split("/"); // Quebra a string dos atributos nas barras para separar os atributos
        int [] arrayAtr = new int [12];

        for (int i = 0; i < auxArrayAtr.length; i++){
            arrayAtr[i] = Integer.parseInt(auxArrayAtr[i]);
        }
        // seta os atributos
        ficha.setAtributos(arrayAtr);

        //seta id
        ficha.setId(cursorFicha.getInt(0));

        // seta classe
        ficha.setClasse(cursorFicha.getString(1));

        // seta raça
        ficha.setRaça(cursorFicha.getString(2));

        // seta nome
        ficha.setNome(cursorFicha.getString(4));

        // seta exp
        ficha.setExp(cursorFicha.getInt(5));

        // seta nivel
        ficha.setNivel(cursorFicha.getInt(6));

        // seta dano
        ficha.setDano(cursorFicha.getInt(7));

        //seta armadura
        ficha.setArmadura(cursorFicha.getInt(8));

        //seta pv atual
        ficha.setPv_atual(cursorFicha.getInt(9));

        //seta pv total
        ficha.setPv_total(cursorFicha.getInt(10));

        //seta alinhamento
        ficha.setAlinhamento(cursorFicha.getString(11));

        //seta carga
        ficha.setCarga(cursorFicha.getInt(12));

        // Seta IMG Path
        ficha.setImagePath(cursorFicha.getString(13));

        // Seta aparencia
        ficha.setAparencia(cursorFicha.getString(14));

        // Seta bg
        ficha.setBackground(cursorFicha.getString(15));

        // Seta vinculos
        ficha.setVinculos(cursorFicha.getString(16));

        return ficha;
    }
    
    public void saveFicha(FichaHelper ficha, int id){

        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        // Todos os dados necessários
        cv.put(COL_5_6, ficha.getNome());  // NOME
        cv.put(COL_4_6, buildAtributosString(ficha.getAtributos()));  // ATRIBUTOS
        cv.put(COL_6_6, ficha.getExp());  // EXP
        cv.put(COL_7_6, ficha.getNivel());  // NIVEL
        cv.put(COL_8_6, ficha.getDano());  // DANO
        cv.put(COL_9_6, ficha.getArmadura());  // ARMADURA
        cv.put(COL_10_6, ficha.getPv_atual());  // PV_ATUAL
        cv.put(COL_11_6, ficha.getPv_total());  // PV_TOTAL
        cv.put(COL_12_6, ficha.getAlinhamento());  // ALINHAMENTO
        cv.put(COL_13_6, ficha.getCarga());  // CARGA
        cv.put(COL_14_6, ficha.getImagePath());  // IMAGE PATH
        cv.put(COL_15_6, ficha.getAparencia());  // APARENCIA
        cv.put(COL_16_6, ficha.getBackground());  // BACKGROUND
        cv.put(COL_17_6, ficha.getVinculos());  // VINCULOS

        // não existia uma ficha previamente, então vamos criar uma
        if (ficha.getId() == 0){
            // ta faltando o id temos que checar a funcionalidade do auto_increment aqui
            bd.insert(TABLE_NAME_6, null, cv);
        }else {
            bd.update(TABLE_NAME_6, cv, COL_1_6 + "=" + id, null);
        }

    }

    public void insertInitialDataFicha(){
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues();

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_6);
        db.execSQL( QUERY_6 );

        // Todos os dados necessários

        //contentValues.put(COL_1_6, 1);  // ID -> não é necessário com autoincrement
        contentValues.put(COL_5_6, "Nome");  // NOME
        contentValues.put(COL_4_6, "0/0/0/0/0/0/0/0/0/0/0/0");  // ATRIBUTOS
        contentValues.put(COL_6_6, 0);  // EXP
        contentValues.put(COL_7_6, 0);  // NIVEL
        contentValues.put(COL_8_6, 0);  // DANO
        contentValues.put(COL_9_6, 0);  // ARMADURA
        contentValues.put(COL_10_6, 0);  // PV_ATUAL
        contentValues.put(COL_11_6, 0);  // PV_TOTAL
        contentValues.put(COL_12_6, " ");  // alinhamento
        contentValues.put(COL_13_6, 0);  // CARGA
        contentValues.put(COL_15_6, " ");  // APARENCIA
        contentValues.put(COL_16_6, " ");  // background
        contentValues.put(COL_17_6, " ");  // vinculos

        db.insert(TABLE_NAME_6, null, contentValues);

    }

    private String buildAtributosString(int atr []){
        String res = "";
        res += "" + atr[0];
        for (int i = 1; i < atr.length; i++){
            res += "/" + atr[i];
        }
        return res;
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
