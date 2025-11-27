package controller;

import view.VentanaNuevoPerfil;
import service.PerfilService;

public class NuevoPerfilController {
	private VentanaNuevoPerfil view;
	private PerfilService service;
	
	public NuevoPerfilController(VentanaNuevoPerfil view, PerfilService service) {
		this.view = view;
		this.service = service;
	}
}
