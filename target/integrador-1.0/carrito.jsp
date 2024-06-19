

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
        <link href="css/estilos_p.css" rel="stylesheet" type="text/css"/>

        <style>
            @media print{
                .parte01, btn{


                    display: none;
                }
            }
        </style>
        <title>Comprobante</title>
        <script>
            $(document).ready(function () {
                $("tr #btnDelete").click(function () {
                    var idp = $(this).parent().find("#idp").val();
                    swal({
                        title: "Estas seguro?",
                        text: "Desea Eliminar este producto del Carrito de Compras",
                        icon: "warning",
                        buttons: true,
                        dangerMode: true,
                    }).then((willDelete) => {
                        if (willDelete) {
                            Eliminar(idp);
                            swal("Deseas Eliminar el Producto", {
                                icon: "success",
                            }).then((willDelete) => {
                                if (willDelete) {

                                    parent.location.href = "ControladorU?accion=Carrito";
                                }
                            });
                        } else {
                            swal("No se hizo cambios");
                        }
                    });

                });
                function Eliminar(idp) {
                    var url = "ControladorU?accion=Delete";
                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: "idp=" + idp,
                        success: function (data, textStatus, jqXHR) {
                            alert("Registro eliminado!");
                        }
                    });
                }

                $("tr #Cantidad").click(function () {
                    var idp = $(this).parent().find("#idpro").val();
                    var cantidad = $(this).parent().find("#Cantidad").val();
                    var url = "ControladorU?accion=ActualizarCantidad";
                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: "idp=" + idp + "&Cantidad=" + cantidad,
                        success: function (data, textStatus, jqXHR) {
                            location.href = "ControladorU?accion=Carrito";
                        }
                    });
                });
            });
        </script>

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
        <div class="container mt-4">
            <h3>Carrito</h3>
            <br>
            <div class="row">
                <div class="col-sm-8">
                    <table border="1" class="table table-hover">
                        <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>NOMBRES</th>
                                <th>DESCRIPCION</th>
                                <th>PRECIO</th>
                                <th>CANT</th>
                                <th>SUBTOTAL</th>
                                <th>ACCION</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                                <tr>
                                    <td>${car.getItem()}</td>
                                    <td>${car.getNombres()}</td>
                                    <td>${car.getDescripcion()} 
                            <center><img src="ControladorIMG?id=${car.getIdProducto()}" width="150" height="150"></center>
                            </td>
                            <td>${car.getPreciocompra()}</td>
                            <td>
                                <input type="hidden" id="idpro" value="${car.getIdProducto()}">
                                <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control text-center" min="1">
                            </td>
                            <td>${car.getSubtotal()}</td>
                            <td>

                                <input type="hidden" id="idp" value="${car.getIdProducto()}">
                                <i class="fa-solid fa-trash" id="btnDelete"  >eliminar</i>
                            </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>

                </div>        
                <div class="col-sm-4 parte01">
                    <div class="card">
                        <div class="card-header">
                            <h3>Generar Compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <input type="text" value="${totalPagar}"readonly="" class="form-control">

                            <label>Total a Pagar:</label>
                            <input type="text"value="${totalPagar}" readonly="" class="form-control">
                        </div>

                        <div class="card card-footer">

                            <center><a href="#" onclick="print()" class="btn btn-info btn-block">Imprimir Boleta</a></center> 
                            <center><a href="ControladorU?accion=GenerarCompra"  class="btn btn-danger btn-block">Generar Compra</a></center> 
                        </div>
                    </div>
                </div>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
            <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
            <script src="js/funciones.js" type="text/javascript"></script>



    </body>

</html>
