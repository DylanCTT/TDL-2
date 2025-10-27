package model;

/**
 * Representa al duenio de la cuenta
 * @author dylan y valen
 * @version 1.0
 * @since 12-9-2025
 */

public class Cliente extends Usuario {
	private Integer id;
	private String plan;
	private static final int maxPerfiles = 5;
	private Perfil[] perfiles;
	private int cantPerfiles;
	
	public Cliente(Integer id, String nombre, String apellido, int DNI, String email, String contrasenia, String plan, Perfil[] perfiles, int cantPerfiles) {
		super(nombre, apellido, DNI, email, contrasenia);
		this.id = id;
		this.plan = plan;
		this.perfiles = new Perfil[maxPerfiles];
		this.cantPerfiles = cantPerfiles;
	}
	
	public Cliente() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlan() {
		return plan;
	}
	
	public void setPlan(String plan) {
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
	
}
