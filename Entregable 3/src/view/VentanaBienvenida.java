package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaBienvenida extends JFrame {
	private JLabel lblBienvenida= new JLabel("Bienvenido a la plataforma de streaming");
	private CardLayout layout = new CardLayout();
	private JPanel panelContenedor = new JPanel(layout);
	private JPanel panelEspera = new JPanel(new BorderLayout());
	private JLabel msjEspera = new JLabel("Cargando películas... Un momento por favor...", SwingConstants.CENTER);
	private JPanel panelPeliculas = new JPanel();
	private JScrollPane scroll;
	private JButton[] botonesCalificar;
	private ArrayList<JPanel> tarjetasPeliculas = new ArrayList<>();

	public VentanaBienvenida() {
		setTitle("Plataforma de Streaming");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		add(panelContenedor); 	

		msjEspera.setFont(new Font("Calibri", Font.BOLD, 20));
		panelEspera.add(msjEspera, BorderLayout.CENTER);
		panelContenedor.add(panelEspera, "espera");
		
		// vista de películas con un panel con scroll
		panelPeliculas.setLayout(new BoxLayout(panelPeliculas, BoxLayout.Y_AXIS));		
		scroll = new JScrollPane(panelPeliculas);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelContenedor.add(scroll, "peliculas"); //se agrega el scroll y no el panelPeliculas porque el scroll envuelve al panel
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new VentanaBienvenida());
	}
}
