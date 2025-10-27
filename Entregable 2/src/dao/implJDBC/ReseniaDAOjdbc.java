package dao.implJDBC;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.Resenia;
import util.Conexion;
import dao.interfaces.ReseniaDAO;

public class ReseniaDAOjdbc implements ReseniaDAO {

	@Override
	public void guardar(Resenia resenia) {
		String sql = "INSERT INTO RESENIA (PUNTAJE, CONTENIDO, APROBADA, FECHA, ID_PERFIL, ID_PELICULA) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
		  
		  ps.setInt(1, resenia.getPuntaje());
		  ps.setString(2, resenia.getContenido());
		  ps.setBoolean(3, resenia.isAprobada());
		  ps.setTimestamp(4, Timestamp.valueOf(resenia.getFecha()));
		  ps.setInt(5, resenia.getIdCliente());
		  ps.setInt(6, resenia.getIdContenido());
		  
		  ps.executeUpdate();
		  
		  System.out.println("Resenia guardada exitosamente");
		}
		catch (SQLException e) {
		  System.out.println("Error al guardar resenia: " + e.getMessage());	
		}
	}
	
	@Override
	public List<Resenia> listarNoAprobadas() {
		List<Resenia> lista = new ArrayList<>();
		String sql = "SELECT * FROM RESENIA WHERE APROBADA = 0";
		Connection conn = Conexion.getConnection();
		try (Statement st = conn.createStatement();     
			 ResultSet rs = st.executeQuery(sql);) {   
			
			while (rs.next()) {
				Resenia r = new Resenia();
				r.setId(rs.getInt("ID"));
				r.setPuntaje(rs.getInt("PUNTAJE"));
				r.setContenido(rs.getString("CONTENIDO"));
				r.setAprobada(rs.getBoolean("APROBADA"));
				r.setFecha(rs.getTimestamp("FECHA").toLocalDateTime());
				r.setIdCliente(rs.getInt("ID_PERFIL"));
				r.setIdContenido(rs.getInt("ID_PELICULA"));
				lista.add(r);
			}
			
		}
		catch (SQLException e) {
			System.out.println("Error al listar resenias: " + e.getMessage());
		}
		return lista;	
	}
	
	@Override 
	public Resenia mostrar(Integer id) {
		Resenia r = new Resenia();
		String sql = "SELECT * FROM RESENIA WHERE ID = ?";
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next() && rs.getInt(id) > 0) {
					r.setId(rs.getInt("ID"));
					r.setPuntaje(rs.getInt("PUNTAJE"));
					r.setContenido(rs.getString("CONTENIDO"));
					r.setFecha(rs.getTimestamp("FECHA").toLocalDateTime());
					r.setIdCliente(rs.getInt("ID_PERFIL"));
					r.setIdContenido(rs.getInt("ID_PELICULA"));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error al mostar resenia: " + e.getMessage());
		}
		return r;
	}
	
	@Override
	public void aprobar(Integer idResenia) {
		String sql = "UPDATE RESENIA SET APROBADA = 1 WHERE ID = ?";
		
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
		
			ps.setInt(1, idResenia);
			
			ps.executeUpdate();
		
			System.out.println("Resenia aprobada exitosamente");
		}
		
		catch(SQLException e) {
			System.out.println("Error al aprobar resenia: " + e.getMessage());
		}
	}
	
	@Override
	public boolean existeResenia(Integer id) {
		boolean existe = false;
		String sql = "SELECT COUNT(*) FROM RESENIA WHERE ID = ?"; 
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
