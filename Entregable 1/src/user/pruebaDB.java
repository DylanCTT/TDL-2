package user;

import java.sql.*;

public class pruebaDB {

  public static void main(String[] args) {
    try {
      Connection conn = DriverManager.getConnection("jdbc:sqlite:plataforma.db");
      System.out.println("✅ Conexión establecida");
      conn.close();
     } 
     catch (SQLException e) {
       System.out.println("❌ Error de conexión: " + e.getMessage());
     }
  }	
	
}
