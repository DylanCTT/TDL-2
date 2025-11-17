package model;

import java.util.List;

public class Contenido {
	private Integer id;
	private String genero; //se utiliza esta VI para el modelado de la BD 
	private List<Generos> generos;
	private String sinopsis;
	private String director;
	
	public Contenido(Integer id, String genero, List<String> generos, String sinopsis, String director) {
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

	@Override
	public String toString() {
		return "genero=" + genero + ", director=" + director;
	}
	
}
