package util;

import java.sql.*;

public class CreacionTablas {

/** 
  * Este metodo se encarga de la creación de las tablas donde se 
       * almacenara la 
  * informacion de los objetos. Una vez establecida una conexion, debería 
  * ser lo proximo a ser ejecutado. 
  * 
  * @param connection objeto conexion a la base de datos SQLite 
  * @throws SQLException 
  */ 
	
	public void creacionDeTablasEnDB(Connection connection) throws SQLException { //connection es la conexion activa con la base de datos. usa la connection ya abierta en pruebaDB
																				   //que haya un throws de una exception significa que quien llame al metodo este debera encargarse con un try/catch de manejar el error
		Statement stmt = connection.createStatement(); //se crea un objeto que maneje sentencias SQL sobre esta conexion (crea, modifica, inserta o elimina tablas)
      
	  
		//nuestro "DATOS_PERSONALES"
		String sql = "CREATE TABLE IF NOT EXISTS CLIENTE (" +
					 "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + 
					 "NOMBRE TEXT NOT NULL," +
					 "APELLIDO TEXT NOT NULL," +
					 "DNI INTEGER NOT NULL," +
					 "EMAIL TEXT NOT NULL," + 
					 "CONTRASENIA TEXT NOT NULL" + 
					 ");";       
		stmt.executeUpdate(sql); //executeUpdate modifica la base de datos con el string sql que escribimos
 
      
		//nuestro "USUARIO"
		sql = "CREATE TABLE IF NOT EXISTS PERFIL (" +
			  "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
			  "NOMBRE TEXT NOT NULL," +
			  "ID_CLIENTE INTEGER NOT NULL," +
			  "CONSTRAINT PERFIL_CLIENTE_FK FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE(ID)" +
			  ");";     
		stmt.executeUpdate(sql);
      
      
		sql = "CREATE TABLE IF NOT EXISTS PELICULA (" + 
			  "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
			  "GENERO TEXT NOT NULL," +
			  "TITULO TEXT(100) NOT NULL," + 
			  "RESUMEN TEXT(500) NOT NULL," +
			  "DIRECTOR TEXT(100) NOT NULL," +
			  "DURACION REAL NOT NULL" + 
    		");"; 
      stmt.executeUpdate(sql); 
  
      
      sql = "CREATE TABLE IF NOT EXISTS RESENIA (" + 
    		"ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
    		"PUNTAJE INTEGER NOT NULL," +
    		"CONTENIDO TEXT(500)," +  
    		"APROBADA INTEGER DEFAULT (1) NOT NULL," + 
    		"FECHA DATETIME NOT NULL," +
    		"ID_PERFIL INTEGER NOT NULL," + 
    		"ID_PELICULA INTEGER NOT NULL," + 
    		"CONSTRAINT RESENIA_PERFIL_FK FOREIGN KEY (ID_PERFIL) REFERENCES PERFIL(ID),"+ 
    		"CONSTRAINT RESENIA_PELICULA_FK FOREIGN KEY (ID_PELICULA) REFERENCES PELICULA(ID)"+ 
    		");";   
      stmt.executeUpdate(sql); 
      
      stmt.close(); //cierra el objeto statement, para no dejar conexiones abiertas
	}
}
