/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.SingletonConnection;
import com.lp2.model.javabeans.UserInfo;
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

    public long createUser(Usuario e) {
        long generatedKey = 0;
        try {
            //passo 2 - preparar sql e statement
            String sql = "INSERT INTO usuario(username, password, tipo) VALUES (?,?,?)"; // ? = prepared statement, onde vale um valor, mas não se sabe qual
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, e.getLogin()); //1o interrogaçao eh uma string e recebe o nome do usuario
            pst.setString(2, e.getPassword()); //2a interrogaçao eh uma string e recebe a senha
            pst.setInt(3, e.getTipo());
            pst.execute(); //linhas afetadas
            generatedKey = e.getIdUser()+1;
            //passo 5 - fechar tudo (statement e conexao quando possivel)
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generatedKey;
    }

    @Override
    public List<Usuario> read() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            //PASSO 2
            String sql = "SELECT * FROM usuario INNER JOIN userinfo on ID_USER=ID_USERINFO";
            PreparedStatement pst = connection.prepareStatement(sql);

            //PASSO 3
            ResultSet rs = pst.executeQuery();
            
            //PASSO 4
            while (rs != null && rs.next()) {
                long idUserInfo = rs.getLong("id_userinfo");
                String nomeCompleto = rs.getString("nome");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                long telefone = rs.getInt("telefone");
                String rg = rs.getString("RG");
                long cpf = rs.getInt("cpf");
                
                UserInfo userInfo = new UserInfo();
                
                userInfo.setNome(nomeCompleto);
                userInfo.setEmail(email);
                userInfo.setEndereco(endereco);
                userInfo.setTelefone(telefone);
                userInfo.setCpf(cpf);
                
                long idUsuario = idUserInfo;
                
                String nome = rs.getString("username");
                String senha = rs.getString("password");
                
                Usuario u = new Usuario();
                u.setName(nome);
                u.setPassword(senha);
                u.setIdUser(idUsuario);

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
                usuario.setName(nomeUsuario);
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

    @Override
    public void create(Usuario e) {
        
    }

}
