package com.keeper.company.dwkeeper;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class SelecaoFicha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_ficha);

        List<FichaView> itens = pegarFichas();
        ListView listaDeFichas = (ListView) findViewById(R.id.listViewGroup);

        ListaFichas adapter = new ListaFichas(itens, this);
        listaDeFichas.setAdapter(adapter);
    }

    List<FichaView> pegarFichas() {
        List<FichaView> itens = new LinkedList<>();
        DatabaseHelper bd = new DatabaseHelper(this);
        Cursor c = bd.viewFichas();
        c.moveToFirst();

        for (int i = 0; i < c.getCount(); i++) {
            itens.add(new FichaView(
                    Integer.parseInt(c.getString(0)),
                    c.getString(4), c.getString(1),
                    c.getString(6), c.getString(13)));
        }

        return itens;
    }
}