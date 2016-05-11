/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.dao;

import com.br.lp2.model.SingletonConnection;
import com.lp2.model.javabeans.Produto;
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
public class ProdutoDAO implements GenericDAO<Produto>{
    
    private final Connection connection;
 
    public ProdutoDAO() {
        this.connection = SingletonConnection.getIntance().getConnection();
    }

    @Override
    public void create(Produto e) {
       long resposta = -1;
        try {
            //passo 2 - preparar sql e statement
            String sql = "INSERT INTO produto(nome, preço, codigo, descricao, imagem) VALUES (?,?,?,?,?)"; // ? = prepared statement, onde vale um valor, mas não se sabe qual

            PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //retorna a chave 
            pst.setString(1, e.getProductName()); 
            pst.setDouble(2, e.getPrice()); 
            pst.setLong(3, e.getProductCode());
            //pst.setString(4, e.ge)
            
            
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
    }

    @Override
    public boolean update(Produto e) {
       boolean resposta = false;

        try {
            //passo 2 
            String sql = "UPDATE produto SET nome=?, preco=?, codigo=? WHERE id_produto=?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, e.getProductName()); //nome do produto
            pst.setDouble(2, e.getPrice()); //preco do produto
            pst.setLong(3, e.getProductCode()); //codigo do produto

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
    public boolean delete(Produto e) {
       boolean resposta = false;

        try {
            //passo 2
            String sql = "DELETE FROM produto WHERE id_produto = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, e.getId_produto());

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
    public List<Produto> read() {
        List<Produto> produtos = new ArrayList<>();
        try {
            //PASSO 2
            String sql = "SELECT * FROM produto";
            PreparedStatement pst = connection.prepareStatement(sql);

            //PASSO 3
            ResultSet rs = pst.executeQuery();

            //PASSO 4
            while (rs != null && rs.next()) {
                long id_produto = rs.getLong("id_produto");
                String nome = rs.getString("username");
                Double preco = rs.getDouble("preco");
                int codigo = rs.getInt("codigo");

                Produto p = new Produto();
                p.setId_produto(id_produto);
                p.setProductName(nome);
                p.setPrice(preco);
                p.setProductCode(codigo);
                
                produtos.add(p);
            }

            //PASSO 5
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    @Override
    public Produto readById(long id) {
       Produto p = null;
        try {
            // PASSO 2
            String sql = "SELECT * FROM produto WHERE id_produto=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, id);

            //PASSO 3
            ResultSet rs = pst.executeQuery();

            // PASSO 4
            while (rs != null && rs.next()) {
                p = new Produto();
                p.setId_produto(id);
                p.setProductName(rs.getString("username"));
                p.setPrice(rs.getDouble("preco"));
                p.setProductCode(rs.getInt("codigo"));
                
            }

            // PASSO 5
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}
