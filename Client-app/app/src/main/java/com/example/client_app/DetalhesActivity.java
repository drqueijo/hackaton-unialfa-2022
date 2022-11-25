package com.example.client_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.client_app.datasources.DownloadImagem;

public class DetalhesActivity extends AppCompatActivity {

    TextView nome;
    TextView status;
    TextView species;
    TextView gender;
    ImageView imagem;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        nome = findViewById(R.id.nome);
        species = findViewById(R.id.species);
        gender = findViewById(R.id.gender);
        imagem = findViewById(R.id.imagem);
        status = findViewById(R.id.status);
        btnBack = findViewById(R.id.btnBack);

        //capturando o caminho de tela utilizado para abrir esta tela
        Intent dadosRecebidos = getIntent();
        if (dadosRecebidos != null) {
            //capturando os dados recebidos no caminho de tela
            Bundle params = dadosRecebidos.getExtras();
            if (params != null) {
                //adicionando o nome do pokemon no texto da tela
                nome.setText(params.getString("name"));
                status.setText(params.getString("status"));
                species.setText(params.getString("species"));
                gender.setText(params.getString("gender"));
                //carregando a imagem da web no objeto imagem da tela
                new DownloadImagem(imagem).execute(params.getString("imagem"));
            }
        }
        btnBack.setOnClickListener(view -> onBackPressed());
    }
}