
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap demo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>
  
      <body>
        <hr>
        <div class="container">
            <center><h5 style="color:#000"><i class="fa-solid fa-users"style="color:#FFF" ></i> Tabla de Registros</h5></center><hr>
            <div class="card" style="background: #FFC300" >
                 
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <form action="Controlador?men=registro&accion=${empty registro.id ? 'Agregar' : 'Actualizar'}" method="POST">
                                <div class="form-group">
                                    <label>Usuario</label>
                                    <input type="text" value="${registro.getUser()}" name="txtuser" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input type="text" value="${registro.getNombre()}"name="txtnom" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Apellido</label>
                                    <input type="text" value="${registro.getApe()}"name="txtape" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Contraseña</label>
                                    <input type="password" value="${registro.getContra()}"name="txtcontra" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="text" value="${registro.getEmail()}" name="txtema" class="form-control" required>
                                </div><br>
                                <div class="form-group" style="margin-bottom: 35px;">
                                    <label>Rol de cargo:</label>
                                    <select name="opcion" required class="btn btn-primary" style="margin-left: 20px;">
                                        <option value="Administrador" <c:if test="${registro.rol == 'Administrador'}">selected</c:if>>Administrador</option>
                                        <option value="Moderador" <c:if test="${registro.rol == 'Moderador'}">selected</c:if>>Moderador</option>
                                        </select>
                                    </div>                        
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
                <h5 class="text-center mt-3" style="color:#000">Registro</h5>
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Id_Registro</th>
                                    <th scope="col">Usuario</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellido</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Rol</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="em" items="${registros}">
                                <tr>
                                    <td>${em.getId()}</td>
                                    <td>${em.getUser()}</td>
                                    <td>${em.getNombre()}</td>
                                    <td>${em.getApe()}</td>
                                    <td>${em.getEmail()}</td>
                                    <td>${em.getRol()}</td>
                                    <td> 
                                        <a class="btn btn-warning" href="Controlador?men=registro&accion=Editar&id=${em.getId()}">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?men=registro&accion=Delete&id=${em.getId()}">Delete</a>
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
