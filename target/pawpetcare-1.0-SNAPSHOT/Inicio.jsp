<%-- 
    Document   : Inicio
    Created on : 18/10/2024, 12:20:35 a. m.
    Author     : Crism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paw Pet Care</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: 'Roboto', sans-serif;
                background-color: #f7f7f7;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f4f4f9;
            }
            .container {
                background-color: #fff;
                border-radius: 12px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                width: 80%;
                max-width: 500px;
                padding: 20px;
                text-align: center;
            }
            h1 {
                color: #3866f2;
                font-size: 2.5em;
                margin-bottom: 0.5em;
            }
            h2 {
                color: #023e8a;
                font-size: 1.5em;
                margin-top: 1.5em;
                margin-bottom: 1em;
                border-bottom: 2px solid #3866f2;
                padding-bottom: 10px;
            }
            a {
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
        <div class="container">
            <h1>Paw Pet Care</h1>

            <h2>Cliente</h2>
            <a href="./FormCustomer.jsp" target="_self">Registrar Cliente</a>
            <a href="./ShowCustomer.jsp" target="_self">Mostrar Cliente</a>
            <a href="./CustomerSearch.jsp" target="_self">Buscar cliente</a>
            <a href="./DeleteCustomer.jsp" target="_self">Eliminar Cliente</a>

            <h2>Mascota</h2>
            <a href="./FormPet.jsp" target="_self">Registrar Mascota</a>
            <a href="./showPet.jsp" target="_self">Mostrar Mascota</a>
            
        
        </div>
    </body>
</html>
