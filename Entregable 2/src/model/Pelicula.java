package model;

import java.time.LocalTime;
import java.util.List;

public class Pelicula extends Contenido {
	private String titulo;
	private LocalTime duracion;
	private float duracionR; //simplificao para tablas
	
	public Pelicula(String genero, List<String> generos, String sinopsis, String director, String titulo, LocalTime duracion, float duracionR) {
		super(genero, generos, sinopsis, director);
		this.titulo = titulo;
		this.duracion = duracion;
		this.duracionR = duracionR;
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

	public float getDuracionR() {
		return duracionR;
	}

	public void setDuracionR(float duracionR) {
		this.duracionR = duracionR;
	}
	
}
