/*Esta es a clase que se encraga de hacer los procesos para la gestion de la tabla Usuarios.
 * 
 */
package procesos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import conexion.Conex;

public class ProcesosUsuario {

	

private PreparedStatement psInsertar = null;
private PreparedStatement psBuscar = null;
private Connection conexion = null;
private Conex conDB;

	public ProcesosUsuario() {
		conDB = new Conex();
	
	}

	public String insertar( String cedula, String nombre, String apellido1,
			String apellido2, String usuario, String clave) {

		
		String respuesta = "Error catastrofico no entra al try o no esta conectando bien";
		
		try {

		

			if (!existe_cedula(cedula)) {
                            if (!existe_usuario(usuario)) {
                                conexion = Conex.getConexion();
				psInsertar = conexion
						.prepareStatement("INSERT INTO usuarios (cedula, nombre, apellido1, apellido2, usuario, clave)"
								+ "VALUES ( ?, ?, ?, ?, ?, ?);");
				
				psInsertar.setString(1, cedula);
				psInsertar.setString(2, nombre);
				psInsertar.setString(3, apellido1);
				psInsertar.setString(4, apellido2);
				psInsertar.setString(5, usuario);
				psInsertar.setString(6, clave);

				psInsertar.executeUpdate();

				respuesta = "Usuario insertado con exito";
                            }else{
                            respuesta="YA existe un usuario con ese nombre de usuario";
                            }
				
			
			} else 
				respuesta = "La cedula ya esta en uso";
			

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {
			//conDB.cerrarConexion(conexion);
		}

		return respuesta;
		
	}

	// ********************************

	
	

	/**
	 * Verifica si existe el usuario (Numerico)
	 * 
	 * @param userId
	 * @return
	 */
	private boolean existe_usuario(String usuario) {

		boolean flag = false;
		
		
		try {

			conexion = Conex.getConexion();
			psBuscar = conexion
					.prepareStatement("SELECT usuario FROM usuarios WHERE usuario = ?");
			psBuscar.setString(1, usuario);

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

	/**
	 * Verifica si existe el cedula de usuario
	 * 
	 * @return - boolean
	 */
	private boolean existe_cedula(String cedula) {
		
		boolean flag = false;
		
		
		try {

			conexion = Conex.getConexion();
			psBuscar = conexion
					.prepareStatement("SELECT cedula FROM usuarios WHERE cedula = ?;");
			psBuscar.setString(1, cedula);
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
