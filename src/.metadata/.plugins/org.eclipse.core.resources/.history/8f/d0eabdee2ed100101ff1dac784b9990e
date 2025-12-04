package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistro extends JPanel {
	private JLabel lblNombres = new JLabel("Nombres");
	private JTextField tfNombres = new JTextField(10);
	private JLabel lblApellidos = new JLabel("Apellidos");
	private JTextField tfApellidos = new JTextField(10);
	private JLabel lblDni = new JLabel("DNI");
	private JTextField tfDni = new JTextField(10);
	private JLabel lblEmail = new JLabel("Email");
	private JTextField tfEmail = new JTextField(10);
	private JLabel lblPassword = new JLabel("Contrasenia");
	private JPasswordField tfPassword = new JPasswordField(10);
	private JButton btnRegistrar = new JButton("Registrarse");
	
	public VentanaRegistro () {
		setLayout(new BorderLayout());
		JPanel panelCentral = new JPanel(new GridLayout(6,2));
		panelCentral.setPreferredSize(new Dimension(500, 250));
		
		lblNombres.setFont(new Font("Calibri", Font.BOLD, 14));
		tfNombres.setFont(new Font("Calibri", Font.BOLD, 14));
		
		lblApellidos.setFont(new Font("Calibri", Font.BOLD, 14));
		tfApellidos.setFont(new Font("Calibri", Font.BOLD, 14));
		
		lblDni.setFont(new Font("Calibri", Font.BOLD, 14));
		tfDni.setFont(new Font("Calibri", Font.BOLD, 14));
		
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 14));
		tfEmail.setFont(new Font("Calibri", Font.BOLD, 14));
		
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		
		btnRegistrar.setBackground(Color.BLUE);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Calibri", Font.BOLD, 14));
		
		panelCentral.add(lblNombres); panelCentral.add(tfNombres);
		panelCentral.add(lblApellidos); panelCentral.add(tfApellidos);
		panelCentral.add(lblDni); panelCentral.add(tfDni);
		panelCentral.add(lblEmail); panelCentral.add(tfEmail);
		panelCentral.add(lblPassword); panelCentral.add(tfPassword);
		
		panelCentral.add(new JLabel(" "));
		panelCentral.add(btnRegistrar);
		
		// Centrar el panel en la ventana grande
		add(panelCentral, BorderLayout.CENTER);
	}
	
	public void addRegistrarListener(ActionListener l) {
		btnRegistrar.addActionListener(l);
	}
	
	public String getNombres() {
		return tfNombres.getText();
	}
	
	public String getApellidos() {
		return tfApellidos.getText();
	}
	
	public int getDni() {
		return Integer.parseInt(tfDni.getText());
	}
	
	public String getEmail() {
		return tfEmail.getText();
	}
	
	public String getPassword() {
		return String.valueOf(tfPassword.getPassword());
	}
	
	public JButton getBotonRegistro() {
		return btnRegistrar;
	}
	
	public void mostrarMensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}
	
	public void mostarMensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String args[]) {
		VentanaRegistro vr = new VentanaRegistro();
	}
}
