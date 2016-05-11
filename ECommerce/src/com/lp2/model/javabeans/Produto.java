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
public class Produto implements Serializable{
    
    private long id_produto;
    private long productCode;
    private String productName;
    private double price;
    private String descricao;
    private String imagem;
    private int quantidade;

    public Produto(long productCode, String productName, double price, String descricao, String imagem, int quantidade) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.descricao = descricao;
        this.imagem = imagem;
        this.quantidade = quantidade;
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

    
    public long getProductCode() {
        return productCode;
    }

    public void setProductCode(long productCode) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "id_produto=" + id_produto + ", productCode=" + productCode + ", productName=" + productName + ", price=" + price + ", descricao=" + descricao + ", imagem=" + imagem + ", quantidade=" + quantidade + '}';
    }
     
}
