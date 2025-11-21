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
			try {
				String nombres = view.getNombres().trim();
				String apellidos = view.getApellidos().trim();
				int dni = view.getDni();
				String email = view.getEmail().trim();
				String password = view.getPassword().trim();
				
				service.registar(nombres, apellidos, dni, email, password);
				
				view.mostrarMensaje("Registro realizado con exito");
			}
			catch (Exception exc) {
				view.mostarMensajeError(exc.getMessage());
			}
		}
	}
	
}
