package controller;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cliente;
import model.Perfil;
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

				Cliente c = service.ingresar(email, password);
				
				view.mostrarMensaje("Login realizado con exito");
				
				PerfilService service = new PerfilService();
				ArrayList<Perfil> perfiles = (ArrayList<Perfil>) service.getPerfilesXidCliente(c.getId());
				VentanaPerfiles view = new VentanaPerfiles(perfiles);
				
				PerfilesController controller = new PerfilesController(view, service, c);
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