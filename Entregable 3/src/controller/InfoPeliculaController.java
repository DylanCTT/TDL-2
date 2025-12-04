package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.VentanaBienvenida;
import view.VentanaInfoPelicula;

public class InfoPeliculaController {
	private VentanaInfoPelicula view;
	
	public InfoPeliculaController(VentanaInfoPelicula view) {
		this.view = view;
		
		this.view.getBotonContinuar().addActionListener(new ContinuarListener());
	}
	
	class ContinuarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaBienvenida view = new VentanaBienvenida();	
			}
			catch(Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
}
