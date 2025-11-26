package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
	private JLabel lblEmail = new JLabel("E-mail");
	private JTextField tfEmail = new JTextField(50);
	private JLabel lblPassword = new JLabel("Contrasenia");
	private JPasswordField tfPassword = new JPasswordField(50);
	private JButton btnIngresar = new JButton("Ingresar");
	private JButton btnRegistrate = new JButton("Registrarte");
	
	public VentanaLogin() {
		setTitle("Bienvenido a la Plataforma de Streaming");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4,2));

		//Agrego colores lindos
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 14));
		tfEmail.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		btnIngresar.setBackground(Color.BLUE);
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setFont(new Font("Calibri", Font.BOLD, 14));
		btnRegistrate.setBackground(Color.BLUE);
		btnRegistrate.setForeground(Color.WHITE);
		btnRegistrate.setFont(new Font("Calibri", Font.BOLD, 14));
		
		// Agregado de componentes al layout
		add(lblEmail); add(tfEmail);
		add(lblPassword); add(tfPassword);
		add(new JLabel(" "));
		add(btnIngresar);
		add(new JLabel("¿Todavia no tenes cuenta?"));
		add(btnRegistrate);

		setVisible(true);
	}

	public void addIngresarListener(ActionListener l) {
		btnIngresar.addActionListener(l);
	}
	
	public void addRegistrateListener(ActionListener l) {
		btnRegistrate.addActionListener(l);
	}
	
	public String getEmail() {
		return tfEmail.getText();
	}

	public String getPassword() {
		return String.valueOf(tfPassword.getPassword());
	}

	public JButton getBotonIngresar() {
		return btnIngresar;
	}

	public JButton getBotonRegistrate() {
		return btnRegistrate;
	}
	
	public void mostrarMensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}
	
	public void mostrarMensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new VentanaLogin());
	}
}
