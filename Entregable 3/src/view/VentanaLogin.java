package view;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
	private JTextField campoEmail= new JTextField(50);
	private JPasswordField campoContraseña= new JPasswordField(50);
	private JButton botonIngresar= new JButton("Ingresar");
	private JButton botonRegistrate= new JButton("Registrarte");
	
	public VentanaLogin() {
		setTitle("Bienvenido a la Plataforma de Streaming");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setResizable(false);
		setLayout(new GridLayout(4,2));

		// Inicialización de componentes
		campoEmail = new JTextField();
		campoContraseña = new JPasswordField();
		botonIngresar = new JButton("Ingresar");
		botonRegistrate = new JButton("Registrarte");

		//Agrego colores lindos
		botonIngresar.setBackground(Color.BLUE);
		botonIngresar.setForeground(Color.WHITE);
		botonIngresar.setFont(new Font("Calibri", Font.BOLD, 14));
		botonRegistrate.setBackground(Color.BLUE);
		botonRegistrate.setForeground(Color.WHITE);
		botonRegistrate.setFont(new Font("Calibri", Font.BOLD, 14));
		
		// Agregado de componentes al layout
		add(new JLabel("E-mail:"));
		add(campoEmail);
		add(new JLabel("Password:"));
		add(campoContraseña);
		add(new JLabel(" "));
		add(botonIngresar);
		add(new JLabel("¿Aun no tienes cuenta?"));
		add(botonRegistrate);

		setLocationRelativeTo(null);
		setVisible(true);

	}

	public String getEmail() {
		return campoEmail.getText();
	}

	public String getPassword() {
		return new String(campoContraseña.getPassword());
	}

	public JButton getBotonIngresar() {
		return botonIngresar;
	}

	public JButton getBotonRegistrate() {
		return botonRegistrate;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new VentanaLogin());
	}
	
	
	
}
