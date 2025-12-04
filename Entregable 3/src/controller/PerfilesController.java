package controller;

import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cliente;
import view.VentanaPerfiles;
import view.VentanaBienvenida;
import view.VentanaNuevoPerfil;
import view.VentanaPrincipal;
import view.VentanasEnum;
import service.PerfilService;
import service.PeliculaService;

public class PerfilesController {
	private VentanaPerfiles view;
	private PerfilService service;
	private Cliente c;
	private VentanaPrincipal ventanaPrincipal;
	
	public PerfilesController(VentanaPerfiles view, PerfilService service, Cliente c, VentanaPrincipal ventanaPrincipal) {
		this.view = view;
		this.service = service;
		this.c = c;
		this.ventanaPrincipal = ventanaPrincipal;
		
		List<JButton> botones = view.getBotonesSeleccionar();
		
		for (int i = 0 ; i < botones.size(); i++) {
			botones.get(i).addActionListener(new SeleccionarListener());
		}
		
		this.view.getBotonAgregarPerfiles().addActionListener(new AgregarPerfilListener());
	}
	
	class SeleccionarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaBienvenida ventanaBienvenida = ventanaPrincipal.getVentanaBienvenida();
				PeliculaService peliculaService = new PeliculaService();
				
				BienvenidaController controller = new BienvenidaController(ventanaBienvenida, peliculaService, ventanaPrincipal);
				
				// Cambiar a la vista de bienvenida
				ventanaPrincipal.mostrarCarta(VentanasEnum.BIENVENIDA);
			}
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	class AgregarPerfilListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaNuevoPerfil ventanaNuevoPerfil = ventanaPrincipal.getVentanaNuevoPerfil();
				PerfilService perfilService = new PerfilService();
				
				NuevoPerfilController controller = new NuevoPerfilController(ventanaNuevoPerfil, perfilService, c, ventanaPrincipal);
				
				// Cambiar a la vista de nuevo perfil
				ventanaPrincipal.mostrarCarta(VentanasEnum.NUEVOPERFIL);
			}
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	
}
