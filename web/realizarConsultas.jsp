<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Consultas</title>
        <link rel="shortcut icon" href="img/Solo logo.ico">

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
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

        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/consultas.css" rel="stylesheet" type="text/css"/>
        <script src="js/consultas.js" type="text/javascript"></script>
        <style>#table01 td{ padding-top: 8px; cursor: pointer}
        input[type="checkbox"][readonly] {
  pointer-events: none;
}</style>
        
        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="main-content">
            <div class="title d-flex  justify-content-between align-items-center">
                <h5>
                    REGISTRO DE CONSULTAS
                </h5>
                <a class="btn btn-primary" href="SConsultas?accion=mostrar"><i class="fas fa-eye"></i> Mostrar Consultas</a>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="main col-md-4">
                        
                        <h5>Agregar Consultas</h5>
                        <hr>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#modalPac" data-whatever="@mdo"><i class="fas fa-check-circle"></i> Seleccionar Paciente</button><br>
                        <br>
                        <form action="${pageContext.servletContext.contextPath}/SConsultas?accion=insertar_modificar" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label>Paciente</label>
                                </div>
                                <div class="form-group col-md-3">
                                    <input type="text" class="form-control" name="txtIdPac" id="txtIdPac" value="${paciente.expediente}" readonly="readonly" required/>
                                </div>
                                <div class="form-group col-m-9">
                                    <input type="text" class="form-control" name="txtPac" id="txtPac" value="${paciente.nombres} ${paciente.apellidos}" readonly="readonly" required/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label><input type="checkbox" id="cbox1" value="1"  onclick="return false" <c:if test="${membresia==1}">checked</c:if>> Membresía</label>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="cbTipo">Tipo de Consulta</label>
                                    <select class="browser-default custom-select col-md-12" id="cbTipo" name="cbTipo">
                                        <option  value="Diagnostica">Diagnostica</option>
                                        <option value="Normal" selected>Normal</option>
                                    </select>
                                </div>
                            </div>
                            
                            <div class="form-row">
                                <div class="form-group">
                                    
                                    <label for="cbDoctor">Doctor</label>
                                    <select class="browser-default custom-select col-md-12" id="cbDoctor" name="cbDoctor">
                                        <c:forEach  var="doc" items="${empleados}">
                                            <option  <c:if test="${citas.idEmpleadoDoctor==doc.idEmpleado}">selected</c:if> value="${doc.idEmpleado}">${doc.nombres} ${doc.apellidos}</option>    
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            
                            <button type="submit" class="btn btn-primary"><i class="fas fa-plus-circle" ></i> Agregar Consulta</button><br>

                        </form>

                        <div class="modal fade" id="modalPac" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Pacientes</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        ${tabla}
                                        


                                    </div>
                                    <div class="modal-footer">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="main col-md-8">
                        <h5>Consultas</h5>
                        <hr>
                        <div id="accordion">
                            
                            <c:forEach  var="con" items="${consultas}">
                               
                                    
                                <div class="card">
                                    <div class="card-header" id="headingOne">
                                        <h5 class="mb-0">
                                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapse${con.idConsulta}" aria-expanded="true" aria-controls="collapse${con.idConsulta}">
                                                <c:forEach  var="emp" items="${empleados}">
                                                    <c:if test="${con.idEmpleadoDoctor==emp.idEmpleado}">Consulta Dr. ${emp.nombres} ${emp.apellidos}</c:if> 
                                                </c:forEach>
                                            </button>
                                        </h5>
                                    </div>

                                    <div id="collapse${con.idConsulta}" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                                        <div class="card-body">
                                            
                                            <div class="container-fluid">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        
                                                        <label>ID Consulta: </label>
                                                        <input type="text"  class="form-control txt" readonly="readonly" size="5" value="${con.idConsulta}">
                                                        
                                                    </div>
                                                    <div class="col-md-8">
                                                        
                                                        <label>Paciente: </label>
                                                            <c:forEach  var="pac" items="${pacientes}">
                                                                <c:if test="${con.expediente==pac.expediente}"><strong>${pac.nombres} ${pac.apellidos} </strong></c:if> 
                                                            </c:forEach>
                                                    </div>
                                                </div>
                                                        
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        
                                                        <label>Tipo de consulta: </label>
                                                        <strong>${con.tipoConsulta}</strong>
                                                        
                                                    </div>
                                                    <div class="col-md-4">
                                                        
                                                        <label>Costo: </label>
                                                        <strong>$ ${con.costo}</strong>
                                                    </div>
                                                    <div class="col-md-4">
                                                        
                                                        <label>Descuento: </label>
                                                        <strong>$ ${con.descuento}</strong>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        
                                                        <a href="SConsultas">Iniciar</a>
                                                        
                                                    </div>
                                                    <div class="col-md-4">
                                                        
                                                        <label>Total </label>
                                                        <strong>$ ${con.total}</strong>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input type="button" class="boton" value="Finalizar" onclick="enviar('${con.idConsulta}');">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>  

                            </c:forEach>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

