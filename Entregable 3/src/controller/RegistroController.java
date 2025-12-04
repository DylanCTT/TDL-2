package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.VentanaRegistro;
import view.VentanaPrincipal;
import view.VentanasEnum;
import service.ClienteService;

public class RegistroController {
	private VentanaRegistro view;
	private ClienteService service;
	private VentanaPrincipal ventanaPrincipal;
	
	public RegistroController(VentanaRegistro view, ClienteService service, VentanaPrincipal ventanaPrincipal) {
		this.view = view;
		this.service = service;
		this.ventanaPrincipal = ventanaPrincipal;
		
		this.view.getBotonRegistro().addActionListener(new RegistarListener());
		this.view.getBotonRetroceso().addActionListener(new RetrocesoListener());
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
				
				// Volver a la ventana de login después del registro
				ventanaPrincipal.mostrarCarta(VentanasEnum.LOGIN);
			}
			catch (Exception exc) {
				view.mostarMensajeError(exc.getMessage());
			}
		}
	}
	
	class RetrocesoListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        ventanaPrincipal.mostrarCarta(VentanasEnum.LOGIN);
	    }
	}
	
}
