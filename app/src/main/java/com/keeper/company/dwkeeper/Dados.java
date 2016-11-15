package com.keeper.company.dwkeeper;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Dados extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        texto = (TextView) findViewById(R.id.textView);
    }

    // método para simular o rolar de um dado qualquer
    public void rolaDado(View v){
        int lados = Integer.parseInt(v.getTag().toString());
        Random rand = new Random();
        int res =  rand.nextInt(lados) + 1; // acrescenta 1 pq começa no zero
        texto.setText("Ultimo d" + lados + ": " + res);
    }

}
