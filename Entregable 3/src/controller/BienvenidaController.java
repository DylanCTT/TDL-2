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
import view.VentanaLogin;
import view.VentanaBienvenida;
import view.VentanaCalificarPelicula;
import view.VentanaInfoPelicula;
import service.PeliculaService;
import service.PerfilService;
import service.ReseniaService;

public class BienvenidaController {
	private VentanaBienvenida view;
	private PeliculaService peliculaService;
	private PerfilService perfilService;
	private VentanaPrincipal ventanaPrincipal;
	private List<Pelicula> peliculas;
	private Perfil perfilActual;
	
	public BienvenidaController(VentanaBienvenida view, PeliculaService peliculaService, PerfilService perfilService, VentanaPrincipal ventanaPrincipal, Perfil perfilActual) {
		this.view = view;
		this.peliculaService = peliculaService;
		this.perfilService = perfilService;
		this.ventanaPrincipal = ventanaPrincipal;
		this.perfilActual = perfilActual;
		
		view.mostrarPantalla("espera");
		
		Thread t = new Thread(new CargaPeliculasTask());
		t.start();
		
		this.view.getBtnBuscar().addActionListener(new BuscarPeliculaListener());
		
		this.view.getBtnCerrarSesion().addActionListener(new CerrarSesionListener());
	}
	
	class CargaPeliculasTask implements Runnable {
		public void run() {
			if (!peliculaService.hayPeliculas()) peliculas = peliculaService.cargarPeliculas("src/resources/movies_database.csv");
			else {
				if (perfilActual.getCantAccesos() == 0) peliculas = peliculaService.listar10mayorVotacionPromedio();
				else peliculas = peliculaService.listar10randomSinCalificar(perfilActual.getId());
			}
			
			SwingUtilities.invokeLater(() -> {
				view.mostrarPeliculas(peliculas);
				view.mostrarPantalla("peliculas");
				
				List<JButton> botones = view.getBotonesCalificar();
				
				for (JButton b : botones) {
					b.addActionListener(new CalificarListener());
				}
			});
			
			perfilService.sumarNroAccesos(perfilActual);
			perfilActual.setCantAccesos(perfilActual.getCantAccesos() + 1);
		}
	}
	
	class CalificarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// me da el boton que aprete
				JButton btnPresionado = (JButton) e.getSource();
				
				//tomo pos del boton que presione
				int pos = view.getBotonesCalificar().indexOf(btnPresionado);
				
				Pelicula peliculaAclasificar = peliculas.get(pos);
				
				VentanaCalificarPelicula ventanaCalificarPelicula = ventanaPrincipal.getVentanaCalificarPelicula();
				ventanaCalificarPelicula.actualizarPelicula(peliculaAclasificar);
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
	
	class BuscarPeliculaListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	String titulo = view.getTextoBusqueda().trim();
		        Pelicula p = peliculaService.buscar(titulo);
	        	
	            VentanaInfoPelicula ventanaInfo = ventanaPrincipal.getVentanaInfoPelicula();
	            ventanaInfo.actualizarPelicula(p);

	            ventanaPrincipal.mostrarCarta(VentanasEnum.INFOPELICULA);
	        } 
	        catch(Exception exc) {
	            view.mostrarMensajeError(exc.getMessage());
	        }
	    }
	}
	
	class CerrarSesionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				VentanaLogin ventanaLogin = ventanaPrincipal.getVentanaLogin();
				
				ventanaLogin.setEmail("");
				ventanaLogin.setPassword("");
				
				ventanaPrincipal.mostrarCarta(VentanasEnum.LOGIN);
			}
			
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
}
