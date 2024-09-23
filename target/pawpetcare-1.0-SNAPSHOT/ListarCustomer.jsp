<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entities.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <style>
            body {
                background-color: #e5e5f7;
                font-family: 'Roboto', sans-serif;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
            }
            table, th, td {
                border: 1px solid #ddd;
            }
            th, td {
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #3866f2;
                color: white;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h1>Lista de Clientes Registrados</h1>

        <%
            List<Customer> listaClientes = (List<Customer>) request.getAttribute("listaClientes");
            if (listaClientes != null && !listaClientes.isEmpty()) {
        %>
        <table>
            <tr>
                <th>#</th>
                <th>Documento</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Género</th>
                <th>Número</th>
                <th>Email</th>
                <th>Dirección</th>
            </tr>
            <%
                int count = 1;
                for (Customer cli : listaClientes) {
            %>
            <tr>
                <td><%= count++ %></td>
                <td><%= cli.getDocument() %></td>
                <td><%= cli.getName() %></td>
                <td><%= cli.getLastName() %></td>
                <td><%= cli.getGener() %></td>
                <td><%= cli.getNumber() %></td>
                <td><%= cli.getEmail() %></td>
                <td><%= cli.getAddres() %></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            } else {
        %>
        <p>No hay clientes registrados.</p>
        <%
            }
        %>
    </body>
</html>

