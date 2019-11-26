<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Pacientes</title>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/68ab40f8cf.js" type="text/javascript"></script>
        <link href="css/pacientes.css" rel="stylesheet" type="text/css"/>
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
                    DATOS DE LOS PRIVILEGIOS
                </h5>
                <button  class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"><i class="fas fa-plus-circle" ></i> Nuevo privilegios</button>
            </div>
            <div class="main">
                <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Nuevo privilegios</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="txtNom">Nombres</label>
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
                                        <input type="email" class="form-control" id="txtEmail" >
                                    </div>


                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" data-dismiss="modal"><i class="fas fa-ban"></i> Cancelar</button>

                                <button type="submit" class="btn btn-primary"><i class="fas fa-edit"></i> Actualizar</button>

                                <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="tbPac">

                    <table id="tb1" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Edad</th>
                                <th>Telefono</th>
                                <th>Direccion</th>
                                <th>Email</th>
                                <th>Opción</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21</td>
                                <td>70656565</td>
                                <td>Roca dragon</td>
                                <td>juanperez@gmail.com</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            <td>Roca dragon</td>
                            <td>juanperez@gmail.com</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>

                        </tbody>
                        <tfoot>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Edad</th>
                                <th>Telefono</th>
                                <th>Direccion</th>
                                <th>Email</th>

                                <th>Opcion</th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>

        </div>
    </body>
</html>