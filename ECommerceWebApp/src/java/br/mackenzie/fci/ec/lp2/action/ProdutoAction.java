/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import com.br.lp2.model.dao.ProdutoDAO;
import com.lp2.model.javabeans.Produto;

/**
 *
 * @author VictorOka
 */
public class ProdutoAction extends ActionSupport {
    
    public String cadastrar() {
        String nomeProduto = this.getRequest().getParameter("nomeProduto");
        double preco = Double.parseDouble(this.getRequest().getParameter("preco"));
        long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        String descricao = this.getRequest().getParameter("descricao");
        String imagem = this.getRequest().getParameter("imagem");
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setProductName(nomeProduto);
        produto.setPrice(preco);
        produto.setProductCode(codigo);
        produto.setDescricao(descricao);
        produto.setImagem(imagem);
        
        produtoDAO.create(produto);
        return "WEB-INF/jsp/produto/inserir.jsp";
    }
    
    public String listar() {
        return "";
    }
    
    public String remover() {
        return "";
    }
    
    public String alterar() {
        return "";
    }
}
