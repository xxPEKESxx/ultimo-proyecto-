/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xxACSxx
 */
@WebServlet(name = "salir", urlPatterns = {"/salir"})
public class salir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public salir() {
		super();
	}

	protected void doGet(HttpServletRequest peticion,
			HttpServletResponse respuesta) {

		try {

			respuesta.setContentType("text/html");
			Cookie[] cookies = peticion.getCookies();
			if (cookies != null)
				for (Cookie cookie : cookies)
					if (cookie.getName().equals("JSESSIONID")) {
						System.out.println("JSESSIONID=" + cookie.getValue());
						break;
					}

			HttpSession sesion = peticion.getSession(false);
			System.out.println("Usuario= " + sesion.getAttribute("usuario"));
			if (sesion != null)
				sesion.invalidate();

			respuesta.sendRedirect("index.jsp");

		} catch (IOException ioex) {
			ioex.printStackTrace();
		}

	}

}
