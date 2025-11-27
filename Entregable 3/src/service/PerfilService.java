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
	
	public List<Perfil> getPerfilesXidCliente(Integer id) {
		List<Perfil> perfiles = perfilDAO.getPerfilesXidCliente(id);
		return perfiles;
	}
}
