/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.model.javabeans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author VictorOka
 */
public class Usuario implements Serializable {
    
    private long idUser;
    private String name;
    private String login;
    private String password;
    private int tipo;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }
    private UserInfo userInfo;
    private List<Comentario> comentario;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Usuario(){
        // Default pro read()
    }
    
    public Usuario(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    // Construtor para o readById()
    public Usuario(String login, String password) {
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
