package user;

import java.util.List;

/**
 * Representa un reporte que contiene datos sobre el rendimiento financiero de la plataforma
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Financiero extends Reporte{
	private List<Integer> cantSubsPlan;

	public Financiero(String contenido, List<Integer> cantSubsPlan) {
		super(contenido);
		this.cantSubsPlan = cantSubsPlan;
	}
	
	public Financiero() {
		
	}
	
	public List<Integer> getCantSubsPlan() {
		return cantSubsPlan;
	}

	public void setCantSubsPlan(List<Integer> cantSubsPlan) {
		this.cantSubsPlan = cantSubsPlan;
	}
	
	
	
}
