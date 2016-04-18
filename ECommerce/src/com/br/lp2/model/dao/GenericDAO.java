/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import java.util.List;

/**
 *
 * @author VictorOka
 */
public interface GenericDAO<E> {
    public long create(E e); //CREATE
    public List<E> read();      //READ
    public E readById(long id);
    public boolean update(E e); //UPDATE
    public boolean delete(E e); //DELETE
}
