package app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Cliente;
import model.Pelicula;
import model.Perfil;
import model.Resenia;

public class RegistroDatos {
	private static Scanner in = new Scanner(System.in);
	
	public static boolean stringContieneNum(String s) {
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean stringEsMail(String email) { //??
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@\" +\r\n" + "\"(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$";
		
		Pattern p = Pattern.compile(emailRegex);
		
		return p.matcher(email).matches();
	}
	
	public static Cliente registroCliente() {
		Cliente c = new Cliente();
		boolean ok = false;
		String validacion = "";
		
		System.out.println("Ingrese sus datos personales: ");
		
		while (!ok) {
		
			System.out.println("Nombre: ");
			c.setNombre(in.nextLine());
		
			System.out.println("Apellido: ");
			c.setApellido(in.nextLine());
			
			System.out.println("DNI: ");
			c.setDNI(in.nextInt());
		
			in.nextLine();
			
			System.out.println("Email: ");
			c.setEmail(in.nextLine());
		
			System.out.println("Contrasenia: ");
			c.setContrasenia(in.nextLine());
		
			if (stringContieneNum(c.getNombre())) validacion += "El nombre no debe contener numeros. ";
			
			if (stringContieneNum(c.getApellido())) validacion += "El apellido no debe contener numeros. ";

			//verificar DNI unico. ingreso a BD?
			
			if (stringEsMail(c.getEmail())) validacion += "Ingrese un mail valido. ";
			
			if ((c.getNombre().isEmpty()) || (c.getApellido().isEmpty()) || (c.getDNI().isEmpty()) || (c.getEmail().isEmpty()) || (c.getContrasenia().isEmpty())) validacion += "Se deben ingresar todos los datos. ";
			
			if (validacion.isEmpty()) ok = true;
			else {
			  System.out.println(validacion);
			  System.out.println("Ingrese los datos nuevamente: ");
			}
		}
		
		return c;
	}
	
	public static Perfil registroPerfil() {
		
	}
	
	public static Pelicula registroPelicula() {
		
	}
	
	public static Resenia registroResenia() {
		
	}
}
