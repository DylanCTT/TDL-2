package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Pelicula;

public class VentanaInfoPelicula extends JPanel {
	private JLabel lblTitulo;
	private JPanel pnlCentro = new JPanel();
	private JLabel lblAnio;
	private JLabel lblResumen;
	private JButton btnContinuar = new JButton("Continuar");
	
	public VentanaInfoPelicula() {
		this(null);
	}
	
	public VentanaInfoPelicula(Pelicula p) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 400));
		
		lblTitulo = new JLabel("", SwingConstants.CENTER);
		lblAnio = new JLabel("");
		lblResumen = new JLabel("");
		
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAnio.setFont(new Font("Calibri", Font.BOLD, 14));
		lblResumen.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblResumen.setVerticalAlignment(SwingConstants.TOP);
		
		btnContinuar.setBackground(Color.BLUE);
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setFont(new Font("Calibri", Font.BOLD, 14));
		
		pnlCentro.setLayout(new GridLayout(2,1));
		pnlCentro.add(lblAnio);
		pnlCentro.add(lblResumen);
		
		add(lblTitulo, BorderLayout.NORTH);
		add(pnlCentro, BorderLayout.CENTER);
		add(btnContinuar, BorderLayout.SOUTH);
		
		if (p != null) actualizarPelicula(p);
	}
	
	public void actualizarPelicula(Pelicula p) {
		if (p != null) {
			lblTitulo.setText(p.getTitulo() != null ? p.getTitulo() : "Titulo no disponilbe");
			
			if (p.getAnioSalida() > 0) lblAnio.setText("Año: " + p.getAnioSalida());		
			else lblAnio.setText("Año: No disponible");
			
			lblResumen.setText(p.getResumen() != null ? p.getResumen() : "Resumen no disponible");
		}
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
	
	public void mostrarMensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}
}