package service;

import java.time.LocalDateTime;
import dao.FactoryDAO;
import dao.interfaces.ReseniaDAO;
import model.Resenia;

public class ReseniaService {
	private ReseniaDAO reseniaDAO;
	
	public ReseniaService() {
		this.reseniaDAO = FactoryDAO.getReseniaDAO();
	}
	
	public void crear(String comentario, int puntaje, Integer idPerfil, Integer idPelicula) throws Exception {
		if (comentario == null || comentario.trim().isEmpty()) {
			throw new Exception("Ingrese todos los campos");
		}
		if (puntaje < 1 || puntaje > 5) {
			throw new Exception("El puntaje debe estar entre 1 y 5");
		}
		if (idPerfil == null || idPelicula == null) {
			throw new Exception("Debe especificar el perfil y la película");
		}
		
		Resenia r = new Resenia();
		r.setContenido(comentario.trim());
		r.setPuntaje(puntaje);
		r.setAprobada(false); // Por defecto no está aprobada
		r.setFecha(LocalDateTime.now());
		r.setIdCliente(idPerfil);
		r.setIdContenido(idPelicula);
		
		reseniaDAO.guardar(r);
	}
}
