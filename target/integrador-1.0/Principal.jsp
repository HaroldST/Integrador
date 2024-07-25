

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <link rel="shortcut icon" href="imagenes/logo.jpg">
        <title>
            Menu
        </title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <!-- Los iconos tipo Solid de Fontawesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <script src="https://use.fontawesome.com/releases/v6.1.1/js/all.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <link href="css/estilos_p.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-danger">      
            <div class="container-fluid">
                <a class="navbar-brand" href="Principal.jsp" style="margin: 0px 40px"  >
                    <img src="imagenes/logo.jpg" alt="100" width="70"  />
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">                    
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item" style="margin: 0px 20px" >
                            <a class="nav-link btn btn-outline-warning efecto_boton" href="Controlador?men=inicio" target="myFrame" ><i class="bi bi-house"></i> Inicio</a>
                        </li>
                        <li class="nav-item " style="margin: 0px 20px" >
                            <a class="nav-link btn btn-outline-warning efecto_boton" href="Controlador?men=registro&accion=Listar" target="myFrame"><i class="bi bi-building"></i> Registro</a>
                        </li>
                        <li class="nav-item " style="margin: 0px 20px" >
                            <a class="nav-link btn btn-outline-warning efecto_boton" href="Controlador?men=medi&accion=Listar" target="myFrame"><i class="bi bi-building"></i> Productos</a>
                        </li>
                        
                        <li class="nav-item " style="margin: 0px 20px" >
                            
                        </li>
                        <div style="margin: 0px 100px" class=" dropdown">
                            <button class="btn btn-outline-warning dropdown-toggle efecto_boton " data-bs-toggle="dropdown" type="button" id="dropdownMenuButton">
                                <i class="fa-solid fa-user-tie"></i> 
                                ${usuario.getNombre()}  ${usuario.getApe()}
                            </button>
                            <div class=" dropdown-menu  text-center  " >
                                <a class="dropdown-item" href="#">
                                    <img src="imagenes/usuario.png" alt="130" width="130"/>
                                </a>
                                <a class="dropdown-item ">${usuario.getNombre()}</a>
                                <a class="dropdown-item ">${usuario.getRol()}</a>
                                <a href="Controlador?men=registro&accion=Listar" target="myFrame" class="dropdown-item">Configuracion</a>
                                <div class="dropdown-divider"></div>
                                <form action="Validar" method="POST">
                                    <button name="accion" value="Salir" class="dropdown-item text-center">Cerrar Sesion</button>
                                </form>                        
                            </div>
                        </div>
                    </ul>
                </div>
        </nav>
        <!--Para un contenedor para cargar los demas modulos-->
        <div class="m-4" style="height: 800px;">
            <iframe name="myFrame" style="height: 100%; width: 100%;border: none"></iframe>
        </div>
        <!--De bootstrap-->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
    </body>
</html>
