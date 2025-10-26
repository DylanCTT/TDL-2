package dao.implJDBC;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import model.Cliente;
import util.Conexion;
import dao.interfaces.ClienteDAO;

public class ClienteDAOjdbc implements ClienteDAO {

	@Override
	public void guardar(Cliente cliente) {
		try {
			//abre un canal hacia la base de datos
			//Connection es de java.util.sql
			//getConnection devuelve un tipo Connection 
			Connection conn = Conexion.getConnection();
		  
			String sql = "INSERT INTO cliente (NOMBRE, APELLIDO, DNI, EMAIL, CONTRASENIA) VALUES (?, ?, ?, ?, ?)";
		  
			 //como voy a insertar datos variables, uso prepareStatement
			//preparo al sql para recibir datos variabls (indicados con ? en el String)
			PreparedStatement ps = conn.prepareStatement(sql);
		  
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setInt(3, cliente.getDNI());
			ps.setString(4, cliente.getEmail());
			ps.setString(5, cliente.getContrasenia());
		  
			//executeUpdate hace los cambios de los datos en el ps
			ps.executeUpdate();
		  
			ps.close();
		  
			System.out.println("Cliente guardado exitosamente");
		}
		catch (SQLException e) {
			System.out.println("Error al guardar cliente: " + e.getMessage());	
		}
	}
	
	@Override
	public List<Cliente> listar() {
		List<Cliente> lista = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		try (Connection conn = Conexion.getConnection();			
			 Statement st = conn.createStatement();     //statement porque se van a leer datos
			 ResultSet rs = st.executeQuery(sql);) {    //al poner esto entre parentesis se cierran solos
			
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setNombre(rs.getString("NOMBRE"));
				c.setApellido(rs.getString("APELLIDO"));
				c.setDNI(rs.getInt("DNI"));
				c.setEmail(rs.getString("EMAIL"));
				c.setContrasenia(rs.getString("CONTRASENIA"));
				lista.add(c);
			}
			
		}
		catch (SQLException e) {
			System.out.println("Error al listar clientes: " + e.getMessage());
		}
		return lista;
	}
	
	public boolean existeDNI(int DNI) {
		boolean existe = false;
		String sql = "SELECT COUNT(*) FROM USUARIO WHERE DNI = ?"; //COUNT(*) devuelve la cantidad de filas que cumple una condicion. si hay usuario con ese DNI devuelve 1 o mas. sino 0 
		try (Connection conn = Conexion.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {
			ps.setInt(1, DNI); //rempleza el ? del rs con el DNI que me llega
		}
		catch (SQLException e) {
			System.out.println("Error al validar DNI: " + e.getMessage());
		}
		return existe;
	}
	
}
