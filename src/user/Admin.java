package user;

import java.util.List;

public class Admin {
	private List<Reporte> listaReporte;

	public Admin(List<Reporte> listaReporte) {
		super();
		this.listaReporte = listaReporte;
	}

	public List<Reporte> getListaReportes() {
		return listaReporte;
	}

	public void setListaReportes(Reporte R) {
		listaReporte.add(R);
	}
	
	
}
