package com.webbitmax.bitmax.model;

import java.io.Serializable;

/**
 * Created by leonardo on 21/08/17.
 */

public class Chamado implements Serializable {

    String suporte_id;
    String numero;
    String tipo;
    String prazodata;
    String tecnico;
    String mensagem;
    String cliente_nome;
    String cliente_endereco;
    String cliente_numero;
    String complemento;
    String cliente_bairro;
    String cliente_cidade;
    String telefone;
    String celular;
    String cliente_login;
    String cliente_senha;
    String cliente_mac;
    String tipoconexao;
    String groupname;
    String up;
    String down;


    public String getId() {
        return suporte_id;
    }

    public void setId(String id) {
        this.suporte_id = id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrazodata() {
        return prazodata;
    }

    public void setPrazodata(String prazodata) {
        this.prazodata = prazodata;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getCliente_endereco() {
        return cliente_endereco;
    }

    public void setCliente_endereco(String cliente_endereco) {
        this.cliente_endereco = cliente_endereco;
    }

    public String getCliente_numero() {
        return cliente_numero;
    }

    public void setCliente_numero(String cliente_numero) {
        this.cliente_numero = cliente_numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCliente_bairro() {
        return cliente_bairro;
    }

    public void setCliente_bairro(String cliente_bairro) {
        this.cliente_bairro = cliente_bairro;
    }

    public String getCliente_cidade() {
        return cliente_cidade;
    }

    public void setCliente_cidade(String cliente_cidade) {
        this.cliente_cidade = cliente_cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCliente_login() {
        return cliente_login;
    }

    public void setCliente_login(String cliente_login) {
        this.cliente_login = cliente_login;
    }

    public String getCliente_senha() {
        return cliente_senha;
    }

    public void setCliente_senha(String cliente_senha) {
        this.cliente_senha = cliente_senha;
    }

    public String getCliente_mac() {
        return cliente_mac;
    }

    public void setCliente_mac(String cliente_mac) {
        this.cliente_mac = cliente_mac;
    }

    public String getTipoconexao() {
        return tipoconexao;
    }

    public void setTipoconexao(String tipoconexao) {
        this.tipoconexao = tipoconexao;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

}
