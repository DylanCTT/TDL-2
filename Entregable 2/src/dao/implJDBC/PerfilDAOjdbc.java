package dao.implJDBC;

import java.util.List;
import java.util.ArrayList;

import java.sql.*;
import model.Perfil;
import util.Conexion;
import dao.interfaces.PerfilDAO;

public class PerfilDAOjdbc implements PerfilDAO {

	@Override
	public void guardar(Perfil perfil) {
		String sql = "INSERT INTO PERFIL (NOMBRE, ID_CLIENTE) VALUES (?, ?)";
		
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, perfil.getNombre());
			ps.setInt(2, perfil.getIdCliente());
			
			ps.executeUpdate();
			
			System.out.println("Perfil guardado exitosamente");
		}
		catch (SQLException e) {
		  System.out.println("Error al guardar perfil: " + e.getMessage());  
		}
	}
	
	@Override
	public List<Perfil> listar(String orden) {
		List<Perfil> lista = new ArrayList<>();
		return lista;

		
	}
	
}
