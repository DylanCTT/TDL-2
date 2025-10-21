package model;

/**
 * Representa estadisticas financieras y de datos sobre la plataforma 
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public abstract class Reporte {
	private String contenido;
	
	public Reporte(String contenido) {
		this.contenido = contenido;
	}
	
	public Reporte() {
		
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
}
