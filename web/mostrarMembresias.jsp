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
        <link href="css/tabla.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

        <%@include file="menu.jsp" %>
        
        <div class="main-content">
            <div class="title d-flex  justify-content-between align-items-center">
                <h5>
                    MEMBRESIAS REGISTRADAS
                </h5>
                
                <a href="SMembresias" class="btn btn-primary" href="Compras"> Regresar</a>
            </div>
            <div class="main">
                

                <div class="tbPac">
                    <div class="busqueda" style="width: 50%; text-align: right">
                        <form action="${pageContext.servletContext.contextPath}/SMembresias?accion=mostrar" method="get">
                            <input type="text" name="txtBusqueda" id="txtBusqueda" value="${valor}" />
                            <input type="submit" value="Buscar"/>
                            <div class="form-group col-md-2">
                                   
                                </div>
                        </form>
                            
                    </div>                    
                    ${tablaMembresiaYBeneficiario}
                    <script>
                        window.onload = function () {
                            document.getElementById("txtBusqueda").focus();
                        };
                    </script> 
                </div>
            </div>

        </div>
    </body>
</html>