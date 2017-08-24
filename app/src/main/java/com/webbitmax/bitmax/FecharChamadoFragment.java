package com.webbitmax.bitmax;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.webbitmax.bitmax.model.Chamado;
import com.webbitmax.bitmax.retrofit.ApiService;
import com.webbitmax.bitmax.retrofit.RequestInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wargas on 24/08/17.
 */

public class FecharChamadoFragment extends DialogFragment {

    EditText et_mcabo, et_qconectores, et_relatorio;
    CheckBox check_resolvido;
    Button btn_fechar;
    Chamado chamado;

   public static FecharChamadoFragment newInstance(Chamado chamado){
       FecharChamadoFragment f = new FecharChamadoFragment();
       Bundle args = new Bundle();
       f.setArguments(args);
       f.chamado = chamado;

       return f;
   }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fecharchamado, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

       super.onViewCreated(view, savedInstanceState);
        getDialog().setTitle("Fechar chamados");
        getDialog().setCancelable(false);

        et_mcabo = (EditText) view.findViewById(R.id.text_mcabos);
        et_qconectores = (EditText) view.findViewById(R.id.text_qconectores);
        et_relatorio = (EditText) view.findViewById(R.id.text_relatorio);
        check_resolvido = (CheckBox) view.findViewById(R.id.check_resolvido);
        btn_fechar = (Button) view.findViewById(R.id.btn_fechar);

        btn_fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestInterface requestService = ApiService.getApiService();
                String resolvido = "";
                if(check_resolvido.isChecked()){
                    resolvido = "Sim";
                } else {
                    resolvido = "Nao";
                }

                Call<String> call = requestService.fecharChamado(
                        chamado.getId(),
                        et_mcabo.getText().toString(),
                        et_qconectores.getText().toString(),
                        et_relatorio.getText().toString(),
                        resolvido
                );

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        getDialog().cancel();
                        Log.d("wrgs", response.body());
                        Toast.makeText(getActivity().getApplicationContext(), "Fechado com sucesso", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        getDialog().cancel();
                        Toast.makeText(getActivity().getApplicationContext(), "Erro de comunicação, tente novamente", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
