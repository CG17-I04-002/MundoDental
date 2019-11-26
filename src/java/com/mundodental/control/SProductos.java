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

public class SProductos extends HttpServlet {

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

            request.getRequestDispatcher("productos.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
