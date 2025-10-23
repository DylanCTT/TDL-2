package dao.interfaces;

import java.util.List;
import model.Usuario;

public interface UsuarioDAO {
	void guardar(Usuario usuario);
	List<Usuario> listar();
}
