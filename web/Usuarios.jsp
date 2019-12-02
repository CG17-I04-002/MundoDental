<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Usuarios</title>
        <link rel="shortcut icon" href="img/Solo logo.ico">

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>

        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/68ab40f8cf.js" type="text/javascript"></script>
        <link href="css/pacientes.css" rel="stylesheet" type="text/css"/>
        <!-- Tablas-->
        <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/select.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
        <script src="js/dataTables.select.min.js" type="text/javascript"></script>

        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
        <script src="js/dataTables.responsive.min.js" type="text/javascript"></script>
        <script src="js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
        <script src="js/responsive.bootstrap4.min.js" type="text/javascript"></script>
        <!-- Agregar Ventana modal-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

        <script src="js/default.js" type="text/javascript"></script>

        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

        <%@include file="menu.jsp" %>
        <c:if test="${modi!=null}">
            <script>
                $(document).ready(function () {
                    $("#exampleModal").modal("show");
                }
                );
            </script>
        </c:if>
        <div class="main-content">
            <div class="title d-flex  justify-content-between align-items-center">
                <h5>
                    DATOS DE LOS USUARIOS
                </h5>
                <button  class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"><i class="fas fa-plus-circle" ></i> Nuevo Usuario</button>
            </div>
            <div class="main">
                <form action="${pageContext.servletContext.contextPath}/SConfiguracion?accion=insertar_modificar_user" method="POST">
                    <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Nuevo Usuario</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="txtUser">Usuario</label>
                                            <input type="text" class="form-control" name="txtUser" id="txtUser" value="${usuario.usuario}">
                                            <input type="hidden" class="form-control" name="txtUserh" id="txtUserh" value="${usuario.usuario}">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="txtContrasena">Contraseña</label>
                                            <input type="password" class="form-control" name="txtContrasena" id="txtContrasena" >
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="txtNom">Nombres</label>
                                            <input type="text" class="form-control" name="txtNom" id="txtNom" value="${empleado.nombres}" >
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="txtApe">Apellidos</label>
                                            <input type="text" class="form-control" name="txtApe" id="txtApe" value="${empleado.apellidos}">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        
                                        <div class="form-group col-md-6">
                                            
                                            <label for="cbEstado">Estado</label>
                                            <select class="browser-default custom-select" id="cbEstado" name="cbEstado">
                                                <option value="Activo">Activo</option>    
                                                <option value="Inactivo">Inactivo</option> 
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            
                                            <label for="txtTel">Telefono</label>
                                            <input type="text" class="form-control" name="txtTel" id="txtTel" value="${empleado.telefono}">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            
                                            <label for="cbEstado">Rol</label>
                                           <select class="browser-default custom-select" id="txtIdRol" name="txtIdRol" >
                                                <c:forEach var="item" items="${ro}">
                                                    <option value="${item.idRol}">${item.rol}</option>
                                                </c:forEach> 
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            
                                            <label for="cbEstado">Local</label>
                                           <select class="browser-default custom-select" id="cbLocal" name="cbLocal" >
                                                <c:forEach var="loc" items="${local}">
                                                    <option value="${loc.idLocal}">${loc.local}</option>
                                                </c:forEach> 
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                     <a class="btn btn-primary"  href="SPacientes"> <i class="fas fa-arrow-left"></i> Regresar</a>
                                    <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <div class="tbPac">
                    <div class="busqueda" style="width: 50%; text-align: right">
                        <form action="${pageContext.servletContext.contextPath}/SConfiguracion?accion=12" method="get">
                            <input type="txtBusquedaUsuario" name="txtBusquedaUsuario" id="txtBusquedaProducto" value="${valor}" />
                            <input type="submit" value="Buscar"/>
                        </form>
                    </div>                    
                    ${tabla}
                    <script>
                        window.onload = function () {
                            document.getElementById("txtBusquedaUsuario").focus();
                        };
                    </script> 

                </div>
            </div>

        </div>
    </body>
</html>