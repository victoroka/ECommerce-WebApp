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
        <h1>About&nbsp;Us</h1>
         <div id="containerdiv">
        <section class="box left">
            <article>
                <figure>
                    <img src="imgs/lucasimg.jpg" alt="Imagem do DevLucas" class="foto"/>
                    <figcaption class="textofig">Lucas&nbsp;Portella</figcaption>
                </figure>
                <p class="pabout">Lucas Portella Santos tem 21 anos, gosta de rock alternativo e indie folk, tendo como artistas preferidos Lucy Rose, City and Colour e Muse.</p>
                <p class="pabout">Nas horas vagas toca guitarra, canta, joga jogos eletrônicos, como League of Legends, e assiste séries, como The Office, Homeland e The Americans. </p>
                <p class="pabout">Sempre gostou de tecnologia, desde criança quando se envolveu com video-games e computadores, e também sempre acompanhou assuntos relacionados a astronomia.</p>
            </article>
        </section>
             <section class="box right">
            <article>
                <figure>
                    <img src="imgs/victorimg.jpg" alt="Imagem do DevVictor" class="foto"/>
                    <figcaption class="textofig">Victor&nbsp;Oka</figcaption>
                </figure>
                <p class="pabout">Victor Hideo Oka tem 19 anos, gosta de rock classico e alternativo. Por este fato, um de seus hobbies é tocar guitarra.</p>
                <p class="pabout">Nas horas vagas também gosta de jogar jogos eletronicos no computador, como League of Legends e Life is Strange.</p>
                <p class="pabout">Sempre foi um entusiasta de tecnologia e gosta de ficar sempre atualizado em relação ao assunto.</p>
            </article>
        </section>
         </div>
        <%@include file="Footer.jspf" %>
    </body>
</html>
