package model;

/**
 * Representa el tipo "base" de un usuario de la plataforma
 * 
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public abstract class Usuario {
	private String nombre;
	private String apellido;
	private int DNI;
	private String email;
	private String contrasenia;
	
	public Usuario(String nombre, String apellido, int DNI, String mail, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.email = mail;
		this.contrasenia = contrasenia;
	}
	
	public Usuario() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getDNI() {
		return DNI;	
	}
	
	public void setDNI(int DNI) {
		this.DNI = DNI;	
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI + ", email=" + email
				+ ", contrasenia=" + contrasenia + "]";
	}
	
}
