package com.webbitmax.bitmax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalhes, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_fechar:
                

        }
        return super.onOptionsItemSelected(item);
    }
}
