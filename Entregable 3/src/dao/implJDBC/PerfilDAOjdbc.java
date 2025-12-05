package dao.implJDBC;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import model.Perfil;
import util.Conexion;
import dao.interfaces.PerfilDAO;

public class PerfilDAOjdbc implements PerfilDAO {

	@Override
	public Integer guardar(Perfil perfil) {
		String sql = "INSERT INTO PERFIL (NOMBRE, ID_CLIENTE) VALUES (?, ?)";
		Integer id = null;
		
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			ps.setString(1, perfil.getNombre());
			ps.setInt(2, perfil.getIdCliente());
			
			ps.executeUpdate();
			
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					id = rs.getInt("ID");
				}
			}
			
			System.out.println("Perfil guardado exitosamente");
		}
		
		catch (SQLException e) {
		  System.out.println("Error al guardar perfil: " + e.getMessage());  
		}
		
		return id;
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
	
	@Override
	public List<Perfil> getPerfilesXidCliente(Integer id) {
		List<Perfil> perfiles = new ArrayList<>();
		String sql = "SELECT * FROM PERFIL WHERE ID_CLIENTE = ?";
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next() && rs.getInt(1) > 0) {
					Perfil p = new Perfil();
					p.setId(rs.getInt("ID"));
					p.setNombre(rs.getString("NOMBRE"));
					p.setIdCliente(rs.getInt("ID_CLIENTE"));
					perfiles.add(p);
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error al devolver perfiles: " + e.getMessage());
		}
		return perfiles;
	}
}
