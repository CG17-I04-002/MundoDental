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
            </div>
            <div class="container-fluid">
                <form action="${pageContext.servletContext.contextPath}/SConsultas?accion=completar" method="POST">

                    <div class="row">
                        <div class="main col-md-4">

                            <h5>Agregar Consultas</h5>
                            <hr>
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label>ID Consulta</label>
                                </div>
                                <div class="form-group col-md-8">
                                    <input type="text" class="form-control" name="txtCon" id="txtCon" value="${consulta.idConsulta}" readonly="readonly" required/>
                                </div>
                                
                            </div>
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
                            <a class="btn btn-primary" data-toggle="modal" data-target="#modalTra" data-whatever="@mdo"><i class="fas fa-check-circle"></i> Tratamiento</a><br>

                            <br>
                            

                            <div class="modal fade" id="modalTra" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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

                            <table id="tabla" border=1 class="table table-condensed table-striped">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tratamiento</th>
                                        <th>Precio</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                            <input type="text" class="form-control" name="txtTotal" id="txtTotal" readonly="readonly" required value="0"/>
                            <br>
                            <button type="submit" class="btn btn-primary"><i class="fas fa-plus-circle" ></i> Completar</button><br>

                        </div>
                    </div>

                </form>
            </div>
        </div>
    </body>
</html>

