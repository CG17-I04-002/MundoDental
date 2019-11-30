package com.mundodental.control;

import com.mundodental.control.SCitas;
import com.mundodental.entidad.Productos;
import com.mundodental.conexion.Conexion;
import com.mundodental.conexion.ConexionPool;
import com.mundodental.entidad.Categorias;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Menu;
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

public class SProductos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        HttpSession s = request.getSession();
        List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
        //List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre() == 0).collect(Collectors.toList());
        //request.setAttribute("MenuPrincipal", MenuPrincipal);
        
        List<Productos> prod;
        List<Empleados> em;
        List<Categorias> ca;
                
                try {
                    ca = getCategorias();
                    request.setAttribute("cat",ca);
                    prod= getProductos();
                    request.setAttribute("produ",prod);
                    
                    em=getEmpleados();
                    request.setAttribute("emple", em);
                } catch (SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
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
               /* List<Categorias> cate = Operaciones.getTodos(new Categorias());
                request.setAttribute("categorias", cate);*/
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
            cargarTabla(request, response);

            request.getRequestDispatcher("productos.jsp").forward(request, response);
        } else if (accion.equals("modificar")) {
            /*List<Categorias> ca;
            try{
                ca=getCategorias();
                request.setAttribute("cat", ca);
            }catch(SQLException ex){
                Logger.getLogger(SProductos.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            cargarTabla(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                
/*                List<Categorias> cate = Operaciones.getTodos(new Categorias());
                request.setAttribute("categorias", cate);*/
                Productos p = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Productos());
                request.setAttribute("producto", p);
                request.setAttribute("modi", 1);
                Operaciones.commit();
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
            request.getRequestDispatcher("productos.jsp").forward(request, response);
        }else if (accion.equals("eliminar")) {

            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Productos p = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new Productos());
                if (p.getIdProducto()!= 0) {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                response.sendRedirect(request.getContextPath() + "/SProductos");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                ////////////////////////////////////////ARREGLAR
                String idProducto = request.getParameter("txtIdProducto");
                String nombre = request.getParameter("txtNombreProducto");
                String detalle = request.getParameter("txtDetalleProducto");
                String categoria = request.getParameter("txtIdCategoria");
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    
                    if (idProducto != null && !idProducto.equals("")) {
                        Productos p = new Productos();
                        p.setIdProducto(Integer.parseInt(idProducto));
                        p.setNombre(nombre);
                        p.setDetalleProducto(detalle);
                        p.setIdCategoria(Integer.parseInt(categoria));
                        p = Operaciones.actualizar(p.getIdProducto(), p);
                        if (p.getIdProducto()!= 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    }else{
                    /*em = getEmpleados();
                    
                    request.setAttribute("emple",em);*/
                    
                    Productos p = new Productos();
                    p.setNombre(nombre);
                    p.setDetalleProducto(detalle);
                    p.setIdCategoria(Integer.parseInt(categoria));
                    p = Operaciones.insertar(p);
                    if(p.getIdProducto()!=0){
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
                        Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 2);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/SProductos");
                break;
            }
            case "eliminar": {
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
            if (request.getParameter("txtBusquedaProducto") != null) {
                sql = "select idProducto, nombre, detalleProducto, (select c.categoria from Categorias c where p.idCategoria=c.idCategoria) from productos p where p.nombre like ?";
            } else {
                sql = "select idProducto, nombre, detalleProducto, (select c.categoria from Categorias c where p.idCategoria=c.idCategoria) from productos p";
            }
            String[][] productos = null;
            if (request.getParameter("txtBusquedaProducto") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusquedaProducto").toString() + "%");
                productos = Operaciones.consultar(sql, params);
            } else {
                productos = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"ID Producto", "Nombre", "Detalle Producto", "Categoria"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(productos, //array quecontiene los datos
                    "50%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            tab.setEliminable(true);//boton actualizar
            tab.setModificable(true); //url del proyecto
            tab.setPageContext(request.getContextPath());//pagina encargada de eliminar
            tab.setPaginaEliminable("/SProductos?accion=eliminar");//pagina encargada de actualizacion
            tab.setPaginaModificable("/SProductos?accion=modificar");//pagina encargada de seleccion para operaciones
            tab.setPaginaSeleccionable("/SProductos?accion=modificar");//icono para modificar y eliminar
            tab.setIconoModificable("/iconos/edit.png");
            tab.setIconoEliminable("/iconos/delete.png"); //columnas seleccionables
            //tab.setColumnasSeleccionables(new int[]{1});//pie de tabla
            tab.setPie("Resultado de productos");
            //imprime la tabla enpantalla
            String tabla01 = tab.getTabla();
            request.setAttribute("tabla", tabla01);
            request.setAttribute("valor", request.getParameter("txtBusquedaProducto"));
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
   private List<Categorias> getCategorias() throws SQLException{
        List<Categorias> ca = new ArrayList();
        try{
            ConexionPool con = new ConexionPool();
            con.conectar();
          
            
            Operaciones.abrirConexion(con);
            ca = Operaciones.getTodos(new Categorias());
        }catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ca;
    }
    private List<Productos> getProductos() throws SQLException{
        List<Productos> pro = new ArrayList();
        try{
            ConexionPool con = new ConexionPool();
            con.conectar();
          
            
            Operaciones.abrirConexion(con);
            pro = Operaciones.getTodos(new Productos());
        }catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SProductos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(SProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(SProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pro;
    }
    private List<Empleados> getEmpleados() throws SQLException{
        List<Empleados> emple = new ArrayList();
        try{
            ConexionPool con = new ConexionPool();
            con.conectar();
          
            
            Operaciones.abrirConexion(con);
            emple = Operaciones.getTodos(new Empleados());
        }catch (Exception ex) {
            try {
                Operaciones.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emple;
    }
}
