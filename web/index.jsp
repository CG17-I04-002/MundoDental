<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="shortcut icon" href="img/Solo logo.ico">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="jsp/all.min.js" type="text/javascript"></script>
        
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="js/68ab40f8cf.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link href="css/styleLogin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="contenedor">
            <div class="caja">
                <div class="isquierda">
                    <h2>Clínica Mundo Dental</h2>
                    <p>Nuestra mayor satisfacción es ver sonrisas felices</p>
                    <img src="img/Solo logo.png" />
                </div>
                <div class="derecha">
                    <div class="formbox">
                        <form name="main" action="Login?accion=login" method="POST">
                            <div class="user">
                                <img src="img/user4.png">
                            </div>
                            <h2>INICIO DE SESIÓN</h2>
                            <c:if test="${error!=null}">
                                <c:if test="${error==2}">
                                    <p>
                                        <strong style="color: red">Usuario y/o contrasena incorrectos</strong>
                                    </p>

                                </c:if>
                            </c:if>
                            <div class="form1" id="user" >
                                <div class="lab">Usuario</div>
                                <input type="text" name="txtUsuario" placeholder="" required>
                            </div>
                            <div class="form2" id="cotra">
                                <div class="lab">Contraseña</div>
                                <input type="password" name="txtClave"  placeholder="" required>
                            </div>
                            <div class="btn">
                                <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="jsp/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="jsp/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>

