package service;

import dao.FactoryDAO;
import dao.interfaces.ReseniaDAO;
import model.Resenia;

public class ReseniaService {
	private ReseniaDAO reseniaDAO;
	
	public ReseniaService() {
		this.reseniaDAO = FactoryDAO.getReseniaDAO();
	}
	
	public void crear(String comentario, int puntaje) throws Exception {
		if (!comentario.isEmpty()) throw new Exception("Ingrese todos los campos");
		
		Resenia r = new Resenia(comentario, puntaje);
		
		reseniaDAO.guardar(r);
	}
}
