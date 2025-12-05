package exceptions;

public abstract class ClientException extends Exception {
	public ClientException (String msj) {
		super(msj);
	}
	
	public ClientException() {
		
	}
}
