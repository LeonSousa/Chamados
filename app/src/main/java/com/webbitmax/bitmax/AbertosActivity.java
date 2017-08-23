package com.webbitmax.bitmax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    AdapterAbertos adapterAbertos;
    Abertos abertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertos);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        popularAbertos();
    }

    private void popularAbertos() {

        //retrofit
        RequestInterface requestService = ApiService.getApiService();

        String tecnico = "leonardo";
        Call<Abertos> call = requestService.listAbertos(tecnico);

        call.enqueue(new Callback<Abertos>() {
            @Override
            public void onResponse(Call<Abertos> call, Response<Abertos> response) {
                abertos = response.body();
                Log.d("wrgs", "opa carregou");
                adapterAbertos = new AdapterAbertos(abertos);
                recyclerView.setAdapter(adapterAbertos);

            }

            @Override
            public void onFailure(Call<Abertos> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro: "+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void chamarDetalhes(Chamado chamado){

        Intent it = new Intent(getApplicationContext(), DetalhesActivity.class);
        it.putExtra("chamado", chamado);
        startActivity(it);

    }
}
