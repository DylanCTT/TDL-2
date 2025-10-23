package dao.implJDBC;

import java.util.List;
import java.sql.*;
import model.Usuario;
import dao.interfaces.UsuarioDAO;
import util.Conexion;

public class UsuarioDAOjdbc implements UsuarioDAO {

	@Override
	public void guardar(Usuario usuario) {
		try {
		  Connection conn = Conexion.getConnection();
		  
		  String sql = "INSERT INTO USUARIO (NOMBRE, APELLIDO, DNI, EMAIL, CONTRASENIA) VALUES (?, ?, ?, ?, ?)";
		  
		  //como voy a insertar datos variables, uso prepareStatement
		  PreparedStatement ps = conn.prepareStatement(sql);
		  
		  ps.setString(1, usuario.getNombre());
		  ps.setString(2, usuario.getApellido());
		  ps.setInt(3, usuario.getDNI());
		  ps.setString(4, usuario.getEmail());
		  ps.setString(5, usuario.getContrasenia());
		  
		  ps.executeUpdate();
		  
		  ps.close();
		  
		  System.out.println("Usuario guardado exitosamente");
		}
		catch (SQLException e) {
		  System.out.println("Error al guardar usuario: " + e.getMessage());	
		}
	}
	
	@Override
	public List<Usuario> listar() {
		
	}
	
}
