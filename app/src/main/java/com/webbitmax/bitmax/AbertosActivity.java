package com.webbitmax.bitmax;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.webbitmax.bitmax.adapters.AdapterAbertos;
import com.webbitmax.bitmax.model.Abertos;
import com.webbitmax.bitmax.model.Chamado;
import com.webbitmax.bitmax.retrofit.ApiService;
import com.webbitmax.bitmax.retrofit.RequestInterface;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AbertosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    AdapterAbertos adapterAbertos;
    Abertos abertos;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertos);
        getSupportActionBar().setTitle("Chamados");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(this).build());
        realm = Realm.getDefaultInstance();

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        popularAbertos();
    }


    public void popularAbertos(){
        RealmResults<Chamado> results = realm.where(Chamado.class).findAll();

            adapterAbertos = new AdapterAbertos(results);
            recyclerView.setAdapter(adapterAbertos);
            getSupportActionBar().setSubtitle(results.size()+" abertos");

    }

    private void atualizar() {

        progressBar.setVisibility(View.VISIBLE);
        RequestInterface requestService = ApiService.getApiService();

        String tecnico = "sistema";
        Call<Abertos> call = requestService.listAbertos(tecnico);

        call.enqueue(new Callback<Abertos>() {
            @Override
            public void onResponse(Call<Abertos> call, Response<Abertos> response) {
                Abertos apiAbertos = response.body();

                realm.beginTransaction();
                    realm.deleteAll();
                    for(Chamado c : apiAbertos.getAbertos()){
                        realm.copyToRealm(c);
                    }
                realm.commitTransaction();


                progressBar.setVisibility(View.INVISIBLE);

                popularAbertos();
            }

            @Override
            public void onFailure(Call<Abertos> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(
                        getApplicationContext(),
                        "Erro de comunicação com o servidor",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void chamarDetalhes(Chamado chamado){
        Intent it = new Intent(getApplicationContext(), DetalhesActivity.class);
        it.putExtra("chamadoId", chamado.getId());
        startActivity(it);
    }

    public void abrirChamado(final Chamado chamado){
        AlertDialog.Builder builder = new AlertDialog.Builder(AbertosActivity.this);
        builder.setMessage("Deseja iniciar esse chamado?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       chamarDetalhes(chamado);
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_abertos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_atualizar:
                atualizar();
        }

        return super.onOptionsItemSelected(item);
    }
}
