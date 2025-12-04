package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.Pelicula;

public class VentanaBienvenida extends JPanel {

    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JPanel panelCargando;
    private JPanel panelPeliculas;

    public VentanaBienvenida(List<Pelicula> peliculas) {
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        setLayout(new BorderLayout());

        // Panel de carga
        panelCargando = new JPanel(new BorderLayout());
        JLabel lblCargando = new JLabel("Cargando películas...", SwingConstants.CENTER);
        lblCargando.setFont(new Font("Arial", Font.BOLD, 24));
        panelCargando.add(lblCargando, BorderLayout.CENTER);

        // Panel de películas
        panelPeliculas = new JPanel();
        panelPeliculas.setLayout(new BoxLayout(panelPeliculas, BoxLayout.Y_AXIS));

        if (peliculas != null) {
            for (Pelicula p : peliculas) {
                agregarPelicula(p);
            }
        }

        panelPrincipal.add(panelCargando, "CARGANDO");
        panelPrincipal.add(new JScrollPane(panelPeliculas), "PELICULAS");

        add(panelPrincipal, BorderLayout.CENTER);
        
        // Mostrar pantalla de carga por defecto
        mostrarPantalla("espera");
    }
    
    public void mostrarPantalla(String pantalla) {
        if (pantalla.equals("espera") || pantalla.equals("CARGANDO")) {
            cardLayout.show(panelPrincipal, "CARGANDO");
        } else if (pantalla.equals("peliculas") || pantalla.equals("PELICULAS")) {
            cardLayout.show(panelPrincipal, "PELICULAS");
        }
    }
    
    public void mostrarPeliculas(List<Pelicula> peliculas) {
        panelPeliculas.removeAll();
        
        for (Pelicula p : peliculas) {
            agregarPelicula(p);
        }
        
        panelPeliculas.revalidate();
        panelPeliculas.repaint();
    }
    
    private void agregarPelicula(Pelicula p) {
        JPanel tarjeta = new JPanel(new BorderLayout());
        tarjeta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel(p.getTitulo());
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JTextArea txtResumen = new JTextArea(p.getResumen());
        txtResumen.setLineWrap(true);
        txtResumen.setWrapStyleWord(true);
        txtResumen.setEditable(false);

        JButton btnCalificar = new JButton("Calificar");
        
        tarjeta.add(lblTitulo, BorderLayout.NORTH);
        tarjeta.add(new JScrollPane(txtResumen), BorderLayout.CENTER);
        tarjeta.add(btnCalificar, BorderLayout.SOUTH);

        panelPeliculas.add(tarjeta);
    }
    
    public void mostrarMensajeError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }

   
}
