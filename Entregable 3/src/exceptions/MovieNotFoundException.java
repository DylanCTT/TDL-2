package exceptions;

public class MovieNotFoundException extends Exception {
	public MovieNotFoundException(String msj) {
		super(msj);
	}
	
	public MovieNotFoundException() {
		
	}
}
