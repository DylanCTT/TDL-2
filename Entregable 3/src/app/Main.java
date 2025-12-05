package app;

import view.*;
import service.*;
import util.Conexion;
import util.CreacionTablas;

import java.sql.Connection;
import java.sql.SQLException;

import controller.*;

public class Main {
	public static void main(String[] args) {
		//conexion y creacion tablas
		try {
			Connection conn = Conexion.getConnection();	
			
			if (conn == null) {
				System.out.println("No se pudo establecer la conexion");
				return;
			}
			
			System.out.println("Conexion obtenida");
	    
			CreacionTablas creadorTablas = new CreacionTablas();
			creadorTablas.creacionDeTablasEnDB(conn);
	    
			System.out.println("Tablas creadas correctamente");
		}
		
		catch(SQLException e) {
			System.out.println("Error de Base de datos: " + e.getMessage());
			return;
		}
		
		Vista vista = new Vista();
		VentanaPrincipal ventanaPrincipal = vista.getPanelMain();
		
		VentanaLogin ventanaLogin = ventanaPrincipal.getVentanaLogin();
		ClienteService service = new ClienteService();
		
		LoginController controller = new LoginController(ventanaLogin, service, ventanaPrincipal);
	}
}
