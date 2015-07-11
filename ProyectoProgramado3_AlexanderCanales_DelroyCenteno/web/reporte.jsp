<%-- 
    Document   : reporte
    Created on : 11-jul-2015, 13:06:18
    Author     : xxACSxx
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
             <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Reporte Estudiantes</title>
    </head>
    <body background="fondo_1.jpg">
      
	
                    <div id="contenido" align="center">
		<header>
			<p>
				Proyecto Programado 3 - Programacion 2 <br>UCR - 2015
			</p>
		</header>

		<nav>


			<a href="principal.jsp">Atras</a>

		</nav>

		<article>
			<form  method="post"
				action="ControlEstudiantes">
				<table border="1">
					
					
					
					
					
					<tr>
					<td><input type="submit" name="mostrar" id="mostrar" value="Mostrar"></td>
					</tr>
					<tr>

					</tr>

				</table>
			</form>
			<div id="reporte">
				<table border="1">
					<tr>
                                            <th>Carnet</th>
						<th>Nombre</th>
						<th>Apellido 1</th>
						<th>Apellido 2</th>
                                                <th>Carrera</th>
					</tr>

				</table>
			</div>
		</article>



		<footer>
			<p>Alexander Canales Saenz</p>
		</footer>

	</div>
    </body>
</html>
