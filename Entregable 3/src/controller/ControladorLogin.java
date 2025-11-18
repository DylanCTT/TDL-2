package controller;

import view.VentanaLogin;

import javax.swing.*;
import java.sql.*;

public class ControladorLogin {
	private VentanaLogin vista;

	public ControladorLogin(VentanaLogin vista) {
		this.vista = vista;

		vista.getBotonIngresar().addActionListener(e -> validarLogin());
	}

	private void validarLogin() {
		String email = vista.getEmail().trim();
		String password = vista.getPassword().trim();

		if (email.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(vista, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// conexion y consulta
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:usuarios.db")) {
			String sql = "SELECT * FROM usuarios WHERE email = ? AND contraseña = ?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, email);
				stmt.setString(2, password);

				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						// login exitoso
						JOptionPane.showMessageDialog(vista, "Login exitoso. Bienvenido " + rs.getString("nombre"));
					} else {
						// no coincide
						JOptionPane.showMessageDialog(vista, "Email o contraseña incorrectos.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(vista, "Error al conectar con la base de datos:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}