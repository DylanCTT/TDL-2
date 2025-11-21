package app;

import view.*;
import service.*;
import controller.*;

public class Main {
	public static void main(String[] args) {
		VentanaLogin view = new VentanaLogin();
		ClienteService service = new ClienteService();
		
		LoginController controller = new LoginController(view, service);
	}
}
