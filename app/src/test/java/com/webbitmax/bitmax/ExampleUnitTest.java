package com.webbitmax.bitmax;

import com.google.gson.Gson;
import com.webbitmax.bitmax.model.Abertos;
import com.webbitmax.bitmax.retrofit.RequestService;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        RequestService requestService = RequestService.retrofit.create(RequestService.class);

        Call<Abertos> call = requestService.teste();


        call.enqueue(new Callback<Abertos>() {
            @Override
            public void onResponse(Call<Abertos> call, Response<Abertos> response) {

            }

            @Override
            public void onFailure(Call<Abertos> call, Throwable t) {
                System.out.print("opa2");
            }
        });

        System.out.print(call.isExecuted());

    }
}