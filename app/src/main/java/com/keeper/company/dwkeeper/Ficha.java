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
        FichaHelper ficha = bd.loadFicha(1);

        nome = (TextView) findViewById(R.id.ViewNome);
        exp = (TextView) findViewById(R.id.ViewExp);
        carga = (TextView) findViewById(R.id.ViewCarga);
        nivel = (TextView) findViewById(R.id.ViewNivel);
        armadura = (TextView) findViewById(R.id.ViewArm);
        pv_atual = (TextView) findViewById(R.id.ViewPVAtual);
        pv_total = (TextView) findViewById(R.id.ViewPVTotal);


        nome.setText(ficha.getNome());
        carga.setText(""  + ficha.getCarga());
        exp.setText("" + ficha.getExp());
        nivel.setText("" + ficha.getNivel());
        armadura.setText("" + ficha.getArmadura());
        pv_atual.setText("" + ficha.getPv_atual());
        pv_total.setText("" + ficha.getPv_total());
    }

}
