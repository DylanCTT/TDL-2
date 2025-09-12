package user;

import java.util.List;

public class Individual extends Reporte{
	private int tiempoTot;
	private List<String> generosFav;
	
	
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
