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
public class Compra {
    
    private int code;
    private double total;
    private Date saleTime;
    private Carrinho cart;

    public Compra(int code, double total, Date saleTime, Carrinho cart) {
        this.code = code;
        this.total = total;
        this.saleTime = saleTime;
        this.cart = cart;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Carrinho getCart() {
        return cart;
    }

    public void setCart(Carrinho cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Compra{" + "code=" + code + ", total=" + total + ", saleTime=" + saleTime + ", cart=" + cart + '}';
    }
    
}
