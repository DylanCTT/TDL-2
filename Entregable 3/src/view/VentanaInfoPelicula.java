package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.Pelicula;

public class VentanaInfoPelicula extends JPanel {
	private JLabel lblTitulo;
	private JLabel lblAnio;
	private JLabel lblSinopsisHeader = new JLabel("Sinopsis");
    private JTextArea txtResumen;
	private JButton btnContinuar = new JButton("Continuar");
	private JScrollPane scrollResumen;
	
	private Color colorFondo = Color.WHITE;
    private Color colorBoton = Color.BLUE;
    private Color colorTextoBoton = Color.WHITE;
    
    private Font fuenteTitulo = new Font("Arial", Font.BOLD, 24);
    private Font fuenteSubtitulo = new Font("Arial", Font.BOLD, 16);
    private Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);    
    private Font fuenteDetalle = new Font("Arial", Font.ITALIC, 14);
	
	public VentanaInfoPelicula() {
		this(null);
	}
	
	public VentanaInfoPelicula(Pelicula p) {
		setLayout(new BorderLayout());
		setBackground(colorFondo);
		
		JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.setBackground(colorFondo);
        pnlNorte.setBorder(new EmptyBorder(20, 40, 10, 40));
		
		lblTitulo = new JLabel("Titulo", SwingConstants.CENTER);
		lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(Color.BLACK);
        
        pnlNorte.add(lblTitulo, BorderLayout.CENTER);
        add(pnlNorte, BorderLayout.NORTH);
        
        JPanel pnlCentro = new JPanel(new GridBagLayout());
        pnlCentro.setBackground(colorFondo);
        pnlCentro.setBorder(new EmptyBorder(10, 60, 20, 60));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        
        lblAnio = new JLabel("Año");
        lblAnio.setFont(fuenteDetalle);
        lblAnio.setForeground(Color.DARK_GRAY);
        lblAnio.setHorizontalAlignment(SwingConstants.CENTER);
        
        gbc.gridy = 0;
        pnlCentro.add(lblAnio, gbc);
        
        lblSinopsisHeader.setFont(fuenteSubtitulo);
        lblSinopsisHeader.setHorizontalAlignment(SwingConstants.LEFT);
        lblSinopsisHeader.setBorder(new EmptyBorder(20, 0, 5, 0));
        
        gbc.gridy = 1;
        pnlCentro.add(lblSinopsisHeader, gbc);
        
        txtResumen = new JTextArea();
        txtResumen.setWrapStyleWord(true);
        txtResumen.setLineWrap(true);
        txtResumen.setEditable(false);
        txtResumen.setFont(fuenteTexto);
        txtResumen.setBackground(colorFondo);
        txtResumen.setBorder(null);
        
        scrollResumen = new JScrollPane(txtResumen);
        scrollResumen.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        scrollResumen.setPreferredSize(new Dimension(400, 150));
        
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        pnlCentro.add(scrollResumen, gbc);
        
        add(pnlCentro, BorderLayout.CENTER);
        
        JPanel pnlSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlSur.setBackground(colorFondo);
        pnlSur.setBorder(new EmptyBorder(10, 0, 30, 0));
        
        btnContinuar.setFont(new Font("Arial", Font.BOLD, 14));
        btnContinuar.setBackground(colorBoton);
        btnContinuar.setForeground(colorTextoBoton);
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        btnContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        pnlSur.add(btnContinuar);
        add(pnlSur, BorderLayout.SOUTH);
        				
		if (p != null) actualizarPelicula(p);
	}
	
	public void actualizarPelicula(Pelicula p) {
		if (p != null) {
            
			lblTitulo.setText(p.getTitulo() != null ? p.getTitulo() : "Titulo no disponible");
			
			if (p.getAnioSalida() > 0) lblAnio.setText("Año: " + p.getAnioSalida());		
			else lblAnio.setText("Año: No disponible");
			
			txtResumen.setText(p.getResumen() != null ? p.getResumen() : "Resumen no disponible");
			
			SwingUtilities.invokeLater(() -> {
                scrollResumen.getVerticalScrollBar().setValue(0);
            });
			
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