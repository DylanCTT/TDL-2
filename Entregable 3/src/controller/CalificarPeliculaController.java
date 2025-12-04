package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.VentanaCalificarPelicula;
import service.ReseniaService;
import model.Pelicula;

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
				Integer idPerfil = view.getIdPerfilActual();
				Pelicula pelicula = view.getPeliculaActual();
				
				if (idPerfil == null) {
					view.mostrarMensajeError("No se ha seleccionado un perfil");
					return;
				}
				
				if (pelicula == null || pelicula.getId() == null) {
					view.mostrarMensajeError("No se ha seleccionado una película");
					return;
				}
				
				service.crear(comentario, puntaje, idPerfil, pelicula.getId());
				
				view.mostrarMensaje("Reseña guardada exitosamente");
				
				// Resetear el formulario
				view.setPuntaje(0);
				view.getTaComentarioComponent().setText("");
			}
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
}
