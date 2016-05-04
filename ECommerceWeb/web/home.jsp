<%-- 
    Document   : home
    Created on : 03/05/2016, 19:21:06
    Author     : Victor
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ECommerce</title>
    </head>
    <body>
        <c:if test="${usuario == null}">
            <c:redirect url="index.jsp"></c:redirect>
        </c:if>
        <%@include file="TopMenu.jspf" %>
        <section class="container">
            <h1>ECommerce</h1>
            <h2>Bem vindo ${usuario.name}!</h2>
        </section>
    </body>
</html>
