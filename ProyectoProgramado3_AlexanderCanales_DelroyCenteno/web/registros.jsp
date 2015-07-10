<%-- 
    Document   : registros
    Created on : 09-jul-2015, 21:48:27
    Author     : xxACSxx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarse</title>
    </head>
    <body background="alternando.jpg" >
        <%
			if(session.getAttribute("usuario") != null)
			    response.sendRedirect("registros.jsp");
			
			String nombreUsuario = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null)
				for(Cookie cookie : cookies)
				    if(cookie.getName().equals("usuario")) 
				    	nombreUsuario = cookie.getValue();
			
		%>
                
       <div align="center" >
			<header>
				<p><font face="Comic Sans MS" color="White">Proyecto Programado 3 - Programacion 2
                                    <br>UCR - 2015</font></p>
			</header>
		
	
	
		<article>
			<form method="post" action="ControlUsuarios">
				<table border="1">
					<tr>
						<td><font face="Comic Sans MS" color="White">Cedula:</font></td>
						<td><input type="text" name="cedula" value=""></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS" color="White">Nombre:</font></td>
						<td><input type="text" name="nombre" value=""></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS" color="White">Apellido 1:</font></td>
						<td><input type="text" name="apellido1" value=""></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS" color="White">Apellido 2:</font></td>
						<td><input type="text" name="Apellido2" value=""></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS" color="White"> Nom Usuario:</font></td>
						<td><input type="text" name="Usuario" value=""></td>
					</tr>
					<tr>
						<td><font face="Comic Sans MS" color="White">Clave:</font></td>
						<td><input type="password" name="Clave" value=""></td>
					</tr>
					
				
					<tr>
						<td><input type="submit" name="insertar" value="Registrarse"></td>
						<td><a href= "index.jsp" > Regresar </a></td>
					</tr>
					
					
				</table>
			</form>
		</article>

		<footer>
			<font face="Comic Sans MS" color="White">Alexander Canales Saenz / Delroy Centeno Contreras</font>
			</footer>
			
	</div>
    </body>
</html>
