<%-- 
    Document   : estudiantes
    Created on : 10-jul-2015, 3:56:04
    Author     : xxACSxx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link type="text/css" rel="stylesheet" href="forma.css">
        <title>JSP Page</title>
    </head>
    <body background="alternando.jpg">
        
        
        	<%
			if(session.getAttribute("usuario") == null)
			    response.sendRedirect("index.jsp");
			
			String nombreUsuario = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null)
				for(Cookie cookie : cookies)
				    if(cookie.getName().equals("usuario")) 
				    	nombreUsuario = cookie.getValue();
			
		%>
        
        
        
        
        <div id="contenido" aling="center">
			<header>
				<p>Proyecto Programado 3 - Programacion 2
				<br>UCR - 2015</p>
			</header>
		
	
	
		<article>
			<form method="post" action="ControlEstudiantes">
				<table border="1">
					<tr>
                                            <td><b><font face="Comic Sans MS" color="White">Carnet:</font></b></td>
						<td><input type="text" name="carnet" value=""></td>
					</tr>
					<tr>
						<td><b><font face="Comic Sans MS" color="White">Nombre:</font></b></td>
						<td><input type="text" name="nombre" value=""></td>
					</tr>
					<tr>
						<td><b><font face="Comic Sans MS" color="White">Apellido 1:</font></b></td>
						<td><input type="text" name="apellido1" value=""></td>
					</tr>
					<tr>
						<td><b><font face="Comic Sans MS" color="White">Apellido 2:</font></b></td>
						<td><input type="text" name="apellido2" value=""></td>
					</tr>
					<tr>
						<td><b><font face="Comic Sans MS" color="White">Carrera qu cursa:</font></b></td>
						<td><input type="text" name="carrera" value=""></td>
					</tr>
                                                
						<td><input type="submit" name="agrega" value="agrega"></td>
						<td><input type="reset" value="Limpiar"></td>
                                                <td><a href= "principal.jsp" > Regresar </a></td>
					</tr>
					
				</table>
			</form>
			
		</article>

		<footer>
			<p> Alexander Canales Saenz / Delroy Centeno Contreras</p>
			</footer>
			
	</div>
        

    </body>
</html>
