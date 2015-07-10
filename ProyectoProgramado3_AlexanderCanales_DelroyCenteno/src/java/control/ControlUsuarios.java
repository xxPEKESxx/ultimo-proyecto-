package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import procesos.ProcesosUsuario;

/**
 * Servlet implementation class Matricula
 */
@WebServlet("/ControlUsuarios")
public class ControlUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProcesosUsuario adminUsuarios;
	

	public ControlUsuarios() {
		super();
                adminUsuarios = new ProcesosUsuario(this);
	}

	protected void doPost(HttpServletRequest peticion,
			HttpServletResponse respuesta) throws ServletException, IOException {

	
		

		if (null != peticion.getParameter("insertar")) {
			respuesta(peticion, respuesta, insertar(peticion));

		} 

	}

	private String insertar(HttpServletRequest peticion) {

		String respuesta = "";

		try {
			

			String cedula = peticion.getParameter("cedula");
			String nombre = peticion.getParameter("nombre");
			String apellido1 = peticion.getParameter("apellido1");
			String apellido2 = peticion.getParameter("apellido2");
			String usuario = peticion.getParameter("usuario");
			String clave = peticion.getParameter("clave");

			respuesta = adminUsuarios.insertar(cedula, nombre, apellido1, apellido2, usuario,clave);
                                

		} catch (NumberFormatException nfex) {
			nfex.printStackTrace();
		}

		return respuesta;
	}

	


	

	private void respuesta(HttpServletRequest peticion,
			HttpServletResponse respuesta, String res) {

		try {

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/registros.jsp");
			PrintWriter pw = respuesta.getWriter();
			pw.println("<script type='text/javascript'>alert('" + res
					+ "')</script>");
			rd.include(peticion, respuesta);

		} catch (IOException ioex) {
			ioex.printStackTrace();

		} catch (ServletException sex) {
			sex.printStackTrace();

		}

	}

}
