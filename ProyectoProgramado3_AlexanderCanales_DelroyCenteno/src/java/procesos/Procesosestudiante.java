/*Esta es la clase que se encarga de hacer los procesos para la gestion de  la tabla de Estudiantes.
 * 
 */
package procesos;

import conexion.Conex;
import control.ControlEstudiantes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xxACSxx delroy
 */
public class Procesosestudiante extends Conex  {
      private Connection conexion = null;
    private PreparedStatement psInsertar = null;
	private PreparedStatement psBuscar = null;
   
    private ControlEstudiantes control;
    
    public Procesosestudiante(ControlEstudiantes c) {
		
         control = c;
		
        }
    public String insertar(String carnet, String nombre, String primerApellido,
			String segundoApellido, String carrera) {
String resultado="";
		try {

			conexion = getConexion();
			
			

                    
				if (!exste_carnet(carnet)) {
                                
                                if (!existe_telefono(primerApellido)) {
                        

					conexion = getConexion();
					psInsertar = conexion
					.prepareStatement("INSERT INTO estudiantes (carnet, nombre, primerApellido,  segundoApellido, carrera)"
									+ "VALUES ( ?, ?, ?, ?, ?);");
 
					psInsertar.setString(1, carnet);
					psInsertar.setString(2, nombre);
					psInsertar.setString(3, primerApellido);
					psInsertar.setString(4, segundoApellido);
					psInsertar.setString(5, carrera);
                                        

					psInsertar.executeUpdate();

					resultado= "Estudiante agregado";

				
                        
                    }else {
                                   resultado="El telefono ya existe CAMBIELo!!!";
                                }
                                    
                                
                                
                                } else {
					resultado="El carnet ya existe en la base de datos";
				}

			

		} catch (SQLException exsql) {
			System.out.println("Problema con conexion");
			exsql.printStackTrace();
		}
                
                return resultado;
	}
    
    	private boolean existeUsuario(String userId) {
		
		boolean flag = false;
		Connection conexion = null;
		
		try {

			conexion=getConexion();
			psBuscar = conexion
					.prepareStatement("SELECT usuario FROM estudiantes WHERE usuario = ?;");
			psBuscar.setString(1, userId);
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
