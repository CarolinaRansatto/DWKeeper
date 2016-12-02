package com.keeper.company.dwkeeper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelecaoFicha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_ficha);

        LayoutInflater vi =  getLayoutInflater();
        View v = vi.inflate(R.layout.uma_ficha_selecao, null);
        View v2 = vi.inflate(R.layout.uma_ficha_selecao, null);

        // fill in any details dynamically here
        TextView textView = (TextView) v.findViewById(R.id.viewNome);
        textView.setText("mylovelytest");

        // insert into main view
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.lovelyViewGroup);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        insertPoint.addView(v2, -1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }
}
