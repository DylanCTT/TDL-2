package model;

import java.util.List;

public class Contenido {
	private Integer id;
	private Generos genero; //se utiliza esta VI para el modelado de la BD 
	private List<String> generos;
	private String sinopsis;
	private String director;
	
	public Contenido(Integer id, Generos genero, List<String> generos, String sinopsis, String director) {
		this.id = id;
		this.genero = genero;
		this.generos = generos;
		this.sinopsis = sinopsis;
		this.director = director;
	}
	
	public Contenido() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
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

	@Override
	public String toString() {
		return "genero=" + genero + ", director=" + director;
	}
	
}
