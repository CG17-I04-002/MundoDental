package com.mundodental.control;

import com.mundodental.entidad.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SConfiguracion extends HttpServlet {


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

                request.getRequestDispatcher("configuracion.jsp").forward(request, response);
            }else if(accion.equals("1")){
                
                request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
            }else if(accion.equals("2")){
                
                request.getRequestDispatcher("Roles.jsp").forward(request, response);
            }else if(accion.equals("3")){
                
                request.getRequestDispatcher("Privilegios.jsp").forward(request, response);
            }
            
            
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
