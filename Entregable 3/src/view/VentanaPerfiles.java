package view;

import javax.swing.*;
import java.awt.*;

public class VentanaPerfiles extends JFrame {
	public VentanaPerfiles() {
		setTitle("¿Quién está viendo ahora?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Título superior
		JLabel titulo = new JLabel("¿Quién está viendo ahora?", SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		add(titulo, BorderLayout.NORTH);

		// Panel de perfiles
		JPanel panelPerfiles = new JPanel(new GridLayout(1, 5, 10, 10));
		panelPerfiles.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		// Crear perfiles
		panelPerfiles.add(crearPerfil("Dylan", Color.BLUE));
		panelPerfiles.add(crearPerfil("Iara", Color.PINK));
		panelPerfiles.add(crearPerfil("Silvi", Color.RED));
		panelPerfiles.add(crearPerfil("Carlos", Color.CYAN));
		panelPerfiles.add(crearPerfil("Cande", Color.GREEN));

		add(panelPerfiles, BorderLayout.CENTER);

		setVisible(true);
	}

	private JPanel crearPerfil(String nombre, Color colorFondo) {
		JPanel perfil = new JPanel();
		perfil.setLayout(new BorderLayout());
		perfil.setBackground(colorFondo);
		perfil.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		JLabel nombreLabel = new JLabel(nombre, SwingConstants.CENTER);
		nombreLabel.setForeground(Color.WHITE);
		nombreLabel.setFont(new Font("Arial", Font.BOLD, 14));

		JButton botonSeleccion = new JButton("Seleccionar");
		botonSeleccion.setFocusPainted(false);

		perfil.add(nombreLabel, BorderLayout.CENTER);
		perfil.add(botonSeleccion, BorderLayout.SOUTH);

		return perfil;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new VentanaPerfiles());

	}
}