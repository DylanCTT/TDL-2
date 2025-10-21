package util;

import java.sql.*;

public class Conexion {

  //guarda la conexion compartida
  private static Connection conn = null;
  
  //constructor privado para evitar instancias
  private Conexion() {
  }
	  
  public static Connection getConnection() throws SQLException { 
	  if (conn == null || conn.isClosed()) {
		  conn = DriverManager.getConnection("jdbc:sqlite:plataforma.db");
	  }
	  return conn;
  }
  
  public static void closeConnection() throws SQLException {
	  if (conn != null && !conn.isClosed()) {
	    conn.close();	  
	  }
  }
	  
  }
