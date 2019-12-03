<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="img/Solo logo.ico">
        <title>Configuración</title>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/68ab40f8cf.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/index.css" rel="stylesheet" type="text/css"/> 
    </head>
    <body>
        
        <%@include file="menu.jsp" %>
        <div class="main-content ">
            <div class="title">
                <h5>
                    Configuraciones
                </h5>
            </div>
            <div class="main">
                <div class="card-columns">

                    <a href="SConfiguracion?accion=12" class="opciones">
                        <div class="card col-md-12">
                            <div class="card-body">
                                <div class="row">
                                    <div class="d-flex justify-content-center align-items-center  col-md-4 col-xs-12">
                                        <i class="iconIndex fas fa-user-md"></i>
                                    </div>
                                    <div class="d-flex flex-column justify-content-center align-items-center  col-md-8 col-xs-12">
                                   
                                        <p class="txt">Usuarios</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a href="SConfiguracion?accion=13" class="opciones">

                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="d-flex justify-content-center align-items-center  col-md-4 col-xs-12">
                                        <i class="iconIndex fas fa-notes-medical"></i>
                                    </div>
                                    <div class="d-flex flex-column justify-content-center align-items-center  col-md-8 col-xs-12">
                                        
                                        <p class="txt">Roles</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                    <a href="SConfiguracion?accion=14" class="opciones">

                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class=" d-flex justify-content-center align-items-center  col-md-4 col-xs-12">
                                        <i class="iconIndex fas fa-stethoscope"></i> 
                                    </div>
                                    <div class="d-flex flex-column justify-content-center align-items-center  col-md-8 col-xs-12">
                                        
                                        <p class="txt">Permisos</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>

        </div>
    </body>
</html>