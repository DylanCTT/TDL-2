package app;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.time.LocalDateTime;

import model.Cliente;
import model.Pelicula;
import model.Perfil;
import model.Resenia;
import model.Generos;
import dao.FactoryDAO;
import dao.interfaces.*;

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
	
	private static Cliente registroCliente() {
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

			ClienteDAO cDAO = FactoryDAO.getClienteDAO(); //objeto DAO que accede a todos los clientes de la base
			
			if (!cDAO.existeDNI(c.getDNI())) validacion += "El DNI ingresado ya existe. ";
			
			if (stringEsMail(c.getEmail())) validacion += "Ingrese un mail valido. ";
			
			if ((c.getNombre().isEmpty()) || (c.getApellido().isEmpty()) || (c.getDNI() <= 0) || (c.getEmail().isEmpty()) || (c.getContrasenia().isEmpty())) validacion += "Se deben ingresar todos los datos. ";
			
			if (validacion.isEmpty()) ok = true;
			else {
				System.out.println(validacion);
				System.out.println("Ingrese los datos nuevamente: ");
			}
		}
		
		System.out.println("Datos ingresados: " + c.toString());
		return c;
	}
	
	private static boolean confirmar() {
		System.out.println("Son correctos los datos ingresados? (si/no)");
		String res = in.nextLine().trim().toLowerCase();
		return res.equals("si");
	}
	
	public static void registrarCliente() {
		Cliente c = registroCliente();
		
		if (confirmar()) {
			FactoryDAO.getClienteDAO().guardar(c);
			System.out.println("Cliente guardado correctamente");
		}
		else {
			System.out.println("Registro cancelado");
		}
	}
	
	private static Perfil registroPerfil(Integer id) {
		Perfil p = new Perfil();
		boolean ok = false;
		String validacion = "";
		
		p.setIdCliente(id);
		
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
	
	private static void listarClientes() {
		ClienteDAO cDao = FactoryDAO.getClienteDAO();
		List<Cliente> listaClientes = cDao.listar();
		
		System.out.println("Listado clientes: ");
		for (Cliente c : listaClientes) {
			System.out.println("ID: " + c.getId() + ". Nombre: " + c.getNombre() + ". Apellido: " + c.getApellido() + ". Email: " + c.getEmail() + ". Contrasenia: " + c.getContrasenia());
		}
	}
	
	public static void registrarPerfil() {
		listarClientes();
		
		//se selecciona un Cliente de la base de datos el cual queda asociado al perfil
		System.out.println("Seleccionar ID del cliente a asociarse");
		Integer id = in.nextInt();
		
		Perfil p = registroPerfil(id);
		
		if (confirmar()) {
			FactoryDAO.getPerfilDAO().guardar(p);
			System.out.println("Perfil guardado correctamente");
		}
		else {
			System.out.println("Registro cancelado");
		}
	}
	
	private static Pelicula registroPelicula() {
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
			
			p.setGenero(p.getGenero().toUpperCase());
			try {
				Generos genero = Generos.valueOf(p.getGenero());
			} catch (IllegalArgumentException e) {
				validacion += "Genero ingresado no valido. ";
			}
			
			if ((p.getGenero().isEmpty()) || (p.getTitulo().isEmpty()) || (p.getDirector().isEmpty()) || (p.getDuracionR() <= 0)) validacion += "Se deben ingresar todos los datos. ";
			
			if (validacion.isEmpty()) ok = true;
			else {
			  System.out.println(validacion);
			  System.out.println("Ingrese los datos nuevamente: ");
			}
		}	
		System.out.println("Datos ingresaos: " + p.toString());
		
		return p;
	}
	
	public static void registrarPelicula() {
		Pelicula p = registroPelicula();
		
		if (confirmar()) {
			FactoryDAO.getPeliculaDAO().guardar(p);
			System.out.println("Pelicula guardada correctamente");
		}
		else {
			System.out.println("Registro cancelado");
		}	
	}
	
	public static void listarPerfiles() {
		
	}
	
	public static void listarPeliculas() {
		
	}
	
	private static Resenia registroResenia(Integer idCliente, Integer idPelicula) {
		Resenia r = new Resenia();
		boolean ok = false;
		String validacion = "";
		
		System.out.println("Ingrese los datos de una resenia: ");
		
		r.setIdCliente(idCliente);
		r.setIdContenido(idPelicula);
		
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
	
	public static void registrarResenia() {
		System.out.println("Ingrese nombre de usuario y contrasenia: ");
		String nom = in.nextLine();
		String contrasenia = in.nextLine();
		
		//validar nombre y contrasenia en la BD
		ClienteDAO cDAO = FactoryDAO.getClienteDAO();
		Integer idCliente = cDAO.validarUsuario(nom, contrasenia);
		if (idCliente == null) System.out.println("Usuario no valido");
		else {
			//mostrar listado peliculas
			listarPeliculas();
		
			//elegir pelicula
			System.out.println("Ingrese el ID de la pelicula a reseniar");
			int idPelicula = in.nextInt();
			PeliculaDAO pDAO = FactoryDAO.getPeliculaDAO();
			if(!pDAO.validarID(idPelicula)) System.out.println("ID de pelicula no valido");
			else {		
				Resenia r = registroResenia(idCliente, idPelicula);
		
				if (confirmar()) {
					FactoryDAO.getReseniaDAO().guardar(r);
					System.out.println("Resenia guardada correctamente");
				}
				else System.out.println("Registro cancelado");
			}
		}
	}
	
	private static void listarResenias() {
		ReseniaDAO rDAO = FactoryDAO.getReseniaDAO();
		rDAO.listarNoAprobadas();
	}
	
	public static void aprobarResenia() {
		//listado resenias
		listarResenias();
		
		//solicitar nro resenia a aprobar
		System.out.println("Ingrese el ID de la resenia a aprobar");
		Integer id = in.nextInt();
		
		//validar existencia resenia
		ReseniaDAO rDAO = FactoryDAO.getReseniaDAO();
		if (!rDAO.existeResenia(id)) System.out.println("ID de resenia no valido");
		else {
			//mostrar resenia seleccionada
			rDAO.mostrar(id);
		
			//aprobar
			rDAO.aprobar(id);
		}
	}
}
