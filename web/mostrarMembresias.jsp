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
                    MEMBRESIAS REGISTRADAS
                </h5>
               
                <a class="btn btn-primary" href="Membresias"> Regresar</a>
            </div>
            <div class="main">
                <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Nueva Membresia</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label for="txtNombreBeneficiario3">Nombre del Beneficiario</label>
                                        <input type="text" class="form-control" id="txtDir" >
                                    </div>
                                    <div class="form-group">
                                        <label for="txtNombreBeneficiario3">Nombre del Beneficiario</label>
                                        <input type="text" id="txtFecha" class="form-control"><br>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtNombreBeneficiario3">Nombre del Beneficiario</label>
                                        <input type="text" class="form-control" id="txtEmail" >
                                    </div>
                                    <button type="submit" class="btn btn-primary">Agregar</button>
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
                                <th>Telefono</th>
                                <th>DUI</th>
                                <th>Beneficiario</th>
                                <th>Beneficiario</th>
                                <th>Beneficiario</th>
                                <th>Opcion</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                                <td>1</td>
                                <td>Juan Perez</td>
                                <td>21254495</td>
                                <td>70656565-1</td>
                                <td>Jose Arevalo</td>
                                <td>Juan Perez</td>
                                <td>Juan Arevalo</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>

        </div>
    </body>
</html>