<%-- 
    Document   : ShowCustomer
    Created on : 26/09/2024, 9:57:10 a. m.
    Author     : Crism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar cliente</title>
    </head>
    <body>
        <h1>Clientes</h1>
        <%
            String mensaje = (String) request.getAttribute("mensaje");
            if (mensaje != null) {
        %>
            <div class="message"><%= mensaje %></div>
        <%
            }
        %>
        
        <form action="CustomerControl" method="POST">
            <input type="submit" value="listar">
            <input type="hidden" value="mostrar" id="contCustomer" name="contCustomer">
            <a href="./FormCustomer.jsp" target="_self">Registrar cliente</a>
            <a href="./DeleteCustomer.jsp" target="_Self">Eliminar Cliente</a>
        </form>
    </body>
</html>
