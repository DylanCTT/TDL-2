package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Pelicula;

public class VentanaCalificarPelicula extends JPanel {
	private JLabel lblTitulo;
	private JPanel pnlCentro = new JPanel();
	private JLabel lblCalificacion = new JLabel("Calificacion");
	private JButton[] estrellas;
	private JPanel pnlCalificacion = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private int puntaje = 0;
	private JPanel pnlComentario = new JPanel(new BorderLayout());
    private JLabel lblComentario = new JLabel("Comentario");
    private JTextArea taComentario = new JTextArea(5, 30);
    private JScrollPane scrollComentario;
    private JButton btnGuardar = new JButton("Guardar");
    private Pelicula peliculaActual;
    private Integer idPerfilActual;

    public VentanaCalificarPelicula() {
        this(null);
    }
    
    public VentanaCalificarPelicula(Pelicula p) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 400));
   
        String titulo = (p != null) ? p.getTitulo() : "Calificar Película";
        lblTitulo = new JLabel(titulo, SwingConstants.CENTER);         
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 18));
        
        lblCalificacion.setFont(new Font("Calibri", Font.BOLD, 15));
        crearEstrellas(pnlCalificacion);
        
        // Panel para la calificación
        JPanel pnlCalificacionCompleto = new JPanel(new BorderLayout());
        pnlCalificacionCompleto.add(lblCalificacion, BorderLayout.NORTH);
        pnlCalificacionCompleto.add(pnlCalificacion, BorderLayout.CENTER);
        
        lblComentario.setFont(new Font("Calibri", Font.BOLD, 15));
        
        taComentario.setFont(new Font("Calibri", Font.BOLD, 13));
        taComentario.setLineWrap(true); // para que el texto baje automaticamente
        
        scrollComentario = new JScrollPane(taComentario);
        
        pnlComentario.add(lblComentario, BorderLayout.NORTH);
        pnlComentario.add(scrollComentario, BorderLayout.CENTER);
        
        pnlCentro.setLayout(new GridLayout(2,1));
        pnlCentro.add(pnlCalificacionCompleto);
        pnlCentro.add(pnlComentario);
        
        btnGuardar.setBackground(Color.BLUE);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Calibri", Font.BOLD, 14));
                
        add(lblTitulo, BorderLayout.NORTH);
        add(pnlCentro, BorderLayout.CENTER);
        add(btnGuardar, BorderLayout.SOUTH);
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

    private void crearEstrellas(JPanel pnlCalificacion) {
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
    		
    		pnlCalificacion.add(estrellas[i]);
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
    
    public void mostrarMensaje(String msj) {
        JOptionPane.showMessageDialog(this, msj);
    }
    
    public void mostrarMensajeError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
}