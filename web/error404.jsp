<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ///BORRAR CACHE
    
    String usuario = (String)request.getSession().getAttribute("Usuario");
    if(usuario==null){
        response.sendRedirect("Login");
    }
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error 404</title>
        <link rel="stylesheet" href="css/error404.css">
    </head>
    <body>
        <div class="sub-body">
            
                <h1>¡Error 404!</h1>
                <h3>El archivo o dirección a la que trata de acceder ¡no existe!</h3>
                <p>Debería tomar en cuenta lo siguiente:</p>
                <button onclick="regresar()">Regresar</button>
                <script>
                    function regresar(){
                        window.history.back();
                    }
                </script>
                
                <div class="">
                	<img class="imag" src="img/Solo logo.png" alt="">
                </div>
                
        </div>
        
    </body>
</html>
