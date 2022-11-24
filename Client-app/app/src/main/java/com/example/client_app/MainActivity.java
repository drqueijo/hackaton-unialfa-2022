package com.example.client_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.client_app.datasources.BuscaDadosWeb;

public class MainActivity extends ListActivity {

    private ArrayList<HashMap<String,String>> listaDados;
    private String id = "1";
    private Button pag1;
    private Button pag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pag1 = findViewById(R.id.btn1);
        pag2 = findViewById(R.id.btn2);

        Intent dadosRecebidos = getIntent();

        if (dadosRecebidos != null) {

            Bundle params = dadosRecebidos.getExtras();
            if (params != null) {
                id = params.getString("id");
            }
        }

        pag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    listaDados = new BuscaDadosWeb().execute(Config.urlApi + id).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent telaDetalhes = new Intent(MainActivity.this, MainActivity.class);


                Bundle params = new Bundle();
                if(id != null) {
                    int pageInt =  Integer.parseInt(id) - 1;
                    id = String.valueOf(pageInt);
                }

                if(id == "1" ) {
                    params.putString("id", "1");
                } else {
                    params.putString("id", id);
                }

                telaDetalhes.putExtras(params);

                startActivity(telaDetalhes);
            }
        });

        pag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    listaDados = new BuscaDadosWeb().execute(Config.urlApi + id).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent telaDetalhes = new Intent(MainActivity.this, MainActivity.class);
                Bundle params = new Bundle();


                if(id != null) {
                    int pageInt =  Integer.parseInt(id) + 1;
                    id = String.valueOf( pageInt);
                }

                if(id == "35" ) {
                    params.putString("id", "1");
                } else {
                    params.putString("id", id);
                }

                params.putString("id", id);

                telaDetalhes.putExtras(params);

                startActivity(telaDetalhes);
            }
        });

        try {
            listaDados = new BuscaDadosWeb().execute(Config.urlApi + id).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String texto = listaDados.get(0).get("name");
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();


        ListAdapter adapter = new SimpleAdapter(
                this,
                listaDados,
                R.layout.listview_modelo,
                new String[] { "name" },
                new int[] { R.id.txtNome }
        );


        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        HashMap<String, String> personagem =  listaDados.get(position);


        Intent telaDetalhes = new Intent(MainActivity.this, DetalhesActivity.class);


        Bundle params = new Bundle();
        params.putString("name", personagem.get("name"));
        params.putString("imagem", personagem.get("imagem"));
        params.putString("status", personagem.get("status"));


        telaDetalhes.putExtras(params);


        startActivity(telaDetalhes);
    }
}