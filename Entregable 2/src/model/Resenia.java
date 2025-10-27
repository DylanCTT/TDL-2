package model;

import java.time.LocalDateTime;

/**
 * Representa un comentario/opinion/puntaje que va a dejar un usuario sobre un contenido
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Resenia {
	private Integer id;
	private String contenido;
	private int puntaje;
	private boolean aprobada;
	private LocalDateTime fecha;
	private String nomUsuario;
	private Integer idCliente;
	private Integer idContenido;
  
	public Resenia(Integer id, String contenido, int puntaje, boolean aprobada, LocalDateTime fecha, String nomUsuario, Integer idCliente, Integer idContenido) {
		this.id = id;
		this.contenido = contenido;
		this.puntaje = puntaje;
		this.aprobada = aprobada;
		this.fecha = fecha;
		this.nomUsuario = nomUsuario;
		this.idCliente = idCliente;
		this.idContenido = idContenido;
	}
  
	public Resenia() {
	  
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdContenido() {
		return idContenido;
	}

	public void setIdContenido(Integer idContenido) {
		this.idContenido = idContenido;
	}

	@Override
	public String toString() {
		return "Resenia [contenido=" + contenido + ", puntaje=" + puntaje + ", aprobada=" + aprobada + ", fecha="
				+ fecha + "]";
	}
  
}
