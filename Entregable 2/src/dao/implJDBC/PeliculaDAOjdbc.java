package dao.implJDBC;

import java.util.List;
import java.sql.*;
import model.Pelicula;
import util.Conexion;
import dao.interfaces.PeliculaDAO;

public class PeliculaDAOjdbc implements PeliculaDAO {

	@Override
	public void guardar(Pelicula pelicula) {
		try {
			Connection conn = Conexion.getConnection();
			
			String sql = "INSERT INTO PELICULA (GENERO, TITULO, RESUMEN, DIRECTOR, DURACION) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, pelicula.getGenero());
			ps.setString(2, pelicula.getTitulo());
			ps.setString(3, pelicula.getSinopsis());
			ps.setString(4, pelicula.getDirector());
			ps.setFloat(5, pelicula.getDuracionR());
			
			ps.executeUpdate();
			
			ps.close();
			
			System.out.println("Pelicula guardada exitosamente");
		}
		catch (SQLException e) {
			System.out.println("Error al guardar pelicula: " + e.getMessage());
		}
	}
	
	@Override
	public List<Pelicula> listar(String orden) {
		
	}
	
}
