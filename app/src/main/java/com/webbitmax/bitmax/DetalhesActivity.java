package com.webbitmax.bitmax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.webbitmax.bitmax.model.Chamado;

public class DetalhesActivity extends AppCompatActivity {

    Chamado chamado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);


        Bundle bundle = getIntent().getExtras();
        chamado = (Chamado) bundle.get("chamado");
        getSupportActionBar().setTitle(chamado.getTecnico());
        getSupportActionBar().setSubtitle("Id: "+chamado.getNumero());
    }
}
