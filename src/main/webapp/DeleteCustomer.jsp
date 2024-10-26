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
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                color: #333;
                margin: 0;
                padding: 20px;
                font-size: 1.1em;
            }
            h1 {
                color: #ff4c4c;
                text-align: center;
            }
            form {
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }
            label {
                font-weight: bold;
                margin-bottom: 10px;
                display: block;
            }
            input[type="text"], input[type="submit"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                background-color: #ff4c4c;
                color: white;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s;
                font-size: 1.1em;
            }
            input[type="submit"]:hover {
                background-color: #e04343;
            }
            .mensaje {
                background-color: #ffcccc;
                color: #cc0000;
                padding: 10px;
                border-radius: 4px;
                text-align: center;
                margin-bottom: 15px;
            }
           a{
                display: block;
                margin: 10px 0;
                padding: 10px 20px;
                color: #fff;
                background-color: #3866f2;
                border-radius: 5px;
                text-decoration: none;
                font-size: 1.1em;
                transition: background-color 0.3s ease;
                text-align: center;
            }
            a:hover {
                background-color: #023e8a;
            }
        </style>
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
            <div class="a">
                <a href="./FormCustomer.jsp" target="_self">Registrar Cliente</a>
        <a href="./ShowCustomer.jsp" target="_self">Mostrar Cliente</a>
        <a href="./CustomerSearch.jsp" target="_self">Buscar cliente</a>
        <a href="./Inicio.jsp" target="_self">Atras</a>
            </div>
        </form>
        
        
    </body>
</html>
