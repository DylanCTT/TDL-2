package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.VentanaCalificarPelicula;
import service.ReseniaService;

public class CalificarPeliculaController {
	private VentanaCalificarPelicula view;
	private ReseniaService service;
	
	public CalificarPeliculaController(VentanaCalificarPelicula view, ReseniaService service) {
		this.view = view;
		this.service = service;
		
		this.view.getBotonGuardar().addActionListener(new GuardarListener());
	}
	
	class GuardarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String comentario = view.getTaComentario().trim();
				int puntaje = view.getPuntaje();
				
				service.crear(comentario, puntaje);
			}
			catch (Exception exc) {
				
			}
		}
	}
}
