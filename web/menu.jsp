<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
    <div class="d-flex  justify-content-end">
        <div class="user">
            <div class="dropdown">
                <button type="button" class="btnUser dropdown-toggle" data-toggle="dropdown">
                  <i class="fas fa-user"></i> ${Nombre}
                </button>
                <div class="dropdown-menu">
                    <span class="dropdown-item-text"><strong>${NombreU}</strong></span>
                    <span class="dropdown-item-text">[${Rol}]</span>
                    <a class="dropdown-item-text" href="Principal?accion=logout"><i class="fas fa-sign-out-alt"></i> Salir</a>
                </div>
             </div>
        </div>
    </div>
</div>
<div class="side-nav ">
    <a href="Principal?accion=1" class="inic">
        <div class="logo">
            <div class="lg">
                <img src="img/Solo logo.png">
            </div>
            <span>Mundo Dental</span>
        </div>
    </a>
    
    <nav class="collapse" id="navbarToggleExternalContent">
        <ul>
            <c:forEach var="menu" items="${MenuPrincipal}">
                <li><a class="opcM" href="${pageContext.servletContext.contextPath}${menu.url}?accion=${menu.idmenu}">${menu.menu}</a></li>    
            </c:forEach>
        </ul>
    </nav>
  <div class="navbar navbar-dark ">
    <button class="navbar-toggler" id="bt" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </div>
</div>
