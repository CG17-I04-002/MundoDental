package com.mundodental.control;

import com.mundodental.conexion.Conexion;
import com.mundodental.conexion.ConexionPool;
import com.mundodental.entidad.Categorias;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Menu;
import com.mundodental.entidad.Pacientes;
import com.mundodental.entidad.Permiso;
import com.mundodental.entidad.Productos;
import com.mundodental.entidad.Roles;
import com.mundodental.entidad.Usuario;
import com.mundodental.operaciones.Operaciones;
import com.mundodental.utilerias.Hash;
import com.mundodental.utilerias.Tabla;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SConfiguracion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        HttpSession s = request.getSession();
                List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
                //List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre() == 0).collect(Collectors.toList());
                //request.setAttribute("MenuPrincipal", MenuPrincipal);
                String op = request.getParameter("op");
                if (op != null) {
                    List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre() == Integer.parseInt(op)).collect(Collectors.toList());
                    request.setAttribute("PermisosAsignados", PermisosAsignados);
                }
            if (null == accion) {
                request.getRequestDispatcher("configuracion.jsp").forward(request, response);
            } else {
                switch (accion) {
                case "12":
                    request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
                    break;
                case "13":
                    request.getRequestDispatcher("Roles.jsp").forward(request, response);
                    break;
                case "14":
                    request.getRequestDispatcher("Permiso.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        }
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //// processRequest(request, response);
        /*String accion = request.getParameter("accion");
        HttpSession s = request.getSession();
                List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
                //List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre() == 0).collect(Collectors.toList());
                //request.setAttribute("MenuPrincipal", MenuPrincipal);
                String op = request.getParameter("op");
                if (op != null) {
                    List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre() == Integer.parseInt(op)).collect(Collectors.toList());
                    request.setAttribute("PermisosAsignados", PermisosAsignados);
                }
            if (null == accion) {
                request.getRequestDispatcher("configuracion.jsp").forward(request, response);
            } else {
                switch (accion) {
                case "12":
                    request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
                    break;
                case "13":
                    request.getRequestDispatcher("Roles.jsp").forward(request, response);
                    break;
                case "14":
                    request.getRequestDispatcher("Permiso.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        }*/
       
       
        
        
        
        ///doGetPermisos(request, response);
        
        doGetRoles(request, response);
        
       /// doGetUsuarios(request, response);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ///processRequest(request, response);
        
        
        
        
        
       
        
        
        
        
        
        ////doPostPermisos(request, response);
        
        doPostRoles(request, response);
        
        ///doPostUsuarios(request, response);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         
    }
    ////////////////////////////////////////////////////////////////////////////TABLA ROLES///////////////////////////////////////////////////////////////////
    private void cargarTablaRol(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";
            if (request.getParameter("txtBusquedaRol") != null) {
                sql = "select * from Roles where rol like ?";
            } else {
                sql = "select * from Roles";
            }
            String[][] roles = null;
            if (request.getParameter("txtBusquedaRol") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusquedaRol").toString() + "%");
                roles = Operaciones.consultar(sql, params);
            } else {
                roles = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"ID Rol", "Rol"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(roles, //array quecontiene los datos
                    "50%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            tab.setEliminable(true);//boton actualizar
            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaEliminable("/SConfiguracion?accion=eliminar");//pagina encargada de actualizacion
            tab.setPaginaModificable("/SConfiguracion?accion=modificar");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SConfiguracion?accion=modificar");//icono para modificar y eliminar
            tab.setIconoModificable("/iconos/edit.png");
            tab.setIconoEliminable("/iconos/delete.png"); //columnas seleccionables
            //tab.setColumnasSeleccionables(new int[]{1});//pie de tabla
            tab.setPie("Resultado de pacientes");
            //imprime la tabla enpantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tabla", tabla01);
            request.setAttribute("valor", request.getParameter("txtBusquedaRol"));
        } catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////TABLA PERMISOS///////////////////////////////////////////////////////////////////
    private void cargarTablaPermisos(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";
            if (request.getParameter("txtBusquedaPermiso") != null) {
                sql = "select idpermiso, (select m.menu from menu m where p.idmenu=m.idmenu), (select r.rol from Roles r where p.idrol=r.idRol) from Permiso p where idpermiso like ?";
            } else {
                sql = "select idpermiso, (select m.menu from menu m where p.idmenu=m.idmenu), (select r.rol from Roles r where p.idrol=r.idRol) from Permiso p;";
            }
            String[][] permisos = null;
            if (request.getParameter("txtBusquedaPermiso") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusquedaPermiso").toString() + "%");
                permisos = Operaciones.consultar(sql, params);
            } else {
                permisos = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"ID Permiso", "Id Menu", "Id Rol"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(permisos, //array quecontiene los datos
                    "50%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            tab.setEliminable(true);//boton actualizar
            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaEliminable("/SConfiguracion?accion=eliminar");//pagina encargada de actualizacion
            tab.setPaginaModificable("/SConfiguracion?accion=modificar");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SConfiguracion?accion=modificar");//icono para modificar y eliminar
            tab.setIconoModificable("/iconos/edit.png");
            tab.setIconoEliminable("/iconos/delete.png"); //columnas seleccionables
            //tab.setColumnasSeleccionables(new int[]{1});//pie de tabla
            tab.setPie("Resultado de permisos");
            //imprime la tabla enpantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tabla", tabla01);
            request.setAttribute("valor", request.getParameter("txtBusquedaPermiso"));
        } catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    ////////////////////////////////////////////////////////////////////////TABLA USUARIOS////////////////////////////////////////////////////////
    
   private void cargarTablaUsuarios(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";
            if (request.getParameter("txtBusquedaUsuario") != null) {
                sql = "select usuario, (select r.rol from Roles r where u.idRol=r.idRol) from Usuario u where usuario like ?";
            } else {
                sql = "select usuario, (select r.rol from Roles r where u.idRol=r.idRol) from Usuario u;";
            }
            String[][] usuarios = null;
            if (request.getParameter("txtBusquedaUsuario") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusquedaUsuario").toString() + "%");
                usuarios = Operaciones.consultar(sql, params);
            } else {
                usuarios = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"Usuario", "Rol"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(usuarios, //array quecontiene los datos
                    "50%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            tab.setEliminable(true);//boton actualizar
            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaEliminable("/SConfiguracion?accion=eliminar");//pagina encargada de actualizacion
            tab.setPaginaModificable("/SConfiguracion?accion=modificar");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SConfiguracion?accion=modificar");//icono para modificar y eliminar
            tab.setIconoModificable("/iconos/edit.png");
            tab.setIconoEliminable("/iconos/delete.png"); //columnas seleccionables
            //tab.setColumnasSeleccionables(new int[]{1});//pie de tabla
            tab.setPie("Resultado de pacientes");
            //imprime la tabla enpantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tabla", tabla01);
            request.setAttribute("valor", request.getParameter("txtBusquedaUsuario"));
        } catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////LISTA MENU///////////////////////////////////////////////////////////////////
    private List<Menu> getMenu() throws SQLException{
        List<Menu> m = new ArrayList();
        try{
            ConexionPool con = new ConexionPool();
            con.conectar();
          
            Operaciones.iniciarTransaccion();
            
            
            
            Operaciones.abrirConexion(con);
            m = Operaciones.getTodos(new Menu());
            
            Operaciones.commit();
        }catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return m;
    }
    
    ////////////////////////////////////////////////////////////////////////////LISTA ROLES///////////////////////////////////////////////////////////////////
    private List<Roles> getRoles() throws SQLException{
        List<Roles> r = new ArrayList();
        try{
            ConexionPool con = new ConexionPool();
            con.conectar();
          
            
            Operaciones.abrirConexion(con);
            r = Operaciones.getTodos(new Roles());
        }catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }
    private List<Permiso> getPermisos() throws SQLException{
        List<Permiso> m = new ArrayList();
        try{
            ConexionPool con = new ConexionPool();
            con.conectar();
          
            
            Operaciones.abrirConexion(con);
            m = Operaciones.getTodos(new Permiso());
        }catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return m;
    }
    private List<Pacientes> getPacientes() throws SQLException{
        List<Pacientes> p = new ArrayList();
        try{
            ConexionPool con = new ConexionPool();
            con.conectar();
          
            
            Operaciones.abrirConexion(con);
            p = Operaciones.getTodos(new Pacientes());
        }catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }
     ////////////////////////////////////////////////////////////////////////////PERMISOS///////////////////////////////////////////////////////////////////
    protected void doGetPermisos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
        
        String accion = request.getParameter("accion");

        HttpSession s = request.getSession();
        List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
       
        List<Pacientes> pa;
        List<Menu> men;
        List<Roles> r;
                
                try {
                    /*pa= getPacientes();
                    request.setAttribute("p", pa);*/
                            
                            
                    men = getMenu();
                    request.setAttribute("menus",men);
                    
                    r= getRoles();
                    request.setAttribute("roles",r);
                } catch (SQLException ex) {
                    Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        
        
        String op = request.getParameter("op");
        if (op != null) {
            List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre() == Integer.parseInt(op)).collect(Collectors.toList());
            request.setAttribute("PermisosAsignados", PermisosAsignados);
        }
        if (accion == null) {
            if (request.getSession().getAttribute("resultado") != null) {
                request.setAttribute("resultado", request.getSession().getAttribute("resultado"));
                request.getSession().removeAttribute("resultado");
            }
            cargarTablaPermisos(request, response);

            request.getRequestDispatcher("Permiso.jsp").forward(request, response);
        } else if (accion.equals("modificar")) {
            cargarTablaPermisos(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Permiso p = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Permiso());
                request.setAttribute("permiso", p);
                request.setAttribute("modi", 1);
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("Permiso.jsp").forward(request, response);
        }else if (accion.equals("eliminar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Permiso p = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new Permiso());
                if (p.getIdpermiso()!= 0) {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                response.sendRedirect(request.getContextPath() + "/SConfiguracion");
        }
    }
    ////////////////////////////////////////////////////////////////////////////ROLES///////////////////////////////////////////////////////////////////
    protected void doGetRoles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String accion = request.getParameter("accion");

        HttpSession s = request.getSession();
        List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
        //List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre() == 0).collect(Collectors.toList());
        //request.setAttribute("MenuPrincipal", MenuPrincipal);
        String op = request.getParameter("op");
        if (op != null) {
            List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre() == Integer.parseInt(op)).collect(Collectors.toList());
            request.setAttribute("PermisosAsignados", PermisosAsignados);
        }
        if (accion == null) {
            if (request.getSession().getAttribute("resultado") != null) {
                request.setAttribute("resultado", request.getSession().getAttribute("resultado"));
                request.getSession().removeAttribute("resultado");
            }
            cargarTablaRol(request, response);

            request.getRequestDispatcher("Roles.jsp").forward(request, response);
        } else if (accion.equals("modificar")) {
            cargarTablaRol(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Roles r = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Roles());
                request.setAttribute("roles", r);
                request.setAttribute("modi", 1);
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("Roles.jsp").forward(request, response);
        }else if (accion.equals("eliminar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Roles r = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new Roles());
                if (r.getIdRol()!= 0) {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                response.sendRedirect(request.getContextPath() + "/SConfiguracion?accion=13");
        }
        
    }
    ////////////////////////////////////////////////////////////////////////////USUARIOS///////////////////////////////////////////////////////////////////
    protected void doGetUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String accion = request.getParameter("accion");

        HttpSession s = request.getSession();
        List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
        
        List<Roles> r;
                
                try {
                    r = getRoles();
                    request.setAttribute("ro",r);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        String op = request.getParameter("op");
        
        
        if (op != null) {
            List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre() == Integer.parseInt(op)).collect(Collectors.toList());
            request.setAttribute("PermisosAsignados", PermisosAsignados);
            
    
        }
        if (accion == null) {
            if (request.getSession().getAttribute("resultado") != null) {
                request.setAttribute("resultado", request.getSession().getAttribute("resultado"));
                request.getSession().removeAttribute("resultado");
                
                try{
                } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
            cargarTablaUsuarios(request, response);

            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
        } else if (accion.equals("modificar")) {
           
            cargarTablaUsuarios(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                

                Usuario u = Operaciones.get(request.getParameter("id"), new Usuario());
                request.setAttribute("usuario", u);
                request.setAttribute("modi", 1);
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
        }else if (accion.equals("eliminar")) {

            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Usuario u = Operaciones.eliminar(request.getParameter("id"), new Usuario());
                if (u.getUsuario()!= "") {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                response.sendRedirect(request.getContextPath() + "/SConfiguracion");
        }
        
        
    }
    ////////////////////////////////////////////////////////////////////////////PERMISOS///////////////////////////////////////////////////////////////////
     protected void doPostPermisos(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
         
        
        
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String idPermiso = request.getParameter("txtIdPermiso");
                String idMenu = request.getParameter("txtIdMenu");
                String idRol = request.getParameter("txtIdRol");
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    
                    if (idPermiso != null && !idPermiso.equals("")) {
                        Permiso p = new Permiso();
                        p.setIdpermiso(Integer.parseInt(idPermiso));
                        p.setIdmenu(Integer.parseInt(idMenu));
                        p.setIdrol(Integer.parseInt(idRol));
                        p = Operaciones.actualizar(p.getIdpermiso(), p);
                        if (p.getIdrol()!= 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    }else{

                    Permiso p = new Permiso();
                       /// p.setIdpermiso(Integer.parseInt(idRol));
                        p.setIdmenu(Integer.parseInt(idMenu));
                        p.setIdrol(Integer.parseInt(idRol));
                        p=Operaciones.insertar(p);
                    
                    if(p.getIdpermiso()!=0){
                         request.getSession().setAttribute("resultado", 1);
                    }
                    else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    }
                    Operaciones.commit();
                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 2);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(Permiso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/SConfiguracion");
                break;
            }
            case "eliminar": {
                break;
            }
        }
     }
     ////////////////////////////////////////////////////////////////////////////ROLES///////////////////////////////////////////////////////////////////
     protected void doPostRoles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        
        
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String idRol = request.getParameter("txtIdRol");
                String rol = request.getParameter("txtRol");
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    
                    if (idRol != null && !idRol.equals("")) {
                        Roles r = new Roles();
                    r.setIdRol(Integer.parseInt(idRol));
                    r.setRol(rol);
                        r = Operaciones.actualizar(r.getIdRol(), r);
                        if (r.getIdRol()!= 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    }else{

                    Roles r = new Roles();
                    r.setRol(rol);
                    r=Operaciones.insertar(r);
                    
                    if(r.getIdRol()!=0){
                         request.getSession().setAttribute("resultado", 1);
                    }
                    else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    }
                    Operaciones.commit();
                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 2);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/SConfiguracion?accion=13");
                break;
            }
            case "eliminar": {
                break;
            }
        }
        }
      ////////////////////////////////////////////////////////////////////////////USUARIOS///////////////////////////////////////////////////////////////////
     protected void doPostUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String hidde = request.getParameter("txtHidden");
                String idUsuario = request.getParameter("txtUsuario");
                String contra = request.getParameter("txtContrasena");
                String rol = request.getParameter("txtIdRol");
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    
                    ///if de insertar
                    ///if (idUsuario == null && !idUsuario.equals("")) {
                    if (hidde != null && !hidde.equals("")) {
                        Usuario u = new Usuario();
                        u.setUsuario(idUsuario);
                        u.setContrasena(Hash.generarHash(contra, Hash.SHA256));
                        u.setIdRol(Integer.parseInt(rol));
                        u = Operaciones.actualizar(u.getUsuario(), u);
                        if (u.getUsuario()!= "") {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                        ////
                    }
                    ///ARREGLAR
                    
                    else {
                    
                    
                        Usuario u = new Usuario();
                        u.setUsuario(idUsuario);
                        u.setContrasena(Hash.generarHash(contra, Hash.SHA256));
                        u.setIdRol(Integer.parseInt(rol));
                        u=Operaciones.insertar(u);
                    if(u.getUsuario()!=""){
                         request.getSession().setAttribute("resultado", 1);
                    }
                    else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    }
                    Operaciones.commit();
                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 2);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/SConfiguracion");
                break;
            }
            case "eliminar": {
                break;
            }
        }     
     }
     }
