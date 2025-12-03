package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaNuevoPerfil extends JFrame {
	private JLabel lblNombre = new JLabel("Nombre perfil");
	private JTextField tfNombre = new JTextField(50);
	private JLabel lblColores = new JLabel("Color");
	String[] colores = {"Rojo", "Verde", "Azul"};
	private JComboBox<String> color = new JComboBox<>(colores);
	private JButton btnCrearPerfil = new JButton("Crear perfil");
	
	public VentanaNuevoPerfil() {
		setTitle("Creacion perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3, 2, 5, 5));
		
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		tfNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCrearPerfil.setBackground(Color.BLUE);
		btnCrearPerfil.setForeground(Color.WHITE);
		btnCrearPerfil.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCrearPerfil.setHorizontalAlignment(SwingConstants.CENTER);
	
		add(lblNombre); add(tfNombre);
		add(lblColores); add(color);
		add(btnCrearPerfil);
		
		setVisible(true);
	}
	
	public void addCrearPerfilListener(ActionListener l) {
		btnCrearPerfil.addActionListener(l);
	}
	
	public String getNombre() {
		return tfNombre.getText();
	}
	
	public JButton getBotonCrearPerfil() {
		return btnCrearPerfil;
	}
	
	public void mostrarMensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}
	
	public void mostrarMensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args) {
		VentanaNuevoPerfil np = new VentanaNuevoPerfil();
	}
}
