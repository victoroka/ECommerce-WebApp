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
public class Administrador extends Usuario {
    
    private int adminCode;

    public Administrador(int adminCode, String name, String login, String password) {
        super(name, login, password);
        this.adminCode = adminCode;
    }

    public int getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(int adminCode) {
        this.adminCode = adminCode;
    }

    @Override
    public String toString() {
        return "Administrador{" + "adminCode=" + adminCode + '}';
    }
    
}
