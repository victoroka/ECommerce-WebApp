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
public class Produto {
    
    private long id_produto;
    private int productCode;
    private String productName;
    private double price;
    private int quantity;

    public Produto(int productCode, String productName, double price, int quantity) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Produto() {
        //read
    }

    public long getId_produto() {
        return id_produto;
    }

    public void setId_produto(long id_produto) {
        this.id_produto = id_produto;
    }

    
    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Produto{" + "id_produto=" + id_produto + ", productCode=" + productCode + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity + '}';
    }    
}
