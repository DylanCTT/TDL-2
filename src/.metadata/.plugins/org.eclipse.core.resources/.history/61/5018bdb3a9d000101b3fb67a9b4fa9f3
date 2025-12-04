package view;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import model.Pelicula;

public class VentanaBienvenida extends JFrame {
	private JLabel lblBienvenida= new JLabel("Bienvenido a la plataforma de streaming");
	private CardLayout layout = new CardLayout();
	private JPanel pnlContenedor = new JPanel(layout);
	private JPanel pnlEspera = new JPanel(new BorderLayout());
	private JLabel msjEspera = new JLabel("Cargando películas... Un momento por favor...", SwingConstants.CENTER);
	private JPanel pnlPeliculas = new JPanel();
	private JScrollPane scroll;
	private JLabel lblPoster = new JLabel("Poster");
	private JLabel lblTitulo = new JLabel("Titulo");
	private JLabel lblGenero = new JLabel("Genero");
	private JLabel lblResumen = new JLabel("Resumen");
	private JButton[] botonesCalificar;
	private ArrayList<JPanel> tarjetasPeliculas = new ArrayList<>();

	public VentanaBienvenida() {
		setTitle("Plataforma de Streaming");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		add(pnlContenedor); 	

		lblBienvenida.setFont(new Font("Calibri", Font.BOLD, 22));
		
		/*msjEspera.setFont(new Font("Calibri", Font.BOLD, 20));
		pnlEspera.add(msjEspera, BorderLayout.CENTER);
		pnlEspera.add(lblBienvenida);
		pnlContenedor.add(pnlEspera, "espera");*/
		
		// vista de películas con un panel con scroll
		
		lblPoster.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblGenero.setFont(new Font("Calibri", Font.BOLD, 20));
		lblResumen.setFont(new Font("Calibri", Font.BOLD, 20));
		
		pnlPeliculas.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
		pnlPeliculas.add(lblBienvenida);
		pnlPeliculas.add(lblPoster);
		pnlPeliculas.add(lblTitulo);
		pnlPeliculas.add(lblGenero);
		pnlPeliculas.add(lblResumen);
		
		scroll = new JScrollPane(pnlPeliculas);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		pnlContenedor.add(scroll, "peliculas"); //se agrega el scroll y no el panelPeliculas porque el scroll envuelve al panel
		
		setVisible(true);
	}
	
	public JPanel getPanelContenedor() {
		return pnlContenedor;
	}
	
	public void mostrarPantalla(String pantalla) {
		switch (pantalla) {
			case "espera": 
				layout.show(pnlContenedor, "espera");
				break;
			case "pelicula":
				layout.show(pnlContenedor, "peliculas");
				break;
		}
	}
	
	public void mostrarPeliculas(List<Pelicula> peliculas) {
		for (Pelicula p : peliculas) {
		
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new VentanaBienvenida());
	}
}
