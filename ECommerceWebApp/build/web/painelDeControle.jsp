<%-- 
    Document   : painelDeControle
    Created on : May 11, 2016, 3:47:21 PM
    Author     : VictorOka
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Painel&nbsp;de&nbsp;Controle</title>
    </head>
    <body>
        <c:if test="${usuario == null}">
            <c:redirect url="index.jsp"></c:redirect>
        </c:if>
        <%@include file="TopMenu.jspf" %>
        <section class="container">
            <h1 class="centro">Painel&nbsp;de&nbsp;Controle</h1>
            <fieldset class="fieldset2">
                <legend>Escolha&nbsp;uma&nbsp;opera&ccedil;&atilde;o:</legend>
                <a href="${pageContext.request.contextPath}/produto!novoProduto.action" class="botao">Cadastrar&nbsp;Produto</a>
                <a href="${pageContext.request.contextPath}/produto!listar.action" class="botao">Listar&nbsp;Produtos</a>
                <a href="${pageContext.request.contextPath}/usuario!listar.action" class="botao">Listar&nbsp;Usu&aacute;rios</a>
            </fieldset>
        </section>
        <%@include file="Footer.jspf" %>
    </body>
</html>
