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
    public long create(UserInfo e) {
      long resposta = -1;   
        try {
            //passo 2 - preparar sql e statement
            String sql = "INSERT INTO userinfo(fullname, email, endereco, telefone, rg, cpf) VALUES (?,?,?,?,?,?)"; // ? = prepared statement, onde vale um valor, mas não se sabe qual
          
            PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //retorna a chave 
            pst.setString(1, e.getNome());
            pst.setString(2, e.getEmail());
            pst.setString(3, e.getEndereco()); 
            pst.setInt(4, e.getTelefone()); 
            pst.setString(5, e.getRg()); 
            pst.setInt(6, e.getCpf()); 
            //data pst.setString(7, e.getPassword()); 
            
            
            //passo 3 - executar a consulta
            int resultado = pst.executeUpdate(); //linhas afetadas
            
            //passo 4 - tratar os resultados
            if(resultado > 0){
                ResultSet rs2 = pst.getGeneratedKeys(); //buscar a chave do banco
                if(rs2!=null && rs2.next()) resposta = rs2.getLong(1);
            }
            
            //passo 5 - fechar tudo (statement e conexao quando possivel)
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
             
     return resposta;
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
                String nomeCompleto = rs.getString("fullname");
                String email = rs.getString("email");
                int telefone = rs.getInt("telefone");
                String endereco = rs.getString("endereco");
                String rg = rs.getString("rg");
                int cpf = rs.getInt("cpf");
                Date dataNascimento = rs.getDate("datanasc");

                UserInfo userInfo = new UserInfo();
                userInfo.setNome(nomeCompleto);
                userInfo.setEmail(email);
                userInfo.setTelefone(telefone);
                userInfo.setEndereco(endereco);
                userInfo.setRg(rg);
                userInfo.setCpf(cpf);
                userInfo.setDataNasc(dataNascimento);

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
                usuarioInfo.setNome(rs.getString("fullname"));
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
            String sql = "UPDATE userinfo SET fullname=?, email=? WHERE id_userinfo=?";
            
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


}
