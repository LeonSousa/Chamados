package com.webbitmax.bitmax.retrofit;

import com.webbitmax.bitmax.model.Abertos;
import com.webbitmax.bitmax.model.Chamado;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by leonardo on 21/08/17.
 */

public interface RequestInterface {

    @GET("chamadosapi/cabertos/{tecnico}")
    Call<Abertos> listAbertos(@Path("tecnico") String tecnico);

    @GET("chamadosapi/cabertos/leonardo")
    Call<Abertos> teste();

    @GET("chamadosapi/cabertos/{id}")
    Call<Chamado> getUnico(@Path("id") int id);

    @FormUrlEncoded
    @POST("chamadosapi/abrir")
    Call<Resposta> abrirChamado(@Field("id") String id, @Field("data") String data);

    @FormUrlEncoded
    @POST("chmadasapi/fechar")
    Call<String> fecharChamado(
            @Field("id") String id,
            @Field("mcabo") String mcabo,
            @Field("qconector") String qconector,
            @Field("relatorio") String relatorio,
            @Field("resolvido") String resolvido
    );

}
