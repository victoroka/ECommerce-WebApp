/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.model.javabeans;


/**
 *
 * @author Lucas
 */
public class Userinfo {
    
    private long id_userinfo;
    private String nome;
    private String email;
    private String endereco;
    private int telefone;
    private String rg;
    private int cpf;
    //private date dataNasc;

    public Userinfo(String nome, String email, String endereco, int telefone, String rg, int cpf) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.rg = rg;
        this.cpf = cpf;
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Userinfo{" + "id_userinfo=" + id_userinfo + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco + ", telefone=" + telefone + ", rg=" + rg + ", cpf=" + cpf + '}';
    }
    
}
