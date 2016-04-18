/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.model.javabeans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VictorOka
 */
public class Carrinho {

    private double totalCart;
    private ItemCompra itemCompra;
    private List<ItemCompra> itensCompra = null;

    public Carrinho() {
        if (itensCompra == null) {
            itensCompra = new ArrayList<ItemCompra>();
        }
    }

    public void registrarItem(ItemCompra itemCompra) {
        itensCompra.add(itemCompra);
    }

    public double calcularTotalCarrinho() {
        double total = 0;
        for (ItemCompra item : itensCompra) {
            total += item.getTotalItem();
        }
        return total;
    }

    public double getTotalCart() {
        return totalCart;
    }

    public void setTotalCart(double totalCart) {
        this.totalCart = totalCart;
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }

    public List<ItemCompra> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(List<ItemCompra> itensCompra) {
        this.itensCompra = itensCompra;
    }

    @Override
    public String toString() {
        return "Carrinho{" + "totalCart=" + totalCart + ", itemCompra=" + itemCompra + ", itensCompra=" + itensCompra + '}';
    }

}
