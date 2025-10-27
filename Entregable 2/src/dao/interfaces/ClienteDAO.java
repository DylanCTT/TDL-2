package dao.interfaces;

import java.util.List;
import model.Cliente;

public interface ClienteDAO {
	void guardar(Cliente cliente);
	List<Cliente> listar();
	boolean existeDNI(int DNI);
	Integer validarCliente(String nom, String pass);
	boolean validarID(Integer id);
}
