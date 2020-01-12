package com.mundodental.control;

import com.mundodental.conexion.Conexion;
import com.mundodental.conexion.ConexionPool;
import com.mundodental.entidad.Citas;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Locales;
import com.mundodental.entidad.Membresias;
import com.mundodental.entidad.Membresias_Beneficiarios;
import com.mundodental.entidad.Menu;
import com.mundodental.entidad.Productos;
import com.mundodental.entidad.Operaciones_Detalles;
import com.mundodental.entidad.Pacientes;
import com.mundodental.entidad.operaciones;
import com.mundodental.operaciones.Operaciones;
import com.mundodental.utilerias.Tabla;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
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

public class SMembresias extends HttpServlet {

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
     /*   try {
            List<Pacientes> pacien;
            pacien = getLocales();
            request.setAttribute("pacientes", pacien);
        } catch (SQLException ex) {
            Logger.getLogger(SCompras.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        cargarTablaPacientes(request, response);
        cargarTablaBeneficiarios(request, response);
        cargarTablaMembresiasYBeneficiarios(request, response);
        cargarTablaSoloBeneficiarios(request,response);
        if (accion == null) {
            request.getRequestDispatcher("membresia.jsp").forward(request, response);
        } 
            else if (accion.equals("mostrar")) {
            request.getRequestDispatcher("mostrarMembresias.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "insertar_modificar": {
                String expediente = request.getParameter("txtexpediente");
                String nombre = request.getParameter("txtNombre");
                String fechaRegistro = request.getParameter("txtfechaRegistro");
                String fechaVencimiento = request.getParameter("txtfechaVencimiento");
                String monto = request.getParameter("txtMonto");
                String porcentaje = request.getParameter("txtPorcentaje");

                String[] idMembresia = request.getParameterValues("id");
                // String[] Producto = request.getParameterValues("producto");
               
                

                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(fechaRegistro);

                    
                    java.sql.Date d = new java.sql.Date(date.getTime());
                    Membresias m = new Membresias();
                    m.setFechaRegistro(d);
                    
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                    Date date2 = sdf2.parse(fechaVencimiento);

                    
                    java.sql.Date d2 = new java.sql.Date(date2.getTime());
                    m.setFechaVencimiento(d2);
                    
                    
                    m.setExpediente(Integer.parseInt(expediente));
                    
                    m.setMonto(BigDecimal.valueOf(Double.parseDouble(monto)));
                    
                    m.setPorcentaje(BigDecimal.valueOf(Double.parseDouble(porcentaje)));
                    
                    m = Operaciones.insertar(m);
                    for (int i = 0; i < idMembresia.length; i++) {
                        Membresias_Beneficiarios mb = new Membresias_Beneficiarios();
                        mb.setIdMembresia(m.getIdMembresia());
                        mb.setExpediente(Integer.parseInt(idMembresia[i]));
                        
                        mb = Operaciones.insertar(mb);

                    }

                    Operaciones.commit();

                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(SMembresias.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 0);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(SMembresias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/SMembresias");
                break;
            }
            case "eliminar": {
                break;
            }
        }
    }

    private void cargarTablaPacientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";

            sql = "select expediente, nombres, apellidos from Pacientes";
            String[][] pacientes = null;
            if (request.getParameter("txtBusqueda") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                pacientes = Operaciones.consultar(sql, params);
            } else {
                pacientes = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"Expediente", "Nombres", "Apellidos"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(pacientes, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar

            tab.setMetodoFilaSeleccionable("_Seleccionarp_");
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
    private void cargarTablaBeneficiarios(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";

            sql = "select expediente, nombres, apellidos from Pacientes";
            String[][] pacientes = null;
            if (request.getParameter("txtBusqueda") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                pacientes = Operaciones.consultar(sql, params);
            } else {
                pacientes = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"Expediente", "Nombres", "Apellidos"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(pacientes, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar

            tab.setMetodoFilaSeleccionable("_Seleccionarb_");
            tab.setPageContext(request.getContextPath());
            tab.setFilaSeleccionable(true);//icono para modificar y eliminar// 
            tab.setIconoModificable("/iconos/edit.png");// 
            tab.setIconoEliminable("/iconos/delete.png");//columnas seleccionables
            tab.setPie("Resultado de pacientes");

            //imprime la tabla en pantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tablab", tabla01);
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
     private void cargarTablaMembresiasYBeneficiarios(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";
            if(request.getParameter("txtBusqueda")!=null){
                sql = "select m.idMembresia, m.fechaRegistro, m.fechaVencimiento, m.monto, mb.expediente from  Membresias m, Membresias_Beneficiarios mb where m.idMembresia=mb.idMembresia and m.idMembresia=?;";
            }
            else{
            sql = "select m.idMembresia, m.fechaRegistro, m.fechaVencimiento, m.monto, porcentaje, (select p.nombres from Pacientes p where p.expediente=m.expediente) from  Membresias m, Membresias_Beneficiarios mb where m.expediente=mb.expediente;";
            }
            String[][] compras = null;
            if (request.getParameter("txtBusqueda") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                compras = Operaciones.consultar(sql, params);
            } else {
                compras = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"ID MEMBRESIA", "FECHA REGISTRO", "FECHA VENCIMIENTO", "MONTO", "PORCENTAJE", "BENEFICIARIO"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(compras, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            /*tab.setEliminable(true);//boton actualizar
            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaEliminable("/SMembresias?accion=eliminar");//pagina encargada de actualizacion
            tab.setPaginaModificable("/SMembresias?accion=modificar");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SMembresias?accion=modificar");//icono para modificar y eliminar
            tab.setIconoModificable("/iconos/edit.png");
            tab.setIconoEliminable("/iconos/delete.png"); //columnas seleccionables*/
            tab.setColumnasSeleccionables(new int[]{5});
            tab.setPie("Resultado de expedientes");

            //imprime la tabla en pantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tablaMembresiaYBeneficiario", tabla01);
            request.setAttribute("valor", request.getParameter("txtBusqueda"));
        } catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SMembresias.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(SMembresias.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
     private void cargarTablaSoloBeneficiarios(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";

            sql = "select expediente, nombres from Pacientes";
            String[][] pacientes = null;
            if (request.getParameter("txtBusqueda") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                pacientes = Operaciones.consultar(sql, params);
            } else {
                pacientes = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"Expediente", "Nombres"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(pacientes, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar

            tab.setMetodoFilaSeleccionable("_SeleccionarSoloB_");
            tab.setPageContext(request.getContextPath());
            tab.setFilaSeleccionable(true);//icono para modificar y eliminar// 
            tab.setIconoModificable("/iconos/edit.png");// 
            tab.setIconoEliminable("/iconos/delete.png");//columnas seleccionables
            tab.setPie("Resultado de pacientes");

            //imprime la tabla en pantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tablasolobene", tabla01);
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