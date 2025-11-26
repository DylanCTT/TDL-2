package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.VentanaLogin;
import view.VentanaPerfiles;
import view.VentanaRegistro;
import service.PerfilService;
import service.ClienteService;

public class LoginController {
	private VentanaLogin view;
	private ClienteService service;

	public LoginController(VentanaLogin view, ClienteService service) {
		this.view = view;
		this.service = service;

		this.view.getBotonIngresar().addActionListener(new IngresarListener());
		this.view.getBotonRegistrate().addActionListener(new RegistrateListener());
	}

	class IngresarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String email = view.getEmail().trim();
				String password = view.getPassword().trim();

				service.ingresar(email, password);
				
				view.mostrarMensaje("Login realizado con exito");
				
				VentanaPerfiles view = new VentanaPerfiles();
				PerfilService service = new PerfilService();
				
				PerfilesController controller = new PerfilesController(view, service);
			} 
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	class RegistrateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaRegistro view = new VentanaRegistro();
				ClienteService service = new ClienteService();
				
				RegistroController controller = new RegistroController(view, service); 
			} 
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
}