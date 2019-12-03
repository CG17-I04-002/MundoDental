<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Membresias</title>
        <link rel="shortcut icon" href="img/Solo logo.ico">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>

        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>

        <script src="js/68ab40f8cf.js" type="text/javascript"></script>
        <link href="css/pacientes" rel="stylesheet" type="text/css"/>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="js/membresia.js" type="text/javascript"></script>
        <script src="js/default.js" type="text/javascript"></script>
        <style>#table01 td{ padding-top: 8px; cursor: pointer}
            .pv{
                width: 120px;
            }
        </style>

        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="menu.jsp" %>
        <div class="main-content">
            <div class="title d-flex  justify-content-between align-items-center">
                <h5>
                    REGISTRO DE MEMBRESIAS
                </h5>
                <a class="btn btn-primary" href="SMembresias?accion=mostrar">Mostrar membresias</a>
            </div>
            <form action="${pageContext.servletContext.contextPath}/SMembresias?accion=insertar_modificar" method="POST">
                <div class="container-fluid">
                    <div class="row">
                        <div class="main col-md-4">
                            <br>
                            <h5>Agregar Membresia</h5>
                            <hr>
                            <div class="form-row">




                                <div class="form-group col-md-6" style="padding: 0px">
                                    <p>Seleccionar Beneficiario</p>
                                </div>

                                <div class="form-group col-md-6">
                                    <input type="button" value="..." class="btn btn-primary" data-toggle="modal" data-target="#exampleModalb" data-whatever="@mdo" >
                                </div>


                            </div>


                            <div class="form-row">
                                <div class="form-group col-md-3" style="padding: 0px">
                                    <p>Seleccionar Paciente</p>
                                </div>
                                <div class="form-group col-md-2">
                                    <input type="text" class="form-control" name="txtexpediente" id="txtexpediente" readonly="readonly"/>
                                </div>
                                <div class="form-group col-md-5">
                                    <input type="text" class="form-control" name="txtNombre" id="txtNombre" readonly="readonly"/>
                                </div>
                                <div class="form-group col-md-2">
                                    <input type="button" value="..." class="btn btn-primary" data-toggle="modal" data-target="#exampleModalp" data-whatever="@mdo" >
                                </div>

                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">

                                    <p>Fecha Registro</p>
                                    <input type="date" class="form-control" name="txtfechaRegistro" id="txtfechaRegistro"/>
                                </div>

                                <div class="form-group col-md-6">

                                    <p>Fecha Vencimiento</p>
                                    <input type="date" class="form-control" name="txtfechaVencimiento" id="txtfechaVencimiento"/>
                                </div>
                            </div>


                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <p>Monto:</p>
                                    <input type="text" class="form-control" name="txtMonto" id="txtMonto"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <p>Porcentaje descuento</p>
                                    <input type="text" class="form-control" name="txtPor" id="txtPor"/>
                                </div>
                            </div>



                            <div class="modal fade" id="exampleModalb" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Membresias</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            ${tablab}
                                      </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal fade" id="exampleModalp" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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

                                    </div>
                                </div>
                            </div>
                            <div class="modal fade" id="modalProducto" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="main col-md-8">
                            <div class="col-md-12">
                                <br>
                                <div>
                                    <H5>BENEFICIARIOS AGREGADOS</H5>
                                    <input type="submit" value="Registrar Membresia" class="btn btn-primary">
                                </div>
                                <hr>
                                <table id="tabla" border=1 class="table table-condensed table-striped">
                                    <thead>
                                        <tr>
                                            <th>EXPEDIENTE</th>
                                            <th>BENEFICIARIO</th>
                                            <th>ELIMINAR</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>

                            </div>
                            <div>

                            </div>
                        </div>
                    </div>
                </div>
            </form>

        </div>
    </body>
</html>