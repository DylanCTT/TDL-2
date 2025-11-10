package dao.implJDBC;

import java.util.List;
import java.util.ArrayList;

import java.sql.*;

import model.Pelicula;
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
	public List<Perfil> listar() {
		List<Perfil> lista = new ArrayList<>();
		String sql = "SELECT * FROM PERFIL";
		Connection conn = Conexion.getConnection();
		try (Statement st = conn.createStatement();     
			 ResultSet rs = st.executeQuery(sql);) {   
			
			while (rs.next()) {
				Perfil p = new Perfil();
				p.setId(rs.getInt("ID"));
				p.setNombre(rs.getString("NOMBRE"));
				lista.add(p);
			}
			
		}
		catch (SQLException e) {
			System.out.println("Error al listar perfiles: " + e.getMessage());
		}
		return lista;
	}
	
}
