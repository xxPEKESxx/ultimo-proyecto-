package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Portal de Ingreso...\"</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("      \n");
      out.write("    </head>\n");
      out.write("     <body background=\"alternando.jpg\">\n");
      out.write("         \n");
      out.write("         \t");

			if(session.getAttribute("usuario") != null)
			    response.sendRedirect("principal.jsp");
			
			String nombreUsuario = null;
			Cookie[] cookies = request.getCookies();
			if(cookies !=null)
				for(Cookie cookie : cookies)
				    if(cookie.getName().equals("usuario")) 
				    	nombreUsuario = cookie.getValue();
			
		
      out.write("\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         <form name=\"login\" method=\"POST\" action=\"login\">\n");
      out.write("            \t<div align=\"right\">\n");
      out.write("\t\t\t<table id='login' >\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"7\" align=\"center\"><font face=\"Comic Sans MS\" color=\"White\">Formulario de Validación</font></td>\n");
      out.write("                            </tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\"><img alt=\"\" src=\"usuario.jpg\"></td>\n");
      out.write("\t\t\t\t\t<td><font face=\"Comic Sans MS\" color=\"White\">Usuario</font></td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"usuario\" value=\"\"></td>\n");
      out.write("\t\t\t\t\t<td><font face=\"Comic Sans MS\" color=\"White\">Contraseña:</font></td>\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"clave\" value=\"\"></td>\n");
      out.write("\t\t\t\t\t<td><input style=\"background-color: #FF9900\" type=\"submit\" value=\"Ingresar\"></td>\n");
      out.write("\t\t\t\t\t<td><input   style=\"background-color: #FF9900\" type=\"reset\" value=\"Cancerlar\"></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("            <table >\n");
      out.write("                         \n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\n");
      out.write("                                    <td><font face=\"Comic Sans MS\" color=\"White\"> Si no es usuario entonces pinche </font> </td>\n");
      out.write("                                       \n");
      out.write("\t\t\t\t\t<td><a href=\"cambioClave.html \" > AQUí </a></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</div> \n");
      out.write("             \n");
      out.write("             \n");
      out.write("         </form>\n");
      out.write("      \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\t <div align=\"center\">\n");
      out.write("          <IMG SRC=\"publicidad2.jpg\"> \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("                 <div align=\"center\">\n");
      out.write("          <IMG SRC=\"fondo_1.jpg\"> \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <div align=\"center\">\n");
      out.write("          <IMG SRC=\"publicidad.jpg\">  \n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("   <div id=\"footer\" align=\"center\"  >\n");
      out.write("            <table   >\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                     <script> \n");
      out.write("\n");
      out.write("var mydate=new Date(); \n");
      out.write("var year=mydate.getYear(); \n");
      out.write("if (year < 1000) \n");
      out.write("year+=1900; \n");
      out.write("var day=mydate.getDay(); \n");
      out.write("var month=mydate.getMonth()+1; \n");
      out.write("if (month<10) \n");
      out.write("month=\"0\"+month; \n");
      out.write("var daym=mydate.getDate(); \n");
      out.write("if (daym<10) \n");
      out.write("daym=\"0\"+daym; \n");
      out.write("document.write(\"<small><font COLOR='White' face='Arial'><b>\"+daym+\"/\"+month+\"/\"+year+\"</b></font></small>\") \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>   \n");
      out.write("</td>\n");
      out.write("\n");
      out.write("<td>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("function startTime(){\n");
      out.write("today=new Date();\n");
      out.write("h=today.getHours();\n");
      out.write("m=today.getMinutes();\n");
      out.write("s=today.getSeconds();\n");
      out.write("m=checkTime(m);\n");
      out.write("s=checkTime(s);\n");
      out.write("document.getElementById('reloj').innerHTML=h+\":\"+m+\":\"+s;\n");
      out.write("t=setTimeout('startTime()',500);}\n");
      out.write("function checkTime(i)\n");
      out.write("{if (i<10) {i=\"0\" + i;}return i;}\n");
      out.write("window.onload=function(){startTime();}\n");
      out.write("</script>\n");
      out.write("<div id=\"reloj\" style=\"font-size:20px;COLOR:White\"></div>\n");
      out.write("\n");
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("              \n");
      out.write("               <td><a href=\"Creditos.html \" > CREDITOS</a></td>\n");
      out.write("               \n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("                   \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
