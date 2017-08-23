package com.webbitmax.bitmax.retrofit;

import com.webbitmax.bitmax.model.Abertos;
import com.webbitmax.bitmax.model.Chamado;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by leonardo on 21/08/17.
 */

public interface RequestService {

    @GET("chamadosapi/cabertos/{tecnico}")
    Call<Abertos> listAbertos(@Path("tecnico") String tecnico);

    @GET("chamadosapi/cabertos/leonardo")
    Call<Abertos> teste();

    @GET("chamadosapi/cabertos/{id}")
    Call<Chamado> getUnico(@Path("id") int id);

}
