package view;

public enum VentanasEnum {
	CALIFICARPELICULA("calificarPelicula"),
	NUEVOPERFIL("nuevoPerfil"),
	LOGIN("login"),
	PERFILES("perfiles"),
	REGISTRO("registro"),
	INFOPELICULA("infoPelicula"),
	BIENVENIDA("bienvenida");
		
	private String nombre;
	
	VentanasEnum(String nombre) {
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
