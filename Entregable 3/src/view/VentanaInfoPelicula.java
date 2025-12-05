package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Pelicula;

public class VentanaInfoPelicula extends JPanel {
	private JLabel lblTitulo;
	private JPanel pnlCentro = new JPanel();
	private JLabel lblAnio;
	private JTextArea txtResumen;
	private JButton btnContinuar = new JButton("Continuar");
	
	public VentanaInfoPelicula() {
		this(null);
	}
	
	public VentanaInfoPelicula(Pelicula p) {
		setLayout(new BorderLayout());
		
		lblTitulo = new JLabel("", SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 18));
		
		txtResumen = new JTextArea("");
		txtResumen.setWrapStyleWord(true);
		txtResumen.setEditable(false);
		txtResumen.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		lblAnio = new JLabel("");
		lblAnio.setFont(new Font("Calibri", Font.BOLD, 14));
		
		btnContinuar.setBackground(Color.BLUE);
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setFont(new Font("Calibri", Font.BOLD, 14));
		
		pnlCentro.setLayout(new GridLayout(10,10));
		pnlCentro.add(lblAnio, BorderLayout.NORTH);
		pnlCentro.add(new JScrollPane(txtResumen), BorderLayout.CENTER);
		
		add(lblTitulo, BorderLayout.NORTH);
		add(pnlCentro, BorderLayout.CENTER);
		add(btnContinuar, BorderLayout.SOUTH);
		
		if (p != null) actualizarPelicula(p);
	}
	
	public void actualizarPelicula(Pelicula p) {
		if (p != null) {
            
			lblTitulo.setText(p.getTitulo() != null ? p.getTitulo() : "Titulo no disponible");
			
			if (p.getAnioSalida() > 0) lblAnio.setText("Año: " + p.getAnioSalida());		
			else lblAnio.setText("Año: No disponible");
			
			txtResumen.setText(p.getResumen() != null ? p.getResumen() : "Resumen no disponible");
			
			this.revalidate();
			this.repaint();
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