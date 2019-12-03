<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="img/Solo logo.ico">
        <title>Inicio</title>

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
                    REGISTROS DIARIOS
                </h5>
            </div>
            <div class="main">
                <div class="card-columns">
                    <c:forEach var="menu" items="${MenuPrincipal}">
                        <a class="opcM" href="${pageContext.servletContext.contextPath}${menu.url}?accion=${menu.idmenu}">
                            <div class="card col-md-12">
                                <div class="card-body">
                                    <div class="row d-flex justify-content-center align-items-center">
                                        
                                         <h1>${menu.menu}</h1>

                                        
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>

        </div>
    </body>
</html>