package dao.implJDBC;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import model.Cliente;
import util.Conexion;
import dao.interfaces.ClienteDAO;

public class ClienteDAOjdbc implements ClienteDAO {

	@Override
	public boolean existeDNI(int DNI) {
		boolean existe = false;
		String sql = "SELECT COUNT(*) FROM CLIENTE WHERE DNI = ?"; //COUNT(*) devuelve la cantidad de filas que cumple una condicion. si hay usuario con ese DNI devuelve 1 o mas. sino 0 
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, DNI); 					 //rempleza el ? del rs con el DNI que me llega
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next() && rs.getInt(1) > 0) { //getInt obtiene el valor de COUNT(*)
					existe = true;
				}
			}
		}
		catch (SQLException e) {
			throw new RuntimeException("Error al validar DNI: ", e);
		}
		return existe;
	}
	
	@Override
	public void guardar(Cliente cliente) {
		String sql = "INSERT INTO cliente (NOMBRE, APELLIDO, DNI, EMAIL, CONTRASENIA) VALUES (?, ?, ?, ?, ?)";
		
		//como voy a insertar datos variables, uso prepareStatement
		//preparo al sql para recibir datos variabls (indicados con ? en el String)
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) { 
		  
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setInt(3, cliente.getDNI());
			ps.setString(4, cliente.getEmail());
			ps.setString(5, cliente.getContrasenia());
		  
			//executeUpdate hace los cambios de los datos en el ps
			ps.executeUpdate();
			
			System.out.println("Cliente guardado exitosamente");
		}
		catch (SQLException e) {
			System.out.println("Error al guardar cliente: " + e.getMessage());	
		}
	}
	
	@Override
	public List<Cliente> listar() {
		List<Cliente> lista = new ArrayList<>();
		String sql = "SELECT * FROM CLIENTE";
		Connection conn = Conexion.getConnection();
		try (Statement st = conn.createStatement();     //statement porque se van a leer datos
			 ResultSet rs = st.executeQuery(sql);) {    //al poner esto entre parentesis se cierran solos
			
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("ID"));
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
	
	@Override
	public boolean validarID(Integer id) {
		boolean existe = false;
		String sql = "SELECT COUNT(*) FROM CLIENTE WHERE ID = ?"; 
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
	
	@Override
	public Integer validarCliente(String email, String pass) {
		String sql = "SELECT ID FROM CLIENTE WHERE EMAIL = ? AND CONTRASENIA = ?";
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, email);
			ps.setString(2, pass);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("ID");
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error al validar cliente: " + e.getMessage());
		}
		return null;
	}
	
	@Override
	public boolean existeEmail(String email) {
		boolean existe = false;
		String sql = "SELECT COUNT(*) FROM CLIENTE WHERE EMAIL = ?";
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql) ) {
			ps.setString(1, email);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next() && rs.getInt(1) > 0) {
					existe = true;
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error al validar email: " + e.getMessage());
		}
		return existe;
	}
	
	@Override
	public Cliente devolverClienteXmail(String email) {
		String sql = "SELECT * FROM CLIENTE WHERE EMAIL = ?";
		Connection conn = Conexion.getConnection();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, email);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next() && rs.getInt(1) > 0) {
					Cliente c = new Cliente();
					c.setId(rs.getInt("ID"));
					c.setNombre(rs.getString("NOMBRE"));
					c.setApellido(rs.getString("APELLIDO"));
					c.setDNI(rs.getInt("DNI"));
					c.setEmail(rs.getString("EMAIL"));
					c.setContrasenia(rs.getString("CONTRASENIA"));
					return c;
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Error al devolver cliente: " + e.getMessage());
		}
		return null;
	}
}
