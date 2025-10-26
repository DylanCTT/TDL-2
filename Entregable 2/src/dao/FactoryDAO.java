package dao;

import dao.interfaces.*;
import dao.implJDBC.*;

public class FactoryDAO {

	public static ClienteDAO getClienteDAO() {
		return new ClienteDAOjdbc(); 
	}
	
	public static PerfilDAO getPerfilDAO() {
		return new PerfilDAOjdbc(); 
	}
	
	public static PeliculaDAO getPeliculaDAO() {
		return new PeliculaDAOjdbc(); 
	}
	
	public static ReseniaDAO ReseniaDAO() {
		return new ReseniaDAOjdbc(); 
	}
	
}
