package com.webbitmax.bitmax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.webbitmax.bitmax.model.Chamado;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetalhesActivity extends AppCompatActivity {

    Chamado chamado;
    TextView tv_tecnico;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(this).build());
        realm = Realm.getDefaultInstance();

        tv_tecnico = (TextView) findViewById(R.id.textView_nome);


        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("chamadoId");

        chamado = realm.where(Chamado.class).equalTo("suporte_id", id).findFirst();

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
