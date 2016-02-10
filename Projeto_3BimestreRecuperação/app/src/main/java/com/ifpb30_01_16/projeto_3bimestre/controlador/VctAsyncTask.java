package com.ifpb30_01_16.projeto_3bimestre.controlador;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.ifpb30_01_16.projeto_3bimestre.Interface.SistemaCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by PESSOAL on 06/02/2016.
 */
public class VctAsyncTask extends AsyncTask<JSONObject, Void, JSONObject> {


    private Context context;
    private ProgressDialog dialog;

    SistemaCallback sistemaCallback;

    public  VctAsyncTask(Context context){

        this.context = context;
    }


    @Override
    protected void onPreExecute(){
        dialog = new ProgressDialog(context);
        dialog.setMessage("Carregando Dados...");
        dialog.show();

    }



    @Override
    protected JSONObject doInBackground(JSONObject... params) {

        JSONObject resultado = null;
        BufferedReader bufferedReader;


        try {
            URL url = new URL("ladoss.com.br:8443/NutrIF_service/calcularVCT");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.connect();

            StringBuilder builder = new StringBuilder();
            bufferedReader = new BufferedReader
                    (new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line + "\n");

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultado;
    }

    public void notificacaoErro(String mensagem) {

        sistemaCallback.erroServicoDemandas(mensagem);
    }



    @Override
    protected void onPostExecute(JSONObject resultado){


        if (resultado == null) {
            notificacaoErro("Requisição sem resultados");
        } else {
            try {
                JSONArray jsonArray = new JSONArray(resultado);
            } catch (JSONException e) {

                notificacaoErro(e.getMessage());
            }
        }
        dialog.dismiss();
    }
}
