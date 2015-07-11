/*Esta es la clase que se encarga de hacer los procesos para la gestion de  la tabla de Estudiantes.
 * 
 */
package procesos;

import conexion.Conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

		
		String respuesta = "Error catastrofico no entra al try o no esta conectando bien";
			
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

public String mostrar() {

	
		String re = "";
		try {

			

			String consul;
			consul = "SELECT * FROM estudiantes";

			conexion = Conex.getConexion();

			Statement consulta = conexion.createStatement();
			ResultSet resultado = consulta.executeQuery(consul);

			re += "<table border='1'><tr><th>Carnet</th><th>Nombre</th><th>Apellido 1</th><th>Apellido 2</th><th>Carrera</th></tr>";
			ResultSetMetaData meta = resultado.getMetaData();
			int columnas = meta.getColumnCount();
			while (resultado.next()) {
				Object[] fila = new Object[columnas];
				for (int x = 0; x < columnas; x++)
					fila[x] = resultado.getObject(x + 1);

				re += "<tr>";
				for (int y = 0; y < fila.length; y++) {
					re += "<td>" + fila[y] + "</td>";
				}
				re += "</tr>";

			}

			re += "</table>";

			return re;

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {
			conDB.cerrarConexion(conexion);
		}

		return re;

	}

}
