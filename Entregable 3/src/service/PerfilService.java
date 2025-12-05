package service;

import java.util.List;
import java.util.ArrayList;
import dao.FactoryDAO;
import dao.interfaces.PerfilDAO;
import model.Perfil;

public class PerfilService {
	private PerfilDAO perfilDAO;
	
	public PerfilService() {
		this.perfilDAO = FactoryDAO.getPerfilDAO();
	}
	
	public void crear(String nombre, Integer idCliente) throws Exception {
		if (nombre.isEmpty()) throw new Exception("Ingrese todos los campos");
		
		Perfil p = new Perfil(nombre, idCliente);
		
		Integer id = perfilDAO.guardar(p);
		
		p.setId(id);
	}
	
	public List<Perfil> getPerfilesXidCliente(Integer id) {
		List<Perfil> perfiles = perfilDAO.getPerfilesXidCliente(id);
		return perfiles;
	}
	
	public void sumarNroAccesos(Perfil p) {
		perfilDAO.sumarNroAccesos(p);
	}
}
