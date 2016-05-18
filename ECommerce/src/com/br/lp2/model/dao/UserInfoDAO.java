/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.SingletonConnection;
import com.lp2.model.javabeans.UserInfo;
// import com.lp2.model.javabeans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class UserInfoDAO implements GenericDAO<UserInfo>{
    
    private final Connection connection;
 
    public UserInfoDAO() {
        this.connection = SingletonConnection.getIntance().getConnection();
    }

    @Override
    public List<UserInfo> read() {
        List<UserInfo> usuariosInfo = new ArrayList<>();
        try {
            // PASSO 2
            String sql = "SELECT * FROM userinfo";
            PreparedStatement pst = connection.prepareStatement(sql);

            // PASSO 3
            ResultSet rs = pst.executeQuery();

            // PASSO 4
            while (rs != null && rs.next()) {
                long idUsuarioInfo = rs.getLong("id_userinfo");
                String nomeCompleto = rs.getString("nome");
                String email = rs.getString("email");
                long telefone = rs.getLong("telefone");
                String endereco = rs.getString("endereco");
                String rg = rs.getString("rg");
                long cpf = rs.getLong("cpf");
                Date dataNasc = rs.getDate("dataNasc");

                UserInfo userInfo = new UserInfo();
                userInfo.setId_userinfo(idUsuarioInfo);
                userInfo.setNome(nomeCompleto);
                userInfo.setEmail(email);
                userInfo.setTelefone(telefone);
                userInfo.setEndereco(endereco);
                userInfo.setRg(rg);
                userInfo.setCpf(cpf);
                userInfo.setDataNasc(dataNasc);

                usuariosInfo.add(userInfo);
            }

            // PASSO 5
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuariosInfo;
    }

    @Override
    public UserInfo readById(long id) {
        UserInfo usuarioInfo = null;
        try {
            // PASSO 2
            String sql = "SELECT * FROM userinfo WHERE id_userinfo=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, id);

            // PASSO 3
            ResultSet rs = pst.executeQuery();

            // PASSO 4
            while (rs != null && rs.next()) {
                usuarioInfo = new UserInfo();
                usuarioInfo.setId_userinfo(id);
                usuarioInfo.setNome(rs.getString("nome"));
                usuarioInfo.setEmail(rs.getString("email"));
                // usuarioInfo.getDataNascimento(rs.getDate("data_nascimento"));
            }

            // PASSO 5
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioInfo;
    }

    @Override
    public boolean update(UserInfo e) {
       boolean resposta = false;
        
        
        try {
            //passo 2 
            String sql = "UPDATE userinfo SET nome=?, email=? WHERE id_userinfo=?";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, e.getNome());
            pst.setString(2, e.getEmail());
            pst.setLong(3, e.getId_userinfo());
            
            //passo 3 
            int resultado = pst.executeUpdate();
            
            //passo 4 
            if(resultado > 0) resposta = true;
            
            //passo 5
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return resposta;
    }

    @Override
    public boolean delete(UserInfo e) {
    boolean resposta = false;
       
       
        try {
            //passo 2
            String sql = "DELETE FROM usuario WHERE id_usuario = ?";
            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, e.getId_userinfo());
            
            //passo 3
            int resultado = pst.executeUpdate();
            
            //passo 4 
            if(resultado > 0) resposta = true;
            
            //passo 5 
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  
       return resposta;
    }

    @Override
    public long create(UserInfo e) {
        long resultado = -1;
        try {
            //passo 2 - preparar sql e statement
            String sql = "INSERT INTO userinfo(id_userinfo, nome, email, endereco, telefone, rg, cpf, dataNasc) VALUES (?,?,?,?,?,?,?,?)"; // ? = prepared statement, onde vale um valor, mas não se sabe qual
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, e.getUsuario().getIdUser());
            pst.setString(2, e.getNome());
            pst.setString(3, e.getEmail());
            pst.setString(4, e.getEndereco()); 
            pst.setLong(5, e.getTelefone()); 
            pst.setString(6, e.getRg()); 
            pst.setLong(7, e.getCpf()); 
            pst.setDate(8, new java.sql.Date(e.getDataNasc().getTime()));
            
            int linhasAfetadas = pst.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    resultado = rs.getLong(1);
                }
            }
            
            //passo 5 - fechar tudo (statement e conexao quando possivel)
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public void deleteById(Integer id) {
        String sql = "DELETE FROM UserInfo WHERE id_UserInfo = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
