package model;

public class Pelicula extends Contenido {	
	private String director;
	private float duracion;
	private String status;
	private String url;
	
	public Pelicula(Integer id, int anioSalida, String titulo, String resumen, double popularidad,
			int cantVotos, double votosPromedio, String idioma, Generos genero, String poster, String sinopsis,
			String director, float duracion, String status, String url) {
		super(id, anioSalida, titulo, resumen, popularidad, cantVotos, votosPromedio, idioma, genero, poster);
		this.director = director;
		this.duracion = duracion;
		this.status = status;
		this.url = url;
	}
	
	public Pelicula() {
		
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", duracion=" + duracion + ", status=" + status + ", url=" + url
				+ "]";
	}
	
}
