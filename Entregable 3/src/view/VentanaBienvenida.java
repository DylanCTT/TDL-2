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

    private JTextField campoBusqueda = new JTextField(20);
    private JButton btnBuscar = new JButton("Buscar");

    public VentanaBienvenida() {
        this(new ArrayList<Pelicula>());
    }

    public VentanaBienvenida(List<Pelicula> peliculas) {
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        setLayout(new BorderLayout());

        //Panel de carga
        panelCargando = new JPanel(new BorderLayout());
        JLabel lblCargando = new JLabel("Cargando películas...", SwingConstants.CENTER);
        lblCargando.setFont(new Font("Arial", Font.BOLD, 24));
        panelCargando.add(lblCargando, BorderLayout.CENTER);

        // Panel de películas
        panelPeliculas = new JPanel();
        panelPeliculas.setLayout(new BoxLayout(panelPeliculas, BoxLayout.Y_AXIS));

        mostrarPeliculas(peliculas);

        // Panel superior con título, subtítulo y buscador
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel lblTitulo = new JLabel("Bienvenido a la Plataforma de Streaming");
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 26));
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel lblSubtitulo = new JLabel("Seguro viste alguna de estas películas, haznos saber qué te pareció dejando una reseña");
        lblSubtitulo.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblSubtitulo.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel panelTextos = new JPanel();
        panelTextos.setLayout(new BoxLayout(panelTextos, BoxLayout.Y_AXIS));
        panelTextos.add(lblTitulo);
        panelTextos.add(lblSubtitulo);

        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        campoBusqueda.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnBuscar.setFont(new Font("Calibri", Font.BOLD, 14));
        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(btnBuscar);

        panelSuperior.add(panelTextos, BorderLayout.CENTER);
        panelSuperior.add(panelBusqueda, BorderLayout.EAST);

        // Panel scrollable con películas
        JScrollPane scrollPeliculas = new JScrollPane(panelPeliculas);
        scrollPeliculas.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        // Panel final armado
        JPanel panelContenido = new JPanel(new BorderLayout());
        panelContenido.add(panelSuperior, BorderLayout.NORTH);
        panelContenido.add(scrollPeliculas, BorderLayout.CENTER);

        panelPrincipal.add(panelCargando, "CARGANDO");
        panelPrincipal.add(panelContenido, "PELICULAS");

        add(panelPrincipal, BorderLayout.CENTER);
        mostrarPantalla("espera");
    }

    public void addCalificarListener(ActionListener l) {
        for (JButton b : botonesCalificar) {
            b.addActionListener(l);
        }
    }

    public void addBuscarListener(ActionListener l) {
        btnBuscar.addActionListener(l);
    }

    public String getTextoBusqueda() {
        return campoBusqueda.getText().trim();
    }

    public List<JButton> getBotonesCalificar() {
        return botonesCalificar;
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
        botonesCalificar.clear();

        for (Pelicula p : peliculas) {
            JPanel tarjeta = new JPanel(new BorderLayout());
            tarjeta.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            tarjeta.setPreferredSize(new Dimension(850, 150));

            //Imagen o ícono por defecto
            JLabel lblImagen = new JLabel();
            lblImagen.setPreferredSize(new Dimension(100, 140));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            lblImagen.setText("Imagen");
            lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            lblImagen.setFont(new Font("Arial", Font.PLAIN, 12));

            //Datos de la película
            JPanel panelDatos = new JPanel();
            panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
            panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel lblTitulo = new JLabel("Título: " + p.getTitulo());
            lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

            JLabel lblGenero = new JLabel("Género: " + p.getGenero());
            lblGenero.setFont(new Font("Arial", Font.PLAIN, 14));

            JTextArea txtResumen = new JTextArea(p.getResumen());
            txtResumen.setLineWrap(true);
            txtResumen.setWrapStyleWord(true);
            txtResumen.setEditable(false);
            txtResumen.setFont(new Font("Arial", Font.PLAIN, 13));
            txtResumen.setBackground(panelDatos.getBackground());

            panelDatos.add(lblTitulo);
            panelDatos.add(lblGenero);
            panelDatos.add(txtResumen);

            //Botón calificar
            JButton btnCalificar = new JButton("Calificar");
            btnCalificar.setPreferredSize(new Dimension(100, 30));
            botonesCalificar.add(btnCalificar);

            tarjeta.add(lblImagen, BorderLayout.WEST);
            tarjeta.add(panelDatos, BorderLayout.CENTER);
            tarjeta.add(btnCalificar, BorderLayout.EAST);

            panelPeliculas.add(Box.createVerticalStrut(10));
            panelPeliculas.add(tarjeta);
        }

        panelPeliculas.revalidate();
        panelPeliculas.repaint();
    }

    public void mostrarMensajeError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
}
