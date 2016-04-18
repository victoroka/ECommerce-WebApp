/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.model.javabeans;

/**
 *
 * @author VictorOka
 */
public class Usuario {
    
    private long idUser;
    private String name;
    private String login;
    private String password;

    public Usuario(){
        //default pro read
    }
    
    public Usuario(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }


    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUser=" + idUser + ", name=" + name + ", login=" + login + ", password=" + password + '}';
    }
    
}
