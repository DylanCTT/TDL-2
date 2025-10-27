package model;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa a la(s) persona(s) que van a consumir el contenido
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Perfil implements Comparable<Perfil> {
	private Integer id;
	private String nombre;
	private String idioma;
	private List<String> preferenciasGenero;
	private List<Contenido> miLista;
	private List<Contenido> recomendaciones;
	private List<Resenia> misResenias;
	private List<Contenido> historial;
	private Integer idCliente;
	
	public Perfil(Integer id, String nombre, String idioma, List<String> preferenciasGenero, List<Contenido> miLista, List<Contenido> recomendaciones, List<Resenia> misResenias, List<Contenido> historial, Integer idCliente) {
		this.id = id;
		this.nombre = nombre;
		this.idioma = idioma;
		this.preferenciasGenero = new ArrayList<String>();
		this.miLista = new ArrayList<Contenido>();
		this.recomendaciones = new ArrayList<Contenido>();
		this.misResenias = new ArrayList<Resenia>();
		this.historial = new ArrayList<Contenido>();
		this.idCliente = idCliente;
	}
	
	public Perfil() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public void agregarPreferenciaGenero() {
		
	}
	
	public void eliminarPreferenciaGenero() {
		
	}
	
	public void agregarMiLista() {
		
	}
	
	public void eliminarMiLista() {
		
	}
	
	public void agregarResenia() {
		
	}
	
	public void eliminarResenia() {
		
	}
	
	public void ingresar() {
		
	}

	@Override
	public String toString() {
		return "Perfil [nombre=" + nombre + ", idCliente=" + idCliente + "]";
	}
	
	@Override
	public int compareTo(Perfil o) {
		return this.nombre.compareTo(o.getNombre());
	}
	
}
