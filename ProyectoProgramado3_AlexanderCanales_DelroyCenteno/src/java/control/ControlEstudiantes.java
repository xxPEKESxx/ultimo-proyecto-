package control;

import conexion.Conex;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import procesos.Procesosestudiantes;

@WebServlet("/ControlEstudiantes")
public class ControlEstudiantes extends HttpServlet {
	private static final long serialVersionUID = 1L;

        Procesosestudiantes adminEstudiantes;
	 

	public ControlEstudiantes() {
		super();
                adminEstudiantes = new Procesosestudiantes();
	}

	protected void doPost(HttpServletRequest peticion,
			HttpServletResponse respuesta) throws ServletException, IOException {


		
		System.out.println("Si llegamos al control de estudiantes");
		
		if (peticion.getParameter("agrega") != null) {
			respuesta(peticion, respuesta, insertar(peticion));

		} else{
                    System.out.println("MAL muy mal");
                }   

	}

	private String insertar(HttpServletRequest peticion) {

		String respuesta = "";

		try {

			String carnet = peticion.getParameter("carnet");
			String nombre = peticion.getParameter("nombre");
			String apellido1 = peticion.getParameter("apellido1");
			String apellido2 = peticion.getParameter("apellido2");
			String carrera = peticion.getParameter("carrera");
		

			respuesta = adminEstudiantes.insertar(carnet, nombre, apellido1, apellido2, carrera);

		} catch (NumberFormatException nfex) {
			nfex.printStackTrace();
			respuesta = "En la edad solo se permiten numeros";
		}

		return respuesta;
	}





	private void respuesta(HttpServletRequest peticion ,HttpServletResponse respuesta, String res) {

		try {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/estudiantes.jsp");
			PrintWriter pw = respuesta.getWriter();
			pw.println("<script type='text/javascript'>alert('"+res+"')</script>");
			rd.include(peticion, respuesta);
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
			
		} catch (ServletException sex) {
			sex.printStackTrace();
			
		}

	}

}
