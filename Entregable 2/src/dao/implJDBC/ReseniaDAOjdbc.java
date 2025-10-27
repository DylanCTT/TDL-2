package dao.implJDBC;

import java.util.List;
import java.sql.*;
import model.Resenia;
import util.Conexion;
import dao.interfaces.ReseniaDAO;

public class ReseniaDAOjdbc implements ReseniaDAO {

	@Override
	public void guardar(Resenia resenia) {
		try {
		  Connection conn = Conexion.getConnection();
		  
		  String sql = "INSERT INTO RESENIA (PUNTAJE, CONTENIDO, APROBADA, FECHA) VALUES (?, ?, ?, ?)";
		  
		  PreparedStatement ps = conn.prepareStatement(sql);
		  
		  ps.setInt(1, resenia.getPuntaje());
		  ps.setString(2, resenia.getContenido());
		  ps.setBoolean(3, resenia.isAprobada());
		  ps.setString(5, resenia.getFecha().toString());
		}
		catch (SQLException e) {
		  System.out.println("Error al guardar resenia: " + e.getMessage());	
		}
	}
	
	@Override
	public List<Resenia> listarNoAprobadas() {
		
	}
	
	@Override 
	public Resenia mostrar(Integer id) {
		Resenia r = new Resenia();
		String sql = "SELECT * FROM RESENIA WHERE ID = ?";
		try (Connection conn = Conexion.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {
			ps.setInt(1, id);
			if (rs.next() && rs.getInt(id) > 0) {
				r.setId(rs.getInt("ID"));
				r.setPuntaje(rs.getInt("PUNTAJE"));
				r.setContenido(rs.getString("CONTENIDO"));
				r.setFecha(rs.getDateTime("FECHA"));
				r.setIdCliente(rs.getInt("ID_PERFIL"));
				r.setIdContenido(rs.getInt("ID_PELICULA"));
			}
		}
		catch (SQLException e) {
			System.out.println("Error al validar ID: " + e.getMessage());
		}
		return r;
	}
	
	@Override
	public void aprobar(Integer idResenia) {
		
	}
	
	@Override
	public boolean existeResenia(Integer id) {
		boolean existe = false;
		String sql = "SELECT COUNT(*) FROM RESENIA WHERE ID = ?"; 
		try (Connection conn = Conexion.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {
			ps.setInt(1, id); 					
			if (rs.next() && rs.getInt("ID") > 0) {
				existe = true;
			}
		}
		catch (SQLException e) {
			System.out.println("Error al validar ID: " + e.getMessage());
		}
		return existe;	
	}
	
}
