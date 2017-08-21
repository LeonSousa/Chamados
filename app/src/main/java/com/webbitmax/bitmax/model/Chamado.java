package com.webbitmax.bitmax.model;

import java.io.Serializable;

/**
 * Created by leonardo on 21/08/17.
 */

public class Chamado implements Serializable {

    int id;
    String tecnico;
    int numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
