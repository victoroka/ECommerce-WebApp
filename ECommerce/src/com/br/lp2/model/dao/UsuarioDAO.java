/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.SingletonConnection;
import com.lp2.model.javabeans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class UsuarioDAO implements GenericDAO<Usuario> {

    private final Connection connection;

    public UsuarioDAO() {
        this.connection = SingletonConnection.getIntance().getConnection();
    }

    @Override
    public long create(Usuario e) {
        long resposta = -1;
        try {
            //passo 2 - preparar sql e statement
            String sql = "INSERT INTO usuario(username, password) VALUES (?,?)"; // ? = prepared statement, onde vale um valor, mas não se sabe qual

            PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //retorna a chave 
            pst.setString(1, e.getLogin()); //1o interrogaçao eh uma string e recebe o nome do usuario
            pst.setString(2, e.getPassword()); //2a interrogaçao eh uma string e recebe a senha

            //passo 3 - executar a consulta
            int resultado = pst.executeUpdate(); //linhas afetadas

            //passo 4 - tratar os resultados
            if (resultado > 0) {
                ResultSet rs2 = pst.getGeneratedKeys(); //buscar a chave do banco
                if (rs2 != null && rs2.next()) {
                    resposta = rs2.getLong(1);
                }
            }

            //passo 5 - fechar tudo (statement e conexao quando possivel)
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resposta;
    }

    @Override
    public List<Usuario> read() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            //PASSO 2
            String sql = "SELECT * FROM usuario";
            PreparedStatement pst = connection.prepareStatement(sql);

            //PASSO 3
            ResultSet rs = pst.executeQuery();

            //PASSO 4
            while (rs != null && rs.next()) {
                long idUsuario = rs.getLong("id_user");
                String nome = rs.getString("username");
                String senha = rs.getString("password");

                Usuario u = new Usuario();
                u.setIdUser(idUsuario);
                u.setName(nome);
                u.setPassword(senha);

                usuarios.add(u);
            }

            //PASSO 5
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public Usuario readById(long id) {
        Usuario usuario = null;
        try {
            // PASSO 2
            String sql = "SELECT * FROM usuario WHERE id_user=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, id);

            //PASSO 3
            ResultSet rs = pst.executeQuery();

            // PASSO 4
            while (rs != null && rs.next()) {
                usuario = new Usuario();
                usuario.setIdUser(id);
                usuario.setName(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
            }

            // PASSO 5
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public Usuario readByName(String nomeUsuario) {
        Usuario usuario = null;
        try {
            String sql = "SELECT * FROM USUARIO WHERE username = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nomeUsuario);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                usuario = new Usuario(nomeUsuario, rs.getString("PASSWORD"));
                usuario.setIdUser(rs.getLong("ID_USER"));
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public boolean update(Usuario e) {
        boolean resposta = false;

        try {
            //passo 2 
            String sql = "UPDATE usuario SET username=?, password=? WHERE id_usuario=?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, e.getLogin());
            pst.setString(2, e.getPassword());
            pst.setLong(3, e.getIdUser());

            //passo 3 
            int resultado = pst.executeUpdate();

            //passo 4 
            if (resultado > 0) {
                resposta = true;
            }

            //passo 5
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resposta;
    }

    @Override
    public boolean delete(Usuario e) {
        boolean resposta = false;

        try {
            //passo 2
            String sql = "DELETE FROM usuario WHERE id_usuario = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, e.getIdUser());

            //passo 3
            int resultado = pst.executeUpdate();

            //passo 4 
            if (resultado > 0) {
                resposta = true;
            }

            //passo 5 
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resposta;
    }

}
