<%-- 
    Document   : shop
    Created on : 29/05/2016, 19:11:51
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ECommerce</title>
    </head>
    <body>
        <%@include file="TopMenu.jspf" %>
        <section class="container">
            <h1>Shop</h1>
        </section>

        <section>
            <p>Produtos</p>
            <table>
                <c:forEach var="produto" items="${produtos}">
                    <tr class="celula">
                        <td class="celula"><c:out value="${produto.productName}"/></td>
                        <td class="celula"><c:out value="${produto.price}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </section>
        <%@include file="Footer.jspf" %>
    </body>
</html>