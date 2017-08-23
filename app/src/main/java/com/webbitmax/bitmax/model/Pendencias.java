package com.webbitmax.bitmax.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo on 23/08/17.
 */

public class Pendencias {


    List<Pendencias> pendencias;
    int registros;

    public Pendencias() {this.pendencias = new ArrayList<>();}

    public List<Pendencias> getPendencias() {return  pendencias;}

    public void setPendencias(List<Pendencias> pendencias) {this.pendencias = pendencias;}

    public int getRegistros() {return  registros;}

    public void setRegistros(int registros) {this.registros = registros;}

    public List<Pendencias> getChamados() {return pendencias;}

   // public void setChamados(<List<Chamado>) {this.chamados = chamados}


}
