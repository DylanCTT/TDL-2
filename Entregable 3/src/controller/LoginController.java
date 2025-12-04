package controller;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cliente;
import model.Perfil;
import view.VentanaLogin;
import view.VentanaPerfiles;
import view.VentanaPrincipal;
import view.VentanaRegistro;
import view.VentanasEnum;
import service.PerfilService;
import service.ClienteService;

public class LoginController {
	private VentanaLogin view;
	private ClienteService service;
	private VentanaPrincipal ventanaPrincipal;

	public LoginController(VentanaLogin view, ClienteService service, VentanaPrincipal ventanaPrincipal) {
		this.view = view;
		this.service = service;
		this.ventanaPrincipal = ventanaPrincipal;

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
				
				PerfilService perfilService = new PerfilService();
				ArrayList<Perfil> perfiles = (ArrayList<Perfil>) perfilService.getPerfilesXidCliente(c.getId());
				
				// Actualizar la ventana de perfiles con los perfiles del cliente
				VentanaPerfiles ventanaPerfiles = ventanaPrincipal.getVentanaPerfiles();
				ventanaPerfiles.actualizarPerfiles(perfiles);
				
				PerfilesController controller = new PerfilesController(ventanaPerfiles, perfilService, c, ventanaPrincipal);
				
				// Cambiar a la vista de perfiles
				ventanaPrincipal.mostrarCarta(VentanasEnum.PERFILES);
			} 
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	class RegistrateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaRegistro ventanaRegistro = ventanaPrincipal.getVentanaRegistro();
				ClienteService registroService = new ClienteService();
				
				RegistroController controller = new RegistroController(ventanaRegistro, registroService, ventanaPrincipal);
				
				// Cambiar a la vista de registro
				ventanaPrincipal.mostrarCarta(VentanasEnum.REGISTRO);
			} 
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
}