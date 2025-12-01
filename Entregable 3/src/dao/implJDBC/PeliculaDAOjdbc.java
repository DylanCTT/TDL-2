package dao.implJDBC;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.Generos;
import model.Pelicula;
import util.Conexion;
import dao.interfaces.PeliculaDAO;

public class PeliculaDAOjdbc implements PeliculaDAO {

	@Override
	public void guardar(Pelicula pelicula) {
		String sql = "INSERT INTO PELICULA (GENERO, TITULO, RESUMEN, DIRECTOR, DURACION, RELEASE_DATE, POPULARITY, VOTE_COUNT, VOTE_AVERAGE, ORIGINAL_LANGUAGE, POSTER, STATUS, URL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		
		Connection conn = Conexion.getConnection();

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        // Campos básicos
	        ps.setString(1, pelicula.getGenero().name());
	        ps.setString(2, pelicula.getTitulo());
	        ps.setString(3, pelicula.getSinopsis());
	        ps.setString(4, pelicula.getDirector());
	        ps.setFloat(5, pelicula.getDuracionR());

	        // Campos nuevos
	        ps.setString(6, pelicula.getReleaseDate());
	        ps.setDouble(7, pelicula.getPopularity());
	        ps.setInt(8, pelicula.getVoteCount());
	        ps.setDouble(9, pelicula.getVoteAverage());
	        ps.setString(10, pelicula.getOriginalLanguage());
	        ps.setString(11, pelicula.getPoster());
	        ps.setString(12, pelicula.getStatus());
	        ps.setString(13, pelicula.getUrl());

	        ps.executeUpdate();
	        System.out.println("Película guardada exitosamente");
	    } catch (SQLException e) {
	        System.out.println("Error al guardar película: " + e.getMessage());
	    }
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
				p.setGenero(Generos.valueOf(rs.getString("GENERO")));
				p.setTitulo(rs.getString("TITULO"));
				p.setSinopsis(rs.getString("RESUMEN"));
				p.setDirector(rs.getString("DIRECTOR"));
				p.setDuracionR(rs.getFloat("DURACION"));
				
				p.setReleaseDate(rs.getString("RELEASEDATE"));
				p.setPopularity(rs.getDouble("POPULARIDAD"));
				p.setVoteCount(rs.getInt("VOTECOUNT"));
				p.setVoteAverage(rs.getDouble("VOTEAVERAGE"));
				p.setOriginalLanguage(rs.getString("OGLANGUAGE"));
				p.setPoster(rs.getString("POSTER"));
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
	public boolean validarID(Integer id) {   //a chequeaaaarr
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
	
}
