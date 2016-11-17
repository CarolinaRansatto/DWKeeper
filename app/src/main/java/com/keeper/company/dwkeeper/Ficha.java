package com.keeper.company.dwkeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ficha extends AppCompatActivity {


    DatabaseHelper bd;
    TextView nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha);

        bd = new DatabaseHelper(this);

        bd.insertInitialDataFicha();

        nome = (TextView) findViewById(R.id.ViewNome);

    }



}
