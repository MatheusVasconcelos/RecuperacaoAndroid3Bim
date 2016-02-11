package com.ifpb30_01_16.projeto_3bimestre.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.ifpb30_01_16.projeto_3bimestre.R;
import com.ifpb30_01_16.projeto_3bimestre.controlador.ImcAsynctask;
import com.ifpb30_01_16.projeto_3bimestre.model.IMC;
import com.ifpb30_01_16.projeto_3bimestre.model.ValorCaloricoTotal;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;

public class IMCActivity extends AppCompatActivity {

    @Bind(R.id.tv_peso)
    EditText mTv_peso;

    @Bind(R.id.tv_altura)
    EditText mTv_altura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ValorCaloricoTotal perfil = null;

        switch (item.getItemId()) {

            case R.id.item_submit:
                enviarIMC();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void enviarIMC() {
        IMC perfil = new IMC();

        String peso = (String) mTv_peso.getText().toString();
        perfil.setPeso((Double) Double.parseDouble(peso));
        String altura = (String) mTv_altura.getText().toString();
        perfil.setAltura((Integer) Integer.parseInt(altura));

        Toast.makeText(this, "IMC Enviado com Sucesso", Toast.LENGTH_SHORT).show();

        JSONObject json = gerarJson(perfil);
        callServerImc(json);


    }

    private JSONObject gerarJson(IMC imc) {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("peso", imc.getPeso());
            jsonObject.put("altura", imc.getAltura());


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return (jsonObject);
    }


    private void callServerImc(final JSONObject data) {

        final ImcAsynctask imcAsynctask = new ImcAsynctask(this);

        imcAsynctask.execute(data);
    }


}
