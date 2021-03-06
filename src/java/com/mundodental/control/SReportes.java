package com.mundodental.control;

import com.mundodental.conexion.*;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Locales;
import com.mundodental.operaciones.Operaciones;
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
            Conexion cn = new ConexionPool();
            cn.conectar();
            Connection conexion = cn.getConexion();

            ServletContext context = request.getServletContext();

            //obtenemos el reporte (archivo .jasper) en un archivo de tipo file
            File reportFile = new File(context.getRealPath("/") + "reportes/Reportes.jasper");
            //configuramos los parametros en una varible de tipo Map
            //que como un array
            Map parameters = new HashMap();
            parameters.put("origen", "1");
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
            response.setHeader("Content-Disposition", "inline; filename=Reporte.pdf");
            response.setContentLength(bytes.length);
            try (ServletOutputStream ouputStream = response.getOutputStream()) {
                ouputStream.write(bytes, 0, bytes.length);
                ouputStream.flush();
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
            case "eliminar": {
                break;
            }
        }

    }

}
