<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Compras</title>
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
                    REGISTRO DE VENTAS
                </h5>
                <a class="btn btn-primary" href="SCompras?accion=mostrar">Mostrar Ventas</a>
            </div>
            <form action="${pageContext.servletContext.contextPath}/SVentas?accion=insertar_modificar" method="POST">
                <div class="container-fluid">
                    <div class="row">
                        <div class="main col-md-4">
                            <h5>Agregar Producto</h5>
                            <hr>
                            <div class="form-row">
                                <div class="form-group col-md-2" style="padding: 0px">
                                    <p>Paciente:</p>

                                </div>
                                <div class="form-group col-md-2">
                                    <input type="text" class="form-control" name="txtId" id="txtIdp" value="${paciente.expediente}" readonly="readonly" required/>

                                </div>

                                <div class="form-group col-md-6">
                                    <input type="text" class="form-control" name="txtId" id="txtPac" value="${paciente.nombres} ${paciente.apellidos}" readonly="readonly" required/>

                                </div>
                                <div class="form-group col-md-1">
                                    <input type="button" value="..." class="btn btn-primary" data-toggle="modal" data-target="#exampleModalpacientes" data-whatever="@mdo">
                                </div>
                                <div class="form-group col-md-6">
                                    Seleccionar Clinica:
                                </div>
                                <div class="form-group col-md-5">
                                    <select class="browser-default custom-select" id="cblocal" name="cblocal">
                                        <c:forEach var="local" items="${locales}">
                                            <option <c:if test="${citas.idLocal==local.idLocal}">selected</c:if> value="${local.idLocal}">${local.local}</option>    
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group col-md-2">
                                    Flujo
                                </div>
                                <div class="form-group col-md-4">
                                    <select class="browser-default custom-select" id="txtflujo" name="txtflujo">
                                        <option value="Entrada">Entrada</option>    
                                        <option value="Salida">Salida</option> 
                                    </select>
                                </div>
                                <div class="form-group col-md-2">
                                    <p>Fecha:</p>
                                </div>
                                <div class="form-group col-md-4">
                                    <input type="date" class="form-control" name="txtfecha" id="txtfecha"/>
                                </div>
                                <div class="form-group col-md-3" style="padding: 0px">
                                    <p>Seleccionar Producto:</p>
                                </div>
                                <div class="form-group col-md-2">
                                    <input type="text" class="form-control" name="txtId" id="txtId" readonly="readonly"/>
                                </div>

                                <div class="form-group col-md-5">
                                    <input type="text" class="form-control" name="txtProd" id="txtProd" readonly="readonly"/>
                                </div>
                                <div class="form-group col-md-2">
                                    <input type="button" value="..." class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" >
                                </div>
                                <div class="form-group col-md-2" style="padding: 0px">
                                    <p>Costo:</p>
                                </div>
                                <div class="form-group col-md-3">
                                    <input type="text" class="form-control" name="txtCosto" id="txtCosto" />
                                </div>
                                <div class="form-group col-md-4">
                                    <p>Precio venta:</p>
                                </div>
                                <div class="form-group col-md-3">
                                    <input type="text" class="form-control" name="txtPrecioV" id="txtPrecioV"/>
                                </div>

                                <div class="form-group col-md-3" style="padding: 0px">
                                    <p>Cantidad:</p>
                                </div>
                                <div class="form-group col-md-3">
                                    <input type="text" class="form-control" name="txtcantidad" id="txtcantidad">
                                </div>
                                <div class="form-group col-md-6">
                                    <button id="add" class="btn btn-primary" type="button" onclick="sumarmonto()" > Agregar Producto</button>
                                </div>
                            </div>
                            <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Productos</h5>
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
                                                    var idProducto = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
                                                    var nom = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                                    //asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                                    document.getElementById("txtId").value = idProducto;
                                                    document.getElementById("txtProd").value = nom;

                                                    $(document).ready(function () {
                                                        $("#exampleModal").modal("toggle");
                                                    }
                                                    );
                                                    return false;
                                                }
                                            </script>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="modal fade" id="exampleModalpacientes" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Clinicas</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            ${tablapacientes}
                                            <script>
                                                //funcion javascript que se ejecuta al hacer click en una fila//recibe un elemento de tipo fila como parametro: row
                                                function _Seleccionarpacientes_(row) {
                                                    ////recupera el idavion de la fila, en la celda 0
                                                    var expe = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
                                                    var nom = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                                    var ape = row.cells[2].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                                    document.getElementById("txtIdp").value = expe;
                                                    document.getElementById("txtPac").value = nom + " " + ape;
                                                    $(document).ready(function () {
                                                        $("#exampleModalpacientes").modal("toggle");
                                                    }
                                                    );
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
                                    <H5>PRODUCTOS AÑADIDOS</H5>
                                    <input type="submit" value="Registrar Venta" class="btn btn-primary">
                                </div>
                                <hr>
                                <table id="tabla" border=1 class="table table-condensed table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>PRODUCTOS</th>
                                            <th>COSTO</th>
                                            <th>PRECIO VENTA</th>
                                            <th>CANTIDAD</th>
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
                                            var id = document.getElementById("txtId").value;
                                            var producto = document.getElementById("txtProd").value;
                                            var cantidad = document.getElementById("txtcantidad").value;
                                            var consto = document.getElementById("txtCosto").value;
                                            var pventa = document.getElementById("txtPrecioV").value;
                                            var nuevaFila = "<tr><td><input type='text' value='" + id + "' name='id' class='form-control' readonly='readonly' ></td> \
                                    <td><input type='text'value='" + producto + "' name='producto' class='form-control' readonly='readonly'></td> \
                                    <td><input type='text'value='" + consto + "' name='costo'class='form-control' readonly='readonly'></td> \
                                    <td><input type='text'value='" + pventa + "' name='precioVenta' class='form-control pv' readonly='readonly'></td> \
                                    <td><input type='text'value='" + cantidad + "' name='cantidad' class='form-control'></td> \
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
