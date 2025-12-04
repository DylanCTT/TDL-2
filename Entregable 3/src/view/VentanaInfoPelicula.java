package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Pelicula;

public class VentanaInfoPelicula extends JFrame{
	private JLabel lblTitulo;
	JPanel pnlCentro = new JPanel();
	private JLabel lblAnio;
	private JLabel lblResumen;
	private JButton btnContinuar = new JButton("Continuar");
	
	public VentanaInfoPelicula(Pelicula p) {
		setTitle("Informacion pelicula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		lblTitulo = new JLabel(p.getTitulo());
		lblAnio = new JLabel("Anio: " + String.valueOf(p.getFechaSalida().getYear()));
		lblResumen = new JLabel(p.getResumen());
			
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblAnio.setFont(new Font("Calibri", Font.BOLD, 14));
		lblResumen.setFont(new Font("Calibri", Font.BOLD, 14));
		
		btnContinuar.setBackground(Color.BLUE);
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setFont(new Font("Calibri", Font.BOLD, 14));
		
		pnlCentro.setLayout(new GridLayout(2,1));
		pnlCentro.add(lblAnio);
		pnlCentro.add(lblResumen);
		
		add(lblTitulo, BorderLayout.NORTH);
		add(pnlCentro, BorderLayout.CENTER);
		add(btnContinuar, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void addContinuarListener(ActionListener l) {
		btnContinuar.addActionListener(l);
	}
	
	public JButton getBotonContinuar() {
		return btnContinuar;
	}
	
	public void mostrarMensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args) {
		Pelicula p = new Pelicula();
		SwingUtilities.invokeLater(() -> new VentanaInfoPelicula(p));
	}
}