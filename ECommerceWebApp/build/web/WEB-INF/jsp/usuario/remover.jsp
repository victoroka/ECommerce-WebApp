<%-- 
    Document   : remover
    Created on : May 13, 2016, 11:32:14 AM
    Author     : VictorOka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover&nbsp;Usuario</title>
    </head>
    <body>
        <%@include file="../../../TopMenu.jspf" %>
        <h1>Usuario : remover</h1>
        <p>Tem certeza que deseja remover este usuario?</p>
        <form method="POST" action="${pageContext.request.contextPath}/usuario!confirmarRemocao.action">
            <label for="codigo">C&oacute;digo:&nbsp;</label>
            <input type="text" name="codigo" size="40" readonly="readonly" value="${userinfo.id_userinfo}" />
            <br>
            <label for="nome">Nome:&nbsp;</label>
            <input type="text" name="nome" size="40" readonly="readonly" value="${userinfo.nome}"/>
            <br>
            <input type="submit" value="Remover" />
        </form>
        <%@include file="../../../Footer.jspf"%>
    </body>
</html>