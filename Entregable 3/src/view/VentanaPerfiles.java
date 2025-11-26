package view;

import javax.swing.*;
import java.awt.*;

public class VentanaPerfiles extends JFrame {
	private JLabel lblTitulo = new JLabel("Quien esta viendo ahora?");
	private JPanel pnlPerfiles = new JPanel(new GridLayout(1, 5, 10, 10));
	
	public VentanaPerfiles() {
		setTitle("Seleccion de perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 20));

		add(lblTitulo, BorderLayout.NORTH);
		add(pnlPerfiles, BorderLayout.CENTER);
		
		//que se vayan agregando perfiles con un for de alguna manera

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