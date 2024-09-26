<%-- 
    Document   : DeleteCustomer
    Created on : 26/09/2024, 11:07:03 a. m.
    Author     : Crism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar cliente</title>
    </head>
    <body>
        <h1>Eliminar cliente</h1>
        <form action="CustomerControl" method="POST">

            <label for="document">Documento: </label>
            <input type="hidden" value="eliminar" id="contCustomer" name="contCustomer">
            <input type="text" id="document" name="document" placeholder="Ingrese el documento">


            <%
         String mensaje = (String) request.getAttribute("mensaje");
         if (mensaje != null) {
            %>
            <div class="mensaje"><%= mensaje %></div>
            <%
                }
            %>

            <input type="submit" class="form_submit" value="Eliminar">
        </form>
        <a href="./FormCustomer.jsp" target="_self">Registrar Cliente</a>
        <a href="./ShowCustomer.jsp" target="_self">Mostrar Cliente</a>
    </body>
</html>
