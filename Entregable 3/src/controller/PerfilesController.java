package controller;

import view.VentanaPerfiles;
import service.PerfilService;

public class PerfilesController {
	private VentanaPerfiles view;
	private PerfilService service;
	
	public PerfilesController(VentanaPerfiles view, PerfilService service) {
		this.view = view;
		this.service = service;
	}
}
