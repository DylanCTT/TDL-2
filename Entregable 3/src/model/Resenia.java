package model;

import java.time.LocalDateTime;

/**
 * Representa un comentario/opinion/puntaje que va a dejar un usuario sobre un comentario
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Resenia {
	private Integer id;
	private String comentario;
	private int puntaje;
	private boolean aprobada;
	private LocalDateTime fecha;
	private Integer idPerfil;
	private Integer idContenido;
  
	public Resenia(Integer id, String comentario, int puntaje, boolean aprobada, LocalDateTime fecha, Integer idPerfil, Integer idContenido) {
		this.id = id;
		this.comentario = comentario;
		this.puntaje = puntaje;
		this.aprobada = aprobada;
		this.fecha = fecha;
		this.idPerfil = idPerfil;
		this.idContenido = idContenido;
	}
	
	public Resenia(String comentario, int puntaje, boolean aprobada, LocalDateTime fecha, Integer idPerfil, Integer idContenido) {
		this.comentario = comentario;
		this.puntaje = puntaje;
		this.aprobada = aprobada;
		this.fecha = fecha;
		this.idPerfil = idPerfil;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Integer getIdContenido() {
		return idContenido;
	}

	public void setIdContenido(Integer idContenido) {
		this.idContenido = idContenido;
	}

	@Override
	public String toString() {
		return "Resenia [comentario=" + comentario + ", puntaje=" + puntaje + ", aprobada=" + aprobada + ", fecha="
				+ fecha + "]";
	}
  
}
