package com.webbitmax.bitmax.model;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by leonardo on 21/08/17.
 */

public class Chamado extends RealmObject implements Serializable {

    String msg;
    

    public String getMsg() {
        return msg;
    }

    public void SetMsg(String msg) {
        this.msg = msg;
    }

   

}
