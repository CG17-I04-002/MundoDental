package com.mundodental.control;

import com.mundodental.conexion.*;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Locales;
import com.mundodental.entidad.Pacientes;
import com.mundodental.operaciones.Operaciones;
import com.mundodental.utilerias.Tabla;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class SReportes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {

            request.getRequestDispatcher("reportes.jsp").forward(request, response);
        } // TOTAL DE LAS CONSULTAS
        else if (accion.equals("totalConsultas")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                List<Locales> locales = Operaciones.getTodos(new Locales());

                request.setAttribute("locales", locales);
                request.setAttribute("modi2", 1);
                request.getRequestDispatcher("reportes.jsp").forward(request, response);
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
        } // TOTAL CITAS
        else if (accion.equals("totalCitas")) {
            //List<Locales> locales = Operaciones.getTodos(new Locales());
            //request.getRequestDispatcher("reportes.jsp").forward(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                List<Locales> locales = Operaciones.getTodos(new Locales());

                request.setAttribute("locales", locales);
                request.setAttribute("modi", 1);
                request.getRequestDispatcher("reportes.jsp").forward(request, response);
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

        }
        else if (accion.equals("historial")) {
            //List<Locales> locales = Operaciones.getTodos(new Locales());
            //request.getRequestDispatcher("reportes.jsp").forward(request, response);
            cargarTablaPac(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                List<Locales> locales = Operaciones.getTodos(new Locales());

                request.setAttribute("modi3", 1);
                request.getRequestDispatcher("reportes.jsp").forward(request, response);
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

        }else if(accion.equals("historialMedico")){
            Conexion cn = new ConexionPool();
            cn.conectar();
            Connection conexion = cn.getConexion();

            ServletContext context = request.getServletContext();
            //obtenemos el reporte (archivo .jasper) en un archivo de tipo file
            File reportFile = new File(context.getRealPath("/") + "reportes/historialMedico.jasper");
            String id = request.getParameter("id");
            //configuramos los parametros en una varible de tipo Map
            //que como un array
            Map parameters = new HashMap();
            
            //parameters.put("origen", "1");
            parameters.put("Logo", context.getRealPath("/")+"img/Solo logo.png");
            
            parameters.put("Paciente", id);
            //parameters.put("FechaIni", "2019-10-14");
            //parameters.put("FechaFin", "2019-12-14");
            //parameters.put("tipoConsulta", "normal");
            //String url = request.getRequestURI().toString();
            
            //para agregar mas parametro solo llame el metodo put() varias veces
            byte[] bytes = null;
            try {
                bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
            } catch (JRException ex) {
                Logger.getLogger(SReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.setContentType("application/pdf");

            //para que el pdf se pueda ver en microsoft explorer
            //response.setHeader("Cache-Control", "cache");
            //para que aparezca el diálogo abrir/guardar
            //response.setHeader("Content-Disposition", "attachment; filename=reporte.pdf");
            response.setHeader("Content-Disposition", "inline; filename=ReporteCitas.pdf");
            response.setContentLength(bytes.length);
            try (ServletOutputStream ouputStream = response.getOutputStream()) {
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
                ouputStream.close();
            }
        }else if (accion.equals("existencias")) {
            //List<Locales> locales = Operaciones.getTodos(new Locales());
            //request.getRequestDispatcher("reportes.jsp").forward(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                List<Locales> locales = Operaciones.getTodos(new Locales());

                request.setAttribute("locales", locales);
                request.setAttribute("modi4", 1);
                request.getRequestDispatcher("reportes.jsp").forward(request, response);
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

        }else if (accion.equals("pacientes")) {
            //List<Locales> locales = Operaciones.getTodos(new Locales());
            //request.getRequestDispatcher("reportes.jsp").forward(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                List<Locales> locales = Operaciones.getTodos(new Locales());

                request.setAttribute("locales", locales);
                request.setAttribute("modi5", 1);
                request.getRequestDispatcher("reportes.jsp").forward(request, response);
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

        }
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        switch (accion) {
            case "citas_total": {

                String local = request.getParameter("cblocal");
                String ini = request.getParameter("txtFeIni");
                String fin = request.getParameter("txtFeFin");
                
                Conexion cn = new ConexionPool();
                cn.conectar();
                Connection conexion = cn.getConexion();
                ServletContext context = request.getServletContext();
                //obtenemos el reporte (archivo .jasper) en un archivo de tipo file
                File reportFile = new File(context.getRealPath("/") + "reportes/totalCitas.jasper");

                //configuramos los parametros en una varible de tipo Map
                //que como un array
                Map parameters = new HashMap();

                //parameters.put("origen", "1");
                parameters.put("Logo", context.getRealPath("/") + "img/Solo logo.png");
                parameters.put("Grafica", context.getRealPath("/") + "reportes/totalCitas_grafica.jasper");
                parameters.put("Local", local);
                parameters.put("FechaIni", ini);
                parameters.put("FechaFin", fin);
                //String url = request.getRequestURI().toString();

                //para agregar mas parametro solo llame el metodo put() varias veces
                byte[] bytes = null;
                try {
                    bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
                } catch (JRException ex) {
                    Logger.getLogger(SReportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.setContentType("application/pdf");

                //para que el pdf se pueda ver en microsoft explorer
                //response.setHeader("Cache-Control", "cache");
                //para que aparezca el diálogo abrir/guardar
                //response.setHeader("Content-Disposition", "attachment; filename=reporte.pdf");
                response.setHeader("Content-Disposition", "inline; filename=Reportes.pdf");
                response.setContentLength(bytes.length);
                try (ServletOutputStream ouputStream = response.getOutputStream()) {
                    ouputStream.write(bytes, 0, bytes.length);
                    ouputStream.flush();
                    ouputStream.close();
                }catch(Exception ex){
                    
                    Logger.getLogger(SReportes.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case "consultas_total":{
                String local = request.getParameter("cblocal");
                String ini = request.getParameter("txtFeIni");
                String fin = request.getParameter("txtFeFin");
                String tipo = request.getParameter("cbCons");
                
                Conexion cn = new ConexionPool();
                cn.conectar();
                Connection conexion = cn.getConexion();
                ServletContext context = request.getServletContext();
                //obtenemos el reporte (archivo .jasper) en un archivo de tipo file
                File reportFile = new File(context.getRealPath("/") + "reportes/totalConsultas.jasper");

                //configuramos los parametros en una varible de tipo Map
                //que como un array
                Map parameters = new HashMap();

                //parameters.put("origen", "1");
                parameters.put("Logo", context.getRealPath("/") + "img/Solo logo.png");
            parameters.put("Grafica", context.getRealPath("/")+"reportes/totalConsultas_grafica.jasper");
                parameters.put("Local", local);
                parameters.put("FechaIni", ini);
                parameters.put("FechaFin", fin);
            parameters.put("tipoConsulta", tipo);
                //String url = request.getRequestURI().toString();

                //para agregar mas parametro solo llame el metodo put() varias veces
                byte[] bytes = null;
                try {
                    bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
                } catch (JRException ex) {
                    Logger.getLogger(SReportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.setContentType("application/pdf");

                //para que el pdf se pueda ver en microsoft explorer
                //response.setHeader("Cache-Control", "cache");
                //para que aparezca el diálogo abrir/guardar
                //response.setHeader("Content-Disposition", "attachment; filename=reporte.pdf");
                response.setHeader("Content-Disposition", "inline; filename=Reportes.pdf");
                response.setContentLength(bytes.length);
                try (ServletOutputStream ouputStream = response.getOutputStream()) {
                    ouputStream.write(bytes, 0, bytes.length);
                    ouputStream.flush();
                    ouputStream.close();
                }catch(Exception ex){
                    
                    Logger.getLogger(SReportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            }
            case "existenciasProd":{
                
                String local = request.getParameter("cblocal");
                String ini = request.getParameter("txtFeIni");
                String fin = request.getParameter("txtFeFin");
            Conexion cn = new ConexionPool();
            cn.conectar();
            Connection conexion = cn.getConexion();

            ServletContext context = request.getServletContext();
            //obtenemos el reporte (archivo .jasper) en un archivo de tipo file
            File reportFile = new File(context.getRealPath("/") + "reportes/existencias.jasper");

            //configuramos los parametros en una varible de tipo Map
            //que como un array
            Map parameters = new HashMap();
            
            //parameters.put("origen", "1");
            parameters.put("Logo", context.getRealPath("/")+"img/Solo logo.png");
            parameters.put("Local", local);
            parameters.put("FechaIni", ini);
            parameters.put("FechaFin", fin);
            //parameters.put("tipoConsulta", "normal");
            //String url = request.getRequestURI().toString();
            
            //para agregar mas parametro solo llame el metodo put() varias veces
            byte[] bytes = null;
            try {
                bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
            } catch (JRException ex) {
                Logger.getLogger(SReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.setContentType("application/pdf");

            //para que el pdf se pueda ver en microsoft explorer
            //response.setHeader("Cache-Control", "cache");
            //para que aparezca el diálogo abrir/guardar
            //response.setHeader("Content-Disposition", "attachment; filename=reporte.pdf");
            response.setHeader("Content-Disposition", "inline; filename=ReporteCitas.pdf");
            response.setContentLength(bytes.length);
            try (ServletOutputStream ouputStream = response.getOutputStream()) {
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
                ouputStream.close();
            }
                    break;
        }case "pacientesAtn":{
            String local = request.getParameter("cblocal");
                String ini = request.getParameter("txtFeIni");
                String fin = request.getParameter("txtFeFin");
            Conexion cn = new ConexionPool();
            cn.conectar();
            Connection conexion = cn.getConexion();

            ServletContext context = request.getServletContext();
            //obtenemos el reporte (archivo .jasper) en un archivo de tipo file
            File reportFile = new File(context.getRealPath("/") + "reportes/pacientesAtn.jasper");

            //configuramos los parametros en una varible de tipo Map
            //que como un array
            Map parameters = new HashMap();
            
            //parameters.put("origen", "1");
            parameters.put("Logo", context.getRealPath("/")+"img/Solo logo.png");
            parameters.put("Local", local);
            parameters.put("FechaIni", ini);
            parameters.put("FechaFin", fin);
            //parameters.put("tipoConsulta", "normal");
            //String url = request.getRequestURI().toString();
            
            //para agregar mas parametro solo llame el metodo put() varias veces
            byte[] bytes = null;
            try {
                bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
            } catch (JRException ex) {
                Logger.getLogger(SReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.setContentType("application/pdf");

            //para que el pdf se pueda ver en microsoft explorer
            //response.setHeader("Cache-Control", "cache");
            //para que aparezca el diálogo abrir/guardar
            //response.setHeader("Content-Disposition", "attachment; filename=reporte.pdf");
            response.setHeader("Content-Disposition", "inline; filename=PacientesAtendidos.pdf");
            response.setContentLength(bytes.length);
            try (ServletOutputStream ouputStream = response.getOutputStream()) {
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
                ouputStream.close();
            }
            
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
            request.setAttribute("tablapacientes", tabla01);
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

}
