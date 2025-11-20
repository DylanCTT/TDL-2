package model;

/**
 * Representa al duenio de la cuenta
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Cliente extends Usuario {
	private Integer id;
	private Planes plan;
	private static final int maxPerfiles = 5;
	private Perfil[] perfiles;
	private int cantPerfiles;
	
	public Cliente(String nombre, String apellido, int DNI, String email, String contrasenia, Integer id,  Planes plan, Perfil[] perfiles, int cantPerfiles) {
		super(nombre, apellido, DNI, email, contrasenia);
		this.id = id;
		this.plan = plan;
		this.perfiles = new Perfil[maxPerfiles];
		this.cantPerfiles = cantPerfiles;
	}
	
	public Cliente(String nombre, String apellido, int DNI, String email, String contrasenia) {
		super(nombre, apellido, DNI, email, contrasenia);
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
	  if (this.cantPerfiles <= maxPerfiles) {
	    this.perfiles[cantPerfiles] = p;
	    this.cantPerfiles++;
	  }
	}
	
	/**
	 * Elimina un perfil de una cuenta
	 * @param p el perfil a eliminar
	 */
	
	public void eliminarPerfil(Perfil p) {
  	  int i = 0;
  	  boolean encontre = false;
	  while ((i <= maxPerfiles) && (!encontre)) {
	    if (this.perfiles[i] == p) {
	      encontre = true;
	      int j;
	      for (j = i; j < maxPerfiles; j++) {
	        this.perfiles[j] = this.perfiles[j + 1];
	      }
	      this.cantPerfiles--;
	    }
	    i++;
	  }
	}
	
	@Override
	public String toString() {
		return "Cliente " + super.toString();
	}
	
}
