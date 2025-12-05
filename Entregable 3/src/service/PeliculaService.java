package service;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import model.Cliente;
import model.Generos;
import model.Pelicula;
import dao.FactoryDAO;
import dao.interfaces.PeliculaDAO;
import util.Conexion;
import java.net.URI;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class PeliculaService {
	private PeliculaDAO peliculaDAO;
	
	public PeliculaService() {
		this.peliculaDAO = FactoryDAO.getPeliculaDAO();
	}

	//lee una pelicula incluso si esta en lineas distintas en el csv
	private String leerRegistroCompleto(FileReader fr) throws IOException{
		StringBuilder linea = new StringBuilder();
		int c;
		boolean entreComillas = false;
		
		while ((c = fr.read()) != -1) {
			char car = (char) c;
			
			if (car == '"') {
				entreComillas = !entreComillas;
			}
			
			// si pasamos de linea y seguimos en las comillas termino la pelicula
			if (car == '\n' && !entreComillas) {
				break;
			}
			
			linea.append(car);
		}
		
		if ((linea.length() == 0) && (c == -1)) return null;
		
		return linea.toString();
	}
	
	private String[] parser(String linea) {
		List<String> segmentos = new ArrayList<>();
		StringBuilder segmentoAct = new StringBuilder(); //string mutable
		boolean entreComillas = false;
		
		for (int i = 0; i < linea.length(); i++) {
			char carAct = linea.charAt(i);
			
			if (carAct == '"') {
				// comillas dobles
				if ((entreComillas) && ((i + 1) < linea.length() && (linea.charAt(i + 1) == '"'))) {
					segmentoAct.append('"');
					i++;
				}
				else entreComillas = !entreComillas;
			}
			
			else if ((carAct == ',') && (!entreComillas)) {
				segmentos.add(segmentoAct.toString());
				segmentoAct.setLength(0);			
			}
			
			else segmentoAct.append(carAct);
		}
		
		segmentos.add(segmentoAct.toString());
		
		return segmentos.toArray(new String[0]);
	}
	
	private Pelicula leerLinea(String linea) {
        // acá parseás la línea CSV en campos
        // ejemplo simplificado (usar parser robusto si hay comillas)
        String[] campos = parser(linea);

        if (campos.length < 9) {
        	System.out.println("Pelicula no valida: " + linea);
        	return null;
        }
        
        Pelicula p = new Pelicula();
        
        LocalDate fecha = null;
        if (!campos[0].isBlank()) fecha = LocalDate.parse(campos[0]);	
        p.setFechaSalida(fecha);
        
        p.setTitulo(campos[1].isBlank() ? "Titulo no disponible" : campos[1]);
        
        p.setResumen(campos[2].isBlank() ? "Resumen no disponible" : campos[2]);
        
        Double popularidad = null;
        if (!campos[3].isBlank()) popularidad = Double.parseDouble(campos[3]);
        p.setPopularidad(popularidad);
        
        Integer cantVotos = null;
        if (!campos[4].isBlank()) cantVotos = Integer.parseInt(campos[4]);
        p.setCantVotos(cantVotos);
        
        Double votosPromedio = null;
        if (!campos[5].isBlank()) votosPromedio = Double.parseDouble(campos[5]);
        p.setVotosPromedio(votosPromedio);
        
        p.setIdioma(campos[6].isBlank() ? "Idioma no disponible" : campos[6]);
        
        if (campos[7].isBlank()) p.setGenero(null);
        else {
        	String generosCSV = campos[7].toUpperCase();        
        	String primerGenero = generosCSV.split(",")[0].trim();        
        	primerGenero = primerGenero.replace(" ", "");      
        	p.setGenero(Generos.valueOf(primerGenero));   
        }
        
        p.setPoster(campos[8].isBlank() ? "Poster no disponible" : campos[8]);

        return p;
    }
	
	public List<Pelicula> cargarPeliculas(String rutaCSV) {
        List<Pelicula> lista = new ArrayList<>();

        try (FileReader fr = new FileReader(rutaCSV);
             Connection conn = Conexion.getConnection()) {

            String registro;
            boolean primera = true;

            while ((registro = leerRegistroCompleto(fr)) != null) {      
            	if (primera) {
            		primera = false; // saltar encabezado
            		continue;
            	}	
            	
                Pelicula p = leerLinea(registro);
                if (p != null) {
                    Integer id = peliculaDAO.guardar(p);
                    p.setId(id);
                    lista.add(p);
                }
            }
        } 
        catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

	public class ConsultaPeliculasOMDb {
	    // Reemplazá con tu API Key obtenida en https://www.omdbapi.com/apikey.aspx
	    private static final String API_KEY = "TU_API_KEY";

	    public static Pelicula consultarPelicula(String titulo) {
	        try {
	            String url = "https://www.omdbapi.com/?t=" + titulo.replace(" ", "+") + "&apikey=" + API_KEY;

	            HttpClient cliente = HttpClient.newHttpClient();
	            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

	            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

	            JSONObject json = new JSONObject(response.body());

	            if (json.has("Response") && json.getString("Response").equals("True")) {
	                // Crear objeto Pelicula con los datos de la API
	                Pelicula p = new Pelicula();
	                p.setTitulo(json.getString("Title"));
	                p.setResumen(json.optString("Plot", "Sin resumen disponible"));
	                p.setGenero(json.optString("Genre", "Desconocido"));
	                p.setAnio(json.optString("Year", "No disponible")); 
	                // Ajustá según cómo esté tu clase Pelicula (Date, String, etc.)

	                return p;
	            } else {
	                return null; // No encontrada
	            }
	        } catch (Exception e) {
	            System.out.println("Error al consultar la API: " + e.getMessage());
	            return null;
	        }
	    }
	}
		
		
	}

	
	/*public Pelicula BuscarPelicula(String peli) throws Exception {
		if (!peliculaDAO.existePelicula(peli)) throw new Exception("La pelicula no se encuentra");
		
		if ((peli.isEmpty())) throw new Exception("Ingrese una pelicula valida");
		
		Pelicula p = peliculaDAO.devolverPeliculaXtitulo(peli);
		
		return p;
	}*/