package com.keeper.company.dwkeeper;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ficha extends AppCompatActivity {

    DatabaseHelper bd;
    TextView nome;
    TextView exp;
    TextView armadura;
    TextView pv_atual;
    TextView pv_total;
    TextView nivel;
    TextView carga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha);

        bd = new DatabaseHelper(this);

        bd.insertInitialDataFicha();

        nome = (TextView) findViewById(R.id.ViewNome);
        exp = (TextView) findViewById(R.id.ViewExp);
        carga = (TextView) findViewById(R.id.ViewCarga);
        nivel = (TextView) findViewById(R.id.ViewNivel);
        armadura = (TextView) findViewById(R.id.ViewArm);
        pv_atual = (TextView) findViewById(R.id.ViewPVAtual);
        pv_total = (TextView) findViewById(R.id.ViewPVTotal);

        Cursor res = bd.viewFichas();
        res.moveToNext();
        String bdNome = res.getString(4);
        String bdExp = res.getString(5);
        String bdCarga = res.getString(12);
        String bdNivel = res.getString(6);
        String bdArm = res.getString(8);
        String bdPv_atual = res.getString(9);
        String bdPv_total = res.getString(10);



        nome.setText(bdNome);
        carga.setText(bdCarga);
        exp.setText(bdExp);
        nivel.setText(bdNivel);
        armadura.setText(bdArm);
        pv_atual.setText(bdPv_atual);
        pv_total.setText(bdPv_total);
    }


    private int[] cortarAtributos(){
        int [] array = new int[10];
        return array;
    }






}
