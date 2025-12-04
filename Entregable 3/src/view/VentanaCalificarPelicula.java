package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Pelicula;
import model.Perfil;

public class VentanaCalificarPelicula extends JPanel {
	private JLabel lblTitulo;
	private JPanel pnlCentro = new JPanel();
	private JLabel lblCalificacion = new JLabel("Calificacion");
	private JButton[] estrellas;
	private JPanel pnlEstrellas = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private int puntaje = 0;
	private JPanel pnlComentario = new JPanel(new BorderLayout());
    private JLabel lblComentario = new JLabel("Comentario");
    private JTextArea taComentario = new JTextArea(5, 30);
    private JScrollPane scrollComentario;
    private JButton btnGuardar = new JButton("Guardar");
    private Pelicula peliculaActual;
    private Integer idPerfilActual;
    private JButton btnRetroceso = new JButton("← Volver");

    public VentanaCalificarPelicula() {
        this(null);
    }
    
    public VentanaCalificarPelicula(Pelicula p) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(950, 950));

        String titulo = (p != null) ? p.getTitulo() : "Calificar Película";
        lblTitulo = new JLabel(titulo, SwingConstants.CENTER);         
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 26));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

        //Estrellas
        lblCalificacion.setFont(new Font("Calibri", Font.BOLD, 18));
        crearEstrellas(pnlEstrellas);

        JPanel pnlCalificacion = new JPanel(new BorderLayout());
        pnlCalificacion.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        pnlCalificacion.add(lblCalificacion, BorderLayout.NORTH);
        pnlCalificacion.add(pnlEstrellas, BorderLayout.CENTER);

        //Comentario
        lblComentario.setFont(new Font("Calibri", Font.BOLD, 18));
        taComentario.setFont(new Font("Calibri", Font.PLAIN, 16));
        taComentario.setLineWrap(true);
        scrollComentario = new JScrollPane(taComentario);

        pnlComentario.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        pnlComentario.add(lblComentario, BorderLayout.NORTH);
        pnlComentario.add(scrollComentario, BorderLayout.CENTER);

        //Panel central agrupado
        pnlCentro = new JPanel();
        pnlCentro.setLayout(new BoxLayout(pnlCentro, BoxLayout.Y_AXIS));
        pnlCentro.setBorder(BorderFactory.createEmptyBorder(20, 200, 20, 200)); // centrado horizontal
        pnlCentro.add(pnlCalificacion);
        pnlCentro.add(Box.createVerticalStrut(20));
        pnlCentro.add(pnlComentario);

        //Botón guardar
        btnGuardar.setBackground(Color.BLUE);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Calibri", Font.BOLD, 16));
        btnGuardar.setPreferredSize(new Dimension(150, 40));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        panelBoton.add(btnGuardar);
        
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.add(btnRetroceso);
        add(panelSuperior, BorderLayout.NORTH);

        add(lblTitulo, BorderLayout.NORTH);
        add(pnlCentro, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    public void actualizarPelicula(Pelicula p) {
        this.peliculaActual = p;
        if (p != null) {
            lblTitulo.setText(p.getTitulo());
        }
        // Resetear el puntaje y comentario
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
                estrellas[i].setText("\u2605"); // Estrella llena
            } else {
                estrellas[i].setText("\u2606"); // Estrella vacía
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
    
    public void addRetrocesoListener(ActionListener l) {
        btnRetroceso.addActionListener(l);
    }

    public JButton getBotonRetroceso() {
        return btnRetroceso;
    }
    
    public void mostrarMensaje(String msj) {
        JOptionPane.showMessageDialog(this, msj);
    }
    
    public void mostrarMensajeError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
}