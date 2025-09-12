package user;

public class Resenia {
  private String contenido;
  private String nomUsuario;
  private int puntaje;
  
  public Resenia(String contenido, String nomUsuario, int puntaje) {
	  this.contenido = contenido;
	  this.nomUsuario = nomUsuario;
	  this.puntaje = puntaje;
  }

  public String getContenido() {
	  return contenido;
  }

  public void setContenido(String contenido) {
	  this.contenido = contenido;
  }

  public String getNomUsuario() {
	  return nomUsuario;
  }

  public void setNomUsuario(String nomUsuario) {
	  this.nomUsuario = nomUsuario;
  }

  public int getPuntaje() {
	  return puntaje;
  }

  public void setPuntaje(int puntaje) {
	  this.puntaje = puntaje;
  }
  
}
