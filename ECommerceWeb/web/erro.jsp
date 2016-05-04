<%-- 
    Document   : erro
    Created on : 03/05/2016, 19:29:54
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="TopMenu.jspf" %>
        <section class="container">
            <h1>ECommerce</h1>
            <h2>ERRO: ${erromsg}</h2>
        </section>
    </body>
</html>
