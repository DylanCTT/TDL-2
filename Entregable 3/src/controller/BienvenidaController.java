package controller;

import java.util.List;
import java.awt.*;
import javax.swing.*;
import model.Pelicula;
import view.VentanaBienvenida;
import view.VentanaPrincipal;
import service.PeliculaService;

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
			List<Pelicula> peliculas = service.cargarPeliculas("movies_database.csv");
			
			SwingUtilities.invokeLater(() -> {
				view.mostrarPeliculas(peliculas);
				view.mostrarPantalla("peliculas");
			});
		}
	}
	
}
