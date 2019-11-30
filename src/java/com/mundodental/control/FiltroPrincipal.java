
package com.mundodental.control;

import com.mundodental.entidad.Menu;
import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "FiltroPrincipal", urlPatterns = {"/*"})
public class FiltroPrincipal implements Filter {
    
    private static final boolean debug = true;

    
    private FilterConfig filterConfig = null;
    
    public FiltroPrincipal() {
    }    
    
    
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) res;
        ///BORRAR CACHE 
        /*response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        ///OMITIR ARCHIVOS DE ESOS TIPOS
        String path= request.getRequestURI();
        if(path.endsWith(".css") || path.endsWith(".min.js") || path.endsWith(".map") || path.endsWith(".js") || path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".ico")){
          chain.doFilter(request,response);
          return;
        }
       
        if (request.getSession().getAttribute("Usuario") != null || request.getRequestURI().equals(request.getContextPath()+"/Login")) {
            
            boolean  encontrado = true;
            String url = request.getRequestURI().toString();
            String context = request.getContextPath();
            if(request.getSession().getAttribute("Permisos") != null && request.getParameter("accion")==null && !url.equals(context+"/Login") && !request.getRequestURI().equals(request.getContextPath()+"/Principal")  ){
                List<Menu> permisos = (List<Menu>) request.getSession().getAttribute("Permisos"); 
                    encontrado = false;
                    int cont = 0;
                    while(cont<permisos.size() && !encontrado){
                        if(url.equals(context+"/S"+permisos.get(cont).getMenu())){
                            encontrado = true;
                        }
                        cont++;
                    }
            }
            if(encontrado)
                chain.doFilter(request, response);
            else
                response.sendError(404);
            
        } else {
            response.sendRedirect("Login");
        }
        */
        chain.doFilter(request, response);
    }

    
    public void destroy() {        
    }

   
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("FiltroPrincipal:Initializing filter");
            }
        }
    }

    
    
    
    
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
