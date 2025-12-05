package controller;

import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import exceptions.MovieNotFoundException;
import model.Pelicula;
import model.Perfil;
import view.VentanaPrincipal;
import view.VentanasEnum;
import view.VentanaBienvenida;
import view.VentanaCalificarPelicula;
import view.VentanaInfoPelicula;
import service.PeliculaService;
import service.ReseniaService;


public class BienvenidaController {
	private VentanaBienvenida view;
	private PeliculaService service;
	private VentanaPrincipal ventanaPrincipal;
	private List<Pelicula> peliculas;
	private Perfil perfilActual;
	
	public BienvenidaController(VentanaBienvenida view, PeliculaService service, VentanaPrincipal ventanaPrincipal, Perfil perfilActual) {
		this.view = view;
		this.service = service;
		this.ventanaPrincipal = ventanaPrincipal;
		this.perfilActual = perfilActual;
		
		view.mostrarPantalla("espera");
		
		Thread t = new Thread(new CargaPeliculasTask());
		t.start();
		//this.view.getBtnBuscar().addActionListener(new BuscarPeliculaXtitulo());
	}
	
	class CargaPeliculasTask implements Runnable {
		public void run() {
			peliculas = service.cargarPeliculas("src/resources/movies_database.csv");
			
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
				// me da el boton que aprete
				JButton btnPresionado = (JButton) e.getSource();
				
				//tomo pos del boton que presione
				int pos = view.getBotonesCalificar().indexOf(btnPresionado);
				
				Pelicula peliculaAclasificar = peliculas.get(pos);
				
				VentanaCalificarPelicula ventanaCalificarPelicula = ventanaPrincipal.getVentanaCalificarPelicula();
				ventanaCalificarPelicula.actualizarPelicula(peliculaAclasificar);
				System.out.println(peliculaAclasificar.getTitulo());
				ventanaCalificarPelicula.actualizarPerfil(perfilActual);
				
				ReseniaService reseniaService = new ReseniaService();
				
				CalificarPeliculaController controller = new CalificarPeliculaController(ventanaCalificarPelicula, reseniaService, ventanaPrincipal);
			
				ventanaPrincipal.mostrarCarta(VentanasEnum.CALIFICARPELICULA);
			}
			catch(Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	class BuscarPeliculaXtitulo implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String titulo = view.getTextoBusqueda().trim();
		        Pelicula p = service.buscar(titulo);
	        	
	            // Actualizar VentanaInfoPelicula con la película encontrada
	            VentanaInfoPelicula ventanaInfo = ventanaPrincipal.getVentanaInfoPelicula();
	            ventanaInfo.actualizarPelicula(p);

	            // Mostrar la carta de información
	            ventanaPrincipal.mostrarCarta(VentanasEnum.INFOPELICULA);
	        } 
	        catch(Exception exc) {
	            view.mostrarMensajeError(exc.getMessage());
	        }
	    }
	}
	
}
