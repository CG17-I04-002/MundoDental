
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Permisos</title>
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
                    DATOS DE LOS PERMISOS
                </h5>
            </div>
            <div class="main">
                <form action="${pageContext.servletContext.contextPath}/SConfiguracion?accion=insertar_permiso" method="POST">
                    <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Editar Permisos</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="container-fluid">

                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="txtIdRol">ID Rol</label>
                                                <input type="text" class="form-control" readonly="true" name="txtIdRol" id="txtIdRol" value="${rol.idRol}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="txtRol">Rol</label>
                                                <input type="text" class="form-control" readonly="true" name="txtRol" id="txtRol" value="${rol.rol}">
                                            </div>
                                        </div>

                                        <div class="form-row">

                                                <c:forEach  var="m" items="${menu}">
                                                    
                                                    <div class="form-group col-md-4">
                                                        <label><input type="checkbox" 
                                                               <c:forEach  var="per" items="${permiso}">       
                                                                      <c:if test="${m.idmenu==per.idmenu}">checked</c:if>
                                                                
                                                                </c:forEach>    
                                                                id="cb${m.idmenu}" name="cb${m.idmenu}" value="${m.idmenu}"> ${m.menu}</label> 
                                                    </div>
                                            </c:forEach> 
                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <a class="btn btn-primary"  href="SConfiguracion?accion=14" onclick="javascript: return window.history.back()"> <i class="fas fa-arrow-left"></i> Regresar</a>
                                    <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <div class="tbPac">
                    <div class="busqueda" style="width: 50%; text-align: right">
                        <form action="${pageContext.servletContext.contextPath}/SConfiguracion?accion=13" method="get">
                            <input type="txtBusquedaPermiso" name="txtBusquedaPermiso" id="txtBusquedaPermiso" value="${valor}" />
                            <input type="submit" value="Buscar"/>
                        </form>
                    </div>                    
                    ${tabla}
                    <script>
                        window.onload = function () {
                            document.getElementById("txtBusquedaPermiso").focus();
                        };
                    </script> 

                </div>
            </div>

        </div>


    </body>
</html>