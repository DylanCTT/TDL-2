package dao.interfaces;

import java.util.List;
import model.Pelicula;

public interface PeliculaDAO {
	Integer guardar(Pelicula pelicula);
	List<Pelicula> listar();
	boolean validarID(Integer id);
	boolean existePelicula(String peli);
	Pelicula devolverPeliculaXtitulo(String peli);
}
