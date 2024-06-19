
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="navbar-brand" href="$" style="margin: 0px 40px">
                    <img src="imagenes/logo.jpg" alt="100" width="70" />
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">                    
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item" style="margin: 0px 20px">
                            <a class="nav-link btn btn-outline-warning efecto_boton" href="Principalu.jsp"><i class="bi bi-house"></i> Inicio</a>
                        </li>
                        <li class="nav-item " style="margin: 0px 20px">
                            <a class="nav-link btn btn-outline-warning efecto_boton" href="ControladorU?accion=stock"><i class="bi bi-building"></i> Productos</a>
                        </li>

                        <li class="nav-item" style="margin: 0px 20px">
                            <a class="nav-link" href="ControladorU?accion=Carrito"><i class="fas fa-cart-plus"></i><label style="color: black">${contador}</label>Carrito</a>
                        </li>
                    </ul>
                    <!-- El div se mueve fuera del ul -->
                    <div style="margin: 0px 100px" class="nav-link btn btn-outline-primary efecto_boton">
                        <a class="btn btn-outline-secondary efecto_boton" type="button" href="index.jsp" style="color: #fff">
                            <i class="fa-solid fa-user-tie"></i> 
                            <h6>SALIR</h6>
                        </a>                    
                    </div>
                </div>
            </div>
        </nav>
        <main>                  
            <div class="container mt-4">


                <div class="row">
                    <c:forEach var="p" items="${productos}">
                        <div class="col-sm-4">
                            <div class="card">
                                <div class="card-body text-center">
                                    <label><center>${p.getNombres()}</center></label>
                                </div>
                                <div class="card-body">
                                    <center><img src="ControladorIMG?id=${p.getId()}" width="200" height="180"></center>

                                </div>
                                <label><center>S/.${p.getPrecio()}</center></label>
                                <div class="card-footer text-center">
                                    <label>${p.getDescripcion()}</label>
                                    <div>
                                        <a href="ControladorU?accion=AgregarCarrito&id=${p.getId()}" class="btn btn-outline-info">Agregar</a>
                                        <a href="ControladorU?accion=Comprar&id=${p.getId()}" class="btn btn-danger">Comprar</a>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </c:forEach>

                </div>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
    </body>
</main>   
</html>
