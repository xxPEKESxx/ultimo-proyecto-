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
        <title>JSP Page</title>
    </head>
    <body background="alternando.jpg">
        
        <div id="contenido" aling="center">
			<header>
				<p>Proyecto Programado 3 - Programacion 2
				<br>UCR - 2015</p>
			</header>
		
	
	
		<article>
			<form name="Procesosestudiante" method="post" action="ControlEstudiantes">
				<table border="1">
					<tr>
						<td><b>Carnet:</b></td>
						<td><input type="text" name="carnet" value=""></td>
					</tr>
					<tr>
						<td><b>Nombre:</b></td>
						<td><input type="text" name="nombre" value=""></td>
					</tr>
					<tr>
						<td><b>1re Apellido:</b></td>
						<td><input type="text" name="apellido1" value=""></td>
					</tr>
					<tr>
						<td><b>2do Apellido:</b></td>
						<td><input type="text" name="apellido2" value=""></td>
					</tr>
					<tr>
						<td><b>Carrera que cursa</b></td>
						<td><input type="text" name="carrera" value=""></td>
					</tr>
				
						<td><input type="submit" name="agrega" value="agrega"></td>
						<td><input type="reset" value="Limpiar"></td>
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
