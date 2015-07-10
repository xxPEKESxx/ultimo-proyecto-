package conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class Conex {

	public static Connection getConexion() {
		Connection conexion = null;
		try {
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=ucr;user=sa;password=123;";
			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    
                    conexion = DriverManager.getConnection(url);
                      
		} catch (ClassNotFoundException cnfex) {
			System.err.print("Error # 1");
			System.out.println("Imposible abrir la clase");

		} catch (SQLException sqlex) {
			System.err.print("Error # 2");
			System.out.println("Imposible obtener la conexion");
		}

		return conexion;
	}

	// ********************************
public void cerrarConexion(Connection conexion) {
		try {
			if (conexion != null)
				conexion.close();
			
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
	protected boolean tablaExiste(Connection conexion, String nombreTabla){
		
		boolean flag = false;
		
		try{
			
			DatabaseMetaData data = conexion.getMetaData();
			ResultSet tabla = data.getTables(null, null, nombreTabla, null);
			
			if (tabla.next())
				flag = true;
			
		}catch(SQLException sqlex){
			sqlex.printStackTrace();
		
		} finally {
			
			try{
				if (conexion != null)
				conexion.close();
			
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
			}
			
		}
		
		return flag;
	
	}
	
}//Fin de clase.
