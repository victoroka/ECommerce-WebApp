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
public class CartaoCredito extends Pagamento {
    
    private long cardNumber;
    private String bandeira;
    private int parcelas;

    public CartaoCredito(long cardNumber, String bandeira, int parcelas, double amount) {
        super(amount);
        this.cardNumber = cardNumber;
        this.bandeira = bandeira;
        this.parcelas = parcelas;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" + "cardNumber=" + cardNumber + ", bandeira=" + bandeira + ", parcelas=" + parcelas + '}';
    }
    
}
