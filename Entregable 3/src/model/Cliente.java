package model;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa al duenio de la cuenta
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Cliente extends Usuario {
	private Integer id;
	private Planes plan;
	private List<Perfil> perfiles;
	private int cantPerfiles;
	
	public Cliente(String nombre, String apellido, int DNI, String email, String contrasenia, Integer id, Planes plan, List<Perfil> perfiles) {
		super(nombre, apellido, DNI, email, contrasenia);
		this.id = id;
		this.plan = plan;
		this.perfiles = new ArrayList<Perfil>();
	}
	
	public Cliente(String nombre, String apellido, int DNI, String email, String contrasenia, int cantPerfiles) {
		super(nombre, apellido, DNI, email, contrasenia);
		this.cantPerfiles = 0;
	}
	
	public Cliente() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Planes getPlan() {
		return plan;
	}
	
	public void setPlan(Planes plan) {
		this.plan = plan;
	}
	
	public int getCantPerfiles() {
		return cantPerfiles;
	}

	public void setCantPerfiles(int cantPerfiles) {
		this.cantPerfiles = cantPerfiles;
	}
	
	/**
	 * Agrega un perfil a una cuenta
	 * @param p el perfil a agregar
	 */
	
	public void agregarPerfil(Perfil p) {
		perfiles.add(p);
	}
	
	/**
	 * Elimina un perfil de una cuenta
	 * @param p el perfil a eliminar
	 */
	
	public void eliminarPerfil(Perfil p) {
		if (perfiles.contains(p)) perfiles.remove(p);
	}
	
	@Override
	public String toString() {
		return "Cliente " + super.toString();
	}
	
}
