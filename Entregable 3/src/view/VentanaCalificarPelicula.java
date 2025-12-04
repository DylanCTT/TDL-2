package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Pelicula;

public class VentanaCalificarPelicula extends JFrame {
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

    public VentanaCalificarPelicula(Pelicula p) {
        setTitle("Calificar Película");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
   
        lblTitulo = new JLabel(p.getTitulo(), SwingConstants.CENTER);         
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 18));
        
        lblCalificacion.setFont(new Font("Calibri", Font.BOLD, 15));
        crearEstrellas(pnlCalificacion);
        
        lblComentario.setFont(new Font("Calibri", Font.BOLD, 15));
        
        taComentario.setFont(new Font("Calibri", Font.BOLD, 13));
        taComentario.setLineWrap(true); // para que el texto baje automaticamente
        
        scrollComentario = new JScrollPane(taComentario);
        
        pnlComentario.add(lblComentario, BorderLayout.NORTH);
        pnlComentario.add(scrollComentario, BorderLayout.CENTER);
        
        pnlCentro.setLayout(new GridLayout(2,2));
        pnlCentro.add(pnlCalificacion);
        pnlCentro.add(pnlComentario);
        
        btnGuardar.setBackground(Color.BLUE);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Calibri", Font.BOLD, 14));
                
        add(lblTitulo, BorderLayout.NORTH);
        add(pnlCentro, BorderLayout.CENTER);
        add(btnGuardar, BorderLayout.SOUTH);
           
        setVisible(true);
    }

    private void crearEstrellas(JPanel pnlCalifiacion) {
    	estrellas = new JButton[5];
    	
    	for (int i = 0; i < 5; i++) {
    		estrellas[i] = new JButton("\u2606");
    		estrellas[i].setFont(new Font("SansSerif", Font.BOLD, 30));
    		estrellas[i].setForeground(Color.orange);
    		//estrellas[i].setBorderPainted(false);
    		//estrellas[i].setContentAreaFilled(false);
    		//estrellas[i].setFocusPainted(false);
    		
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
    
    public String getTaComentario() {
    	return taComentario.getText();
    }
    
    public JButton getBotonGuardar() {
    	return btnGuardar;
    }
    
    public static void main(String args[]) {
    	Pelicula p = new Pelicula();
		VentanaCalificarPelicula califPeli = new VentanaCalificarPelicula(p);
	}
}
