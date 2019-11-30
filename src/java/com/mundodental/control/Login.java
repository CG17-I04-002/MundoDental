package com.mundodental.control;

import com.mundodental.conexion.Conexion;
import com.mundodental.conexion.ConexionPool;
import com.mundodental.entidad.Empleados;
import com.mundodental.entidad.Menu;
import com.mundodental.entidad.Roles;
import com.mundodental.entidad.Usuario;
import com.mundodental.operaciones.Operaciones;
import com.mundodental.utilerias.Hash;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        if (request.getSession().getAttribute("Usuario") != null) {
            response.sendRedirect("Principal");
        } else {
            if (accion == null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (accion.equals("login")) {
                try {
                    iniciarSesion(request, response);

                } catch (SQLException ex) {

                }
            }
        }

    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String usuario = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
        PrintWriter io = response.getWriter();
        if (usuario == null) {
            usuario = "";
        }
        if (clave == null) {
            clave = null;
        }
        try {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            Operaciones.iniciarTransaccion();
            if (conn.getConexion() == null) {
                request.setAttribute("error", 1);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                HttpSession sesion = request.getSession();
                Usuario u = Operaciones.get(usuario, new Usuario());

                if (u.getUsuario() != null) {
                    if (u.getContrasena().equals(Hash.generarHash(clave, Hash.SHA256))) {
                        sesion.setAttribute("Usuario", u.getUsuario());
                        Empleados emp= getNombre(u.getUsuario());
                        sesion.setAttribute("Nombre", emp.getNombres()+ " "+emp.getApellidos());
                        sesion.setAttribute("NombreU", u.getUsuario());
                        Roles roles= getRol(u.getIdRol());
                        sesion.setAttribute("idRol",u.getIdRol());
                        sesion.setAttribute("Rol",roles.getRol());
                        List<Menu> permisos = getPermisos(u.getIdRol());
                        List<Menu> MenuPrincipal = permisos.stream().filter(field -> field.getIdpadre()==0).collect(Collectors.toList());
                        sesion.setAttribute("MenuPrincipal",MenuPrincipal);
                        sesion.setAttribute("Permisos", permisos);
                        response.sendRedirect("Principal");
                    } else {
                        request.setAttribute("error", 2);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", 2);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
            Operaciones.commit();
        } catch (Exception ex) {
            Operaciones.rollback();
            io.print(ex);
        }

    }

    private List<Menu> getPermisos(Integer idrol) throws SQLException {
        List<Menu> permisos = new ArrayList();
        try {
            String sql = "SELECT * FROM menu WHERE idmenu in (SELECT idmenu FROM permiso WHERE idrol=?); ";
            List<Object> param = new ArrayList();
            param.add(idrol);
            String[][] rs = Operaciones.consultar(sql, param);
            for (int i = 0; i < rs[0].length; i++) {
                Menu m = new Menu(Integer.parseInt(rs[0][i]), rs[1][i], rs[2][i], rs[3][i], Integer.parseInt(rs[4][i] == null ? "0" : rs[4][i]));
                permisos.add(m);
            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }
        return permisos;
    }
    private Empleados getNombre(String nombre) throws SQLException {
        Empleados user = new Empleados();
        try{
            String sql = "SELECT nombres, apellidos FROM Empleados WHERE usuario=? ; ";
            List<Object> param = new ArrayList();
            param.add(nombre);
            String[][] rs = Operaciones.consultar(sql, param);
            user.setNombres(rs[0][0]);
            user.setApellidos(rs[1][0]);
        }catch (Exception ex) {
             Operaciones.rollback();    
        }
        return user;
    }
    private Roles getRol(Integer rol) throws SQLException {
        Roles roles = new Roles();
        try{
            String sql = "SELECT rol FROM Roles WHERE idrol=? ; ";
            List<Object> param = new ArrayList();
            param.add(rol);
            String[][] rs = Operaciones.consultar(sql, param);
            roles.setRol(rs[0][0]);
        }catch (Exception ex) {
             Operaciones.rollback();    
        }
        return roles;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    

    
}
