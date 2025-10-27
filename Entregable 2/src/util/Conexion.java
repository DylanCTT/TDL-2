package util;

import java.sql.*;

public class Conexion {

  //guarda la conexion compartida
  private static Connection conn = null;
  static {
	  try {
		  conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/valen/Desktop/TDL-2/Entregable 2/plataforma.db");
	  }
	  catch (SQLException e) {
		  System.out.println("Error al conectar con BD: " + e.getMessage());
	  }
  }
  
  //constructor privado para evitar instancias
  private Conexion() {
	  
  }
	  
  //conecta a la base de datos
  public static Connection getConnection() { 
	  return conn;
  }
	  
}

