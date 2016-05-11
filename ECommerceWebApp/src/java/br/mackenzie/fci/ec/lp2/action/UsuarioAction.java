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
        String username = this.getRequest().getParameter("username");
        String senha = this.getRequest().getParameter("senha");
        String confirmarSenha = this.getRequest().getParameter("confirmarSenha");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UserInfoDAO userInfoDAO = new UserInfoDAO();

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

            long generatedKey = usuarioDAO.createUser(usuario);
            userInfoDAO.createUserInfo(userInfo, generatedKey);
            this.getRequest().getSession().setAttribute("usuario", usuario);
            return "WEB-INF/jsp/usuario/home.jsp";
        } else {
            this.getRequest().getSession().setAttribute("erromsg", "Senhas não conferem!");
            return "WEB-INF/jsp/usuario/erro.jsp";
        }
    }
}
