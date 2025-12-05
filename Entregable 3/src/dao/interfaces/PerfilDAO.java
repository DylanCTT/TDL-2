package dao.interfaces;

import java.util.List;
import model.Perfil;

public interface PerfilDAO {
	Integer guardar(Perfil perfil);
	List<Perfil> listar();
	List<Perfil> getPerfilesXidCliente(Integer id);
	void sumarNroAccesos(Perfil p);
}
