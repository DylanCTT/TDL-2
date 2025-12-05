package controller;

import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cliente;
import model.Perfil;
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
	private List<Perfil> perfiles;
	
	public PerfilesController(VentanaPerfiles view, PerfilService service, Cliente c, VentanaPrincipal ventanaPrincipal, List<Perfil> perfiles) {
		this.view = view;
		this.service = service;
		this.c = c;
		this.ventanaPrincipal = ventanaPrincipal;
		this.perfiles = perfiles;
		
		List<JButton> botones = view.getBotonesSeleccionar();
		
		for (JButton b : botones) {
			b.addActionListener(new SeleccionarListener());
		}
		
		this.view.getBotonAgregarPerfiles().addActionListener(new AgregarPerfilListener());
	}
	
	class SeleccionarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				JButton btnPresionado = (JButton) e.getSource();
				
				int pos = view.getBotonesSeleccionar().indexOf(btnPresionado);
				
				Perfil perfilSeleccionado = perfiles.get(pos);
				
				VentanaBienvenida ventanaBienvenida = ventanaPrincipal.getVentanaBienvenida();
				PeliculaService peliculaService = new PeliculaService();
				
				BienvenidaController controller = new BienvenidaController(ventanaBienvenida, peliculaService, ventanaPrincipal, perfilSeleccionado);
				
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
