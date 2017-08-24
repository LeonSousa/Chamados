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

/**
 * Created by leonardo on 21/08/17.
 */

public class AdapterAbertos extends RecyclerView.Adapter<AdapterAbertos.MyViewHolder> {

    Abertos abertos;

    public AdapterAbertos(Abertos abertos) {
        this.abertos = abertos;
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
        Chamado chamado = abertos.getChamados().get(position);

        holder.tv_id.setText(chamado.getId()+"");
        holder.tv_numero.setText(chamado.getNumero());
        holder.tv_tecnico.setText(chamado.getTecnico());
    }

    @Override
    public int getItemCount() {
        return abertos.getChamados().size();
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
                    final AbertosActivity activity = (AbertosActivity) v.getContext();
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity.getApplicationContext());

                    builder.setMessage("Texto para escolher?")
                            .setCancelable(false)
                            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    int position = getAdapterPosition();
                                    activity.chamarDetalhes(abertos.getChamados().get(position));
                                }
                            })
                            .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            }).show();

                }
            });
        }
    }


}
