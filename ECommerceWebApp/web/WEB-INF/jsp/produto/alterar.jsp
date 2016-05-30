<%-- 
    Document   : alterar
    Created on : May 11, 2016, 5:11:26 PM
    Author     : VictorOka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar&nbsp;Produto</title>
    </head>
    <body>
        <%@include file="../../../TopMenu.jspf" %>
        <section class="container">
            <h1>Produto : alterar</h1>
            <p>Tem certeza que deseja remover este cargo?</p>
            <form method="POST" action="${pageContext.request.contextPath}/produto!confirmarAlteracao.action">
                <label for="codigo">C&oacute;digo:&nbsp;</label>
                <input type="text" name="codigo" size="40" readonly="readonly" value="${produto.id_produto}" />
                <br>
                <label for="nome">Nome:&nbsp;</label>
                <input type="text" name="nome" size="40" value="${produto.productName}"/>
                <br>
                <label for="codigoProduto">C&oacute;digo:&nbsp;do&nbsp;Produto:&nbsp;</label>
                <input type="text" name="codigoProduto" size="40" readonly="readonly" value="${produto.productCode}"/>
                <br>
                <label for="preco">Preco:&nbsp;</label>
                <input type="text" name="preco" size="40" value="${produto.price}"/>
                <br>
                <label for="quantidade">Quantidade:&nbsp;</label>
                <input type="text" name="quantidade" size="40" value="${produto.quantidade}"/>
                <br>
                <label for="descricao">Descricao:&nbsp;</label>
                <input type="text" name="descricao" size="40" value="${produto.descricao}"/>
                <br>
                <input type="submit" value="Alterar" />
            </form>
            <br>
            <a href="painelDeControle.jsp" class="botaoListar"><c:out value="Voltar"/></a>
        </section>
        <%@include file="../../../Footer.jspf"%>
    </body>
</html>

