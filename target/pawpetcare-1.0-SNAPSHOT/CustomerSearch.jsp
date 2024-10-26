<%-- 
    Document   : CustomerSearch
    Created on : 21/10/2024, 7:22:07 a. m.
    Author     : Crism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar cliente</title>
    </head>
    <body>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                color: #333;
                margin: 0;
                padding: 20px;
            }
            h1 {
                color: #007bff;
                text-align: center;
            }
            form {
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                text-align: center;
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
                background-color: #3866f2;
                color: white;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s;
                font-size: 1.1em;
            }
            input[type="submit"]:hover {
                background-color: #023e8a;
            }
            .message {
                background-color: #d4edda;
                color: #155724;
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
            }
            a:hover {
                background-color: #023e8a;
            }
        </style>
    </head>
    
        <h1>Clientes</h1>
        <%
            String mensaje = (String) request.getAttribute("mensaje");
            if (mensaje != null) {
        %>
            <div class="message"><%= mensaje %></div>
        <%
            }
        %>
        
        <form action="CustomerControl" method="GET">
            <input type="text" id="document" name="document" placeholder="Ingrese el documento">
            <input type="submit" value="Buscar">
            <input type="hidden" value="search" id="contCustomer" name="contCustomer">
            
            <div class="a">
            <a href="./FormCustomer.jsp" target="_self">Registrar cliente</a>
            <a href="./ShowCustomer.jsp" target="_self">Mostrar Cliente</a>
            <a href="./DeleteCustomer.jsp" target="_Self">Eliminar Cliente</a>
            <a href="./Inicio.jsp" target="_self">Atras</a>
            </div>
        </form>
    </body>
</html>
