package util;

import java.sql.*;

public class Conexion {

	private static Connection conn;
	
	private static final String url_BD = "jdbc:sqlite:plataforma.db";

	private Conexion() {
	  
	}
  
	public static Connection getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(url_BD);
				System.out.println("Conexion establecida con la base de datos");
			}
		}
		
		catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos: " + e.getMessage());
			return null;
		}
		
		return conn;
	}
}


