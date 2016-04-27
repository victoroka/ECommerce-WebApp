/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VictorOka
 */
public class SingletonConnection {

    private static SingletonConnection instance;
    private Connection connection;
    private ResourceBundle bundle = ResourceBundle.getBundle("com.br.lp2.util.config");
    public String url = bundle.getString("url");
    public String username = bundle.getString("user");
    public String password = bundle.getString("password");
    public String driver = bundle.getString("driver");

    private SingletonConnection() {
        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(SingletonConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static SingletonConnection getIntance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SingletonConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
