/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.model.javabeans;

import java.util.Date;

/**
 *
 * @author VictorOka
 */
public class Cliente extends Usuario {

    private String cpf;
    private String rg;
    private Date birthDate;
    private String adress;

    public Cliente(String cpf, String rg, Date birthDate, String adress, String name, String login, String password) {
        super(name, login, password);
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
        this.adress = adress;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", rg=" + rg + ", birthDate=" + birthDate + ", adress=" + adress + '}';
    }
    
}
