package com.keeper.company.dwkeeper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class SelecaoFicha extends AppCompatActivity {

    List<FichaView> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_ficha);

        itens = pegarFichas();
        ListView listaDeFichas = (ListView) findViewById(R.id.listViewGroup);

        final ListaFichas adapter = new ListaFichas(itens, this);
        listaDeFichas.setAdapter(adapter);

        listaDeFichas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FichaView item = adapter.getItem(i);
                Intent intent = new Intent(SelecaoFicha.this, Ficha.class);
                intent.putExtra("ID", item.id);
                startActivity(intent);
            }
        });
    }

    public void onAdd(View v) {
        Intent intent = new Intent(SelecaoFicha.this, Ficha.class);
        intent.putExtra("ID", itens.size() + 1);
        startActivity(intent);
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