package com.ifpb30_01_16.projeto_3bimestre.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.ifpb30_01_16.projeto_3bimestre.R;
import com.ifpb30_01_16.projeto_3bimestre.adapter.GridAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_imc)
    TextView mBtnIMC;
    @Bind(R.id.tv_vct)
    TextView mBtnVCT;
    @Bind(R.id.tv_profileAnt)
    TextView mBtnPerfilAntropometrico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.tv_imc)
    public void btnImcListener(){
        Intent intent = new Intent(MainActivity.this, IMCActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_vct)
    public void btnVctListener(){
        Intent intent = new Intent(MainActivity.this, VCTActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_profileAnt)
    public void btnPerfilAntropometricoListener(){
        Intent intent = new Intent(MainActivity.this, PerfilAntropometricoAct.class);
        startActivity(intent);
    }



}
