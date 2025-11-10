package dao.interfaces;

import java.util.List;
import model.Resenia;

public interface ReseniaDAO {
	void guardar(Resenia resenia);
	List<Resenia> listarNoAprobadas();
	boolean existeNoAprobada(Integer id);
	Resenia imprimir(Integer id);
	void aprobar(Integer idResenia);
}
