<%-- 
    Document   : About
    Created on : May 24, 2016, 9:18:01 AM
    Author     : VictorOka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About&nbsp;Us</title>
    </head>
    <body>
        <%@include file="TopMenu.jspf" %>
        <section class="container">
            <h1>About&nbsp;Us</h1>
            <article class="lucas">
                <figure>
                    <img src="imgs/lucasimg.jpg" width="100px" height="100px" alt="Imagem do DevLucas"/>
                    <figcaption>Lucas&nbsp;Portella</figcaption>
                </figure>
                <p>Luquinas é menino que utiliza das drogas mais pesadas, AKA League of Legends; Menes; Twitter e Carreta Furacão.</p>
            </article>
            <article class="victor">
                <figure>
                    <img src="imgs/victorimg.jpg" width="100px" height="100px" alt="Imagem do DevVictor"/>
                    <figcaption>Victor&nbsp;Oka</figcaption>
                </figure>
                <p>Também conhecido como best jungle do bronze 3 do League of Legends.</p>
            </article>
        </section>
        <%@include file="Footer.jspf" %>
    </body>
</html>
