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
                            <h5>Agregar Membresia</h5>
                            <hr>
                            <div class="form-row">
                                
                                
                                
                                
                                <div class="form-group col-md-3" style="padding: 0px">
                                    <p>Seleccionar Beneficiario</p>
                                </div>
                                <div class="form-group col-md-2">
                                    <input type="text" class="form-control" name="txtexpedienteBeneficiario" id="txtexpedienteBeneficiario" readonly="readonly"/>
                                </div>
                                

                                <div class="form-group col-md-5">
                                    <input type="text" class="form-control" name="txtNombreBeneficiario" id="txtNombreBeneficiario" readonly="readonly"/>
                                </div>
                                <div class="form-group col-md-2">
                                    <input type="button" value="..." class="btn btn-primary" data-toggle="modal" data-target="#exampleModalp" data-whatever="@mdo" >
                                </div>
                                
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
                                    <input type="button" value="..." class="btn btn-primary" data-toggle="modal" data-target="#exampleModalb" data-whatever="@mdo" >
                                </div>
                                
                                
                                <div class="form-group col-md-2">
                                    <p>Fecha R:</p>
                                </div>
                                <div class="form-group col-md-4">
                                    <input type="date" class="form-control" name="txtfechaRegistro" id="txtfechaRegistro"/>
                                </div>
                                <div class="form-group col-md-2">
                                    <p>Fecha V:</p>
                                </div>
                                <div class="form-group col-md-4">
                                    <input type="date" class="form-control" name="txtfechaVencimiento" id="txtfechaVencimiento"/>
                                </div>
                                
                                <div class="form-group col-md-2" style="padding: 0px">
                                    <p>Monto:</p>
                                </div>
                                <div class="form-group col-md-4">
                                    <input type="text" class="form-control" name="txtMonto" id="txtMonto"/>
                                </div>
                                
                                
                                <div class="form-group col-md-6">
                                    <button id="add" class="btn btn-primary" type="button" onclick="sumarmonto()" > Agregar Membresia</button>
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
                                            <script>
                                    //funcion javascript que se ejecuta al hacer click en una fila//recibe un elemento de tipo fila como parametro: row
                                    function _Seleccionarb_(row) {
                                    ////recupera el idavion de la fila, en la celda 0
                                        var expediente = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
                                        var nombre = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                        
                                        document.getElementById("txtexpediente").value = expediente;
                                        document.getElementById("txtNombre").value = nombre;
                                        
                                         $(document).ready(function () {
                                                        $("#exampleModalb").modal("toggle");
                                                    }
                                                    ); 
                                        
                                        
                                        
                                        
                                        return false;
                                    }
                                </script>
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
                                            <script>
                                    //funcion javascript que se ejecuta al hacer click en una fila//recibe un elemento de tipo fila como parametro: row
                                    function _Seleccionarp_(row) {
                                    ////recupera el idavion de la fila, en la celda 0
                                        var expediente = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
                                        var nombre = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                        
                                        document.getElementById("txtexpedienteBeneficiario").value = expediente;
                                        document.getElementById("txtNombreBeneficiario").value = nombre;
                                        
                                        var nuevaFila = "<tr><td><input type='text' value='" + expediente + "' name='id' class='form-control' readonly='readonly' ></td> \
                                    <td><input type='text'value='" + nombre + "' name='nombreMembresia' class='form-control' readonly='readonly'></td> \
                                     \
                                    <td><input type='button' class='del btn btn-danger' value='Eliminar'></td> \
                            </tr>"
                                                    ;
                                            $("#tabla tbody").append(nuevaFila);
                                        
                                        
                                        return false;
                                    }
                                </script>
                                
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
                                <div>
                                    <H5>BENEFICIARIOS AÑADIDOS</H5>
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
                                <br>
                                <script>
                                    $(document).ready(function () {
                                        /**
                                         * Funcion para añadir una nueva fila en la tabla
                                         */
                                        $("#add").click(function () {
                                            
                                            var expediente = document.getElementById("txtexpediente").value;
                                            var nombre = document.getElementById("txtNombre").value;
                                            var nuevaFila = "<tr><td><input type='text' value='" + expediente + "' name='id' class='form-control' readonly='readonly' ></td> \
                                    <td><input type='text'value='" + nombre + "' name='producto' class='form-control' readonly='readonly'></td> \
                                     \
                                    <td><input type='button' class='del btn btn-danger' value='Eliminar'></td> \
                            </tr>"
                                                    ;
                                            $("#tabla tbody").append(nuevaFila);
                                        });
                                        // evento para eliminar la fila
                                        $("#tabla").on("click", ".del", function () {
                                            $(this).parents("tr").remove();
                                        });
                                    });
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
                                            
        </div>
    </body>
</html>