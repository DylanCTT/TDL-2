package controller;

import view.VentanaBienvenida;
import service.PeliculaService;

public class BienvenidaController {
	private VentanaBienvenida view;
	private PeliculaService service;
	
	public BienvenidaController(VentanaBienvenida view, PeliculaService service) {
		this.view = view;
		this.service = service;
	}
	
	
}
