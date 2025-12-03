package controller;

import java.util.List;
import java.awt.*;
import javax.swing.*;
import model.Pelicula;
import view.VentanaBienvenida;
import service.PeliculaService;

public class BienvenidaController {
	private VentanaBienvenida view;
	private PeliculaService service;
	
	public BienvenidaController(VentanaBienvenida view, PeliculaService service) {
		this.view = view;
		this.service = service;
		
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
