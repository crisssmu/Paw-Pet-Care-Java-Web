<%-- 
    Document   : FormCustomer
    Created on : 23/09/2024, 8:15:39 a. m.
    Author     : Crism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registar Cliente</title>
    </head>
    <body>
       <style>
            body{
                background-color: #e5e5f7;
                background-image: radial-gradient(#c657d8 0.5px, transparent 0.5px), radial-gradient(#c657d8 0.5px, #e5e5f7 0.5px);
                background-size: 20px 20px;
                background-position: 0 0, 10px 10px;
                display: flex;
                min-height: 100vh;
            }
            .form{
                background-color: #fff;
                margin: auto;
                width: 90%;
                max-width: 450px;
                padding: 4.5em 3em;
                border-radius: 10px;
                box-shadow: 0 5px 10px -5px;
                text-align: center;
            }
            .form_title{
                margin-top: .1em;
                margin-bottom: .5em;
                
                font-family: 'Roboto',sans-serif;
            }
            .form_container{
                margin-top: 3em;
                display: grid;
                gap: 2.5em;
                font-family: 'Roboto',sans-serif;
                
            }
            .form_group{
                position: relative;
                max-width: 400px;
                
                --color: #5757577e;
            }
            .form_input{
                width: 100%;
                background: none;
                color: #706c6c;
                font-size: 1rem;
                padding: .4em .3em;
                border: none;
                outline: none;
                border-bottom: 1px solid var(--color);
                font-family: 'Roboto',sans-serif;
            }
            .form_input:focus + .form_label, 
            .form_input:not(:placeholder-shown) + .form_label{
                transform: translateY(-12px) scale(0.7);
                transform-origin: left top;
                color:#3866f2;
            }
            .form_label{
                color: var(--color);
                position: absolute;
                top: -20px;
                left: 5px;
                transform: translateY(10px);
                transition: transform 0.5s,color 0.3s;
            }
            .form_submit{
                background: #3866f2;
                color: #fff;
                font-family: 'Roboto',sans-serif;
                font-weight: 300;
                font-size: 1rem;
                padding: .8em 0;
                border: none;
                border-radius: .5em;
                max-width: 250px;
                margin-left: 100px;
                margin-right: 50px;
                cursor: pointer;
            }
            
            input::-webkit-outer-sping-button,
            input::-webkit-inner-spin-button{
                -webkit-appearance: none;
                margin: 0;
            }
            
            .form_select{
                width: 100%;
                background: none;
                color: #706c6c;
                font-size: 1rem;
                padding: .6em .3em;
                border: none;
                outline: none;
                border-bottom: 1px solid var(--color);
                font-family: 'Roboto',sans-serif;
            }
            
            .mensaje {
                background-color: #90e0ef;
                color: #023e8a;
                padding: 10px;
                border-radius: 5px;
                margin-top: 10px;
                font-family: 'Roboto', sans-serif;
                font-size: 0.9rem;
                text-align: center;
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
       
        <form class="form" action="CustomerControl" method="POST">
        <h2 class ="form_title"> Registrar Cliente</h2>
        
        <div class="form_container">
            <div class="form_group">
                <label for="document" class ="form_label">Documento</label>
                <input type="number" id="document" name="document" class="form_input" placeholder=" ">
                <span class="form_line"></span>
            </div>
            
            <div class="form_group">
                <label for="name" class ="form_label">Nombre</label>
                <input type="hidden" value="registrar" id="contCustomer" name="contCustomer">
                <input type="text" id="name" name="name" class="form_input" placeholder=" ">
                <span class="form_line"></span>
            </div>
            
            <div class="form_group">
                <label for="lastName" class ="form_label">Apellido</label>
                <input type="text" id="lastName" name="lastName" class="form_input" placeholder=" " required>
                <span class="form_line"></span>
            </div>
            
            <div class="form_group">
                <label for="cellPhone" class ="form_label">Numero</label>
                <input type="number" id="cellPhone"  name="cellPhone" class="form_input" placeholder=" " required>
                <span class="form_line"></span>
            </div>
            
            <div class="form_group">
                <label for="gener" class ="form_label">Genero</label>
                <select name ="gender" id="gender" class="form_select">
                    <option value="Femenino">Femenino</option>
                    <option value="Masculino">Masculino</option>
                </select>
            </div>
            
            <div class="form_group">
                <label for="email" class ="form_label">Email</label>
                <input type="email" id="email"name="email" class="form_input" placeholder=" ">
                <span class="form_line"></span>
            </div>
            <div class="form_group">
                <label for="address" class ="form_label">Direccion</label>
                <input type="text" id="address" name="address" class="form_input" placeholder=" ">
                <span class="form_line"></span>
            </div>
             <%
            String mensaje = (String) request.getAttribute("mensaje");
            if (mensaje != null) {
        %>
            <div class="mensaje"><%= mensaje %></div>
        <%
            }
        %>
            <input type="submit" class="form_submit" value="Registrar">
            
            <div class ="a"> <a href="./FormPet.jsp" target="_Self">Registrar Mascotas</a>
            <a href="./ShowCustomer.jsp" target="_self">Mostrar Cliente</a>
            <a href="./CustomerSearch.jsp" target="_self">Buscar cliente</a>
            <a href="./DeleteCustomer.jsp" target="_Self">Eliminar Cliente</a>
            
            <a href="./Inicio.jsp" target="_self">Atras</a></div>
            </form>
            
        </div>
            
           
            
        
        
        
        
        
    </body>
</html>
