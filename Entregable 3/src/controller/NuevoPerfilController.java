package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cliente;
import view.VentanaNuevoPerfil;
import service.PerfilService;

public class NuevoPerfilController {
	private VentanaNuevoPerfil view;
	private PerfilService service;
	private Cliente c;
	
	public NuevoPerfilController(VentanaNuevoPerfil view, PerfilService service, Cliente c) {
		this.view = view;
		this.service = service;
		this.c = c;
		
		this.view.getBotonCrearPerfil().addActionListener(new CrearPerfilListener());
	}
	
	class CrearPerfilListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String nombre = view.getNombre().trim();
				Integer idCliente = c.getId();
				
				service.crear(nombre, idCliente);
				
				view.mostrarMensaje("Perfil creado con exito");
			}
			catch(Exception exc) {
				view.mostrarMensajeError(exc.getMessage());
			}
		}
	}
}
