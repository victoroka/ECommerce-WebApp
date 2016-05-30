<%-- 
    Document   : cadastrarProduto
    Created on : May 11, 2016, 5:12:03 PM
    Author     : VictorOka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body>
        <%@include file="../../../TopMenu.jspf" %>
        <section class="container">
            <h1 class="centro">Cadastro&nbsp;de&nbsp;Produto</h1>
            <fieldset class="fieldset1">
                <legend>Preencha&nbsp;o&nbsp;formul&aacute;rio abaixo:</legend>
                <form method="POST" action="${pageContext.request.contextPath}/produto!cadastrar.action" class="formCadastro">
                    <input type="text" name="nomeProduto" size="40" required="required" placeholder="Nome do Produto" /><br>
                    <input type="text" name="preco" size="40" required="required" placeholder="Preço"/><br>
                    <input type="number" name="codigo" size="40" required="required" placeholder="Código"/><br>
                    <!--<textarea name="descricao" cols="45" rows="6" wrap="OFF" required="required" placeholder="Descrição"></textarea><br>-->
                    <input type="text" name="descricao" size="40" required="required" placeholder="Descrição"/><br>
                    <input type="number" name="quantidade" size="10" required="required" placeholder="Quantidade"/><br>
                    <input type="submit" value="Cadastrar" />
                </form>
            </fieldset>
            <br>
            <a href="painelDeControle.jsp" class="botaoListar"><c:out value="Voltar"/></a>
        </section>
        <%@include file="../../../Footer.jspf"%>
    </body>
</html>