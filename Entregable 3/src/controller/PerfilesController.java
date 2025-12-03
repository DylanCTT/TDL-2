package controller;

import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cliente;
import view.VentanaPerfiles;
import view.VentanaBienvenida;
import view.VentanaNuevoPerfil;
import service.PerfilService;
import service.PeliculaService;

public class PerfilesController {
	private VentanaPerfiles view;
	private PerfilService service;
	private Cliente c;
	
	public PerfilesController(VentanaPerfiles view, PerfilService service, Cliente c) {
		this.view = view;
		this.service = service;
		this.c = c;
		
		List<JButton> botones = view.getBotonesSeleccionar();
		
		for (int i = 0 ; i < botones.size(); i++) {
			botones.get(i).addActionListener(new SeleccionarListener());
		}
		
		this.view.getBotonAgregarPerfiles().addActionListener(new AgregarPerfilListener());
	}
	
	class SeleccionarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaBienvenida view = new VentanaBienvenida();
				PeliculaService service = new PeliculaService();
				
				BienvenidaController controller = new BienvenidaController(view, service);
			}
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	class AgregarPerfilListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaNuevoPerfil view = new VentanaNuevoPerfil();
				PerfilService service = new PerfilService();
				
				NuevoPerfilController controller = new NuevoPerfilController(view, service, c);
			}
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	
}
