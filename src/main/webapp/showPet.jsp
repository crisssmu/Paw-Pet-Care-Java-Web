<%-- 
    Document   : ShowPet
    Created on : 18/10/2024
    Author     : Crism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar mascotas</title>
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
            input[type="submit"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                background-color: #28a745;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s;
            }
            input[type="submit"]:hover {
                background-color: #218838;
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
    <body>
        <h1>Mascotas</h1>
        <%
            String mensaje = (String) request.getAttribute("mensaje");
            if (mensaje != null) {
        %>
            <div class="message"><%= mensaje %></div>
        <%
            }
        %>
        
        <form action="PetControl" method="POST">
            <input type="submit" value="Listar">
            <input type="hidden" value="mostrar" id="contPet" name="contPet">
            
            <div class="a">
            <a href="./FormPet.jsp" target="_self">Registrar mascota</a>
            <a href="./Inicio.jsp" target="_self">Atras</a>
            </div>
        </form>
    </body>
</html>