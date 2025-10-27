package dao.interfaces;

import java.util.List;
import model.Perfil;

public interface PerfilDAO {
	void guardar(Perfil perfil);
	List<Perfil> listar();
}
