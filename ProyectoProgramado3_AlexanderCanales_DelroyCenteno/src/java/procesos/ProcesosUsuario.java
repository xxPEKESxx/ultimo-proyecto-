/*Esta es a clase que se encraga de hacer los procesos para la gestion de la tabla Usuarios.
 * 
 */
package procesos;
import conexion.Conex;
import java.sql.Connection;
import control.ControlUsuarios;
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
 * @author xxACSxx
 */public class ProcesosUsuario extends Conex {

    private Connection conexion = null;
    	private Conex conDB;

    private PreparedStatement psInsertar = null;
	
	private PreparedStatement psConsulta = null;
        	String respuesta = "ERROR CATASTROFICO CON LA CONEXION!!!";
   
    private  ControlUsuarios control;
    
    	public ProcesosUsuario(ControlUsuarios c){
		
		control = c;
                 conDB = new Conex();
		
        }
        
        	public String insertar(String  cedula, String nombre, String apellido1,
			String apellido2, String usuario, String clave) {

		try {

		conexion = Conex.getConexion();
			
			

                    
				if (!existeusuario( cedula)) {
                                System.out.println("entraa1");
                                JOptionPane.showMessageDialog(null, "entra a primer if");
                                if (!existenum_clave(clave)) {
                                 JOptionPane.showMessageDialog(null, "entra a segundo if");
                                    System.out.println("entraa2");

					
					psInsertar = conexion
					.prepareStatement("INSERT INTO usuarios (cedula, nombre, apellido1,  apellido2, usuario, clave)"
									+ "VALUES ( ?, ?, ?, ?, ?, ?);");
 
					psInsertar.setString(1,  cedula);
					psInsertar.setString(2, nombre);
					psInsertar.setString(3, apellido1);
					psInsertar.setString(4, apellido2);
					psInsertar.setString(5, usuario);
                                        psInsertar.setString(6, clave);
                                        

					psInsertar.executeUpdate();

					respuesta= "Usuario agregado";

				
                        
                    }else {
                                  
							respuesta= "la clave ya existe CAMBIELA!!!";
                                }
                                    
                                
                                
                                } else {
					
							respuesta="El numero de cedula ya esta en uso!!!";
				}

			

		} catch (SQLException exsql) {
			System.out.println("Problema con conexion");
			exsql.printStackTrace();
		}finally {
		conDB.cerrarConexion(conexion);
		}
                return respuesta;
                }
             
           
           private boolean existeusuario(String cedula) {
		boolean flag = false;

		try {
		conexion = getConexion();
			psConsulta = conexion
					.prepareStatement("SELECT cedula FROM usuarios WHERE cedula = ?;");
			psConsulta.setString(1, cedula);
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
                   
                
                private boolean existenum_clave(String clave) {
		boolean flag = false;

		try {
		conexion = getConexion();
			psConsulta = conexion
					.prepareStatement("SELECT clave FROM usuarios WHERE clave = ?;");
			psConsulta.setString(1, clave);
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
    
        
        public JTable generarReporte_usuario() {

		conexion = getConexion();

		DefaultTableModel modeloTabla = new DefaultTableModel();
		JTable jtbl_tabla = new JTable(modeloTabla);

		try {

			Statement consulta = conexion.createStatement();
			ResultSet resultado = consulta.executeQuery("SELECT   usuario, nombre , apellido1 , apellido2, clave  FROM usuarios;");

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
        
       
} //Fin de la clase.
