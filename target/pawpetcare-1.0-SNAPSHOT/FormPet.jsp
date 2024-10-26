<%-- 
    Document   : FormPet
    Created on : 18/10/2024
    Author     : Crism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Mascota</title>
    </head>
    <body>
       <style>
            body {
                background-color: #e5e5f7;
                background-image: radial-gradient(#c657d8 0.5px, transparent 0.5px), radial-gradient(#c657d8 0.5px, #e5e5f7 0.5px);
                background-size: 20px 20px;
                background-position: 0 0, 10px 10px;
                display: flex;
                min-height: 100vh;
            }
            .form {
                background-color: #fff;
                margin: auto;
                width: 90%;
                max-width: 450px;
                padding: 4.5em 3em;
                border-radius: 10px;
                box-shadow: 0 5px 10px -5px;
                text-align: center;
            }
            .form_title {
                margin-top: .1em;
                margin-bottom: .5em;
                font-family: 'Roboto', sans-serif;
            }
            .form_container {
                margin-top: 3em;
                display: grid;
                gap: 2.5em;
                font-family: 'Roboto', sans-serif;
            }
            .form_group {
                position: relative;
                max-width: 400px;
                --color: #5757577e;
            }
            .form_input {
                width: 100%;
                background: none;
                color: #706c6c;
                font-size: 1rem;
                padding: .4em .3em;
                border: none;
                outline: none;
                border-bottom: 1px solid var(--color);
                font-family: 'Roboto', sans-serif;
            }
            .form_input:focus + .form_label, 
            .form_input:not(:placeholder-shown) + .form_label {
                transform: translateY(-12px) scale(0.7);
                transform-origin: left top;
                color:#3866f2;
            }
            .form_label {
                color: var(--color);
                position: absolute;
                top: -20px;
                left: 5px;
                transform: translateY(10px);
                transition: transform 0.5s, color 0.3s;
            }
            .form_submit {
                background: #3866f2;
                color: #fff;
                font-family: 'Roboto', sans-serif;
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
            .form_select {
                width: 100%;
                background: none;
                color: #706c6c;
                font-size: 1rem;
                padding: .6em .3em;
                border: none;
                outline: none;
                border-bottom: 1px solid var(--color);
                font-family: 'Roboto', sans-serif;
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
       
        <form class="form" action="PetControl" method="POST">
            <h2 class="form_title">Registrar Mascota</h2>
            
            <div class="form_container">
                <div class="form_group">
                    <label for="name" class="form_label">Nombre de la Mascota</label>
                    <input type="hidden" value="registrar" id="contPet" name="contPet">
                    <input type="text" id="name" name="name" class="form_input" placeholder=" " required>
                    <span class="form_line"></span>
                </div>
                
                <div class="form_group">
                    <label for="dateBirth" class="form_label">Fecha de Nacimiento</label>
                    <input type="text" id="dateBirth" name="dateBirth" class="form_input" placeholder=" " required>
                    <span class="form_line"></span>
                </div>

                <div class="form_group">
                    <label for="gender" class="form_label">Género</label>
                    <select name="gender" id="gender" class="form_select" required>
                        <option value="Macho">Macho</option>
                        <option value="Hembra">Hembra</option>
                    </select>
                </div>
                
              
                <div class="form_group">
                    <label for="specie" class="form_label">Raza</label>
                    <select name ="specie" id="specie" class="form_select" requiered>
                        <option value="CANINO">canino</option>
                        <option value="FELINO">felino</option>
                        <option value="AVE">ave</option>
                        <option value="ROEDOR">roedor</option>
                        <option value="REPTIL">reptil</option>
                        <option value="PEZ">pez</option>
                        
                    </select>
                    
                   
                </div>

                <div class="form_group">
                    <label for="customer" class="form_label">ID del Propietario</label>
                    <input type="number" id="idOwner" name="idOwner" class="form_input" placeholder=" " required>
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
                <div class="a">
                <a href="./showPet.jsp" target="_self">Mostrar Mascota</a>
                 <a href="./Inicio.jsp" target="_self">Atras</a>
                 </div>
            </div>
                
        </form>
        
        
    </body>
</html>
