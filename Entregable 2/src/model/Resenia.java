package model;

import java.time.LocalDateTime;

/**
 * Representa un comentario/opinion/puntaje que va a dejar un usuario sobre un contenido
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Resenia {
	private String contenido;
	private int puntaje;
	private boolean aprobada;
	private LocalDateTime fecha;
	private String nomUsuario;
  
	public Resenia(String contenido, int puntaje, boolean aprobada, LocalDateTime fecha, String nomUsuario) {
		this.contenido = contenido;
		this.puntaje = puntaje;
		this.aprobada = aprobada;
		this.fecha = fecha;
		this.nomUsuario = nomUsuario;
	}
  
	public Resenia() {
	  
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
  
	public boolean isAprobada() {
		return aprobada;
	}

	public void setAprobada(boolean aprobada) {
		this.aprobada = aprobada;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
  
}
