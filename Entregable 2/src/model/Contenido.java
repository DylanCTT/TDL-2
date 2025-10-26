package model;

import java.util.List;

public class Contenido {
	private String genero; //se utiliza esta VI para el modelado de la BD 
	private List<String> generos;
	private String sinopsis;
	private String director;
	
	public Contenido(String genero, List<String> generos, String sinopsis, String director) {
		this.genero = genero;
		this.generos = generos;
		this.sinopsis = sinopsis;
		this.director = director;
	}
	
	public Contenido() {
		
	}
	

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}
