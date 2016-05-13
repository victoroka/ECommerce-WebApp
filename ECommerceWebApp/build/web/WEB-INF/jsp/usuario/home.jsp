<%-- 
    Document   : home
    Created on : May 10, 2016, 3:17:09 PM
    Author     : VictorOka
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>ECommerce HOME</title>
    </head>
    <body>
        <c:if test="${usuario == null}">
            <c:redirect url="../../../index.jsp"></c:redirect>
        </c:if>
        <%@include file="../../../TopMenu.jspf" %>
        <section class="container">
            <h1>ECommerce HOME</h1>
            <h2>Bem vindo ${usuario.name}!</h2>
        </section>
        <%@include file="../../../Footer.jspf"%>
    </body>
</html>
