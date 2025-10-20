package user;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa a la(s) persona(s) que van a consumir el contenido
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Perfil {
	private String nombre;
	private String idioma;
	private List<String> preferenciasGenero;
	private List<Contenido> miLista;
	private List<Resenia> resenias;
	
	public Perfil(String nombre, String idioma, List<String> preferenciasGenero, List<Contenido> miLista, List<Resenia> resenias) {
		this.nombre = nombre;
		this.idioma = idioma;
		this.preferenciasGenero = new ArrayList<String>();
		this.miLista = new ArrayList<Contenido>();
		this.resenias = new ArrayList<Resenia>();
	}
	
	public Perfil() {
		
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
}
