package exceptions;

public class ClientAlreadyExistsException extends ClientException {
	public ClientAlreadyExistsException(String msj) {
		super(msj);
	}
	
	public ClientAlreadyExistsException() {
		
	}
}
