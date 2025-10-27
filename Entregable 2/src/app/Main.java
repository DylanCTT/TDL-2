package app;

import java.util.Scanner;

//import java.sql.*;

//import util.*;

public class Main {
  
	public static void main(String[] args) {
		/*try {
			Connection conn = Conexion.getConnection();	  
			System.out.println("Conexion obtenida");
	    
			CreacionTablas creadorTablas = new CreacionTablas();
			creadorTablas.creacionDeTablasEnDB(conn);
	    
			Conexion.closeConnection();
			System.out.println("Tablas creadas correctamente");
		}
		catch(SQLException e) {
			System.out.println("Error de Base de datos: " + e.getMessage());
		}*/
		
		int op;
		boolean salir = false;
		Scanner in = new Scanner (System.in);
		
		System.out.println("Bienvenido a Plataforma de Streaming TDL2");
		
		while (!salir) {
			System.out.println("Ingrese una de las siguientes operaciones: ");
		
			System.out.println("1. Registrar datos personales de cliente");
			System.out.println("2. Registrar datos de un perfil");
			System.out.println("3. Registrar pelicula");
			System.out.println("4. Listar perfiles");
			System.out.println("5. Listar peliculas");
			System.out.println("6. Registrar resenia");
			System.out.println("7. Aprobar resenia");
			System.out.println("8. Salir");
		
			op = in.nextInt();
		
			switch (op) {
			case 1:
				Operaciones.registrarCliente();
				break;
			case 2:
				Operaciones.registrarPerfil();
				break;
			case 3:
				Operaciones.registrarPelicula();
				break;
			case 4:
				Operaciones.listarPerfilesOrdenado();
				break;
			case 5:
				Operaciones.listarPeliculasOrdenado();
				break;
			case 6:
				Operaciones.registrarResenia();
				break;
			case 7:
				Operaciones.aprobarResenia();
				break;
			case 8:
				salir = true;
				System.out.println("Saliendo...");
				System.out.println("Plataforma cerrada correctamente");
				break;
			default:
				System.out.println("Operacion invalida");
			}
		}
		
		in.close();
	}
}
