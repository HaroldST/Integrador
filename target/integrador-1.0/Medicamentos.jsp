

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Drugs</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
    <body>
        <hr>
        <div class="container">
            <center><h5 style="color:#000"><i class="fa-solid fa-users"style="color:#FFF"></i> Tabla Productos</h5></center><hr>
            <div class="card" style="background: #FFC300" >        
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <form action="Controlador?men=medi" method="POST" enctype="multipart/form-data" > 
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input type="text" value="${producto.getNombres()}" name="txtnombre" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Foto</label>
                                    <input type="file" value="${producto.getFoto()}" name="txtfoto" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>precio</label>
                                    <input type="number" value="${producto.getPrecio()}"name="txtprecio" class="form-control" min="1" required>
                                </div>
                                <div class="form-group">
                                    <label>descripcion</label>
                                    <input type="text" value="${producto.getDescripcion()}"name="txtdescrip" class="form-control" required>
                                </div>
                                <br>
                                <div class="dropdown-divider"></div>
                                <div></div>
                                <div class="dropdown-item text-center">
                                    <input type="submit" name="accion" value="Agregar" class="btn btn-primary">    
                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-light" >
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <h5 class="text-center mt-3" style="color:#000">Producto</h5>
            <div class="card">
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">IDProducto</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Foto</th>
                                <th scope="col">Precio</th>
                                <th scope="col">Descripcion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="p" items="${productos}">
                                <tr>
                                    <td>${p.getId()}</td>
                                    <td>${p.getNombres()}</td>
                                    <td><img src="ControladorIMG?id=${p.getId()}" heigth="50" width="50"/></td>
                                    <td>${p.getPrecio()}</td>
                                    <td>${p.getDescripcion()}</td>
                                    <td> 

                                        <a class="btn btn-warning" href="Controlador?men=medi&accion=Editar&id=${p.getId()}">Editar</a>
                                        <a class="btn btn-danger"  href="Controlador?men=medi&accion=Delete&id=${p.getId()}">Borrar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>