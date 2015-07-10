/*Esta es la clase que se encarga de hacer los procesos para la gestion de  la tabla de Estudiantes.
 * 
 */
package procesos;

import conexion.Conex;
import control.control;
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
	private PreparedStatement psEliminar = null;
	private PreparedStatement psModificar = null;
	private PreparedStatement psMostrar = null;
	private PreparedStatement psConsulta = null;
   
    private control control;
    
    public Procesosestudiante(control c) {
		
         control = c;
		
        }
    public void insertar(String carnet, String nombre, String primerApellido,
			String segundoApellido, String telefono) {

		try {

			conexion = getConexion();
			
			

                    
				if (!exste_carnet(carnet)) {
                                
                                if (!existe_telefono(primerApellido)) {
                        

					conexion = getConexion();
					psInsertar = conexion
					.prepareStatement("INSERT INTO estudiantes (carnet, nombre, primerApellido,  segundoApellido, telefono)"
									+ "VALUES ( ?, ?, ?, ?, ?);");
 
					psInsertar.setString(1, carnet);
					psInsertar.setString(2, nombre);
					psInsertar.setString(3, primerApellido);
					psInsertar.setString(4, segundoApellido);
					psInsertar.setString(5, telefono);
                                        

					psInsertar.executeUpdate();

					JOptionPane.showMessageDialog(null, "Estudiante agregado");

				
                        
                    }else {
                                    JOptionPane.showMessageDialog(null,
							"El telefono ya existe CAMBIELo!!!");
                                }
                                    
                                
                                
                                } else {
					JOptionPane.showMessageDialog(null,
							"El carnet ya existe en la base de datos");
				}

			

		} catch (SQLException exsql) {
			System.out.println("Problema con conexion");
			exsql.printStackTrace();
		}
	}
    
      public void modificar(String carnet, String nombre, String primerApellido,
			String segundoApellido, String telefono) {

		try {

			conexion = getConexion();
			
			Statement consulta= conexion.createStatement();

			if (exste_carnet(carnet)) {

				conexion = getConexion();
                                String actualizar="UPDATE estudiantes SET"+
                                        " carnet='"+carnet+
                                        "', nombre='"+nombre+
                                        "', primerApellido='"+primerApellido+
                                        "', segundoApellido='"+segundoApellido+
                                        "', telefono='"+telefono+
                                        "' WHERE carnet='"+ carnet+"'";
				
                                
                              int result=  consulta.executeUpdate(actualizar);
				
if (result==1) {
   				JOptionPane.showMessageDialog(null, "Modificacion exitosa");

                                
                            }

			} else {
				JOptionPane.showMessageDialog(null, "No existe un dato con ese carnet ");
			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
			System.out.println("Problema con base de datos");

		} finally {

			try {
				if (psEliminar != null)
					psEliminar.close();
				if (conexion != null)
					conexion.close();

			} catch (SQLException sqlex) {
				sqlex.printStackTrace();

			}

		}

	}
      public void eliminar(String carnet) {

		try {

			

			if (exste_carnet(carnet)) {

				conexion = getConexion();
				psEliminar = conexion
						.prepareStatement("DELETE FROM estudiantes WHERE carnet = ?");
                                                   
				psEliminar.setString(1, carnet);
				psEliminar.executeUpdate();

				JOptionPane.showMessageDialog(null, "Eliminacion exitosa");

			} else {
				JOptionPane.showMessageDialog(null, "El estudiante no existe");

			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {

			try {
				if (psEliminar != null)
					psEliminar.close();
				if (conexion != null)
					conexion.close();

			} catch (SQLException sqlex) {
				sqlex.printStackTrace();

			}

		}

	}
      
      public M_estudiante consultarDatos(String carnet) {
	M_estudiante estudiante;
        estudiante = new M_estudiante();
		try {
			
			
			
			
			conexion = getConexion();

			psMostrar = conexion
			.prepareStatement("SELECT * FROM estudiantes WHERE carnet  = ?;");
			psMostrar.setString(1, carnet);

			ResultSet resultado = psMostrar.executeQuery();
			boolean encontrado = false;

			
			while (resultado.next()) {
				encontrado = true;
				
				estudiante.setNombre(resultado.getString("nombre"));
                                estudiante.setPrimerApellido(resultado.getString("primerApellido"));
				estudiante.setSegundoApellido(resultado.getString("segundoApellido"));
                                estudiante.setTelefono(resultado.getString("telefono"));
                                
				}

			if (encontrado) {
				control.reporteUsuarios();
			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {

		}
return estudiante;
	}
      
      public JTable generarReporte_estudiante() {

		conexion = getConexion();

		DefaultTableModel modeloTabla = new DefaultTableModel();
		JTable jtbl_tabla = new JTable(modeloTabla);

		try {

			Statement consulta = conexion.createStatement();
			ResultSet resultado = consulta.executeQuery("SELECT   *  FROM estudiantes;");

			ResultSetMetaData metaDatos = resultado.getMetaData();

			int columnas = metaDatos.getColumnCount();
			String[] etiquetas = new String[columnas];

			for (int x = 0; x < columnas; x++) {
				etiquetas[x] = metaDatos.getColumnLabel(x + 1);
			}

			modeloTabla.setColumnIdentifiers(etiquetas);

			while (resultado.next()) {

				Object[] fila = new Object[columnas];
				for (int x = 0; x < columnas; x++) {
					fila[x] = resultado.getObject(x + 1);
				}
				modeloTabla.addRow(fila);

			}

			resultado.close();

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {

			try {
				if (conexion != null)
					conexion.close();

			} catch (SQLException sqlex) {
				sqlex.printStackTrace();

			}

		}

		return jtbl_tabla;

	}
     private boolean exste_carnet(String carnet) {
		boolean flag = false;

		try {
		conexion = getConexion();
			psConsulta = conexion
					.prepareStatement("SELECT carnet FROM estudiantes WHERE carnet = ?;");
			psConsulta.setString(1, carnet);
			ResultSet resultado = psConsulta.executeQuery();

			while (resultado.next()) {
				flag = true;
			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {
			try {
				if (psConsulta != null)
					psConsulta.close();
				if (conexion != null)
					conexion.close();

			} catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}

		}

		return flag;
	} 
     
      private boolean existe_telefono(String telefono) {
		boolean flag = false;

		try {
		conexion = getConexion();
			psConsulta = conexion
					.prepareStatement("SELECT telefono FROM estudiantes WHERE telefono = ?;");
			psConsulta.setString(1, telefono);
			ResultSet resultado = psConsulta.executeQuery();

			while (resultado.next()) {
				flag = true;
			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		} finally {
			try {
				if (psConsulta != null)
					psConsulta.close();
				if (conexion != null)
					conexion.close();

			} catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}

		}

		return flag;
	}
}
