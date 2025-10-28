package dao.interfaces;

import java.util.List;
import model.Pelicula;

public interface PeliculaDAO {
	void guardar(Pelicula pelicula);
	List<Pelicula> listar();
	boolean validarID(Integer id);
}
