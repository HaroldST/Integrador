

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo_login.css" rel="stylesheet" type="text/css"/>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=DynaPuff:wght@500&family=Lobster&display=swap" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>

        <div class="contenido">
            <form action="Validar" method="POST">
                <div><h1 class="text-center">Bienvenido Usuario</h1> 
                </div>
                <h1 class="title">Iniciar Sesion</h1>
                <label>
                    <i class="fa-solid fa-user"></i>
                    <input placeholder="username" type="text" name="textuser" id="username" required>
                </label>
                <label>
                    <i class="fa-solid fa-lock"></i>
                    <input placeholder="password" type="password" name="textpass" id="password" required>
                </label>
                <button class="buton" name="accion" value="Ingresar" id="button" type="submit" href="Controlador?men=Registro">Ingresar</button><hr>
                <a class="buton" name="accion" value="Ingresar" id="button" type="submit" href="index.jsp">Elegir tipo de usuario</a>
            </form>            
        </div>
    </body>
</html>
