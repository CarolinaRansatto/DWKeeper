package com.keeper.company.dwkeeper;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SelecaoFicha extends ListActivity {


    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_ficha);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);

        for(int contador = 0; contador != 4; contador++){
            listItems.add("Clicked : " + clickCounter++);
            adapter.notifyDataSetChanged();
        }

        LayoutInflater vi =  getLayoutInflater();
        View v = vi.inflate(R.layout.uma_ficha_selecao, null);
        View v2 = vi.inflate(R.layout.uma_ficha_selecao, null);

        // fill in any details dynamically here
        TextView textView = (TextView) v.findViewById(R.id.viewNome);
        textView.setText("mylovelytest");

        // insert into main view
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.listViewGroup);
        Log.d("selecaoficha", "viewgroup criado");
        //insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //insertPoint.addView(v2, -1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }

    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }


    /*
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
        //ViewGroup insertPoint = (ViewGroup) findViewById(R.id.lovelyViewGroup);
        //insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //insertPoint.addView(v2, -1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));



    }*/
}
