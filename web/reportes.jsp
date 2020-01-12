<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="img/Solo logo.ico">
        <title>Reportes</title>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/68ab40f8cf.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/index.css" rel="stylesheet" type="text/css"/> 
        <script src="js/reportes.js" type="text/javascript"></script>
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
        <c:if test="${modi2!=null}">
            <script>
                $(document).ready(function () {
                    $("#modalConsultas").modal("show");
                }
                );
            </script>
        </c:if>
        <c:if test="${modi3!=null}">
            <script>
                $(document).ready(function () {
                    $("#modalHistorial").modal("show");
                }
                );
            </script>
        </c:if>
        <c:if test="${modi4!=null}">
            <script>
                $(document).ready(function () {
                    $("#modalProd").modal("show");
                }
                );
            </script>
        </c:if>
        <c:if test="${modi5!=null}">
            <script>
                $(document).ready(function () {
                    $("#modalPaci").modal("show");
                }
                );
            </script>
        </c:if>
        <div class="main-content ">
            <div class="title">
                <h5>
                    REPORTES
                </h5>
            </div>
            <div class="main">
                <div class="card-columns">

                    <a href="SReportes?accion=totalConsultas" class="opciones">
                        <div class="card col-md-12">
                            <div class="card-body">
                                <div class="row">
                                    <div class="d-flex justify-content-center align-items-center  col-md-4 col-xs-12">
                                        <i class="iconIndex fas fa-user-md"></i>
                                    </div>
                                    <div class="d-flex flex-column justify-content-center align-items-center  col-md-8 col-xs-12">
                                        
                                        <p class="txt">Total Consultas</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a href="SReportes?accion=existencias" class="opciones">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="d-flex justify-content-center align-items-center  col-md-4 col-xs-12">
                                        <i class="iconIndex fas fa-notes-medical"></i>
                                    </div>
                                    <div class="d-flex flex-column justify-content-center align-items-center  col-md-8 col-xs-12">
                                        
                                        <p class="txt">Existencias Productos</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a  href="SReportes?accion=totalCitas"  class="opciones">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class=" d-flex justify-content-center align-items-center  col-md-4 col-xs-12">
                                        <i class="iconIndex fas fa-stethoscope"></i> 
                                    </div>
                                    <div class="d-flex flex-column justify-content-center align-items-center  col-md-8 col-xs-12">
                                        <p class="txt">Total de Citas Realizadas</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>

                    <a href="SReportes?accion=historial" class="opciones">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="d-flex justify-content-center align-items-center  col-md-4 col-xs-12">
                                        <i class="iconIndex fas fa-notes-medical"></i>
                                    </div>
                                    <div class="d-flex flex-column justify-content-center align-items-center  col-md-8 col-xs-12">
                                        <p class="txt">Historial Medico</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a href="SReportes?accion=pacientes" class="opciones">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="d-flex justify-content-center align-items-center  col-md-4 col-xs-12">
                                        <i class="iconIndex fas fa-notes-medical"></i>
                                    </div>
                                    <div class="d-flex flex-column justify-content-center align-items-center  col-md-8 col-xs-12">
                                        
                                        <p class="txt">Pacientes Atendidos</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <form action="${pageContext.servletContext.contextPath}/SReportes?accion=citas_total" method="POST">
                <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Parametros</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <div class="form-row">

                                        <div class="form-group col-md-6">

                                            <label for="cblocal">Local</label>
                                            <select class="browser-default custom-select" id="cblocal" name="cblocal">
                                                <c:forEach var="local" items="${locales}">
                                                    <option <c:if test="${citas.idLocal==local.idLocal}">selected</c:if> value="${local.idLocal}">${local.local}</option>    
                                                </c:forEach>
                                            </select>


                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="txtFecha">Fecha de inicio</label>
                                            <input type="date" name="txtFeIni" id="txtFeIni" class="form-control" required>
                                        </div>
                                    </div>


                                    <div class="form-group col-md-6">
                                        <label for="txtFecha">Fecha de final</label>
                                        <input type="date" name="txtFeFin" id="txtFeFin" class="form-control"  required>
                                    </div>
                                </div>    

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Reporte</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form action="${pageContext.servletContext.contextPath}/SReportes?accion=existenciasProd" method="POST">
                <div class="modal fade" id="modalProd" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Parametros</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <div class="form-row">

                                        <div class="form-group col-md-6">

                                            <label for="cblocal">Local</label>
                                            <select class="browser-default custom-select" id="cblocal" name="cblocal">
                                                <c:forEach var="local" items="${locales}">
                                                    <option <c:if test="${citas.idLocal==local.idLocal}">selected</c:if> value="${local.idLocal}">${local.local}</option>    
                                                </c:forEach>
                                            </select>


                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="txtFecha">Fecha de inicio</label>
                                            <input type="date" name="txtFeIni" id="txtFeIni" class="form-control"  required>
                                        </div>
                                    </div>


                                    <div class="form-group col-md-6">
                                        <label for="txtFecha">Fecha de final</label>
                                        <input type="date" name="txtFeFin" id="txtFeFin" class="form-control"  required>
                                    </div>
                                </div>    

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Reporte</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form action="${pageContext.servletContext.contextPath}/SReportes?accion=consultas_total" method="POST">
                <div class="modal fade" id="modalConsultas" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Parametros</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <div class="form-row">

                                        <div class="form-group col-md-6">

                                            <label for="cblocal">Local</label>
                                            <select class="browser-default custom-select" id="cblocal" name="cblocal">
                                                <c:forEach var="local" items="${locales}">
                                                    <option <c:if test="${citas.idLocal==local.idLocal}">selected</c:if> value="${local.idLocal}">${local.local}</option>    
                                                </c:forEach>
                                            </select>


                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="txtFecha">Fecha de inicio</label>
                                            <input type="date" name="txtFeIni" id="txtFeIni" class="form-control"  required>
                                        </div>
                                    </div>

                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="txtFecha">Fecha de final</label>
                                            <input type="date" name="txtFeFin" id="txtFeFin" class="form-control"  required>
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label for="cbTipo">Tipo de Consulta</label>
                                            <select class="browser-default custom-select col-md-12" id="cbCons" name="cbCons">
                                                <option  value="Diagnostico">Diagnostico</option>
                                                <option value="Normal" selected>Normal</option>
                                            </select>
                                        </div>
                                    </div>

                                </div>    

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Reporte</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
                
            
            <form action="${pageContext.servletContext.contextPath}/SReportes?accion=pacientesAtn" method="POST">
                <div class="modal fade" id="modalPaci" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Parametros</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="container-fluid">
                                    <div class="form-row">

                                        <div class="form-group col-md-6">

                                            <label for="cblocal">Local</label>
                                            <select class="browser-default custom-select" id="cblocal" name="cblocal">
                                                <c:forEach var="local" items="${locales}">
                                                    <option <c:if test="${citas.idLocal==local.idLocal}">selected</c:if> value="${local.idLocal}">${local.local}</option>    
                                                </c:forEach>
                                            </select>


                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="txtFecha">Fecha de inicio</label>
                                            <input type="date" name="txtFeIni" id="txtFeIni" class="form-control"  required>
                                        </div>
                                    </div>


                                    <div class="form-group col-md-6">
                                        <label for="txtFecha">Fecha de final</label>
                                        <input type="date" name="txtFeFin" id="txtFeFin" class="form-control"  required>
                                    </div>
                                </div>    

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Reporte</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

            <div class="modal fade" id="modalHistorial" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Parametros</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="container-fluid">
                                ${tablapacientes}
                            </div>    

                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Reporte</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</body>
</html>
