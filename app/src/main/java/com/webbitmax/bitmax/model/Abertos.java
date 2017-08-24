package com.webbitmax.bitmax.model;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by leonardo on 21/08/17.
 */

public class Abertos extends RealmObject {

    RealmList<Chamado> abertos;
    int registros;

    public Abertos() {
        this.abertos = new RealmList<>();
    }

    public RealmList<Chamado> getAbertos() {
        return abertos;
    }

    public void setAbertos(RealmList<Chamado> abertos) {
        this.abertos = abertos;
    }

    public void addChamado(Chamado chamado){
        abertos.add(chamado);
    }

    public int getRegistros() {
        return registros;
    }

    public void setRegistros(int registros) {
        this.registros = registros;
    }



}
