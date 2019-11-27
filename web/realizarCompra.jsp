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

        <script src="js/default.js" type="text/javascript"></script>
        <style>#table01 td{ padding-top: 8px; cursor: pointer}</style>

        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="menu.jsp" %>
        <div class="main-content">
            <div class="title d-flex  justify-content-between align-items-center">
                <h5>
                    REGISTRO DE COMPRAS
                </h5>
            </div>
            <form action="${pageContext.servletContext.contextPath}/SCompras?accion=insertar_modificar" method="POST">
                <div class="container-fluid">
                    <div class="row">
                        <div class="main col-md-4">
                            <h5>Agregar Producto</h5>
                            <hr>


                            <div class="form-row">
                                
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
                                    <input type="text" class="form-control" name="txtCosto" id="txtCosto"/>
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
                                    <button id="add" class="btn btn-primary" type="button" > Agregar Producto</button>
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
                            <div class="modal fade" id="exampleModalLocal" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Clinicas</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            ${tablalocal}
                                            <script>
                                                //funcion javascript que se ejecuta al hacer click en una fila//recibe un elemento de tipo fila como parametro: row
                                                function _Seleccionarl_(row) {
                                                    ////recupera el idavion de la fila, en la celda 0
                                                    var idLocal = row.cells[0].innerHTML;//recupera descripcion del avion de la fila, en la celda 1
                                                    var Local = row.cells[1].innerHTML;//asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                                    //asigna a las cajas de texto de la ventana padre los valores//obtenidos'
                                                    document.getElementById("txtIdLocal").value = idLocal;
                                                    document.getElementById("txtLocal").value = Local;

                                                    $(document).ready(function () {
                                                        $("#exampleModalLocal").modal("toggle");
                                                    }
                                                    );
                                                    return false;
                                                }
                                            </script>
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
                                <H5>PRODUCTOS AÑADIDOS</H5>
                                <table id="tabla" border=1>
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
                                <input type="submit" value="enviar">
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
                                            var nuevaFila = "<tr><td><input type='text' value='" + id + "' name='id' ></td> \
                                    <td><input type='text'value='" + producto + "' name='producto'></td> \
                                    <td><input type='text'value='" + consto + "' name='costo'></td> \
                                    <td><input type='text'value='" + pventa + "' name='precioVenta'></td> \
                                    <td><input type='text'value='" + cantidad + "' name='cantidad'></td> \
                                    <td><input type='button' class='del' value='Eliminar Fila'></td> \
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
