package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.VentanaBienvenida;
import view.VentanaInfoPelicula;
import view.VentanaPrincipal;
import view.VentanasEnum;

public class InfoPeliculaController {
	private VentanaInfoPelicula view;
	private VentanaPrincipal ventanaPrincipal;
	
	public InfoPeliculaController(VentanaInfoPelicula view, VentanaPrincipal ventanaPrincipal) {
		this.view = view;
		this.ventanaPrincipal = ventanaPrincipal;
		
		this.view.getBotonContinuar().addActionListener(new ContinuarListener());
	}
	
	class ContinuarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				// Volver a la vista de bienvenida
				ventanaPrincipal.mostrarCarta(VentanasEnum.BIENVENIDA);
			}
			catch(Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
}
