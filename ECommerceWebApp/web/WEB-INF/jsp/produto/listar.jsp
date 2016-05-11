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
    <body>
        <h1>Produtos Cadastrados</h1>
        <table style="border: 1px solid black; background-color: cadetblue; color: black;">
        <c:forEach var="produto" items="${produtos}">
            <tr>
                <td style="border: 1px solid black; text-align: center;"><c:out value="${produto.id_produto}"/></td>
                <td style="border: 1px solid black; text-align: center;"><c:out value="${produto.productName}"/></td>
                <td style="border: 1px solid black; text-align: center;"><c:out value="${produto.price}"/></td>
                <td style="border: 1px solid black; text-align: center;"><c:out value="${produto.productCode}"/></td>
                <td style="border: 1px solid black; text-align: center;"><c:out value="${produto.descricao}"/></td>
                <td style="border: 1px solid black; text-align: center;"><c:out value="${produto.antidade}"/></td>
                <td style="border: 1px solid black; text-align: center;"><a href="${pageContext.request.contextPath}/produto!alterar.action?code=${produto.id_produto}" class="botao"><c:out value="alterar"/></a>&nbsp;
                    <a href="${pageContext.request.contextPath}/cargo!remover.action?code=${produto.id_produto}" class="botao"><c:out value="remover"/></a></td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
