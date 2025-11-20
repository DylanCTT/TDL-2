package service;

import dao.FactoryDAO;
import dao.interfaces.*;
import model.Cliente;

public class ClienteService {
	private ClienteDAO clienteDAO;
	
	public ClienteService() {
		this.clienteDAO = FactoryDAO.getClienteDAO();
	}
	
	public void registar(String nombres, String apellidos, int dni, String email, String password) {
		//hacer validaciones
		
		Cliente c = new Cliente(nombres, apellidos, dni, email, password);
		
		clienteDAO.guardar(c);
	}
}
