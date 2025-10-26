package app;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.time.LocalDateTime;

import model.Cliente;
import model.Pelicula;
import model.Perfil;
import model.Resenia;
import dao.FactoryDAO;
import dao.interfaces.ClienteDAO;

public class Operaciones {
	private static Scanner in = new Scanner(System.in);
	
	private static boolean stringContieneNum(String s) {
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean stringEsMail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		
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

			ClienteDAO cDAO = FactoryDAO.getClienteDAO();
			
			if (!cDAO.existeDNI(c.getDNI())) validacion += "El DNI ingresado ya existe. ";
			
			if (stringEsMail(c.getEmail())) validacion += "Ingrese un mail valido. ";
			
			if ((c.getNombre().isEmpty()) || (c.getApellido().isEmpty()) || (c.getDNI() <= 0) || (c.getEmail().isEmpty()) || (c.getContrasenia().isEmpty())) validacion += "Se deben ingresar todos los datos. ";
			
			if (validacion.isEmpty()) ok = true;
			else {
				System.out.println(validacion);
				System.out.println("Ingrese los datos nuevamente: ");
			}
		}		
		return c;
	}
	
	public static Perfil registroPerfil() {
		Perfil p = new Perfil();
		boolean ok = false;
		String validacion = "";
		
		System.out.println("Ingrese sus datos de perfil: ");
		
		while (!ok) {
			System.out.println("Nombre: ");
			p.setNombre(in.nextLine());
					
			if (p.getNombre().isEmpty()) validacion += "Se deben ingresar todos los datos. ";
			
			if (validacion.isEmpty()) ok = true;
			else {
			  System.out.println(validacion);
			  System.out.println("Ingrese los datos nuevamente: ");
			}
		}
		return p;
	}
	
	public static Pelicula registroPelicula() {
		Pelicula p = new Pelicula();
		boolean ok = false;
		String validacion = "";
		
		System.out.println("Ingrese los datos de una pelicula: ");
		
		while (!ok) {		
			System.out.println("Genero: ");
			p.setGenero(in.nextLine());
		
			System.out.println("Titulo: ");
			p.setTitulo(in.nextLine());
			
			System.out.println("Sinopsis: ");
			p.setSinopsis(in.nextLine());
			
			System.out.println("Director: ");
			p.setDirector(in.nextLine());
		
			System.out.println("Duracion (en minutos): ");
			p.setDuracionR(in.nextFloat());
			
			if ((p.getGenero().isEmpty()) || (p.getTitulo().isEmpty()) || (p.getDirector().isEmpty()) || (p.getDuracionR() <= 0)) validacion += "Se deben ingresar todos los datos. ";
			
			if (validacion.isEmpty()) ok = true;
			else {
			  System.out.println(validacion);
			  System.out.println("Ingrese los datos nuevamente: ");
			}
		}		
		return p;
	}
	
	public static void listarPerfiles() {
		ClienteDAO cDao = FactoryDAO.getClienteDAO();
		List<Cliente> listaClientes = cDao.listar();
		
		System.out.println("Listado perfiles: ");
		for (Cliente c : listaClientes) {
			System.out.println("Nombre: " + c.getNombre());
		}
	}
	
	public static void listarPeliculas() {
		
	}
	
	public static Resenia registroResenia() {
		Resenia r = new Resenia();
		boolean ok = false;
		String validacion = "";
		
		System.out.println("Ingrese los datos de una resenia: ");
		
		while (!ok) {		
			System.out.println("Puntaje: ");
			r.setPuntaje(in.nextInt());
		
			System.out.println("Mensaje: ");
			r.setContenido(in.nextLine());
			
			r.setAprobada(false);
			
			r.setFecha(LocalDateTime.now());
			
			if ((r.getPuntaje() <= 0) || (r.getContenido().isEmpty())) validacion += "Se deben ingresar todos los datos. ";
			
			if (validacion.isEmpty()) ok = true;
			else {
			  System.out.println(validacion);
			  System.out.println("Ingrese los datos nuevamente: ");
			}
		}		
		return r;
	}
	
	public static void aprobarResenia() {
		
	}
}
