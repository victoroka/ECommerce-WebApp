/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VictorOka
 */
public interface Action {
    
    public String execute(HttpServletRequest request, HttpServletResponse response, Method method) 
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
