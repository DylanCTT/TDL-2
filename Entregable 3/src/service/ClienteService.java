package service;

import java.util.regex.Pattern;
import dao.FactoryDAO;
import dao.interfaces.ClienteDAO;
import model.Cliente;
import exceptions.*;

public class ClienteService {
	private ClienteDAO clienteDAO;
	
	public ClienteService() {
		this.clienteDAO = FactoryDAO.getClienteDAO();
	}
	
	private boolean stringEsMail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		
		Pattern p = Pattern.compile(emailRegex);
		
		return p.matcher(email).matches();
	}
	
	public Cliente ingresar(String email, String password) throws Exception {
		if (!stringEsMail(email)) throw new Exception("El mail ingresado no es valido");
		
		if (!clienteDAO.existeEmail(email)) throw new ClientNotFoundException("El email ingresado no esta registrado");
		
		if ((email.isEmpty()) || (password.isEmpty())) throw new Exception("Ingrese todos los campos");
		
		Cliente c = clienteDAO.devolverClienteXmail(email);
		
		return c;
	}
	
	public void registar(String nombres, String apellidos, int dni, String email, String password) throws Exception {
		if (clienteDAO.existeDNI(dni)) throw new Exception("El DNI ingresado ya existe");
		
		if (!stringEsMail(email)) throw new Exception("El mail ingresado no es valido");
		
		if (clienteDAO.existeEmail(email)) throw new ClientAlreadyExistsException("El email ingresado ya esta registrado");
		
		if ((nombres.isEmpty()) || (apellidos.isEmpty()) || (dni < 0) || (email.isEmpty()) || password.isEmpty()) throw new Exception("Ingrese todos los campos");
		
		Cliente c = new Cliente(nombres, apellidos, dni, email, password, 0);
		
		clienteDAO.guardar(c);
	}
}
