/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.fci.ec.lp2.action;

import com.br.lp2.model.dao.UserInfoDAO;
import com.br.lp2.model.dao.UsuarioDAO;
import com.lp2.model.javabeans.UserInfo;
import com.lp2.model.javabeans.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VictorOka
 */
public class UsuarioAction extends ActionSupport {

    public String login() {
        String username = this.getRequest().getParameter("username");
        String password = this.getRequest().getParameter("password");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.readByName(username);
        if (usuario == null) {
            this.getRequest().getSession().setAttribute("erromsg", "Usuário não encontrado!");
            return "WEB-INF/jsp/usuario/erro.jsp";
        } else if (password.equals(usuario.getPassword())) {
            this.getRequest().getSession().setAttribute("usuario", usuario);
            return "WEB-INF/jsp/usuario/home.jsp";
        } else {
            this.getRequest().getSession().setAttribute("erromsg", "Senha incorreta!");
            return "WEB-INF/jsp/usuario/erro.jsp";
        }
    }

    public String logout() {
        this.getRequest().getSession().invalidate();
        return "index.jsp";
    }

    public String cadastrar() {
        String nomeCompleto = this.getRequest().getParameter("nomeCompleto");
        String email = this.getRequest().getParameter("email");
        String endereco = this.getRequest().getParameter("endereco");
        long telefone = Long.parseLong(this.getRequest().getParameter("telefone"));
        String rg = this.getRequest().getParameter("rg");
        long cpf = Long.parseLong(this.getRequest().getParameter("cpf"));
        int tipo = Integer.parseInt(this.getRequest().getParameter("tipo"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataNasc = null;
        try {
            dataNasc = sdf.parse(this.getRequest().getParameter("dataNasc"));
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String username = this.getRequest().getParameter("username");
        String senha = this.getRequest().getParameter("senha");
        String confirmarSenha = this.getRequest().getParameter("confirmarSenha");

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (senha.equals(confirmarSenha)) {
            Usuario usuario = new Usuario();
            usuario.setPassword(senha);
            usuario.setLogin(username);
            usuario.setTipo(tipo);

            UserInfo userInfo = new UserInfo();
            userInfo.setNome(nomeCompleto);
            userInfo.setCpf(cpf);
            userInfo.setEmail(email);
            userInfo.setRg(rg);
            userInfo.setEndereco(endereco);
            userInfo.setTelefone(telefone);
            userInfo.setUsuario(usuario);
            userInfo.setDataNasc(dataNasc);

            usuario.setUserinfo(userInfo);
            usuarioDAO.create(usuario);

            this.getRequest().getSession().setAttribute("usuario", usuario);
            return "WEB-INF/jsp/usuario/home.jsp";
        } else {
            this.getRequest().getSession().setAttribute("erromsg", "Senhas não conferem!");
            return "WEB-INF/jsp/usuario/erro.jsp";
        }
    }

    public String home() {
        return "WEB-INF/jsp/usuario/home.jsp";
    }

    public String listar() {
        try {
            this.getRequest().setAttribute("usuarios", new UsuarioDAO().read());
            this.getRequest().setAttribute("userinfos", new UserInfoDAO().read());
        } catch (Exception e) {
            Logger.getLogger(UsuarioAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return "WEB-INF/jsp/usuario/listar.jsp";
    }

    public String remover() {
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setId_userinfo(Long.parseLong(this.getRequest().getParameter("code")));
            UserInfoDAO userInfoDAO = new UserInfoDAO();
            this.getRequest().setAttribute("userinfo", userInfoDAO.readById(userInfo.getId_userinfo()));
        } catch (Exception ex) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "WEB-INF/jsp/usuario/remover.jsp";
    }

    public String confirmarRemocao() {
        try {
            new UserInfoDAO().deleteById(Integer.parseInt(this.getRequest().getParameter("codigo")));
        } catch (Exception ex) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.listar();
    }
    
    public String comprar() {
        Usuario usuario = (Usuario)(this.getRequest().getSession().getAttribute("usuario"));
        if (usuario == null) {
            this.getRequest().getSession().setAttribute("erromsg", "Favor realizar o login!");
            return "WEB-INF/jsp/usuario/erro.jsp";
        } else {
            return "WEB-INF/jsp/usuario/produto.jsp";
        }
    }
    
    public String testarUsuario(){
        String username = this.getRequest().getParameter("username");
        String password = this.getRequest().getParameter("password");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.readByName(username);
        if (usuario == null) {
            this.getRequest().getSession().setAttribute("erromsg", "Você precisa se logar para comprar!");
            return "WEB-INF/jsp/usuario/erro.jsp";
        } else if (password.equals(usuario.getPassword())) {
            return "WEB-INF/jsp/usuario/home.jsp";
        } else {
            this.getRequest().getSession().setAttribute("erromsg", "outro erro teste");
            return "WEB-INF/jsp/usuario/erro.jsp";
        }
    }
}
    
