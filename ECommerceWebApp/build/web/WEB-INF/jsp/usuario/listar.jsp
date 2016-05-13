<%-- 
    Document   : listar
    Created on : May 13, 2016, 9:55:47 AM
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
        <h1>Usuarios Cadastrados</h1>
        <table style="border: 1px solid black; background-color: cadetblue; color: black;">
            <tr style="border: 1px solid black; text-align: center;">
                <th>ID</th>
                <th>NOME</th>
                <th>EMAIL</th>
                <th>ENDERECO</th>
                <th>TELEFONE</th>
                <th>RG</th>
                <th>CPF</th>
                <th>OPERACOES</th>
            </tr>
            <c:forEach var="userinfo" items="${userinfos}">
                <tr style="border: 1px solid black; text-align: center;">
                    <td style="border: 1px solid black; text-align: center;"><c:out value="${userinfo.id_userinfo}"/></td>
                    <td style="border: 1px solid black; text-align: center;"><c:out value="${userinfo.nome}"/></td>
                    <td style="border: 1px solid black; text-align: center;"><c:out value="${userinfo.email}"/></td>
                    <td style="border: 1px solid black; text-align: center;"><c:out value="${userinfo.endereco}"/></td>
                    <td style="border: 1px solid black; text-align: center;"><c:out value="${userinfo.telefone}"/></td>
                    <td style="border: 1px solid black; text-align: center;"><c:out value="${userinfo.rg}"/></td>
                    <td style="border: 1px solid black; text-align: center;"><c:out value="${userinfo.cpf}"/></td>
                    <td style="border: 1px solid black; text-align: center;"><a href="${pageContext.request.contextPath}/usuario!remover.action?code=${userinfo.id_userinfo}" class="botaoListar"><c:out value="remover"/></a></td>
                </tr>
            </c:forEach>
        </table>
        <%@include file="../../../Footer.jspf"%>
    </body>
</html>
