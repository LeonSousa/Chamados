package com.webbitmax.bitmax.model;

import java.io.Serializable;

/**
 * Created by leonardo on 21/08/17.
 */

public class Chamado implements Serializable {

    String id;
    String tecnico;
    String numero;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
