<%-- 
    Document   : edit
    Created on : 27/09/2024, 7:43:28 a. m.
    Author     : Crism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
    </head>
    <body>
        <% Customer custo = (Customer) request.getSession().getAttribute(custoEdit);
            %>
        <h1>Editar cliente</h1>
        
        <label for="document" class ="form_label">Documento</label>
        <input type="number" id="document" name="document" class="form_input" value="<%custo.getDocument()%>">
            
            <label for="name" class ="form_label">Nombre</label>
            <input type="text" id="name" name="name" class="form_input" value="<%custo.getName()%>">
            
            <label for="lastName" class ="form_label">Apellido</label>
                <input type="text" id="lastName" name="lastName" class="form_input" value="<%custo.getLastName()%>">
                
                <label for="number" class ="form_label">Numero</label>
                <input type="number" id="number"  name="number" class="form_input" value="<%custo.getNumber()%>">
                
                <label for="gener" class ="form_label">Genero</label>
                <input type="text" id="gener"  name="gener" class="form_input" value="<%custo.getGener()%>">
                
                <label for="email" class ="form_label">Email</label>
                <input type="email" id="email"name="email" class="form_input" value="<%custo.getEmail()%>">
                
                <label for="address" class ="form_label">Direccion</label>
                <input type="text" id="address" name="address" class="form_input" value="<%custo.getAddress()%>">
    </body>
</html>
