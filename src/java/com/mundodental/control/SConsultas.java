package com.mundodental.control;

import com.mundodental.conexion.Conexion;
import com.mundodental.conexion.ConexionPool;
import com.mundodental.entidad.Consultas;
import com.mundodental.entidad.Consultas_Tratamientos;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Facturas;
import com.mundodental.entidad.Menu;
import com.mundodental.entidad.Pacientes;
import com.mundodental.operaciones.Operaciones;
import com.mundodental.utilerias.Tabla;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class SConsultas extends HttpServlet {

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
            int id =(int) request.getSession().getAttribute("idRol");
            if(id == 3){
                cargarTablaTra(request, response);
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    String user = (String) request.getSession().getAttribute("Usuario");
                    Consultas c = new Consultas();
                    c = getConsulta(user);
                    if(c.getIdConsulta()!=0){
                        Pacientes p = new Pacientes();
                        p = Operaciones.get(c.getExpediente(), new Pacientes());

                        request.setAttribute("consulta", c);
                        request.setAttribute("paciente", p);
                    }else{
                        
                        request.setAttribute("existencia","1");
                    }
                    
                    request.getRequestDispatcher("realizarConsultasDoctor.jsp").forward(request, response);
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
            }else{
             
                cargarTablaPac(request, response);
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    List<Empleados> empleados = getDoctores();
                    List<Consultas> consultas = getConsultas();
                    List<Pacientes> pacientes = getPacientes();
                    request.setAttribute("empleados", empleados);
                    request.setAttribute("consultas", consultas);
                    request.setAttribute("pacientes", pacientes);



                    Operaciones.commit();
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
                request.getRequestDispatcher("realizarConsultas.jsp").forward(request, response);   
            }
        }else if (accion.equals("seleccionar")) {
            
            cargarTablaPac(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Pacientes p = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Pacientes());
                request.setAttribute("paciente", p);
                
                List<Empleados> doctores = getDoctores();
                request.setAttribute("doctores", doctores);
                int membresia  = validarMembresia(p.getExpediente());
                request.setAttribute("membresia", membresia);
                
                List<Empleados> empleados = getDoctores();
                List<Consultas> consultas = getConsultas();
                List<Pacientes> pacientes = getPacientes();
                request.setAttribute("empleados", empleados);
                request.setAttribute("consultas", consultas);
                request.setAttribute("pacientes", pacientes);
                
                Operaciones.commit();
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
            request.getRequestDispatcher("realizarConsultas.jsp").forward(request, response);
        }else if (accion.equals("mostrar")) {
            cargarTablaConsultas(request, response);
            request.getRequestDispatcher("mostrarConsultas.jsp").forward(request, response);
        }else if (accion.equals("finalizar")) {
            cargarTablaPac(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Consultas c = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Consultas());
                c.setEstado("Finalizada");
                c = Operaciones.actualizar(c.getIdConsulta(), c);
                
                Operaciones.commit();
            }catch(Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(request.getContextPath() + "/SConsultas");
        }else if (accion.equals("iniciar")) {
            cargarTablaPac(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Consultas c = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Consultas());
                if(validarProcesoDoctor(c.getIdEmpleadoDoctor())==0){

                    c.setEstado("Proceso");
                    c = Operaciones.actualizar(c.getIdConsulta(), c);
                }
                
                Operaciones.commit();
            }catch(Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(request.getContextPath() + "/SConsultas");
        }else if (accion.equals("cancelar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Consultas c = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Consultas());
                c.setEstado("Cancelada");
                c = Operaciones.actualizar(c.getIdConsulta(), c);
                
                Operaciones.commit();
            }catch(Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(request.getContextPath() + "/SConsultas");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String expe = request.getParameter("txtIdPac");
                String tipo = request.getParameter("cbTipo");
                String doc = request.getParameter("cbDoctor");
                
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    Consultas consultas = new Consultas();
                    
                    String fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(fecha);
                    java.sql.Date d = new java.sql.Date(date.getTime());
                    consultas.setFecha(d);
                    consultas.setIdLocal(1);
                    consultas.setHoraIngreso(Time.valueOf(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
                    consultas.setHoraFinalizacionConsulta(Time.valueOf(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now())));
                    consultas.setTipoConsulta(tipo);
                    consultas.setCosto(BigDecimal.ZERO);
                    consultas.setDescuento(BigDecimal.ZERO);
                    consultas.setTotal(BigDecimal.ZERO);
                    consultas.setExpediente(Integer.parseInt(expe));
                    consultas.setIdEmpleadoDoctor(Integer.parseInt(doc));
                    consultas.setEstado("Espera");
                    consultas = Operaciones.insertar(consultas);
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
                response.sendRedirect(request.getContextPath() + "/SConsultas");
                break;
            }
            case "completar": {
                String id = request.getParameter("txtCon");
                String[] idTra = request.getParameterValues("id");
                
                String total = request.getParameter("txtTotal");
                
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    Consultas consultas = new Consultas();
                    consultas = Operaciones.get(Integer.parseInt(id), new Consultas());
                    consultas.setCosto(BigDecimal.valueOf(Double.parseDouble(total)));
                    consultas.setTotal(BigDecimal.valueOf(Double.parseDouble(total)));
                    consultas.setEstado("Completada");
                    for(int i =0; i<idTra.length; i++){
                        Consultas_Tratamientos ct = new Consultas_Tratamientos();
                        ct.setIdConsulta(Integer.parseInt(id));
                        ct.setIdTratamiento(Integer.parseInt(idTra[i]));
                        ct = Operaciones.insertar(ct);
                    }
                    consultas = Operaciones.actualizar(consultas.getIdConsulta(), consultas);
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
                response.sendRedirect(request.getContextPath() + "/SConsultas");
                break;
            }
            case "finalizar_consulta":{
                cargarTablaPac(request, response);
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Consultas c = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Consultas());
                c.setEstado("Finalizada");
                c = Operaciones.actualizar(c.getIdConsulta(), c);
                
                Operaciones.commit();
            }catch(Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(SConsultas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(request.getContextPath() + "/SConsultas");
            }
                
                break;
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
    private void cargarTablaTra(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";
            
            sql = "SELECT * FROM Tratamientos";
            String[][] pacientes = null;
            if (request.getParameter("txtBusqueda") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                pacientes = Operaciones.consultar(sql, params);
            } else {
                pacientes = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"ID", "Tratamiento", "Precio"};//variable de tipo Tabla para generar la Tabla HTML
            Tabla tab = new Tabla(pacientes, //array quecontiene los datos
                    "100%", //ancho de la tabla px | % 
                    Tabla.STYLE.TABLE01, //estilo de la tabla
                    Tabla.ALIGN.LEFT, // alineacion de la tabla
                    cabeceras);
            //array con las cabeceras de la tabla
            //boton eliminar
            
            
            tab.setMetodoFilaSeleccionable("_SeleccionarT_");
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
    
    private List<Empleados> getDoctores() throws SQLException {
        List<Empleados> doctores = new ArrayList();
        try {
            String sql = "SELECT e.idEmpleado, e.nombres, e.apellidos FROM Empleados e, Usuario u WHERE u.usuario = e.usuario AND u.idRol = 3";
            
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
    
    private int validarMembresia(int id) throws SQLException {
        int  encontrado = 0;
        try {
            String sql = "SELECT *   FROM Membresias  WHERE expediente = ?";
            
            List<Object> params = new ArrayList<>();
            params.add(id);
            
            String[][] rs = Operaciones.consultar(sql, params);
            if( rs!=null){
                encontrado = 1;
            }else{
                String sql2 = "SELECT *  FROM Membresias_Beneficiarios  WHERE expediente = ?";
            
                List<Object> params2 = new ArrayList<>();
                params2.add(id);
                 rs = Operaciones.consultar(sql2, params2);
                 if(rs!=null){
                     encontrado = 1;
                 }
            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return encontrado;
    }
    
    private List<Consultas> getConsultas() throws SQLException {
        List<Consultas> consultas = new ArrayList();
        try {
            String sql = "SELECT * FROM Consultas WHERE NOT estado = 'Finalizada' AND NOT estado ='Cancelada'";
            
            String[][] rs = Operaciones.consultar(sql, null);
            for (int i = 0; i < rs[0].length; i++) {
                Consultas c = new Consultas();
                c.setIdConsulta(Integer.parseInt(rs[0][i]));
                c.setExpediente(Integer.parseInt(rs[6][i]));
                c.setIdEmpleadoDoctor(Integer.parseInt(rs[10][i]));
                c.setTipoConsulta(rs[4][i]);
                c.setCosto(BigDecimal.valueOf(Double.parseDouble(rs[5][i])));
                c.setDescuento(BigDecimal.valueOf(Double.parseDouble(rs[8][i])));
                c.setTotal(BigDecimal.valueOf(Double.parseDouble(rs[9][i])));
                c.setEstado(rs[11][i]);
                consultas.add(c);
                
            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return consultas;
    }
    private List<Pacientes> getPacientes() throws SQLException {
        List<Pacientes> pacientes = new ArrayList();
        try {
            String sql = "SELECT * FROM Pacientes ";
            
            String[][] rs = Operaciones.consultar(sql, null);
            for (int i = 0; i < rs[0].length; i++) {
                Pacientes p = new Pacientes();
                p.setExpediente(Integer.parseInt(rs[0][i]));
                p.setNombres(rs[1][i]);
                p.setApellidos(rs[2][i]);
                pacientes.add(p);
                
            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return pacientes;
    }
    
    
    private void cargarTablaConsultas(HttpServletRequest request, HttpServletResponse response) {
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            String sql = "";
            if (request.getParameter("txtBusqueda") != null) {
                sql = "SELECT c.idConsulta, CONCAT(p.nombres, ' ', p.apellidos) Paciente, CONCAT(e.nombres, ' ', e.apellidos) Doctor, c.tipoConsulta, c.estado, c.fecha, c.costo, c.descuento, c.total  FROM Consultas c, Pacientes p, Locales l, Empleados e WHERE c.expediente = p.expediente AND c.idLocal = l.idLocal AND c.idEmpleadoDoctor = e.idEmpleado";
            }else{
                sql = "SELECT c.idConsulta, CONCAT(p.nombres, ' ', p.apellidos) Paciente, CONCAT(e.nombres, ' ', e.apellidos) Doctor, c.tipoConsulta, c.estado, c.fecha, c.costo, c.descuento, c.total  FROM Consultas c, Pacientes p, Locales l, Empleados e WHERE c.expediente = p.expediente AND c.idLocal = l.idLocal AND c.idEmpleadoDoctor = e.idEmpleado";
            
            }
            String[][] citas = null;
            if (request.getParameter("txtBusqueda") != null) {
                List<Object> params = new ArrayList<>();
                params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                citas = Operaciones.consultar(sql, params);
            } else {
                citas = Operaciones.consultar(sql, null);
            }
            //declaracion de cabeceras a usar en la tabla HTML
            String[] cabeceras = new String[]{"idConsulta", "Paciente", "Doctor", "Tipo Consulta", "Estado", "Fecha", "Costo", "Descuento","Total"};//variable de tipo Tabla para generar la Tabla HTML
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
    
    
    private Consultas getConsulta(String nombre) throws SQLException {
        Consultas c = new Consultas();
        try{
            String sql = "SELECT c.idConsulta, c.expediente, c.tipoConsulta FROM Consultas c, Empleados e, Usuario u WHERE c.idEmpleadoDoctor = e.idEmpleado AND e.usuario = u.usuario AND u.usuario = ? AND c.estado = 'Proceso' ";
            List<Object> param = new ArrayList();
            param.add(nombre);
            String[][] rs = Operaciones.consultar(sql, param);
            c.setIdConsulta(Integer.parseInt(rs[0][0]));
            c.setExpediente(Integer.parseInt(rs[1][0]));
            c.setTipoConsulta(rs[2][0]);
        }catch (Exception ex) {
             Operaciones.rollback();    
        }
        return c;
    }
    private int validarProcesoDoctor(int id) throws SQLException {
        int  encontrado = 0;
        try {
            String sql = "SELECT * FROM Consultas  WHERE estado='Proceso' AND  idEmpleadoDoctor = ?";
            
            List<Object> params = new ArrayList<>();
            params.add(id);
            
            String[][] rs = Operaciones.consultar(sql, params);
            if( rs.length>0){
                encontrado = 1;
            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return encontrado;
    }
    
    
}
