

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo_login.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=DynaPuff:wght@500&family=Lobster&display=swap" rel="stylesheet">
        <title>Login</title>
    </head>


    <body>
        <div class="contenido"> 
        <h1 style="color: #fff; margin: 30px;">TU SALUD ES NUESTRA PRIORIDAD, SIEMPRE LISTOS PARA CUIDARTE.</h1>
        <h1 style="color: #fff; font-size: 30px">Escoge el tipo de usuario que eres</h1>
        <form style="margin: 30px;" class="read-more" action="login.jsp" method="post">
            <input class="read-more" type="submit" value="Administrador">
        </form>
        <form class="read-more" action="Principalu.jsp" method="post">
            <input class="read-more" type="submit" value="Usuario">
        </form>
        </div>
    </body>

</html>