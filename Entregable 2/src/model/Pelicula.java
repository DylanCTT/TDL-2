package model;

import java.time.LocalTime;
import java.util.List;

public class Pelicula extends Contenido {
	private String titulo;
	private LocalTime duracion;
	
	public Pelicula(List<String> generos, String sinopsis, String director, String titulo, LocalTime duracion) {
		super(generos, sinopsis, director);
		this.titulo = titulo;
		this.duracion = duracion;
	}	
	
	public Pelicula() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalTime getDuracion() {
		return duracion;
	}

	public void setDuracion(LocalTime duracion) {
		this.duracion = duracion;
	}
	
	
}
