package controller;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import model.Pelicula;
import view.VentanaPrincipal;
import view.VentanasEnum;
import view.VentanaBienvenida;
import view.VentanaCalificarPelicula;
import service.PeliculaService;
import service.ReseniaService;

public class BienvenidaController {
	private VentanaBienvenida view;
	private PeliculaService service;
	private VentanaPrincipal ventanaPrincipal;
	
	public BienvenidaController(VentanaBienvenida view, PeliculaService service, VentanaPrincipal ventanaPrincipal) {
		this.view = view;
		this.service = service;
		this.ventanaPrincipal = ventanaPrincipal;
		
		view.mostrarPantalla("espera");
		
		Thread t = new Thread(new CargaPeliculasTask());
		t.start();
	}
	
	class CargaPeliculasTask implements Runnable {
		public void run() {
			List<Pelicula> peliculas = service.cargarPeliculas("src/resources/movies_database.csv");
			
			SwingUtilities.invokeLater(() -> {
				view.mostrarPeliculas(peliculas);
				view.mostrarPantalla("peliculas");
				
				List<JButton> botones = view.getBotonesCalificar();
				
				for (JButton b : botones) {
					b.addActionListener(new CalificarListener());
				}
			});
		}
	}
	
	class CalificarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaCalificarPelicula ventanaCalificarPelicula = ventanaPrincipal.getVentanaCalificarPelicula();
				ReseniaService reseniaService = new ReseniaService();
				
				CalificarPeliculaController controller = new CalificarPeliculaController(ventanaCalificarPelicula, reseniaService);
			
				ventanaPrincipal.mostrarCarta(VentanasEnum.CALIFICARPELICULA);
			}
			catch(Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
}
