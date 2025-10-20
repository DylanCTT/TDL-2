package user;

import java.util.List;

/**
 * Representa al tipo de usuario con acceso a funciones especiales (reportes, modificacion de catalogo, etc.)
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */


public class Admin {
	private List<Reporte> listaReportes;

	public Admin(List<Reporte> listaReportes) {
		super();
		this.listaReportes = listaReportes;
	}
	
	public Admin() {
		
	}

	public List<Reporte> getListaReportes() {
		return listaReportes;
	}

	public void setListaReportes(Reporte R) {
		listaReportes.add(R);
	}
	
	public void agregarContenido(Contenido C) {
		
	}
	
	public String informarReportes () {
	  String reporte = "";
	  return reporte;
	}
	
}
