package com.mundodental.control;

import com.mundodental.conexion.Conexion;
import com.mundodental.conexion.ConexionPool;
import com.mundodental.entidad.Menu;
import com.mundodental.entidad.Pacientes;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Locales;
import com.mundodental.entidad.Permiso;
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

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //// processRequest(request, response);
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
                    cargarTablaUsuarios(request, response);
                    try {
                        Conexion conn = new ConexionPool();
                        conn.conectar();
                        Operaciones.abrirConexion(conn);
                        Operaciones.iniciarTransaccion();
                        List<Roles> roles = getRoles();
                        List<Locales> locales = Operaciones.getTodos(new Locales());
                        request.setAttribute("ro", roles);
                        request.setAttribute("local", locales);

                        request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
                    } catch (Exception ex) {
                        try {
                            Operaciones.rollback();
                        } catch (SQLException ex1) {
                            Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    } finally {
                        try {
                            Operaciones.cerrarConexion();
                        } catch (SQLException ex) {
                            Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "13":
                    cargarTablaRol(request, response);
                    request.getRequestDispatcher("Roles.jsp").forward(request, response);
                    break;
                case "14":
                    cargarTablaRolPermiso(request, response);
                    request.getRequestDispatcher("Permiso.jsp").forward(request, response);
                    break;
                case "modificar_user":
                    cargarTablaUsuarios(request, response);
                    try {
                        Conexion conn = new ConexionPool();
                        conn.conectar();
                        Operaciones.abrirConexion(conn);
                        Operaciones.iniciarTransaccion();
                        Usuario u = Operaciones.get(request.getParameter("id"), new Usuario());
                        Empleados e = Operaciones.get(getIdEmpleado(request.getParameter("id")), new Empleados());
                        request.setAttribute("empleado", e);

                        request.setAttribute("usuario", u);
                        request.setAttribute("modi", 1);
                        List<Roles> roles = getRoles();
                        List<Locales> locales = Operaciones.getTodos(new Locales());
                        request.setAttribute("ro", roles);
                        request.setAttribute("local", locales);
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

                    break;
                case "eliminar_user":
                    try {
                        Conexion conn = new ConexionPool();
                        conn.conectar();
                        Operaciones.abrirConexion(conn);
                        Operaciones.iniciarTransaccion();
                        Empleados e = Operaciones.eliminar(getIdEmpleado(request.getParameter("id")), new Empleados());
                        Usuario u = Operaciones.eliminar(request.getParameter("id"), new Usuario());
                        Operaciones.commit();
                        request.getSession().setAttribute("resultado", 1);

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
                    response.sendRedirect(request.getContextPath() + "/SConfiguracion?accion=12");
                    break;

                case "modificar_rol":
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
                    break;
                case "eliminar_rol":
                    try {
                        Conexion conn = new ConexionPool();
                        conn.conectar();
                        Operaciones.abrirConexion(conn);
                        Operaciones.iniciarTransaccion();
                        if (Integer.parseInt(request.getParameter("id")) == 1) {

                            request.getSession().setAttribute("resultado", 0);
                        } else {

                            Roles r = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new Roles());
                            if (r.getIdRol() != 0) {
                                request.getSession().setAttribute("resultado", 1);
                            } else {
                                request.getSession().setAttribute("resultado", 0);
                            }
                            Operaciones.commit();
                        }
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
                    break;
                case "modificar_permiso":
                    if (Integer.parseInt(request.getParameter("id")) == 1) {
                        response.sendRedirect(request.getContextPath() + "/SConfiguracion?accion=14");
                    } else {
                        cargarTablaRol(request, response);
                        try {
                            Conexion conn = new ConexionPool();
                            conn.conectar();
                            Operaciones.abrirConexion(conn);
                            Operaciones.iniciarTransaccion();

                            Roles r = Operaciones.get(request.getParameter("id"), new Roles());
                            List<Menu> menu = getMenu();
                            List<Permiso> permiso = getPermisos(Integer.parseInt(request.getParameter("id")));
                            request.setAttribute("rol", r);
                            request.setAttribute("permiso", permiso);

                            request.setAttribute("menu", menu);

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
                        request.getRequestDispatcher("Permiso.jsp").forward(request, response);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar_user": {
                String hidde = request.getParameter("txtUserh");
                String idUsuario = request.getParameter("txtUser");
                String contra = request.getParameter("txtContrasena");
                String rol = request.getParameter("txtIdRol");
                String nom = request.getParameter("txtNom");
                String ape = request.getParameter("txtApe");
                String estado = request.getParameter("cbEstado");
                String tel = request.getParameter("txtTel");
                String local = request.getParameter("cbLocal");

                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();

                    if (hidde != null && !hidde.equals("")) {
                        Usuario u = new Usuario();
                        u.setUsuario(idUsuario);
                        if (contra != null && !contra.equals("")) {
                            u.setContrasena(Hash.generarHash(contra, Hash.SHA256));
                        } else {
                            Usuario aux = Operaciones.get(hidde, new Usuario());
                            u.setContrasena(aux.getContrasena());
                        }
                        u.setIdRol(Integer.parseInt(rol));
                        u = Operaciones.actualizar(hidde, u);
                        Empleados em = new Empleados();
                        em.setNombres(nom);
                        em.setApellidos(ape);
                        em.setEstado(estado);
                        em.setIdLocal(Integer.parseInt(local));
                        em.setTelefono(tel);
                        em.setUsuario(idUsuario);
                        em = Operaciones.actualizar(getIdEmpleado(u.getUsuario()), em);

                    } else {

                        Usuario u = new Usuario();
                        u.setUsuario(idUsuario);
                        u.setContrasena(Hash.generarHash(contra, Hash.SHA256));
                        u.setIdRol(Integer.parseInt(rol));
                        Empleados em = new Empleados();

                        u = Operaciones.insertar(u);

                        em.setNombres(nom);
                        em.setApellidos(ape);
                        em.setEstado(estado);
                        em.setIdLocal(Integer.parseInt(local));
                        em.setTelefono(tel);
                        em.setUsuario(idUsuario);
                        em = Operaciones.insertar(em);
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
                response.sendRedirect(request.getContextPath() + "/SConfiguracion?accion=12");
                break;
            }
            case "insertar_modificar_rol": {
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
                        if (r.getIdRol() != 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    } else {

                        Roles r = new Roles();
                        r.setRol(rol);
                        r = Operaciones.insertar(r);

                        if (r.getIdRol() != 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
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

            case "insertar_permiso": {

                String idRol = request.getParameter("txtIdRol");
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();

                    List<Menu> menu = getMenu();

                    for (int i = 0; i < menu.size(); i++) {
                        String par = "cb" + (i + 1);
                        String c = request.getParameter(par);
                        if (c == null) {
                            int idPer = getIdPermiso(Integer.parseInt(idRol), menu.get(i).getIdmenu());
                            if (idPer > 0) {
                                Permiso p = Operaciones.eliminar(idPer, new Permiso());
                            }
                        } else {
                            int idPer = getIdPermiso(Integer.parseInt(idRol), menu.get(i).getIdmenu());
                            if (idPer < 1) {
                                Permiso p = new Permiso();
                                p.setIdmenu(menu.get(i).getIdmenu());
                                p.setIdrol(Integer.parseInt(idRol));
                                p = Operaciones.insertar(p);
                            }
                        }

                        Operaciones.commit();
                    }
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
                response.sendRedirect(request.getContextPath() + "/SConfiguracion?accion=14");
                break;
            }

            case "eliminar": {
                break;
            }
        }
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
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            tab.setEliminable(true);//boton actualizar
            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaEliminable("/SConfiguracion?accion=eliminar_rol");//pagina encargada de actualizacion
            tab.setPaginaModificable("/SConfiguracion?accion=modificar_rol");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SConfiguracion?accion=modificar_rol");//icono para modificar y eliminar
            tab.setIconoModificable("/iconos/edit.png");
            tab.setIconoEliminable("/iconos/delete.png"); //columnas seleccionables
            //tab.setColumnasSeleccionables(new int[]{1});//pie de tabla
            tab.setPie("Resultado de roles");
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

    private void cargarTablaRolPermiso(HttpServletRequest request, HttpServletResponse response) {
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
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar

            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaModificable("/SConfiguracion?accion=modificar_permiso");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SConfiguracion?accion=modificar_permiso");//icono para modificar y eliminar
            tab.setIconoModificable("/iconos/edit.png");
            //tab.setColumnasSeleccionables(new int[]{1});//pie de tabla
            tab.setPie("Resultado de roles");
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
                    "100%", //ancho de la tabla px | % 
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
                sql = "SELECT u.usuario,r.rol, CONCAT(e.nombres,' ', e.apellidos), e.estado, l.local, e.telefono  FROM Empleados e, Usuario u, Roles r, Locales l WHERE NOT r.idRol = 1 AND   e.usuario = u.usuario AND u.idRol = r.idRol AND e.idLocal = l.idLocal AND usuario like ?";
            } else {
                sql = "SELECT u.usuario,r.rol, CONCAT(e.nombres,' ', e.apellidos), e.estado, l.local, e.telefono  FROM Empleados e, Usuario u, Roles r, Locales l WHERE NOT r.idRol = 1 AND e.usuario = u.usuario AND u.idRol = r.idRol AND e.idLocal = l.idLocal";
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
            String[] cabeceras = new String[]{"Usuario", "Rol", "Empleado", "Estado", "Local", "Telefono"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(usuarios, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            tab.setEliminable(true);//boton actualizar
            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaEliminable("/SConfiguracion?accion=eliminar_user");//pagina encargada de actualizacion
            tab.setPaginaModificable("/SConfiguracion?accion=modificar_user");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SConfiguracion?accion=modificar_user");//icono para modificar y eliminar
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

    
    private int getIdEmpleado(String nombre) throws SQLException {
        int id = 0;
        try {
            String sql = "SELECT idEmpleado FROM empleados WHERE usuario = ?  ";
            List<Object> param = new ArrayList();
            param.add(nombre);
            String[][] rs = Operaciones.consultar(sql, param);
            id = Integer.parseInt(rs[0][0]);

        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return id;
    }

    private List<Roles> getRoles() throws SQLException {
        List<Roles> roles = new ArrayList();
        try {
            String sql = "SELECT * FROM Roles WHERE NOT idRol =1 ";

            String[][] rs = Operaciones.consultar(sql, null);
            for (int i = 0; i < rs[0].length; i++) {
                Roles r = new Roles();
                r.setIdRol(Integer.parseInt(rs[0][i]));
                r.setRol(rs[1][i]);
                roles.add(r);

            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return roles;
    }

    private List<Menu> getMenu() throws SQLException {
        List<Menu> menu = new ArrayList();
        try {
            String sql = "SELECT * FROM menu WHERE idpadre IS NULL";

            String[][] rs = Operaciones.consultar(sql, null);
            for (int i = 0; i < rs[0].length; i++) {
                Menu m = new Menu();
                m.setIdmenu(Integer.parseInt(rs[0][i]));
                m.setMenu(rs[1][i]);
                menu.add(m);

            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return menu;
    }

    private int getIdPermiso(int rol, int p) throws SQLException {
        int id = 0;
        try {
            String sql = "SELECT * FROM permiso WHERE idmenu = ?  AND idrol = ? ";
            List<Object> param = new ArrayList();
            param.add(p);
            param.add(rol);
            String[][] rs = Operaciones.consultar(sql, param);
            if (rs.length > 0) {
                id = Integer.parseInt(rs[0][0]);
            }

        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return id;
    }
    private List<Permiso> getPermisos(int rol) throws SQLException {
        List<Permiso> permiso = new ArrayList();
        try {
            String sql = "SELECT * FROM permiso WHERE idrol = ? ";
            List<Object> param = new ArrayList();
           
            param.add(rol);
            String[][] rs = Operaciones.consultar(sql, param);
            for (int i = 0; i < rs[0].length; i++) {
                Permiso p = new Permiso();
                p.setIdpermiso(Integer.parseInt(rs[0][i]));
                p.setIdmenu(Integer.parseInt(rs[1][i]));
                p.setIdrol(Integer.parseInt(rs[2][i]));
                permiso.add(p);

            }

        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return permiso;
    }

}
