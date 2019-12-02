
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Citas</title>
        <link rel="shortcut icon" href="img/Solo logo.ico">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>

        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/68ab40f8cf.js" type="text/javascript"></script>
        <link href="css/pacientes.css" rel="stylesheet" type="text/css"/>
        <script src="js/popper.min.js" type="text/javascript"></script>
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
        <style>#table01 td{ padding-top: 8px; cursor: pointer}</style>
        
        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
        
        <link href="css/consultas.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        
        <%@include file="menu.jsp" %>
        
        <div class="main-content">
            <div class="title d-flex  justify-content-between align-items-center">
                <h5>
                    DATOS DE LAS CITAS
                </h5>
                
            </div>
            <div class="main">
                <form action="${pageContext.servletContext.contextPath}/SCitas?accion=insertar_modificar" method="POST">
                    
                    <div class="form-row">
                        
                        <div class="form-group col-md-1">
                            <p>ID Cita</p>
                            
                        </div>
                        <div class="form-group col-md-1">
                            <input type="text" class="form-control" name="txtIdCita" id="txtIdCita"  readonly="readonly" value="${citas.idCita}" required/>
                            
                        </div>
                        <div class="form-group col-md-1">
                            <p>Paciente:</p>
                            
                        </div>
                        <div class="form-group col-md-1">
                            <input type="text" class="form-control" name="txtId" id="txtId" value="${paciente.expediente}" readonly="readonly" required/>
                            
                        </div>
                            
                        <div class="form-group col-md-3">
                            <input type="text" class="form-control" name="txtId" id="txtPac" value="${paciente.nombres} ${paciente.apellidos}" readonly="readonly" required/>
                            
                        </div>
                        <div class="form-group col-md-1">
                            <input type="button" value="..." class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">
                        </div>
                        <div class="form-group col-md-1">
                            <p>Doctor:</p>
                            
                        </div>
                        
                        <div class="form-group col-md-3">
                            <select class="browser-default custom-select" id="cbDoctor" name="cbDoctor">
                                <c:forEach  var="emp" items="${empleados}">
                                    <option  <c:if test="${citas.idEmpleadoDoctor==emp.idEmpleado}">selected</c:if> value="${emp.idEmpleado}">${emp.nombres} ${emp.apellidos}</option>    
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-1">
                            Fecha:
                        </div>
                        <div class="form-group col-md-2">
                            <input type="date" name="txtFecha" id="txtFecha" class="form-control" required value="${citas.fecha}" >
                        </div>
                        <div class="form-group col-md-1">
                            Clinica:
                        </div>
                        <div class="form-group col-md-2">
                            <select class="browser-default custom-select" id="cblocal" name="cblocal">
                                <c:forEach var="local" items="${locales}">
                                    <option <c:if test="${citas.idLocal==local.idLocal}">selected</c:if> value="${local.idLocal}">${local.local}</option>    
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-1">
                            Estado:
                        </div>
                        <div class="form-group col-md-2">
                            <select class="browser-default custom-select" id="cbEstado" name="cbEstado">
                                <option value="Pendiente">Pendiente</option>    
                                <option value="Cancelada">Cancelada</option>
                                <option value="Realizada">Realizada</option>  
                            </select>
                        </div>
                        
                        <div class="form-group col-md-3">
                            <input type="submit" class="btn btn-primary" value="Agregar" >
                        </div>
                             
                    </div>
                </form> 
            </div>
            <div class="main">
                <form action="${pageContext.servletContext.contextPath}/SCitas" method="get">
                    
                    <div class="form-row">
                        
                        <div class="form-group col-md-1">
                            <label>Búsqueda:</label>
                            
                        </div>
                        <div class="form-group col-md-3">
                            <input type="text" class="form-control" name="txtBusqueda" id="txtBusqueda" value="${valor}" />
                            
                        </div>
                        <div class="form-group col-md-3">
                            <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i> Buscar</button>
                        </div>
                    </div>
                </form> 
            </div>
            <div class="main">
                <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Pacientes</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div id="tablaP">
                                    
                                ${tabla}
                                    <script>
                                        //funcion javascript que se ejecuta al hacer click en una fila//recibe un elemento de tipo fila como parametro: row
                                        function _Seleccionar_(row) {
                                        ////recupera el idavion de la fila, en la celda 0
                                            var expe = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
                                            var nom = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                            var ape = row.cells[2].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                            document.getElementById("txtId").value = expe;
                                            document.getElementById("txtPac").value = nom+" "+ape;
                                            $(document).ready(function(){
                                                $("#exampleModal").modal("toggle");
                                                }
                                            );
                                            return false;
                                        }
                                    </script>

                                </div>

                            </div>
                            <div class="modal-footer">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="tbPac">
                    <c:if test="${resultado!=null}">
                        <c:if test="${resultado==1}">
                            <p style="color:darkgreen"><strong>Operación realizada correctamente.</strong></p>
                        </c:if>
                        <c:if test="${resultado==0}">
                            <p style="color:darkred"><strong>La operación no se realizó.</strong></p>
                        </c:if>

                    </c:if>     
                    ${tablaCitas}
                    
                </div>
            </div>

        </div>
    </body>
</html>