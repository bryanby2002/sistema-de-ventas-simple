
package cap_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySQl va representar una conexion a la base de datos de nuestro proyecto 
 * para luego hacer consultas desde la Gui a la base de datos
 * @author Bryan, Pery, Pilar, Brady y Jhon
 *
 */
public class MySQL {
	

	public static Connection conexion() {
		
		Connection conex = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conex = DriverManager.getConnection("jdbc:mysql://localhost/pontiFarma","root","plowy");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el diver");
		}catch(SQLException e) {
			System.out.println("Error de conexion en la bd");
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		
		return conex;
	}

}


 