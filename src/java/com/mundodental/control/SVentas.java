package com.mundodental.control;

import com.mundodental.conexion.Conexion;
import com.mundodental.conexion.ConexionPool;
import com.mundodental.entidad.Locales;
import com.mundodental.entidad.Menu;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Facturas;
import com.mundodental.entidad.Operaciones_Detalles;
import com.mundodental.entidad.Pacientes;
import com.mundodental.entidad.Productos;
import com.mundodental.entidad.operaciones;
import com.mundodental.operaciones.Operaciones;
import com.mundodental.utilerias.Tabla;
import java.io.IOException;
import java.math.BigDecimal;
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

public class SVentas extends HttpServlet {

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
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            List<Locales> locales;
            locales = getLocales();
            
            request.setAttribute("locales", locales);
        } catch (SQLException ex) {
            Logger.getLogger(SVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarTablaPac(request, response);
        cargarTablap(request, response);
        if (accion == null) {
            if (request.getSession().getAttribute("resultado") != null) {
                request.setAttribute("resultado", request.getSession().getAttribute("resultado"));
                request.getSession().removeAttribute("resultado");
            }
            request.getRequestDispatcher("realizarVentas.jsp").forward(request, response);
        } else if (accion.equals("mostrar")) {
            request.getRequestDispatcher("mostrarVentas.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "insertar_modificar": {
                String idLocal = request.getParameter("cblocal");
                String fecha = request.getParameter("txtfecha");
                String flujo = request.getParameter("txtflujo");
                String monto = request.getParameter("txtTotal");
                String idpac = request.getParameter("txtIdp");
                

                String[] idProducto = request.getParameterValues("id");
                // String[] Producto = request.getParameterValues("producto");
                String[] costo = request.getParameterValues("costo");
                String[] pventa = request.getParameterValues("precioVenta");
                String[] cantidad = request.getParameterValues("cantidad");

                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(fecha);
                    Operaciones_Detalles o = new Operaciones_Detalles();

                    
                    java.sql.Date d = new java.sql.Date(date.getTime());
                    operaciones op = new operaciones();
                    op.setFecha(d);
                    op.setIdLocal(Integer.parseInt(idLocal));
                    op.setFlujo(flujo);
                    op.setTransaccion("Venta");
                    op.setMonto(BigDecimal.valueOf(Double.parseDouble(monto)));

                    op = Operaciones.insertar(op);
                    for (int i = 0; i < idProducto.length; i++) {
                        Operaciones_Detalles opd = new Operaciones_Detalles();
                        opd.setIdOperacion(op.getIdOperacion());
                        opd.setIdProducto(Integer.parseInt(idProducto[i]));
                        opd.setCostoCompra(BigDecimal.valueOf(Double.parseDouble(costo[i])));
                        opd.setPrecioVenta(BigDecimal.valueOf(Double.parseDouble(pventa[i])));
                        opd.setCantidad(Integer.parseInt(cantidad[i]));
                        opd = Operaciones.insertar(opd);

                    }
                    Facturas f = new Facturas();
                    f.setExpediente(Integer.parseInt(idpac));
                    f.setIdOperacion(op.getIdOperacion());
                    f = Operaciones.insertar(f);
                    Operaciones.commit();

                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(SCompras.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 0);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(SCompras.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/SVentas");
                break;
            }
            case "eliminar": {
                break;
            }
        }

    }

    private void cargarTablap(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";

            sql = "  SELECT p.idProducto, p.nombre,MAX(od.costoCompra), MAX(od.precioVenta), SUM(CASE WHEN o.transaccion = 'Compra' THEN od.cantidad ELSE -od.cantidad END) FROM Operaciones o, Operaciones_Detalles od, Productos p, Locales l WHERE o.idOperacion = od.idOperacion AND p.idProducto = od.idProducto AND o.idLocal = l.idLocal AND l.idlocal= ? GROUP BY p.idProducto, p.nombre";
            String[][] productos = null;
            
            String user = (String) request.getSession().getAttribute("Usuario");
            Empleados e = new Empleados();
            e = Operaciones.get(getIdEmpleado(user), new Empleados());
            List<Object> param = new ArrayList();
            param.add(e.getIdLocal());
            productos = Operaciones.consultar(sql, param);
            
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"ID Producto", "Nombre","Costo","Precio", "Existencia"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(productos, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar

            tab.setMetodoFilaSeleccionable("_SeleccionarP_");
            tab.setPageContext(request.getContextPath());
            tab.setFilaSeleccionable(true);//icono para modificar y eliminar// 
            tab.setIconoModificable("/iconos/edit.png");// 
            tab.setIconoEliminable("/iconos/delete.png");//columnas seleccionables
            tab.setPie("Resultado de productos");

            //imprime la tabla en pantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tabla", tabla01);
            request.setAttribute("valor", request.getParameter("txtBusqueda"));
        } catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

            tab.setMetodoFilaSeleccionable("_Seleccionarpacientes_");
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
}
