package controller;

import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.VentanaPerfiles;
import service.PerfilService;

public class PerfilesController {
	private VentanaPerfiles view;
	private PerfilService service;
	
	public PerfilesController(VentanaPerfiles view, PerfilService service) {
		this.view = view;
		this.service = service;
		
		List<JButton> botones = view.getBotonesSeleccionar();
		
		for (int i = 0 ; i < botones.size(); i++) {
			botones.get(i).addActionListener(new SeleccionarListener());
		}
	}
	
	class SeleccionarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				//abrir ventana bienvenida
			}
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	
}
