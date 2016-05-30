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
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="TopMenu.jspf" %>
        <section class="container">
            <h1>Shop</h1>
        </section>

        <section>
            <p>Produtos</p>
          
                <c:forEach var="produto" items="${produtos}">
                    <div>
                    <section class="boxproduto leftproduto">
                            <img src="imgs/tele.jpg" alt="tele" class="fotoproduto"/>
                            <p class="pproduto"><c:out value="${produto.productName}"/></p>
                            <p class="pproduto"><c:out value="${produto.price}"/></p>
                            <p class="pproduto"><a href="${pageContext.request.contextPath}/usuario!testarUsuario.action" class="botaoproduto">Comprar</a></p>
                    </section>
                    </div>
                </c:forEach>
        </section>
        <%@include file="Footer.jspf" %>
    </body>
</html>