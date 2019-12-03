<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Pacientes</title>
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
                $(document).ready(function(){
                    $("#exampleModal").modal("show");
                    }
                );
             </script>
        </c:if>
        <div class="main-content">
            <div class="title d-flex flex-md-row  justify-content-between align-items-center">
                <h5>
                    DATOS DE LOS PACIENTES
                </h5>
                <button  class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"><i class="fas fa-plus-circle" ></i> Nuevo Paciente</button>
            </div>
            <div class="main">
                <form action="${pageContext.servletContext.contextPath}/SPacientes" method="get">
                    
                    <div class="form-row">
                        
                        <div class="form-group col-md-1">
                            <label>Búsqueda:</label>
                            
                        </div>
                        <div class="form-group col-md-3">
                            <input type="text" class="form-control" placeholder="Digite nombre" name="txtBusqueda" id="txtBusqueda" value="${valor}" />
                            
                        </div>
                        <div class="form-group col-md-3">
                            <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i> Buscar</button>
                        </div>
                    </div>
                </form> 
            </div>
            <div class="main">
                <form action="${pageContext.servletContext.contextPath}/SPacientes?accion=insertar_modificar" method="POST">
                    <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Nuevo Paciente</h5>
                                    
                                    <a class="close"  href="SPacientes" onclick="javascript: return window.history.back()"><span aria-hidden="true">&times;</span></a>
                                    
                                </div>
                                <div class="modal-body">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="txtNom">Nombres</label>
                                                <input type="text" class="form-control" name="txtNom" id="txtNom" value="${paciente.nombres}" required>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="txtApe">Apellidos</label>
                                                <input type="text" class="form-control" name="txtApe" id="txtApe" value="${paciente.apellidos}" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="txtDir">Dirección</label>
                                            <input type="text" class="form-control" name="txtDir" id="txtDir" value="${paciente.direccion}" >
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="txtTel1">Telefono 1</label>
                                                <input type="text" class="form-control" name="txtTel" id="txtTel" value="${paciente.telefono}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="txtFecha">Fecha de nacimiento</label>
                                                <input type="date" name="txtFecha" id="txtFecha" class="form-control" value="${paciente.fechaNacimiento}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="txtEmail">Email</label>
                                            <input type="email" class="form-control" name="txtEmail" id="txtEmail" value="${paciente.email}" >
                                            <input type="hidden" id="expediente" name="expediente" value="${paciente.expediente}">
                                        </div>
                                        
                                </div>
                                <div class="modal-footer">
                                    <a class="btn btn-primary"  href="SPacientes" onclick="javascript: return window.history.back()"> <i class="fas fa-arrow-left"></i> Regresar</a>
                                    <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                
                <div class="tbPac">
                        <c:if test="${resultado!=null}">
                            <c:if test="${resultado==1}">
                                <p style="color:darkgreen"><strong>Operación realizada correctamente.</strong></p>
                            </c:if>
                            <c:if test="${resultado==0}">
                                <p style="color:darkred"><strong>La operación no se realizó.</strong></p>
                            </c:if>

                        </c:if>        
                        ${tabla}
                    <script>            
                        window.onload = function() {
                            document.getElementById("txtBusqueda").focus();};
                    </script> 
                    
                </div>
            </div>

        </div>
    </body>
</html>