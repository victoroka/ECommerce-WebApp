<%-- 
    Document   : remover
    Created on : May 11, 2016, 5:11:36 PM
    Author     : VictorOka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover&nbsp;Produto</title>
    </head>
    <body>
        <%@include file="../../../TopMenu.jspf" %>
        <h1>Produto : remover</h1>
        <p>Tem certeza que deseja remover este produto?</p>
        <form method="POST" action="${pageContext.request.contextPath}/produto!confirmarRemocao.action">
            <label for="codigo">C&oacute;digo:&nbsp;</label>
            <input type="text" name="code" size="40" readonly="readonly" value="${produto.id_produto}" />
            <br>
            <label for="nome">Nome:&nbsp;</label>
            <input type="text" name="name" size="40" readonly="readonly" value="${produto.productName}"/>
            <br>
            <input type="submit" value="Remover" />
        </form>
        <%@include file="../../../Footer.jspf"%>
    </body>
</html>
