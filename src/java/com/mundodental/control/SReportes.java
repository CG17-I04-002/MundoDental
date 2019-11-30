package com.mundodental.control;

import com.mundodental.conexion.*;
import com.mundodental.entidad.Empleados;
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
    /*
     //to get images to display in report, pass their relative path as input stream and add to HashMap
        //there must be one stream and one HashMap per image
        InputStream imgInputStream = this.getClass().getResourceAsStream("/reports/omacLogo.jpg");
        InputStream imgInputStream2 = this.getClass().getResourceAsStream("/reports/omacLogo.jpg");
        parameters.put("omacLogo", imgInputStream);
        parameters2.put("omacLogo", imgInputStream2);

        InputStream jasper1 = this.getClass().getResourceAsStream("/reports/OmacYTDReportFinalpg1.jasper");
        InputStream jasper2 = this.getClass().getResourceAsStream("/reports/OmacYTDReportFinalpg2.jasper");

        JasperPrint jp1 = JasperFillManager.fillReport(jasper1, parameters,new JRBeanCollectionDataSource(ie.orderofmalta.BeanFactory.getCalcs()));
        JasperPrint jp2 = JasperFillManager.fillReport(jasper2, parameters2, new JRBeanCollectionDataSource(ie.orderofmalta.BeanFactory.getCalcs()));
    
    */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if(accion == null){
            //request.getRequestDispatcher("reportes.jsp").forward(request, response);
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
            parameters.put("Logo", context.getRealPath("/")+"img/Logo.png");
            parameters.put("Grafica", context.getRealPath("/")+"reportes/totalCitas_grafica.jasper");
            parameters.put("Local", "1");
            parameters.put("FechaIni", "2019-11-14");
            parameters.put("FechaFin", "2019-11-24");
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
            }
        }
        // TOTAL DE LAS CONSULTAS
        else if(accion.equals("totalConsultas")) {
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
        }
        // TOTAL CITAS
        else if(accion.equals("totalCitas")){
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
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    private List<Empleados> getDoctores() throws SQLException {
        List<Empleados> doctores = new ArrayList();
        try {
            String sql = "SELECT idEmpleado, nombres, apellidos   FROM Empleados";
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

}
