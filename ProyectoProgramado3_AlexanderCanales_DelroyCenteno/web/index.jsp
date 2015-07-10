

<%-- 
    Document   : index
    Created on : 09-jul-2015, 16:00:27
    Author     : xxACSxx
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Portal de Ingreso..."</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
    </head>
     <body background="alternando.jpg">
         
         	<%
			if(session.getAttribute("usuario") != null)
			    response.sendRedirect("principal.jsp");
			
			String nombreUsuario = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null)
				for(Cookie cookie : cookies)
				    if(cookie.getName().equals("usuario")) 
				    	nombreUsuario = cookie.getValue();
			
		%>
         
         
         <form name="login" method="POST" action="login">
            	<div align="right">
			<table  >
                            <tr>
                                <td colspan="7" align="center"><font face="Comic Sans MS" color="White">Formulario de Validación</font></td>
                            </tr>
				<tr>
					<td align="right"><img alt="" src="usuario.jpg"></td>
					<td><font face="Comic Sans MS" color="White">Usuario</font></td>
					<td><input type="text" name="usuario" value=""></td>
					<td><font face="Comic Sans MS" color="White">Contraseña:</font></td>
					<td><input type="password" name="clave" value=""></td>
					<td><input style="background-color: #FF9900" type="submit" value="Ingresar"></td>
					<td><input   style="background-color: #FF9900" type="reset" value="Cancerlar"></td>
				</tr>
			</table>
            <table >
                         
				<tr>
			
                                    <td><font face="Comic Sans MS" color="White"> Si no es usuario entonces pinche </font> </td>
                                       
					<td><a href= "registros.jsp" > AQUí </a></td>
				</tr>
			</table>
		</div> 
             
             
         </form>
      
        		
        
	 <div align="center">
          <IMG SRC="publicidad2.jpg"> 
            
        </div>
                 <div align="center">
          <IMG SRC="fondo_1.jpg"> 
            
        </div>
        <div align="center">
          <IMG SRC="publicidad.jpg">  
        </div>
      
   <div id="footer" align="center"  >
            <table   >
                <tr>
                    <td>
                     <script> 

var mydate=new Date(); 
var year=mydate.getYear(); 
if (year < 1000) 
year+=1900; 
var day=mydate.getDay(); 
var month=mydate.getMonth()+1; 
if (month<10) 
month="0"+month; 
var daym=mydate.getDate(); 
if (daym<10) 
daym="0"+daym; 
document.write("<small><font COLOR='White' face='Arial'><b>"+daym+"/"+month+"/"+year+"</b></font></small>") 



</script>   
</td>

<td>
    <script type="text/javascript">
function startTime(){
today=new Date();
h=today.getHours();
m=today.getMinutes();
s=today.getSeconds();
m=checkTime(m);
s=checkTime(s);
document.getElementById('reloj').innerHTML=h+":"+m+":"+s;
t=setTimeout('startTime()',500);}
function checkTime(i)
{if (i<10) {i="0" + i;}return i;}
window.onload=function(){startTime();}
</script>
<div id="reloj" style="font-size:20px;COLOR:White"></div>

</td>
                </tr>
                <tr>
              
               <td><a href="Creditos.html " > CREDITOS</a></td>
               
                </tr>
            </table>
                   
        </div>


    </body>
</html>
