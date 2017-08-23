package com.webbitmax.bitmax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.webbitmax.bitmax.model.Chamado;

public class DetalhesActivity extends AppCompatActivity {

    Chamado chamado;
    TextView tv_tecnico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_tecnico = (TextView) findViewById(R.id.textView_nome);


        Bundle bundle = getIntent().getExtras();
        chamado = (Chamado) bundle.get("chamado");
        getSupportActionBar().setTitle(chamado.getTecnico());
        getSupportActionBar().setSubtitle("Id: "+chamado.getNumero());

        tv_tecnico.setText(chamado.getTecnico());
    }
}
