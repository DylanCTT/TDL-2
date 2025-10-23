package model;

import java.util.List;

public class Contenido {
	private List<String> generos;
	private String sinopsis;
	private String director;
	
	public Contenido(List<String> generos, String sinopsis, String director) {
		this.generos = generos;
		this.sinopsis = sinopsis;
		this.director = director;
	}
	
	public Contenido() {
		
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
