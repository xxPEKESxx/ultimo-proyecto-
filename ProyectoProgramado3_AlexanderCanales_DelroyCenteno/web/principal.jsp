<%-- 
    Document   : principal
    Created on : 09-jul-2015, 16:28:58
    Author     : xxACSxx
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="forma.css">
        <title>CENTRO DE MANDOS</title>
    </head>
    <body background="alternando.jpg">
        
        	<% 
			String userid = null;
			if (session.getAttribute("usuario") == null)
				response.sendRedirect("index.jsp");
			 else
				userid = (String) session.getAttribute("usuario");
			
			String nombreUsuario = null;
			String sesionId = null;
			Cookie [] cookies = request.getCookies();
			if (cookies != null)
				for (Cookie cookie : cookies)
					if (cookie.getName().equals("usuario"))
						nombreUsuario = cookie.getValue();
			
		%>
        
      	<div id="contenido">
			<header>
				<p>Proyecto Programado 3 - Programacion 2
				<br>UCR - 2015</p>
			</header>
		
		<nav>
		
		
			<a href="registros.jsp">USUARIOS</a>
			<a href="reporte.jsp">REPORTE</a>
			<a href="estudiantes.jsp">ESTUDIANTES</a>
                        <a href="Salir">Salir</a>
			
		</nav>
	
		<article>
			<p>CENTRO DE CONTROL</p>
		</article>

		<footer>
			<p>Alexander Canales Saenz / Delroy Centeno Contreras</p>
		</footer>
			
	</div>
    
    </body>
</html>
