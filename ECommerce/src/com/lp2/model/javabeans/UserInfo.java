/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.model.javabeans;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Lucas
 */
public class UserInfo implements Serializable {
    
    private long id_userinfo;
    private String nome;
    private String email;
    private String endereco;
    private long telefone;
    private String rg;
    private long cpf;
    private Date dataNasc;

    public UserInfo(String nome, String email, String endereco, int telefone, String rg, int cpf) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.rg = rg;
        this.cpf = cpf;
    }

    public UserInfo() {
        // Construtor default para o read()
    }
    
    public long getId_userinfo() {
        return id_userinfo;
    }

    public void setId_userinfo(long id_userinfo) {
        this.id_userinfo = id_userinfo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Userinfo{" + "id_userinfo=" + id_userinfo + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco + ", telefone=" + telefone + ", rg=" + rg + ", cpf=" + cpf + '}';
    }
    
}
