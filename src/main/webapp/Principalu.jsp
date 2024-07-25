

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="imagenes/logo.jpg">
        <title>
            Menu principal
        </title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ADx0gKVuZ9c+UkOLF+5lbKN2GOy1hT0UqHTa43jnBPX9vAh7SNxy+A5DfVkUNhV" crossorigin="anonymous">
        <!-- Los iconos tipo Solid de Fontawesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <script src="https://use.fontawesome.com/releases/v6.1.1/js/all.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <link href="css/estilos_p.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/slider.css" type="text/css">
        <link rel="stylesheet" href="css/estilos.css" type="text/css">
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


            <div class="slider">
                <div class="slides">
                    <div class="slide"><img src="imagenes/slider1.jpg" alt="Slide 1"></div>
                    <div class="slide"><img src="imagenes/slider2.jpg" alt="Slide 2"></div>
                    <!-- Agregar más elementos slide según sea necesario -->
                </div>
                <button id="prevBtn" class="nav-btn"><i class="fas fa-chevron-left"></i></button>
                <button id="nextBtn" class="nav-btn"><i class="fas fa-chevron-right"></i></button>
            </div>



            <h2 class="titulo" >~ Conocenos ~</h2>

            <section class="locales">
                <div class="locales__lugares">
                    <a href="#">
                     ¡Bienvenidos a EasyFarma, tu destino confiable para soluciones de salud y bienestar!
                     En EasyFarma, nos enorgullece ser mucho más que una simple farmacia; somos tu socio
                     comprometido en el camino hacia una vida más saludable y plena. Nuestros valores 
                     fundamentales se reflejan en una misión clara, una visión inspiradora y un equipo
                     dedicado que trabaja incansablemente para satisfacer tus necesidades de salud.
                     Nuestro objetivo es "Posicionar EasyFarma como líder en innovación farmacéutica,
                     ofreciendo soluciones accesibles y de alta calidad para mejorar la salud y el
                     bienestar de nuestros clientes, mientras impulsamos el crecimiento sostenible y
                     la excelencia en el servicio
                    </a>
                  
                </div>
            </section>

            <h2 class="titulo">~ Nuestro Local ~</h2>

            <section class="locales">
                <div class="locales__lugares">
                    <h2>Easyfarma Chorrillos</h2>
                    <img src="imagenes/empresa.jpg" width="330" height="220"><br>
                    <h3>Av. San Martin 432 Chorrillos</h3>
                    <a href="#">Conoce más</a>
                </div>
                 <div class="locales__lugares">
                    <h2>Easyfarma Chorrillos</h2>
                    <img src="imagenes/empresa1.jpg" width="330" height="220"><br>
                  <h3>Av. San Martin 432 Chorrillos</h3>
                    <a href="#">Conoce más</a>
                </div>
                 <div class="locales__lugares">
                    <h2>Easyfarma Chorrillos</h2>
                    <img src="imagenes/empresa2.jpg" width="330" height="220"><br>
                  <h3>Av. San Martin 432 Chorrillos</h3>
                    <a href="#">Conoce más</a>
                </div>

            </section>

        </main>
        <footer id="pie" class="centrado">

            <div class="contenido-columnas">
                <div class="item-footer">
                    <p>Direccion</p>
                    <p>Av. San Martin 432 Chorrillos</p>
                    <p> 945 654 321</p>
                    <p>informaciones@easyfarma.com </p>
                </div>

                <div class="logos">
                    <p> Nuestras redes sociales</p>
                    <img src="imagenes/facebook.png"><br>
                    <img src="imagenes/youtube.png">
                </div>

                <div class="item-footer">
                    <a href="paginas/LibroReclamos.php">Libro de Reclamaciones</a>
                    <p>2024 ©</p>
                    <a href="index.php">Easyfarma.</a>
                    <p>All Rights Reserved</p>
                </div>	
            </div>

        </footer>                  

        <script src="js/slider.js"></script>                
        <!--De bootstrap-->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-oZS5knjPhq3dNbEbud/y5l+4qYWR9kl68+qZ2U+FEi/k378wP9/6+5jGD8iS8" crossorigin="anonymous"></script>
    </body>
</html>