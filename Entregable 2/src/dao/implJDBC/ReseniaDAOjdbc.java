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
		  //ps.setLocalDateTime(5, resenia.getFecha());
		}
		catch (SQLException e) {
		  System.out.println("Error al guardar resenia: " + e.getMessage());	
		}
	}
	
	@Override
	public List<Resenia> listarNoAprobadas() {
		
	}
	
	@Override
	public void aprobar(int idResenia) {
		
	}
	
}
