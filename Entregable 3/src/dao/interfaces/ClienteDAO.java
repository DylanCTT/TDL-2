package dao.interfaces;

import java.util.List;
import model.Cliente;

public interface ClienteDAO {
	boolean existeDNI(int DNI);
	void guardar(Cliente cliente);
	List<Cliente> listar();
	boolean validarID(Integer id);
	Integer validarCliente(String nom, String pass);
	boolean existeEmail(String email);
	Cliente devolverClienteXmail(String email);
}
