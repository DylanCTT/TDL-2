package dao.implJDBC;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.Cliente;
import model.Generos;
import model.Pelicula;
import util.Conexion;
import dao.interfaces.PeliculaDAO;

public class PeliculaDAOjdbc implements PeliculaDAO {

	@Override
	public Integer guardar(Pelicula pelicula) {
		String sql = "INSERT INTO PELICULA (FECHA_SALIDA, TITULO, RESUMEN, POPULARIDAD, CANT_VOTOS, VOTOS_PROMEDIO, IDIOMA, GENERO, POSTER, DIRECTOR, DURACION, STATUS, URL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Integer id = null;
		
		Connection conn = Conexion.getConnection();
	    try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        ps.setDate(1, java.sql.Date.valueOf(pelicula.getFechaSalida()));
	        ps.setString(2, pelicula.getTitulo());
	        ps.setString(3, pelicula.getResumen());
	        ps.setDouble(4, pelicula.getPopularidad());
	        ps.setInt(5, pelicula.getCantVotos());
	        ps.setDouble(6, pelicula.getVotosPromedio());
	        ps.setString(7, pelicula.getIdioma());
	        ps.setString(8, pelicula.getGenero().name());
	        ps.setString(9, pelicula.getPoster());
	        ps.setString(10, pelicula.getDirector());
	        ps.setDouble(11, pelicula.getDuracion());
	        ps.setString(12, pelicula.getStatus());
	        ps.setString(13, pelicula.getUrl());

	        ps.executeUpdate();
	        
	        try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
	        
	        System.out.println("Película guardada exitosamente");        
	    } 
	    catch (SQLException e) {
	        System.out.println("Error al guardar película: " + e.getMessage());
	    }
	    
	    return id;
	}
	
	@Override
	public List<Pelicula> listar() {
		List<Pelicula> lista = new ArrayList<>();
		String sql = "SELECT * FROM PELICULA";
		Connection conn = Conexion.getConnection();
		try (Statement st = conn.createStatement();     
			 ResultSet rs = st.executeQuery(sql);) {   
			
			while (rs.next()) {
				Pelicula p = new Pelicula();
				p.setId(rs.getInt("ID"));
				p.setFechaSalida(rs.getTimestamp("FECHA_SALIDA").toLocalDateTime().toLocalDate());
				p.setTitulo(rs.getString("TITULO"));
				p.setResumen(rs.getString("RESUMEN"));
				p.setPopularidad(rs.getDouble("POPULARIDAD"));
				p.setCantVotos(rs.getInt("CANT_VOTOS"));
				p.setVotosPromedio(rs.getDouble("VOTOS_PROMEDIO"));
				p.setIdioma(rs.getString("IDIOMA"));
				p.setGenero(Generos.valueOf(rs.getString("GENERO")));
				p.setPoster(rs.getString("POSTER"));
				p.setDirector(rs.getString("DIRECTOR"));
				p.setDuracion(rs.getFloat("DURACION"));
				p.setStatus(rs.getString("STATUS"));
				p.setUrl(rs.getString("URL"));
				
				lista.add(p);
			}
		}
		catch (SQLException e) {
			System.out.println("Error al listar peliculas: " + e.getMessage());
		}
		return lista;
	}
	
	@Override
	public boolean validarID(Integer id) {
		boolean existe = false;
		String sql = "SELECT COUNT(*) FROM PELICULA WHERE ID = ?"; 
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, id); 	
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next() && rs.getInt(1) > 0) {
					existe = true;
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error al validar ID: " + e.getMessage());
		}
		return existe;
	}
	
	public boolean existePelicula(String titulo) {
	    boolean existe = false;
	    String sql = "SELECT COUNT(*) AS total FROM PELICULA WHERE TITULO = ?";
	    
	    try (Connection conn = Conexion.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setString(1, titulo);
	        
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next() && rs.getInt("total") > 0) {
	                existe = true;
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al buscar película: " + e.getMessage());
	    }
	    
	    return existe;
	}
	
	public Pelicula devolverPeliculaXtitulo(String peli) {
		String sql = "SELECT * FROM PELICULA WHERE EMAIL = ?";
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, peli);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next() && rs.getInt(1) > 0) {
					Pelicula p = new Pelicula();
					p.setId(rs.getInt("ID"));
					p.setFechaSalida(rs.getTimestamp("FECHA_SALIDA").toLocalDateTime().toLocalDate());
					p.setTitulo(rs.getString("TITULO"));
					p.setResumen(rs.getString("RESUMEN"));
					p.setPopularidad(rs.getDouble("POPULARIDAD"));
					p.setCantVotos(rs.getInt("CANT_VOTOS"));
					p.setVotosPromedio(rs.getDouble("VOTOS_PROMEDIO"));
					p.setIdioma(rs.getString("IDIOMA"));
					p.setGenero(Generos.valueOf(rs.getString("GENERO")));
					p.setPoster(rs.getString("POSTER"));
					p.setDirector(rs.getString("DIRECTOR"));
					p.setDuracion(rs.getFloat("DURACION"));
					p.setStatus(rs.getString("STATUS"));
					p.setUrl(rs.getString("URL"));
					return p;
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error al devolver Pelicula: " + e.getMessage());
		}
		return null;
	}
	
}
