package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

;

public class Conexion {
	private static final String Controlador ="com.mysql.jdbc.Driver";
	private static final String Url = "jdbc:mysql://localhost:3306/inventario";
	private static final String Usuario="root";
	private static final String Contraseña="krauser1998";

	static {
		try {
			Class.forName(Controlador);
		} catch (ClassNotFoundException e) {
			System.out.println("error al cargar el controlador");
			
			e.printStackTrace();
		}
	}
	public Connection conectar() {
		
		Connection conexion = null;
		try {
			
			
			conexion = DriverManager.getConnection(Url,Usuario,Contraseña);
			System.out.println("conexion ok");
		
		} catch (SQLException e) {
			System.out.println("error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}
		
	
	

}
