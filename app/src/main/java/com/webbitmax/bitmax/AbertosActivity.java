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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertos);
        getSupportActionBar().setTitle("Chamados");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        popularAbertos();
    }

    private void popularAbertos() {

        progressBar.setVisibility(View.VISIBLE);
        RequestInterface requestService = ApiService.getApiService();

        String tecnico = "sistema";
        Call<Abertos> call = requestService.listAbertos(tecnico);

        call.enqueue(new Callback<Abertos>() {
            @Override
            public void onResponse(Call<Abertos> call, Response<Abertos> response) {
                abertos = response.body();
                adapterAbertos = new AdapterAbertos(abertos);
                recyclerView.setAdapter(adapterAbertos);
                progressBar.setVisibility(View.INVISIBLE);

                getSupportActionBar().setSubtitle(abertos.getRegistros()+" abertos");
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

    public void chamarDetalhes(final Chamado chamado){
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setMessage("Deseja iniciar esse chamado?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent it = new Intent(getApplicationContext(), DetalhesActivity.class);
                        it.putExtra("chamado", chamado);
                        startActivity(it);

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
                popularAbertos();
        }

        return super.onOptionsItemSelected(item);
    }
}
