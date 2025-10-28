package dao.implJDBC;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.Pelicula;
import util.Conexion;
import dao.interfaces.PeliculaDAO;

public class PeliculaDAOjdbc implements PeliculaDAO {

	@Override
	public void guardar(Pelicula pelicula) {
		String sql = "INSERT INTO PELICULA (GENERO, TITULO, RESUMEN, DIRECTOR, DURACION) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, pelicula.getGenero());
			ps.setString(2, pelicula.getTitulo());
			ps.setString(3, pelicula.getSinopsis());
			ps.setString(4, pelicula.getDirector());
			ps.setFloat(5, pelicula.getDuracionR());
			
			ps.executeUpdate();
			
			System.out.println("Pelicula guardada exitosamente");
		}
		catch (SQLException e) {
			System.out.println("Error al guardar pelicula: " + e.getMessage());
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
				p.setGenero(rs.getString("GENERO"));
				p.setTitulo(rs.getString("TITULO"));
				p.setSinopsis(rs.getString("RESUMEN"));
				p.setDirector(rs.getString("DIRECTOR"));
				p.setDuracionR(rs.getFloat("DURACION"));
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
	
}
