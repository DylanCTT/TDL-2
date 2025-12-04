package view;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Pelicula;

public class VentanaBienvenida extends JPanel {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JPanel panelCargando;
    private JPanel panelPeliculas;
    private List<JButton> botonesCalificar = new ArrayList<>();

    public VentanaBienvenida() {
        this(new java.util.ArrayList<Pelicula>());
    }

    public VentanaBienvenida(List<Pelicula> peliculas) {
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        setLayout(new BorderLayout());

        panelCargando = new JPanel(new BorderLayout());
        JLabel lblCargando = new JLabel("Cargando películas...", SwingConstants.CENTER);
        lblCargando.setFont(new Font("Arial", Font.BOLD, 24));
        panelCargando.add(lblCargando, BorderLayout.CENTER);

        panelPeliculas = new JPanel();
        panelPeliculas.setLayout(new BoxLayout(panelPeliculas, BoxLayout.Y_AXIS));

        mostrarPeliculas(peliculas);
        
        panelPrincipal.add(panelCargando, "CARGANDO");
        panelPrincipal.add(new JScrollPane(panelPeliculas), "PELICULAS");

        add(panelPrincipal, BorderLayout.CENTER);
        
        mostrarPantalla("espera");
    }
    
    public void addCalificarListener(ActionListener l) {
    	for (JButton b : botonesCalificar) {
    		b.addActionListener(l);
    	}
    }
    
    public List<JButton> getBotonesCalificar() {
    	return botonesCalificar;
    }
    
    public void mostrarPantalla(String pantalla) {
        if (pantalla.equals("espera") || pantalla.equals("CARGANDO")) {
            cardLayout.show(panelPrincipal, "CARGANDO");
        } 
        else if (pantalla.equals("peliculas") || pantalla.equals("PELICULAS")) {
            cardLayout.show(panelPrincipal, "PELICULAS");
        }
    }
    
    public void mostrarPeliculas(List<Pelicula> peliculas) {
        panelPeliculas.removeAll();
        botonesCalificar.clear();
        
        for (Pelicula p : peliculas) {
            JPanel tarjeta = new JPanel(new BorderLayout());
            tarjeta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel lblTitulo = new JLabel(p.getTitulo());
            lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

            JTextArea txtResumen = new JTextArea(p.getResumen());
            txtResumen.setLineWrap(true);
            txtResumen.setWrapStyleWord(true);
            txtResumen.setEditable(false);

            JButton btnCalificar = new JButton("Calificar");
            botonesCalificar.add(btnCalificar);
            
            tarjeta.add(lblTitulo, BorderLayout.NORTH);
            tarjeta.add(new JScrollPane(txtResumen), BorderLayout.CENTER);
            tarjeta.add(btnCalificar, BorderLayout.SOUTH);

            panelPeliculas.add(tarjeta);
        }
        
        panelPeliculas.revalidate();
        panelPeliculas.repaint();
    }
    
    public void mostrarMensajeError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    } 
}
