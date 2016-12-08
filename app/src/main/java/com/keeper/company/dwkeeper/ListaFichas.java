package com.keeper.company.dwkeeper;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListaFichas extends BaseAdapter {

    private List<FichaView> itens;
    private final Activity act;

    public ListaFichas(List itens, Activity act) {
        this.itens = itens;
        this.act = act;
    }

    public int getCount() {
        return itens.size();
    }

    public FichaView getItem(int position) {
        return itens.get(position);
    }

    public long getItemId(int position) {
        return itens.get(position).id;
    }

    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            view = act.getLayoutInflater().inflate(R.layout.activity_ficha_view, parent, false);

            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new ItemSuporte();
            itemHolder.viewNome = (TextView) view.findViewById(R.id.viewNome);
            itemHolder.viewClasse = (TextView) view.findViewById(R.id.viewClasse);
            itemHolder.viewNivel = (TextView) view.findViewById(R.id.viewNivel);
            itemHolder.viewImagem = (ImageView) view.findViewById(R.id.viewImagem);

            //define os itens na view;
            view.setTag(itemHolder);
        } else {
            //se a view já existe pega os itens.
            itemHolder = (ItemSuporte) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        FichaView item = itens.get(position);
        itemHolder.viewNome.setText(item.nome);
        itemHolder.viewClasse.setText(item.classe);
        itemHolder.viewNivel.setText("Nível " + item.nivel);
        itemHolder.viewImagem.setImageURI(Uri.parse(item.img));

        //retorna a view com as informações
        return view;
    }

    private class ItemSuporte {
        ImageView viewImagem;
        TextView viewNome;
        TextView viewClasse;
        TextView viewNivel;
    }
}