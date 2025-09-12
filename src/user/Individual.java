package user;

import java.util.List;

/**
 * Representa un reporte que contiene datos sobre un cliente 
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Individual extends Reporte {
	private int tiempoTot;
	private List<String> generosFav;
	
	public Individual(String contenido, int tiempoTot, List<String> generosFav) {
		super(contenido);
		this.tiempoTot = tiempoTot;
		this.generosFav = generosFav;
	}
	
	public Individual() {
		
	}

	public int getTiempoTot() {
		return tiempoTot;
	}
	
	public void setTiempoTot(int tiempoTot) {
		this.tiempoTot = tiempoTot;
	}
	
	public List<String> getGenerosFav() {
		return generosFav;
	}
	
	public void setGenerosFav(String genero) {
		this.generosFav.add(genero);
	}
	
	
	
}
