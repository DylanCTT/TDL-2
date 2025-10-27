package dao.interfaces;

import java.util.List;
import model.Resenia;

public interface ReseniaDAO {
	void guardar(Resenia resenia);
	List<Resenia> listarNoAprobadas();
	Resenia mostrar(Integer id);
	void aprobar(Integer idResenia);
	boolean existeResenia(Integer id);
}
