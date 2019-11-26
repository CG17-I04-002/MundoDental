package com.mundodental.control;

import com.mundodental.conexion.Conexion;
import com.mundodental.conexion.ConexionPool;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Locales;
import com.mundodental.entidad.Menu;
import com.mundodental.operaciones.Operaciones;
import com.mundodental.utilerias.Tabla;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SDoctores extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        HttpSession s = request.getSession();
        List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
        /*List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre() == 0).collect(Collectors.toList());
            request.setAttribute("MenuPrincipal", MenuPrincipal);*/
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
            if (request.getSession().getAttribute("user") != null) {
                request.getSession().removeAttribute("user");
            }
            cargarTabla(request, response);

            request.getRequestDispatcher("doctores.jsp").forward(request, response);
        }else if (accion.equals("modificar")) {
            cargarTabla(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Empleados e = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Empleados());
                request.getSession().setAttribute("user", e.getUsuario());
                        
                List<Locales> locales = getLocales(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("locales", locales);
                request.setAttribute("doctor", e);
                request.setAttribute("modi", 1);
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("doctores.jsp").forward(request, response);
        } 

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String nombre = request.getParameter("txtNom");
                String ape = request.getParameter("txtApe");
                String estado = request.getParameter("cbEstado");
                String local = request.getParameter("cblocal");
                String codigo = request.getParameter("codigo");
                String usuario = request.getSession().getAttribute("user").toString();
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    Empleados e = new Empleados();
                    e.setIdEmpleado(Integer.parseInt(codigo));
                    e.setNombres(nombre);
                    e.setApellidos(ape);
                    e.setEstado(estado);
                    e.setIdLocal(Integer.parseInt(local));
                    e.setUsuario(usuario);
                    e = Operaciones.actualizar(Integer.parseInt(codigo),e);
                    
                    if (e.getIdEmpleado() != 0) {
                        request.getSession().setAttribute("resultado", 1);
                    } else {
                        request.getSession().setAttribute("resultado", 0);
                    }
                    Operaciones.commit();
                    
                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 0);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/SDoctores");
                break;
            }
            
        }
    }

    private void cargarTabla(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";
            if (request.getParameter("txtBusqueda") != null) {
                sql = "SELECT e.nombres, e.apellidos, e.estado,  l.local FROM Empleados e, Locales l, Usuario u WHERE e.nombres LIKE ? AND e.idLocal = l.idLocal AND e.usuario =  u.usuario AND u.idRol =3 ; ";
            } else {
                sql = "SELECT e.idEmpleado,e.nombres, e.apellidos, e.estado,  l.local FROM Empleados e, Locales l, Usuario u WHERE e.idLocal = l.idLocal AND e.usuario =  u.usuario AND u.idRol =3 ";
            }
            String[][] doctores = null;
            if (request.getParameter("txtBusqueda") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                doctores = Operaciones.consultar(sql, params);
            } else {
                doctores = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"Codigo", "Nombre", "Apellido", "Estado", "Local"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(doctores, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaModificable("/SDoctores?accion=modificar");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SDoctores?accion=modificar");//icono para modificar y eliminar
            tab.setIconoModificable("/iconos/edit.png");
            tab.setPie("Resultado de doctores");
            //imprime la tabla en pantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tabla", tabla01);
            request.setAttribute("valor", request.getParameter("txtBusqueda"));
        } catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    private List<Locales> getLocales(Integer id) throws SQLException {
        List<Locales> locales = new ArrayList();
        try {
            String sql = "SELECT * FROM Locales ";
            
            String[][] rs = Operaciones.consultar(sql, null);
            for (int i = 0; i < rs[0].length; i++) {
                Locales l = new Locales(Integer.parseInt(rs[0][i]), rs[1][i]);
                locales.add(l);
            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return locales;
    }

}
