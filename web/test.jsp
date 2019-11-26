<%@page import="com.mundodental.operaciones.Operaciones"%>
<%@page import="com.mundodental.entidad.*"%>
<%@page import="com.mundodental.operaciones.ManejadorSentencias"%>
<%@page import="com.mundodental.conexion.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        Conexion con = new ConexionPool();
        con.conectar();
        if (con.getConexion()==null)
            out.println("Fallo la conexion"+"<br>");
        else
            out.println("Conexion exitosa"+"<br>");
        Roles r = new Roles(1, "Admin Mod");
      
        
        Operaciones.abrirConexion(con);
        Operaciones.iniciarTransaccion();
        try{
        Roles usuarioInsertado = Operaciones.actualizar(1, r);
        if (usuarioInsertado!=null){
            out.println("usuario insertado");
            out.println(r);
        }
        else
            out.println("error al insertar");
        
        Operaciones.commit();
        }catch(Exception e){
            Operaciones.rollback();
        }
        
        con.desconectar();
        %>
    </body>
</html>
