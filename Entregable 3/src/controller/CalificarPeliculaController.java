package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.VentanaPrincipal;
import view.VentanasEnum;
import view.VentanaCalificarPelicula;
import service.ReseniaService;
import model.Pelicula;

public class CalificarPeliculaController {
	private VentanaCalificarPelicula view;
	private ReseniaService service;
	private VentanaPrincipal ventanaPrincipal;
	
	public CalificarPeliculaController(VentanaCalificarPelicula view, ReseniaService service, VentanaPrincipal ventanaPrincipal) {
		this.view = view;
		this.service = service;
		this.ventanaPrincipal = ventanaPrincipal;
		
		this.view.getBotonGuardar().addActionListener(new GuardarListener());
		this.view.getBotonRetroceso().addActionListener(new RetrocesoListener());
	}
	
	class GuardarListener implements ActionListener {
		@Override
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
				
				if (pelicula == null) {
					view.mostrarMensajeError("No se ha seleccionado una película");
					return;
				}
				
				service.crear(comentario, puntaje, idPerfil, pelicula.getId());
				
				view.mostrarMensaje("Reseña guardada exitosamente");
				
				ventanaPrincipal.mostrarCarta(VentanasEnum.BIENVENIDA);
				
				view.setPuntaje(0);
				view.getTaComentarioComponent().setText("");
			}
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	class RetrocesoListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        ventanaPrincipal.mostrarCarta(VentanasEnum.BIENVENIDA);
	    }
	}
}
