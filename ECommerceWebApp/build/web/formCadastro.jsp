<%-- 
    Document   : formCadastro
    Created on : May 10, 2016, 3:47:40 PM
    Author     : VictorOka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastre-se!</title>
    </head>
    <body>
        <%@include file="TopMenuSemForm.jspf" %>
        <section class="container">
            <h1>Cadastro de Usu&aacute;rio</h1>
            <fieldset>
                <legend>Preencha&nbsp;o&nbsp;formul&aacute;rio abaixo:</legend>
                <form method="POST" action="${pageContext.request.contextPath}/usuario!cadastrar.action" class="formCadastro">
                    <input type="text" name="nomeCompleto" size="40" required="required" placeholder="Nome Completo" /><br>
                    <input type="text" name="email" size="40" required="required" placeholder="E-mail"/><br>
                    <input type="text" name="endereco" size="40" required="required" placeholder="Endereço"/><br>
                    <input type="text" name="telefone" size="40" required="required" placeholder="Telefone"/><br>
                    <input type="text" name="rg" size="9" required="required" placeholder="R.G."/><br>
                    <input type="number" name="cpf" size="11" required="required" placeholder="CPF"/><br>
                    <input type="number" name="tipo" size="1" required="required" placeholder="Tipo de Usuario" value="0" readonly="readonly"/><br>
                    <input type="text" name="username" size="40" required="required" placeholder="Nome de Usuário"/><br>
                    <input type="password" name="senha" size="40" required="required" placeholder="Senha"/><br>
                    <input type="password" name="confirmarSenha" size="40" required="required" placeholder="Confirme sua senha"/><br>
                    <input type="submit" value="Cadastrar" />
                </form>
            </fieldset>
        </section>
        <%@include file="Footer.jspf" %>
    </body>
</html>
