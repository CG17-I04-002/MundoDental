<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Productos</title>
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
                    DATOS DE LOS PRODUCTOS
                </h5>
                <button class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"><i class="fas fa-plus-circle" ></i> Nuevo Producto</button>
            </div>
            <div class="main">
                <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Nuevo Producto</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="txtNom">Nombre</label>
                                            <input type="text" class="form-control" id="txtNom">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="txtApe">Detalle del Producto</label>
                                            <input type="text" class="form-control" id="txtApe" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtDir">Categoria</label>
                                        <select class="browser-default custom-select" id="txtDir" >
                                            <option value="Higiene" selected>Higiene bucal</option>
                                            <option value="Bienes">Bienes de uso dental</option>
                                            <option value="Medicamento">Medicamento</option>
                                        </select>
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
                                <th>Detalle</th>
                                <th>Categoria</th>
                                
                                <th>Opción</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td>1</td>
                                <td>Cepillo</td>
                                <td>Producto dañado</td>
                                <td>Higiene bucal</td>
                                
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Enjuague</td>
                            <td>Producto dañado</td>
                            <td>Higiene bucal</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Tetraciclina</td>
                            <td>Producto agotado</td>
                            <td>Meicamento</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Dentadura</td>
                            <td>Producto agotado</td>
                            <td>Bienes de uso dental</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Pasta dental</td>
                            <td>Producto dañado</td>
                            <td>Bienes de uso dental</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                           
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                           
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                           
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                           
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Juan Perez</td>
                            <td>21</td>
                            <td>70656565</td>
                            
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>

                        </tbody>
                        <tfoot>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Detalle</th>
                                <th>Categoria</th>
                               

                                <th>Opcion</th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>

        </div>
    </body>
</html>