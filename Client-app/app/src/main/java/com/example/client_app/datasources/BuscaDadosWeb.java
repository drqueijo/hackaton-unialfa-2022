package com.example.client_app.datasources;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.client_app.Config;

public class BuscaDadosWeb extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>> {

    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(String... strings) {
        ArrayList<HashMap<String, String>> listaDados = new ArrayList<>();

        try {
            //capturando a primeira posicao do vetor de strings
            String link = strings[0];

            //criando uma URL apartir do link recebido
            URL url = new URL(link);

            //criando uma conexao apartir da URL
            URLConnection connection = url.openConnection();

            //Capturando o retorno que veio da conexao e salvando na memoria
            InputStreamReader inputStream =
                    new InputStreamReader(connection.getInputStream());

            //pegando o retorno da memoria e carregando no buffer,
            //   que pode ser lido
            BufferedReader reader = new BufferedReader(inputStream);

            String dados = "";
            String linha;

            //enquanto existir dados para ler no reader
            // salva op valor na variavel linha e mudar o cursor
            // para a proxima linha, faz isso ate o final do arquivo
            while ((linha = reader.readLine()) != null) {
                //dados = dados + linha;
                dados += linha;
            }

            //transforma o texto com os dados vindos
            //   da API em um objeto JSON
            JSONObject json = new JSONObject(dados);

            //captura o vetor RESULTS que existe no objeto JSON
            JSONArray lista = new JSONArray(json.getString("results"));

            //rodar toda a lista de objetos do RESULTS
            for (int i = 0; i < lista.length(); i++) {
                //pega o item atual da lista e transforma em objeto JSON
                JSONObject item = (JSONObject)lista.get(i);

                //mapeando os campos do Array JSON para o Mapa de dados
                HashMap<String, String> mapaDados = new HashMap<>();
                mapaDados.put("name", item.getString("name"));
                mapaDados.put("url", item.getString("url"));
                mapaDados.put("status", item.getString("status"));
                mapaDados.put("imagem", Config.linkImagem + item.getString("id") + ".jpeg");


                listaDados.add(mapaDados);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return listaDados;
    }

}
