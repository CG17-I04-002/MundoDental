
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Ventas</title>
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
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="main-content">
            <div class="title d-flex  justify-content-between align-items-center">
                <h5>
                    REGISTRO DE VENTAS
                </h5>
                <a class="btn btn-primary" href="Ventas?accion=mostrar"><i class="fas fa-eye"></i> Mostrar Ventas</a>
                
            </div>
            <div class="container-fluid">
                <div class="row">

                    <div class="main col-md-4">
                        <h5>Agregar Productos</h5>
                        <hr>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#modalPac" data-whatever="@mdo"><i class="fas fa-plus-circle" ></i> Seleccionar Paciente</button><br>
                        <br>
                        <form>
                            <div class="form-group">
                                <label>Paciente: <strong>Juan Perez</strong></label><br>
                                <label>Membresía: <strong>Sí</strong></label>
                            </div>


                        </form>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#modalProducto" data-whatever="@mdo" ><i class="fas fa-plus-circle" ></i> Agregar Producto</button><br>

                        <div class="modal fade" id="modalPac" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Nuevo Paciente</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <p>
                                            <button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2">Nuevo Paciente</button>
                                        </p>
                                        <div class="collapse show multi-collapse" id="multiCollapseExample1">
                                            <table id="tb2" class="table table-striped table-bordered" style="width:100%">
                                                <thead>
                                                    <tr>
                                                        <th>Paciente</th>
                                                        <th>Telefono</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Juan Perez</td>
                                                        <td>65656656</td>
                                                    </tr>

                                                </tbody>
                                                <tfoot>
                                                </tfoot>
                                            </table>
                                        </div>
                                        <div class="collapse multi-collapse" id="multiCollapseExample2">
                                            <div class="card card-body">
                                                <form>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label for="txtNombres">Nombres</label>
                                                            <input type="text" class="form-control" id="txtNom">
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label for="txtApe">Apellidos</label>
                                                            <input type="text" class="form-control" id="txtApe" >
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="txtDir">Dirección</label>
                                                        <input type="text" class="form-control" id="txtDir" >
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label for="txtTel1">Telefono 1</label>
                                                            <input type="text" class="form-control" id="txtTel1">
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label for="txtTel2">Telefono 2</label>
                                                            <input type="text" class="form-control" id="txtTel2">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="txtFecha">Fecha de nacimiento</label>
                                                        <input type="date" id="txtFecha" class="form-control"><br>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="txtEmail">Email</label>
                                                        <input type="text" class="form-control" id="txtEmail" >
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Agregar</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary" data-dismiss="modal"><i class="fas fa-ban"></i> Cancelar</button>
                                        <button type="submit" class="btn btn-primary"><i class="fas fa-edit"></i> Actualizar</button>
                                        <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal fade" id="modalProducto" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Seleccionar Producto</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <table id="tb1" class="table table-striped table-bordered" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>Codigo</th>
                                                    <th>Producto</th>
                                                    <th>Categoria</th>
                                                    <th>Existencia</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Paracetamol</td>
                                                    <td>Medicamento</td>
                                                    <td>10</td>
                                                </tr>

                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th>Codigo</th>
                                                    <th>Producto</th>
                                                    <th>Categoria</th>
                                                    <th>Existencia</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary" data-dismiss="modal">Seleccionar</button>
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="main col-md-8">
                        <h5>Carretilla</h5>
                        <hr>
                        <table id="tbCarr" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Producto</th>
                                    <th>Categoria</th>
                                    <th>Existencia</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Paracetamol</td>
                                    <td>Medicamento</td>
                                    <td>10</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Paracetamol</td>
                                    <td>Medicamento</td>
                                    <td>10</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Paracetamol</td>
                                    <td>Medicamento</td>
                                    <td>10</td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Paracetamol</td>
                                    <td>Medicamento</td>
                                    <td>10</td>
                                </tr>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Producto</th>
                                    <th>Categoria</th>
                                    <th>Existencia</th>
                                </tr>
                            </tfoot>
                        </table>
                        <label>Total: <strong>$100.00</strong></label><br>
                        <button class="btn btn-primary"  ><i class="fas fa-plus-circle" ></i> Realizar Venta</button><br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>