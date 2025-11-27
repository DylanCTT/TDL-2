package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaBienvenida extends JFrame {
	private JPanel panelContenedor;
	private CardLayout layout;
	private JPanel panelPeliculas;
	private JButton[] botonesCalificar;
	private ArrayList<JPanel> tarjetasPeliculas = new ArrayList<>();

	public VentanaBienvenida() {
		setTitle("Plataforma de Streaming");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);

		// Layout principal con CardLayout
		layout = new CardLayout();
		panelContenedor = new JPanel(layout);
		add(panelContenedor);

		// Vista de espera
		JPanel panelEspera = new JPanel(new BorderLayout());
		JLabel mensaje = new JLabel("Cargando películas... Un momento por favor...", SwingConstants.CENTER);
		mensaje.setFont(new Font("Arial", Font.BOLD, 20));
		panelEspera.add(mensaje, BorderLayout.CENTER);
		panelContenedor.add(panelEspera, "espera");

	}
}
