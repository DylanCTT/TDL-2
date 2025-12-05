package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Cliente;
import model.Perfil;
import view.VentanaNuevoPerfil;
import view.VentanaPerfiles;
import view.VentanaPrincipal;
import view.VentanasEnum;
import service.PerfilService;

public class NuevoPerfilController {
	private VentanaNuevoPerfil view;
	private PerfilService service;
	private Cliente c;
	private VentanaPrincipal ventanaPrincipal;
	
	public NuevoPerfilController(VentanaNuevoPerfil view, PerfilService service, Cliente c, VentanaPrincipal ventanaPrincipal) {
		this.view = view;
		this.service = service;
		this.c = c;
		this.ventanaPrincipal = ventanaPrincipal;
		
		this.view.getBotonCrearPerfil().addActionListener(new CrearPerfilListener());
	}
	
	class CrearPerfilListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String nombre = view.getNombre().trim();
				Integer idCliente = c.getId();
				
				service.crear(nombre, idCliente);
				
				view.mostrarMensaje("Perfil creado con exito");
				
				// Recargar los perfiles actualizados
				VentanaPerfiles ventanaPerfiles = ventanaPrincipal.getVentanaPerfiles();
				ArrayList<Perfil> perfiles = (ArrayList<Perfil>) service.getPerfilesXidCliente(c.getId());
				ventanaPerfiles.actualizarPerfiles(perfiles);
				
				// Actualizar los listeners de los botones
				PerfilesController perfilesController = new PerfilesController(ventanaPerfiles, service, c, ventanaPrincipal, perfiles);
				
				// Volver a la vista de perfiles después de crear el perfil
				ventanaPrincipal.mostrarCarta(VentanasEnum.PERFILES);
			}
			catch(Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
}
