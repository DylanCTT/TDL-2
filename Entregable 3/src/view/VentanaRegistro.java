package view;

import java.awt.*;
import javax.swing.*;

public class VentanaRegistro extends JFrame {
	private JLabel lblNombres = new JLabel("Nombres");
	private JTextField tfNombres = new JTextField("", 10);
	private JLabel lblApellidos = new JLabel("Apellidos");
	private JTextField tfApellidos = new JTextField("", 10);
	private JLabel lblDni = new JLabel("DNI");
	private JTextField tfDni = new JTextField("", 10);
	private JLabel lblEmail = new JLabel("Email");
	private JTextField tfEmail = new JTextField("", 10);
	private JLabel lblPassword = new JLabel("Contrasenia");
	private JPasswordField tfPassword = new JPasswordField("", 10);
	private JButton btnRegistrar = new JButton("Registrarse");
	
	public VentanaRegistro () {
		setTitle("Registro");
		setSize(500, 250);
		setLayout(new GridLayout(6,1));
		
		lblNombres.setForeground(Color.BLACK);
		lblApellidos.setForeground(Color.BLACK);
		lblDni.setForeground(Color.BLACK);
		lblEmail.setForeground(Color.BLACK);
		lblPassword.setForeground(Color.BLACK);
		
		add(lblNombres); add(tfNombres);
		add(lblApellidos); add(tfApellidos);
		add(lblDni); add(tfDni);
		add(lblEmail); add(tfEmail);
		add(lblPassword); add(tfPassword);
		
		add(new JLabel(" "));
		
		btnRegistrar.setBackground(Color.BLUE);
		btnRegistrar.setForeground(Color.WHITE);
		
		add(btnRegistrar);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		VentanaRegistro vr = new VentanaRegistro();
	}
}
