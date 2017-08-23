package com.webbitmax.bitmax.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo on 21/08/17.
 */

public class Abertos {

    List<Chamado> chamados;
    //alteraçao provisoria, enquanto corrige a api
    List<Chamado> abertos;
    int registros;

    public Abertos() {
        this.abertos = new ArrayList<>();
    }

    public List<Chamado> getAbertos() {
        return abertos;
    }

    public void setAbertos(List<Chamado> abertos) {
        this.abertos = abertos;
    }

    public int getRegistros() {
        return registros;
    }

    public void setRegistros(int registros) {
        this.registros = registros;
    }

    public List<Chamado> getChamados() {
        return abertos;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
