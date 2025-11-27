package view;

import java.awt.*;
import javax.swing.*;

public class VentanaNuevoPerfil extends JFrame {
	private JLabel lblNombre = new JLabel("Nombre perfil");
	private JTextField tfNombre = new JTextField(50);
	String[] colores = {"Rojo", "Verde", "Azul"};
	private JComboBox<String> color = new JComboBox<>(colores);
	private JButton btnCrearPerfil = new JButton("Crear perfil");
	
	public VentanaNuevoPerfil() {
		setTitle("Creacion perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2, 1, 5, 5));
		
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		tfNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCrearPerfil.setBackground(Color.BLUE);
		btnCrearPerfil.setForeground(Color.WHITE);
		btnCrearPerfil.setFont(new Font("Calibri", Font.BOLD, 14));
	
		add(lblNombre); add(tfNombre);
		add(color);
		add(btnCrearPerfil);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		VentanaNuevoPerfil np = new VentanaNuevoPerfil();
	}
}
