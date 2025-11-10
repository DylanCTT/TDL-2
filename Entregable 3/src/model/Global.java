package model;

/**
 * Representa un reporte que contiene datos sobre los clientes de la plataforma
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Global extends Reporte{
	private int subsActivos;
	
	public Global(String contenido, int subsActivos) {
		super(contenido);
		this.subsActivos = subsActivos;
	}
	
	public Global() {
		
	}

	public int getSubsActivos() {
		return subsActivos;
	}

	public void setSubsActivos(int subsActivos) {
		this.subsActivos = subsActivos;
	}
		
}
