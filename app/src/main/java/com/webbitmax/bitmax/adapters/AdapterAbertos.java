package com.webbitmax.bitmax.adapters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webbitmax.bitmax.AbertosActivity;
import com.webbitmax.bitmax.R;
import com.webbitmax.bitmax.model.Abertos;
import com.webbitmax.bitmax.model.Chamado;

import io.realm.RealmResults;

/**
 * Created by leonardo on 21/08/17.
 */

public class AdapterAbertos extends RecyclerView.Adapter<AdapterAbertos.MyViewHolder> {

    RealmResults<Chamado> chamados;

    public AdapterAbertos(RealmResults<Chamado> chamados) {
        this.chamados = chamados;
    }

    @Override
    public AdapterAbertos.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_abertos, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(AdapterAbertos.MyViewHolder holder, int position) {
        Chamado chamado = chamados.get(position);

        holder.tv_id.setText(chamado.getId()+"");
        holder.tv_numero.setText(chamado.getNumero());
        holder.tv_tecnico.setText(chamado.getTecnico());
    }

    @Override
    public int getItemCount() {
        return chamados.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_id, tv_numero, tv_tecnico;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_id = (TextView) itemView.findViewById(R.id.tv_id);
            tv_numero = (TextView) itemView.findViewById(R.id.tv_numero);
            tv_tecnico = (TextView) itemView.findViewById(R.id.tv_tecnico);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AbertosActivity activity = (AbertosActivity) v.getContext();

                    int position = getAdapterPosition();
                    activity.abrirChamado(chamados.get(position));
                }
            });
        }
    }


}
