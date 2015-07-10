/*Esta es la clase que se encarga de hacer los procesos para la gestion de  la tabla de Estudiantes.
 * 
 */
package procesos;

import conexion.Conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Procesosestudiantes {

	private PreparedStatement psInsertar = null;

	private PreparedStatement psBuscar = null;
        private Connection conexion = null;
	private Conex conDB;

	public Procesosestudiantes() {
		conDB = new Conex();
		
	}

	public String insertar(String carnet, String nombre, String apellido1,
			String apellido2, String carrera) {

		
		String respuesta = "ERROR ERROR DESCONOCIDO";
			
                try {

	

			if (!existeCarnet(carnet)) {

				conexion = Conex.getConexion();
				psInsertar = conexion
						.prepareStatement("INSERT INTO estudiantes (carnet, nombre, apellido1, apellido2, carrera) "
								+ "VALUES (?, ?, ?, ?, ?);");

				psInsertar.setString(1, carnet);
				psInsertar.setString(2, nombre);
				psInsertar.setString(3, apellido1);
				psInsertar.setString(4, apellido2);
				psInsertar.setString(5, carrera);
                                psInsertar.executeUpdate();
				
                                respuesta = "Estudiante agregado con exito";
				
			} else
				respuesta = "Ya existe un estudiante con este carnet";
				
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {
			conDB.cerrarConexion(conexion);

		}
		
		return respuesta;

	}

	

	private boolean existeCarnet(String carnet) {

		boolean flag = false;
		

		try {

			conexion = Conex.getConexion();
			psBuscar = conexion
					.prepareStatement("SELECT carnet FROM estudiantes WHERE carnet = ?;");

			psBuscar.setString(1, carnet);

			ResultSet resultado = psBuscar.executeQuery();
			while (resultado.next()) {
				flag = true;
			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {
			conDB.cerrarConexion(conexion);

		}

		return flag;

	}



}
