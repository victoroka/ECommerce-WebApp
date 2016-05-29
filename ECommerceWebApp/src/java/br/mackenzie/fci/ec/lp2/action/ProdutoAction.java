/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import com.br.lp2.model.dao.ProdutoDAO;
import com.lp2.model.javabeans.Produto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VictorOka
 */
public class ProdutoAction extends ActionSupport {
    
    public String novoProduto() {
        return "WEB-INF/jsp/produto/cadastrarProduto.jsp";
    }
    
    public String cadastrar() {
        String nomeProduto = this.getRequest().getParameter("nomeProduto");
        double preco = Double.parseDouble(this.getRequest().getParameter("preco"));
        long codigo = Long.parseLong(this.getRequest().getParameter("codigo"));
        String descricao = this.getRequest().getParameter("descricao");
        // String imagem = this.getRequest().getParameter("imagem");
        int quantidade = Integer.parseInt(this.getRequest().getParameter("quantidade"));
        
        Produto produto = new Produto();
        produto.setProductName(nomeProduto);
        produto.setPrice(preco);
        produto.setProductCode(codigo);
        produto.setDescricao(descricao);
        // produto.setImagem(imagem);
        produto.setQuantidade(quantidade);
        
        try {
            new ProdutoDAO().create(produto);
            this.getRequest().setAttribute("produtos", new ProdutoDAO().read());
        } catch (Exception ex) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "WEB-INF/jsp/produto/listar.jsp";
    }
    
    public String listar() {
        try {
        this.getRequest().setAttribute("produtos", new ProdutoDAO().read());
        } catch (Exception e) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return "WEB-INF/jsp/produto/listar.jsp";
    }
    
    public String alterar() {
        try {
            Produto produto = new Produto();
            produto.setId_produto(Long.parseLong(this.getRequest().getParameter("code")));
            ProdutoDAO produtoDAO = new ProdutoDAO();
            this.getRequest().setAttribute("produto", produtoDAO.readById(produto.getId_produto()));
        } catch (Exception ex) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "WEB-INF/jsp/produto/alterar.jsp";
    }
    
    public String confirmarAlteracao() {
        try {
            Produto produto = new Produto();
            produto.setId_produto(Long.parseLong(this.getRequest().getParameter("codigo")));
            produto.setProductName(this.getRequest().getParameter("nome"));
            produto.setProductCode(Long.parseLong(this.getRequest().getParameter("codigoProduto")));
            produto.setPrice(Double.parseDouble(this.getRequest().getParameter("preco")));
            produto.setDescricao(this.getRequest().getParameter("descricao"));
            produto.setImagem("urlImagem");
            produto.setQuantidade(Integer.parseInt(this.getRequest().getParameter("quantidade")));
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.update(produto);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.listar();
    }
    
    public String remover() {
        try {
            Produto produto = new Produto();
            produto.setId_produto(Long.parseLong(this.getRequest().getParameter("code")));
            ProdutoDAO produtoDAO = new ProdutoDAO();
            this.getRequest().setAttribute("produto", produtoDAO.readById(produto.getId_produto()));
        } catch (Exception ex) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "WEB-INF/jsp/produto/remover.jsp";
    }
    
    public String confirmarRemocao() {
        try {
            new ProdutoDAO().deleteById(Integer.parseInt(this.getRequest().getParameter("code")));
        } catch (Exception ex) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.listar();
    }
    
    public String comprar() {
        try {
        this.getRequest().setAttribute("produtos", new ProdutoDAO().read());
        } catch (Exception e) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return "shop.jsp";
    }
}
