<%-- 
    Document   : listar
    Created on : May 11, 2016, 5:11:16 PM
    Author     : VictorOka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        <%@include file="../../../TopMenu.jspf" %>
        <h1>Produtos Cadastrados</h1>
        <table style="border: 1px solid black; background-color: cadetblue; color: black;">
            <tr style="border: 1px solid black; text-align: center;">
                <th>ID</th>
                <th>NOME</th>
                <th>PREÇO</th>
                <th>CÓDIGO</th>
                <th>DESCRICAO</th>
                <th>QUANTIDADE</th>
                <th>OPÇÕES</th>
            </tr>
            <c:forEach var="produto" items="${produtos}">
                <tr class="celula">produtos
                    <td class="celula"><c:out value="${produto.id_produto}"/></td>
                    <td class="celula"><c:out value="${produto.productName}"/></td>
                    <td class="celula"><c:out value="${produto.price}"/></td>
                    <td class="celula"><c:out value="${produto.productCode}"/></td>
                    <td class="celula"><c:out value="${produto.descricao}"/></td>
                    <td class="celula"><c:out value="${produto.quantidade}"/></td>
                    <td class="celula"><a href="${pageContext.request.contextPath}/produto!alterar.action?code=${produto.id_produto}" class="botaoListar"><c:out value="alterar"/></a>&nbsp;
                        <a href="${pageContext.request.contextPath}/produto!remover.action?code=${produto.id_produto}" class="botaoListar"><c:out value="remover"/></a></td>
                </tr>
            </c:forEach>
        </table>
        <%@include file="../../../Footer.jspf"%>
    </body>
</html>
