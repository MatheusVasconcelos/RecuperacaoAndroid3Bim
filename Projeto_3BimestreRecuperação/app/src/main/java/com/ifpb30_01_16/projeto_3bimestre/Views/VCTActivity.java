package com.ifpb30_01_16.projeto_3bimestre.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.ifpb30_01_16.projeto_3bimestre.R;
import com.ifpb30_01_16.projeto_3bimestre.controlador.VctAsyncTask;
import com.ifpb30_01_16.projeto_3bimestre.model.ValorCaloricoTotal;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VCTActivity extends AppCompatActivity {
    @Bind(R.id.edt_vct_weight)
    EditText mEdt_vct_weight;

    @Bind(R.id.edt_vct_height)
    EditText mEdt_vcy_height;

    @Bind(R.id.edt_level)
    EditText mEtLevel;

    @Bind(R.id.edt_birth_day)
    EditText mEdt_birth_day;

    @Bind(R.id.edt_sexo)
    EditText mEdt_sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vtc);

        ButterKnife.bind(this);

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
                enviarVCT();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void enviarVCT() {

        ValorCaloricoTotal valorCaloricoTotal = new ValorCaloricoTotal();
        String peso = (String) mEdt_vct_weight.getText().toString();
        valorCaloricoTotal.setPeso((Double) Double.parseDouble(peso));
        String altura = (String) mEdt_vcy_height.getText().toString();
        valorCaloricoTotal.setAltura((Integer) Integer.parseInt(altura));
        String nivel = (String) mEtLevel.getText().toString();
        valorCaloricoTotal.setNivel((Integer) Integer.parseInt(nivel));
        String nascimento = (String) mEdt_birth_day.getText().toString();
        valorCaloricoTotal.setDataDeNascimento(nascimento);
        String sexo = (String) mEdt_sexo.getText().toString();
        valorCaloricoTotal.setSexo(sexo);

        JSONObject jsonObject = gerarJson(valorCaloricoTotal);
        callServerVct(jsonObject);

    }

    private JSONObject gerarJson(ValorCaloricoTotal valorCaloricoTotal){
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("peso", valorCaloricoTotal.getPeso());
            jsonObject.put("altura", valorCaloricoTotal.getAltura());
            jsonObject.put("nivelEsporte", valorCaloricoTotal.getNivel());
            jsonObject.put("nascimento", valorCaloricoTotal.getDataDeNascimento());
            jsonObject.put("sexo", valorCaloricoTotal.getSexo());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return (jsonObject);
    }


    private void callServerVct(final JSONObject data) {

        final VctAsyncTask vctAsyncTask = new VctAsyncTask(this);

        vctAsyncTask.execute(data);
    }

}

