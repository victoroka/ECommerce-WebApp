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
    public long create(Produto e) {
       long resultado = -1;
        try {
            //passo 2 - preparar sql e statement
            String sql = "INSERT INTO produto (nome, preco, codigo, descricao, imagem, quantidade) VALUES (?,?,?,?,?,?)"; // ? = prepared statement, onde vale um valor, mas não se sabe qual

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, e.getProductName()); 
            pst.setDouble(2, e.getPrice()); 
            pst.setLong(3, e.getProductCode());
            pst.setString(4, e.getDescricao());
            pst.setString(5, "urlImagem");
            pst.setInt(6, e.getQuantidade());
            
            
            //passo 3 - executar a consulta
            pst.executeUpdate();
            
            //passo 5 - fechar tudo (statement e conexao quando possivel)
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public boolean update(Produto e) {
       boolean resposta = false;

        try {
            //passo 2 
            String sql = "UPDATE produto SET nome=?, preco=?, codigo=?, descricao=?, imagem=?, quantidade=? WHERE id_produto=?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, e.getProductName()); //nome do produto
            pst.setDouble(2, e.getPrice()); //preco do produto
            pst.setLong(3, e.getProductCode()); //codigo do produto
            pst.setString(4, e.getDescricao());
            pst.setString(5, e.getImagem());
            pst.setInt(6, e.getQuantidade());
            pst.setLong(7, e.getId_produto());

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

    public void deleteById(long id) {
        String sql = "DELETE FROM produto WHERE id_produto = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setLong(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                String nome = rs.getString("nome");
                Double preco = rs.getDouble("preco");
                long codigo = rs.getLong("codigo");
                String descricao = rs.getString("descricao");
                String imagem = rs.getString("imagem");
                int quantidade = rs.getInt("quantidade");
                

                Produto p = new Produto();
                p.setId_produto(id_produto);
                p.setProductName(nome);
                p.setPrice(preco);
                p.setProductCode(codigo);
                p.setDescricao(descricao);
                p.setImagem(imagem);
                p.setQuantidade(quantidade);
                
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
                p.setProductName(rs.getString("nome"));
                p.setPrice(rs.getDouble("preco"));
                p.setProductCode(rs.getInt("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setQuantidade(rs.getInt("quantidade"));
            }

            // PASSO 5
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
}
