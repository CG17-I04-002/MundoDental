<%-- 
    Document   : empleados
    Created on : 20-sep-2019, 12:57:09
    Author     : LARIN
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Empleados</title>
        <link rel="shortcut icon" href="img/Solo logo.ico">

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>

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
        <div class="header">
            <div class="d-flex  justify-content-end">

                <button class="btn btn-primary cerrar"><i class="fas fa-sign-out-alt"></i></button>
            </div>
        </div>
        <div class="side-nav">
            <div class="logo">
                <span>Mundo Dental</span>
            </div>
            <nav>
                <%@include file="menu.jsp" %>
            </nav>
        </div>
        <div class="main-content">
            <div class="title d-flex  justify-content-between align-items-center">
                <h5>
                    DATOS DE LOS EMPLEADOS
                </h5>
                <button class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"><i class="fas fa-plus-circle" ></i> Nuevo Empleado</button>
            </div>
            <div class="main">
                <div class="modal fade" id="exampleModal" data-backdrop="static" data-keyboard="false"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-plus-circle" ></i> Nuevo Empleados</h5>
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
                                    
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="txtTel1">Nombre de Usuario</label>
                                            <input type="text" class="form-control" id="txtTel1">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="txtTel2">Contraseña</label>
                                            <input type="password" class="form-control" id="txtTel2">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="txtTel1">Estado</label>
                                            <select class="browser-default custom-select" id="txtTel1">
                                                <option value="1" selected="">Activo</option>
                                                <option value="2">Inactivo</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="txtTel2">Rol</label>
                                            <select class="browser-default custom-select" id="txtTel2">
                                                <option value="1" selected="">Administrador</option>
                                                <option value="2">Secretaria</option>
                                                <option value="3">Doctor</option>
                                            </select>
                                        </div>
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
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Nombre de Usuario</th>
                                <th>Estado</th>
                                <th>Rol</th>
                                <th>Opcion</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td>1</td>
                                <td>Ricardo</td>
                                <td>Gonzales</td>
                                <td>ric24</td>
                                <td>Activo</td>
                                <td>Doctor</td>
                                <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Maria</td>
                            <td>Escobar</td>
                            <td>mari76</td>
                            <td>Activo</td>
                            <td>Secreatria</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Edgardo</td>
                            <td>Flores</td>
                            <td>Edg45</td>
                            <td>Inactivo</td>
                            <td>Administrador</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Xavi</td>
                            <td>Hernandez</td>
                            <td>xavifcb56</td>
                            <td>Activo</td>
                            <td>Administrador</td>
                            <td><center><button class="btn btn-primary"><i class="fas fa-pencil-alt"></i></button></center></td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Carmen</td>
                            <td>Mendez</td>
                            <td>crm21</td>
                            <td>Inactivo</td>
                            <td>Secreatia</td>
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
                        
                    </table>
                </div>
            </div>

        </div>
    </body>
</html>