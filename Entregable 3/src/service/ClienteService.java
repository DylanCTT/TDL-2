package service;

import java.util.regex.Pattern;
import dao.FactoryDAO;
import dao.interfaces.*;
import model.Cliente;

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
	
	public void ingresar(String email, String password) throws Exception {
		if (!stringEsMail(email)) throw new Exception("El mail ingresado no es valido");
		
		if (!clienteDAO.existeEmail(email)) throw new Exception("El email ingresado no existe");
		
		if ((email.isEmpty()) || (password.isEmpty())) throw new Exception("Ingrese todos los campos");
	}
	
	public void registar(String nombres, String apellidos, int dni, String email, String password) throws Exception {
		if (clienteDAO.existeDNI(dni)) throw new Exception("El DNI ingresado ya existe");
		
		if (!stringEsMail(email)) throw new Exception("El mail ingresado no es valido");
		
		if (clienteDAO.existeEmail(email)) throw new Exception("El email ingresado ya existe");
		
		if ((nombres.isEmpty()) || (apellidos.isEmpty()) || (dni < 0) || (email.isEmpty()) || password.isEmpty()) throw new Exception("Ingrese todos los campos");
		
		Cliente c = new Cliente(nombres, apellidos, dni, email, password);
		
		clienteDAO.guardar(c);
	}
}
