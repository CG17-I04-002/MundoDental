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
        <script src="js/operacionescompra.js" type="text/javascript"></script>
        <script src="js/default.js" type="text/javascript"></script>
        <link href="css/operacionescompras.css" rel="stylesheet" type="text/css"/>
        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="menu.jsp" %>
        <div class="main-content">
            <div class="title d-flex  justify-content-between align-items-center">
                <h5>
                    REGISTRO DE COMPRAS
                </h5>
                <a class="btn btn-primary" href="SCompras?accion=mostrar">Mostrar compras</a>
            </div>
            <form action="${pageContext.servletContext.contextPath}/SCompras?accion=insertar_modificar" method="POST">
                <div class="container-fluid">
                    <div class="row">
                        <div class="main col-md-4">
                            <h5>Agregar Producto</h5>
                            <hr>
                            <div class="form-row">
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
                                    <button id="add" class="btn btn-primary" type="button" onclick="validarfor()" > Agregar Producto</button>
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
                                            <form action="${pageContext.servletContext.contextPath}/SCompra" method="get">

                                                <div class="form-row">

                                                    <div class="form-group col-md-3">
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
                                            ${tabla}
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
                                <div class="row justify-content-between columna2">
                                    <H5>PRODUCTOS AÑADIDOS</H5>
                                    <input type="submit" value="Registrar Compra" class="btn btn-primary">
                                </div>
                                <hr>
                                <table id="tabla" border=1>
                                    <thead>
                                        <tr>
                                            <th class="id">ID</th>
                                            <th class="prod">PRODUCTOS</th>
                                            <th class="cost">COSTO</th>
                                            <th class="pv">PRECIO VENTA</th>
                                            <th class="cant">CANTIDAD</th>
                                            <th class="vft">TOTAL</th>
                                            <th class="elim">ELIMINAR</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                                <br>
                                <div class="row">
                                    Total Compra :
                                    <div class="form-group col-md-2" >
                                        <input type="text" class="form-control" name="txtTotal" id="txtTotal" readonly="readonly" required value="0"/>
                                    </div>
                                    <c:if test="${resultado!=null}">
                                        <c:if test="${resultado==1}">
                                            <p style="color:darkgreen"><strong>Operación realizada correctamente.</strong></p>
                                        </c:if>
                                        <c:if test="${resultado==0}">
                                            <p style="color:darkred"><strong>La operación no se realizó.</strong></p>
                                        </c:if>

                                    </c:if>   
                                </div>
                            </div>
                            <div>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </form>
</div>
</body>
</html>