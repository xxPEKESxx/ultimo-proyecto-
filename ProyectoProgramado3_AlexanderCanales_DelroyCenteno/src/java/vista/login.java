/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import conexion.Conex;


/**
 *
 * @author xxACSxx
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    
    
    private PreparedStatement psConsultar = null;
   private Connection conexion = null;
	private boolean loginCorrecto = false;
	private Conex conDB;
	private String usuario;
        
        public login(){
        super();
        conDB = new Conex();
        }
  
    @Override
    protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
        
        
       conexion= Conex.getConexion();
       
		String userId = peticion.getParameter("usuario");
		char[] pass = peticion.getParameter("clave").toCharArray();

		loginCorrecto = false;
		if (!(userId.isEmpty()) && (pass.length > 0))
			consultar(userId, pass);

		respuesta(peticion, respuesta);

      
    }
      private void consultar(String usuario, char[] clave) {

	

		

		try {
			conexion = Conex.getConexion();
			psConsultar = conexion
					.prepareStatement("SELECT * FROM usuarios WHERE usuario = ?;");

			psConsultar.setString(1, usuario);
			ResultSet resultado = psConsultar.executeQuery();

			boolean encontrado = false;
			String user = "";
			char[] pass = new char[0];
			while (resultado.next()) {
				encontrado = true;
				user = resultado.getString("usuario");
				pass = resultado.getString("clave").toCharArray();
			}

			if (encontrado)
				if ((usuario.equals(user)) && (Arrays.equals(clave, pass))){
					loginCorrecto = true;
					this.usuario = usuario;
				}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {
			conDB.cerrarConexion(conexion);

		}

	}
   
private void respuesta(HttpServletRequest peticion,
			HttpServletResponse respuesta) throws IOException,
			ServletException {

		respuesta.setContentType("text/html");

		if (loginCorrecto){
			
			HttpSession sesion = peticion.getSession();
			sesion.setAttribute("usuario", usuario);
			sesion.setMaxInactiveInterval(5*10);
			Cookie nombreUsuario = new Cookie("usuario", usuario);
			nombreUsuario.setMaxAge(30*60);
			respuesta.addCookie(nombreUsuario);
			respuesta.sendRedirect("principal.jsp");
			
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/index.jsp");
			PrintWriter pw = respuesta.getWriter();
			pw.println("<script type='text/javascript'>alert('Datos de ingreso incorrectos!');</script>");
			rd.include(peticion, respuesta);
		}

	}


  
   


}
