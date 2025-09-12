package user;

public class Cliente extends Usuario {
	private String plan;
	private static final int maxPerfiles = 5;
	private Perfil[] perfiles;
	private int cantPerfiles;
	
	public Cliente(String nombre, String apellido, String mail, String contrasenia, String plan, Perfil[] perfiles, int cantPerfiles) {
		super(nombre, apellido, mail, contrasenia);
		this.plan = plan;
		this.perfiles = new Perfil[maxPerfiles];
		this.cantPerfiles = cantPerfiles;
	}
	
	public Cliente() {
		
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
	
	public void agregarPerfil(Perfil p) {
	  if (this.cantPerfiles <= maxPerfiles) {
	    this.perfiles[cantPerfiles] = p;
	    this.cantPerfiles++;
	  }
	}
	
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
