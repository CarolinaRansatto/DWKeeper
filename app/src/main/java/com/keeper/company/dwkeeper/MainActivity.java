package com.keeper.company.dwkeeper;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState)   {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = new DatabaseHelper(this);
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    public void addData(View v){
        if (bd.insertInitialData()){
            Toast.makeText(MainActivity.this, "Dado inserido com sucesso!", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(MainActivity.this, "Dado não foi inserido com sucesso =/", Toast.LENGTH_LONG).show();
        }
    }


    public void deleteAll(View v){
        bd.deleteAllDatabase();
    }

    public void viewData(View v){
        Cursor res  = bd.viewAllData();
        if (res.getCount() == 0) {
            showMessage("Erro", "Você ainda não tem nada no banco de dados!");
            return;
        }else {
            StringBuffer buffer = new StringBuffer();
            while(res.moveToNext()){
                buffer.append("Lados : "+ res.getString(0) + "\n");
            }

            showMessage("Dados", buffer.toString());

        }

    }

}
