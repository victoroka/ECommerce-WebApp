/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.model.javabeans;

import java.io.Serializable;

/**
 *
 * @author VictorOka
 */
public class Pagamento implements Serializable {
    
    private double amount;

    public Pagamento(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "amount=" + amount + '}';
    }
    
}
