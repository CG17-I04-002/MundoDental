
package com.mundodental.control;

import com.mundodental.entidad.Menu;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Principal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession s = request.getSession();
        List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
        //List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre() == 0).collect(Collectors.toList());
        //request.setAttribute("MenuPrincipal", MenuPrincipal);
        String op = request.getParameter("op");
        if (op != null) {
            List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre() == Integer.parseInt(op)).collect(Collectors.toList());
            request.setAttribute("PermisosAsignados", PermisosAsignados);
        }
        if (null == accion) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } else switch (accion) {
            case "logout":
                logout(request, response);
                break;
            case "1":
                request.getRequestDispatcher("principal.jsp").forward(request, response);
                break;
            case "2":
                response.sendRedirect("SPacientes");
                break;
            case "3":
                response.sendRedirect("SCitas");
                break;
            case "4":
                response.sendRedirect("SConsultas");
                break;
            case "5":
                response.sendRedirect("SCompras");
                break;
            case "6":
                response.sendRedirect("SVentas");
                break;
            case "7":
                response.sendRedirect("SProductos");
                break;
            case "8":
                response.sendRedirect("SDoctores");
                break;
            case "9":
                response.sendRedirect("SMembresias");
                break;
            case "10":
                response.sendRedirect("SReportes");
                break;
            case "11":
                response.sendRedirect("SConfiguracion");
                break;
            default:
                break;
        }
        
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        sesion.removeAttribute("Usuario");
        sesion.removeAttribute("Nombre");
        sesion.removeAttribute("NombreU");
        sesion.removeAttribute("Rol");
        sesion.invalidate();
        response.sendRedirect("Login");
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
