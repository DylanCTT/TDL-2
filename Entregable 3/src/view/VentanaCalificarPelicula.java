package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.Pelicula;
import model.Perfil;

public class VentanaCalificarPelicula extends JPanel {
	private JLabel lblTitulo;
	private JPanel pnlCentro = new JPanel();
	private JLabel lblCalificacion = new JLabel("Puntaje");
	private JButton[] estrellas;
	private JPanel pnlEstrellas = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
	private JLabel lblComentario = new JLabel("Escribí tu reseña");
	private JTextArea taComentario = new JTextArea(5, 30);
	private JScrollPane scrollComentario;
	private JButton btnGuardar = new JButton("Subir reseña");
	private JButton btnVolver = new JButton("← Volver");
	
	private int puntaje = 0;
    private Pelicula peliculaActual;
    private Integer idPerfilActual;
	
    private Color colorFondo = Color.WHITE;
    private Color colorBoton = Color.BLUE;
    private Color colorTextoBoton = Color.WHITE;
	
    private Font fuenteTitulo = new Font("Arial", Font.BOLD, 24);
    private Font fuenteSubtitulo = new Font("Arial", Font.BOLD, 16);
    private Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);
    private Font fuenteEstrellas = new Font("SansSerif", Font.BOLD, 40);
     
    public VentanaCalificarPelicula() {
        setLayout(new BorderLayout());
        setBackground(colorFondo);
 
        JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.setBackground(colorFondo);
        pnlNorte.setBorder(new EmptyBorder(15, 20, 10, 20));

        btnVolver.setFont(new Font("Arial", Font.PLAIN, 12));
        btnVolver.setForeground(Color.GRAY);
        btnVolver.setBackground(colorFondo);
        btnVolver.setBorder(null);
        btnVolver.setFocusPainted(false);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
        
        lblTitulo = new JLabel("Título", SwingConstants.CENTER);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(Color.BLACK);

        pnlNorte.add(btnVolver, BorderLayout.WEST);
        pnlNorte.add(lblTitulo, BorderLayout.CENTER);
        pnlNorte.add(Box.createHorizontalStrut(80), BorderLayout.EAST); 
        
        add(pnlNorte, BorderLayout.NORTH);

        JPanel pnlCentro = new JPanel(new GridBagLayout());
        pnlCentro.setBackground(colorFondo);
        pnlCentro.setBorder(new EmptyBorder(20, 50, 20, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 5, 0);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lblCalificacion.setFont(fuenteSubtitulo);
        lblCalificacion.setHorizontalAlignment(SwingConstants.CENTER);
        
        gbc.gridy = 0;
        pnlCentro.add(lblCalificacion, gbc);

        pnlEstrellas.setBackground(colorFondo);
        crearEstrellas(pnlEstrellas);
        
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 30, 0);
        pnlCentro.add(pnlEstrellas, gbc);

        lblComentario.setFont(fuenteSubtitulo);
        lblComentario.setHorizontalAlignment(SwingConstants.LEFT);
        
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 5, 0);
        pnlCentro.add(lblComentario, gbc);

        taComentario.setFont(fuenteTexto);
        taComentario.setLineWrap(true);
        taComentario.setWrapStyleWord(true);
        taComentario.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        scrollComentario = new JScrollPane(taComentario);
        scrollComentario.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        scrollComentario.setPreferredSize(new Dimension(500, 120));
        
        gbc.gridy = 3;
        gbc.weighty = 1.0; 
        gbc.fill = GridBagConstraints.BOTH;
        pnlCentro.add(scrollComentario, gbc);

        add(pnlCentro, BorderLayout.CENTER);

        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSur.setBackground(colorFondo);
        panelSur.setBorder(new EmptyBorder(20, 0, 40, 0));

        btnGuardar.setBackground(colorBoton);
        btnGuardar.setForeground(colorTextoBoton);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 14));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBorder(BorderFactory.createEmptyBorder(12, 40, 12, 40));
        btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        panelSur.add(btnGuardar);
        add(panelSur, BorderLayout.SOUTH);
    }

    public void actualizarPelicula(Pelicula p) {
        this.peliculaActual = p;
        if (p != null) {
            lblTitulo.setText(p.getTitulo());
        }
        puntaje = 0;
        taComentario.setText("");
        actualizarEstrellas();
    }
    
    public void actualizarPerfil(Perfil p) {
    	this.idPerfilActual = p.getId();
    }
    
    public void setIdPerfil(Integer idPerfil) {
        this.idPerfilActual = idPerfil;
    }
    
    public Pelicula getPeliculaActual() {
        return peliculaActual;
    }
    
    public Integer getIdPerfilActual() {
        return idPerfilActual;
    }
    
    private void actualizarEstrellas() {
        for (int i = 0; i < estrellas.length; i++) {
            if (i < puntaje) {
                estrellas[i].setText("\u2605");
            } else {
                estrellas[i].setText("\u2606"); 
            }
        }
    }

    private void crearEstrellas(JPanel pnlEstrellas) {
    	estrellas = new JButton[5];
    	
    	for (int i = 0; i < 5; i++) {
    		estrellas[i] = new JButton("\u2606");
    		estrellas[i].setFont(new Font("SansSerif", Font.BOLD, 30));
    		estrellas[i].setForeground(Color.orange);
    		estrellas[i].setBorderPainted(false);
    		estrellas[i].setContentAreaFilled(false);
    		estrellas[i].setFocusPainted(false);
    		
    		final int index = i;
    		estrellas[i].addActionListener(e -> {
    			puntaje = index + 1;
    			actualizarEstrellas();
    		});
    		
    		pnlEstrellas.add(estrellas[i]);
    	}
    }
    
    public void addEstrellasListener(ActionListener l) {
    	for (int i = 0; i < 5; i++) {
    		estrellas[i].addActionListener(l);
    	}
    }
    
    public void addGuardarListener(ActionListener l) {
    	btnGuardar.addActionListener(l);
    }
    
    public int getPuntaje() {
    	return puntaje;
    }
    
    public void setPuntaje(int puntaje) {
    	this.puntaje = puntaje;
    	actualizarEstrellas();
    }
    
    public String getTaComentario() {
    	return taComentario.getText();
    }
    
    public JTextArea getTaComentarioComponent() {
    	return taComentario;
    }
    
    public JButton getBotonGuardar() {
    	return btnGuardar;
    }
    
    public JButton[] getEstrellas() {
    	return estrellas;
    }
    
    public void addVolverListener(ActionListener l) {
        btnVolver.addActionListener(l);
    }

    public JButton getBotonVolver() {
        return btnVolver;
    }
    
    public void mostrarMensaje(String msj) {
        JOptionPane.showMessageDialog(this, msj);
    }
    
    public void mostrarMensajeError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
}