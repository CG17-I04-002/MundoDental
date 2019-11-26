package com.mundodental.control;

import com.mundodental.conexion.Conexion;
import com.mundodental.conexion.ConexionPool;
import com.mundodental.entidad.Citas;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Locales;
import com.mundodental.entidad.Menu;
import com.mundodental.entidad.Pacientes;
import com.mundodental.operaciones.Operaciones;
import com.mundodental.utilerias.Tabla;
import java.io.IOException;
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

public class SCitas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession s = request.getSession();
        List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
        String op = request.getParameter("op");
        if (op != null) {
            List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre() == Integer.parseInt(op)).collect(Collectors.toList());
            request.setAttribute("PermisosAsignados", PermisosAsignados);
        }
        
        cargarTablaPac(request, response);
        cargarTablaCitas(request, response);
        if (accion == null) {
            
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                      
                List<Empleados> empleados = getDoctores();
                List<Locales> locales = getLocales();
                request.setAttribute("empleados", empleados);
                request.setAttribute("locales", locales);
                
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
            request.getRequestDispatcher("citas.jsp").forward(request, response);
        }else if (accion.equals("modificar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Citas c = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Citas());
                Pacientes p = Operaciones.get(c.getExpediente(), new Pacientes());
                List<Empleados> empleados = getDoctores();
                List<Locales> locales = getLocales();
                request.setAttribute("empleados", empleados);
                request.setAttribute("locales", locales);
                request.setAttribute("citas", c);
                request.setAttribute("paciente", p);
                
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("citas.jsp").forward(request, response);
        }else if (accion.equals("eliminar")) {

            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Citas c = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new Citas());
                if (c.getIdCita() != 0) {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                response.sendRedirect(request.getContextPath() + "/SCitas");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String idPac = request.getParameter("txtId");
                String idDoc = request.getParameter("cbDoctor");
                String fecha = request.getParameter("txtFecha");
                String local = request.getParameter("cblocal");
                String estado = request.getParameter("cbEstado");
                String cita = request.getParameter("txtIdCita");
                
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    Citas citas = new Citas();
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(fecha);
                    java.sql.Date d = new java.sql.Date(date.getTime());
                    citas.setFecha(d);
                    citas.setIdEmpleadoDoctor(Integer.parseInt(idDoc));
                    citas.setExpediente(Integer.parseInt(idPac));
                    citas.setEstado(estado);
                    citas.setIdLocal(Integer.parseInt(local));
                    if(cita!=null && !cita.equals("")){
                       citas.setIdCita(Integer.parseInt(cita));
                       citas = Operaciones.actualizar(citas.getIdCita(),new Citas());
                    }else{
                        citas = Operaciones.insertar(citas);
                    }
                    Operaciones.commit();
                    
                    
                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 0);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/SCitas");
                break;
            }
            case "eliminar": {
                break;
            }
        }
    }

    private void cargarTablaPac(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";
            
            sql = "select expediente, nombres, apellidos from pacientes";
            String[][] pacientes = null;
            if (request.getParameter("txtBusqueda") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                pacientes = Operaciones.consultar(sql, params);
            } else {
                pacientes = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"Expediente", "Nombre", "Apellido"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(pacientes, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            
            
            tab.setMetodoFilaSeleccionable("_Seleccionar_");
                tab.setPageContext(request.getContextPath());
                tab.setFilaSeleccionable(true);//icono para modificar y eliminar// 
                tab.setIconoModificable("/iconos/edit.png");// 
                tab.setIconoEliminable("/iconos/delete.png");//columnas seleccionables
            tab.setPie("Resultado de pacientes");
            
            
            //imprime la tabla en pantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tabla", tabla01);
            request.setAttribute("valor", request.getParameter("txtBusqueda"));
        } catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void cargarTablaCitas(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";
            
            sql = "SELECT c.idCita, CONCAT(p.nombres, ' ', p.apellidos) Paciente, CONCAT(e.nombres, ' ', e.apellidos) Empleado,c.fecha, c.estado, l.local  FROM Citas c, Pacientes p, Empleados e, Locales l WHERE p.expediente = c.expediente AND e.idEmpleado = c.idEmpleadoDoctor AND c.idLocal =l.idLocal";
            String[][] citas = null;
            if (request.getParameter("txtBusqueda") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                citas = Operaciones.consultar(sql, params);
            } else {
                citas = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"idCita", "Paciente", "Empleado", "Fecha", "Estado", "Local"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(citas, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            tab.setEliminable(true);//boton actualizar
            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaEliminable("/SCitas?accion=eliminar");//pagina encargada de actualizacion
            tab.setPaginaModificable("/SCitas?accion=modificar");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SCitas?accion=modificar");//icono para modificar y eliminar
            tab.setIconoModificable("/iconos/edit.png");
            tab.setIconoEliminable("/iconos/delete.png"); //columnas seleccionables
            tab.setPie("Resultado de pacientes");
            
            
            //imprime la tabla en pantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tablaCitas", tabla01);
            request.setAttribute("valor", request.getParameter("txtBusqueda"));
        } catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private List<Empleados> getDoctores() throws SQLException {
        List<Empleados> doctores = new ArrayList();
        try {
            String sql = "SELECT idEmpleado, nombres, apellidos   FROM Empleados ";
            
            String[][] rs = Operaciones.consultar(sql, null);
            for (int i = 0; i < rs[0].length; i++) {
                Empleados e = new Empleados();
                e.setIdEmpleado(Integer.parseInt(rs[0][i]));
                e.setNombres(rs[1][i]);
                e.setApellidos(rs[2][i]);
                doctores.add(e);
                
            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return doctores;
    }
    private List<Locales> getLocales() throws SQLException {
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
