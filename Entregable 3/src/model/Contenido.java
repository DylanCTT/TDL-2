package model;

public class Contenido {
	private Integer id;
	private int anioSalida;
	private String titulo;
	private String resumen;
	private double popularidad;
	private int cantVotos;
	private double votosPromedio;
	private String idioma;
	private Generos genero;
	private String poster; 
	
	public Contenido(Integer id, int anioSalida, String titulo, String resumen, double popularidad,
			int cantVotos, double votosPromedio, String idioma, Generos genero, String poster) {
		this.id = id;
		this.anioSalida = anioSalida;
		this.titulo = titulo;
		this.resumen = resumen;
		this.popularidad = popularidad;
		this.cantVotos = cantVotos;
		this.votosPromedio = votosPromedio;
		this.idioma = idioma;
		this.genero = genero;
		this.poster = poster;
	}

	public Contenido() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAnioSalida() {
		return anioSalida;
	}

	public void setAnioSalida(int anioSalida) {
		this.anioSalida = anioSalida;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public double getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(double popularidad) {
		this.popularidad = popularidad;
	}

	public int getCantVotos() {
		return cantVotos;
	}

	public void setCantVotos(int cantVotos) {
		this.cantVotos = cantVotos;
	}

	public double getVotosPromedio() {
		return votosPromedio;
	}

	public void setVotosPromedio(double votosPromedio) {
		this.votosPromedio = votosPromedio;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "Contenido [id=" + id + ", anioSalida=" + anioSalida + ", titulo=" + titulo + ", resumen=" + resumen
				+ ", popularidad=" + popularidad + ", cantVotos=" + cantVotos + ", votosPromedio=" + votosPromedio
				+ ", idioma=" + idioma + ", genero=" + genero + ", poster=" + poster + ", resumen=" + resumen + "]";
	}
	
}
