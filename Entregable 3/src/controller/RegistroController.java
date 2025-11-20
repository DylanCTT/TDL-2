package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.VentanaRegistro;
import service.ClienteService;

public class RegistroController {
	private VentanaRegistro view;
	private ClienteService service;
	
	public RegistroController(VentanaRegistro view, ClienteService service) {
		this.view = view;
		this.service = service;
		
		this.view.getBotonRegistro().addActionListener(new RegistarListener());
	}
	
	class RegistarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombres = view.getNombres();
			String apellidos = view.getApellidos();
			int dni = view.getDni();
			String email = view.getEmail();
			String password = view.getPassword();
				
			service.registar(nombres, apellidos, dni, email, password);
		}
	}
	
}
