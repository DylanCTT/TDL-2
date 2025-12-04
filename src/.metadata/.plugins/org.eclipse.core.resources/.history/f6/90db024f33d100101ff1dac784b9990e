package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaNuevoPerfil extends JPanel {
	private JLabel lblNombre = new JLabel("Nombre perfil");
	private JTextField tfNombre = new JTextField(50);
	private JLabel lblColores = new JLabel("Color");
	String[] colores = {"Rojo", "Verde", "Azul"};
	private JComboBox<String> color = new JComboBox<>(colores);
	private JButton btnCrearPerfil = new JButton("Crear perfil");
	
	public VentanaNuevoPerfil() {
		setLayout(new BorderLayout());
		JPanel panelCentral = new JPanel(new GridLayout(3, 2, 5, 5));
		panelCentral.setPreferredSize(new Dimension(500, 300));
		
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		tfNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCrearPerfil.setBackground(Color.BLUE);
		btnCrearPerfil.setForeground(Color.WHITE);
		btnCrearPerfil.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCrearPerfil.setHorizontalAlignment(SwingConstants.CENTER);
	
		panelCentral.add(lblNombre); panelCentral.add(tfNombre);
		panelCentral.add(lblColores); panelCentral.add(color);
		panelCentral.add(btnCrearPerfil);
		panelCentral.add(new JLabel()); // Espacio vacío para completar el grid
		
		// Centrar el panel en la ventana grande
		add(panelCentral, BorderLayout.CENTER);
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
