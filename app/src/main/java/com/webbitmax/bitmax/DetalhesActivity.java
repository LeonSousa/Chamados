package com.webbitmax.bitmax;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.webbitmax.bitmax.model.Chamado;
import com.webbitmax.bitmax.retrofit.ApiService;
import com.webbitmax.bitmax.retrofit.RequestInterface;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetalhesActivity extends AppCompatActivity {

    Chamado chamado;
    TextView tv_tecnico, tv_tipo, tv_prazo, tv_nome, tv_endereco, tv_complem,
            tv_bairro, tv_cidade, tv_telefone, tv_celular, tv_login, tv_senha, tv_plano, tv_mensagem;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(this).build());
        realm = Realm.getDefaultInstance();


        tv_tipo  = (TextView) findViewById(R.id.value_tipo);
        tv_prazo  = (TextView) findViewById(R.id.value_prazo);
        tv_nome  = (TextView) findViewById(R.id.value_nome);
        tv_endereco = (TextView) findViewById(R.id.value_endereco);
        tv_complem  = (TextView) findViewById(R.id.value_complemtno);
        tv_bairro = (TextView) findViewById(R.id.value_bairro);
        tv_cidade  = (TextView) findViewById(R.id.value_cidade);
        tv_telefone  = (TextView) findViewById(R.id.value_telefone);
        tv_celular  = (TextView) findViewById(R.id.value_celular);
        tv_login = (TextView) findViewById(R.id.value_login);
        tv_senha = (TextView) findViewById(R.id.value_senha);
        tv_plano  = (TextView) findViewById(R.id.value_plano);
        tv_mensagem  = (TextView) findViewById(R.id.value_mensagem);

        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("chamadoId");

        chamado = realm.where(Chamado.class).equalTo("suporte_id", id).findFirst();

        getSupportActionBar().setTitle("Detalhe");

        tv_tipo.setText(chamado.getTipo());
        tv_prazo.setText(chamado.getPrazodata());
        tv_nome.setText(chamado.getCliente_nome());
        tv_endereco.setText(chamado.getCliente_endereco());
        tv_complem.setText(chamado.getComplemento());
        tv_bairro.setText(chamado.getCliente_bairro());
        tv_cidade.setText(chamado.getCliente_cidade());
        tv_telefone.setText(chamado.getTelefone());
        tv_celular.setText(chamado.getCelular());
        tv_login.setText(chamado.getCliente_login());
        tv_senha.setText(chamado.getCliente_senha());
        tv_mensagem.setText(chamado.getMensagem());

    }

    public void fecharChamado(Chamado chamado){
        FragmentManager fm = getFragmentManager();
        FecharChamadoFragment fecharChamadoFragment = FecharChamadoFragment.newInstance(chamado);
        fecharChamadoFragment.show(fm, "fechar_chamado");
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
                AlertDialog.Builder builder = new AlertDialog.Builder(DetalhesActivity.this);
                builder.setCancelable(false);
                builder.setMessage("Confirma fechar este chamado?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fecharChamado(chamado);
                    }
                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();


        }
        return super.onOptionsItemSelected(item);
    }
}
