package app;

import java.sql.*;
import util.*;

public class Main {
  
	public static void main(String[] args) {
	  try {
	    Connection conn = Conexion.getConnection();	  
	    System.out.println("Conexion obtenida");
	    
	    CreacionTablas creadorTablas = new CreacionTablas();
	    creadorTablas.creacionDeTablasEnDB(conn);
	    
	    Conexion.closeConnection();
	    System.out.println("Tablas creadas correctamente");
	  }
	  catch(SQLException e) {
	    System.out.println("Error de Base de datos: " + e.getMessage());
	  }
	}
	
}
