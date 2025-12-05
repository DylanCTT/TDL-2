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
		
		this.view.getBtnCerrarSesion().addActionListener(new CerrarSesionListener());
		
		this.view.getBtnBuscar().addActionListener(new BuscarPeliculaListener());
		
		this.view.getCmbOrden().addActionListener(new OrdenListener());
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
								
				for (JButton b : view.getBotonesCalificar()) {
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
	        	
	        	if (titulo.isEmpty()) {
	        		view.mostrarMensajeError("Por favor, ingrese el titulo de una pelicula");
	        		return;
	        	}
	        	
		        Pelicula p = peliculaService.buscar(titulo);
	        			        
		        if (p!= null) {
		        	VentanaInfoPelicula ventanaInfo = ventanaPrincipal.getVentanaInfoPelicula();
		        	ventanaInfo.actualizarPelicula(p);
	            
		        	InfoPeliculaController controller = new InfoPeliculaController(ventanaInfo, ventanaPrincipal);

		        	ventanaPrincipal.mostrarCarta(VentanasEnum.INFOPELICULA);
		        }
		        else {
		        	view.mostrarMensajeError("El titulo ingresado no existe");
		        }
	        } 
	        catch(MovieNotFoundException exc) {
	        	view.mostrarMensajeError(exc.getMessage());
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
				
				view.setTextoBusqueda("");
				ventanaLogin.setEmail("");
				ventanaLogin.setPassword("");
				
				ventanaPrincipal.mostrarCarta(VentanasEnum.LOGIN);
			}
			
			catch (Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
	
	class OrdenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox<String> cmbOrden = (JComboBox<String>) e.getSource();
			String orden = (String) cmbOrden.getSelectedItem();
			
			if ((peliculas == null) || (peliculas.isEmpty()) || orden.equals("Ordenar por...")) return;
		
			switch (orden) {
				case "Titulo (Descendente)":
					peliculas.sort((p1, p2) -> p1.getTitulo().compareToIgnoreCase(p2.getTitulo()));
					break;
				case "Titulo (Ascendente)":
					peliculas.sort((p1, p2) -> p2.getTitulo().compareToIgnoreCase(p1.getTitulo()));
					break;
				case "Genero (Descendente)":
					peliculas.sort((p1, p2) -> p1.getGenero().toString().compareToIgnoreCase(p2.getGenero().toString()));
					break;
				case "Genero (Ascendente)":
					peliculas.sort((p1, p2) -> p2.getGenero().toString().compareToIgnoreCase(p1.getGenero().toString()));
					break;
			}
			
			view.mostrarPeliculas(peliculas);
			
			for (JButton b : view.getBotonesCalificar()) {
				b.addActionListener(new CalificarListener());
			}
		}
	}
}
