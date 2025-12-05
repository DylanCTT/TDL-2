package view;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Pelicula;
import model.Perfil;

public class VentanaBienvenida extends JPanel {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JPanel panelCargando;
    private JPanel panelPeliculas;
    private JLabel lblNombre;
    private JButton btnCerrarSesion;
    private JComboBox<String> cmbOrden;
    private List<JButton> botonesCalificar = new ArrayList<>();
    private JTextField campoBusqueda = new JTextField(20);
    private JButton btnBuscar;
    private JScrollPane scrollPeliculas;

    public VentanaBienvenida() {
        this(new ArrayList<Pelicula>());
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

        scrollPeliculas = new JScrollPane(panelPeliculas);
        scrollPeliculas.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        scrollPeliculas.getVerticalScrollBar().setUnitIncrement(20);
        
        mostrarPeliculas(peliculas);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel lblTitulo = new JLabel("Bienvenido a la Plataforma de Streaming");
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 26));
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel lblSubtitulo = new JLabel("Hacenos saber que te parecieron estas peliculas dejando una resena");
        lblSubtitulo.setFont(new Font("Calibri", Font.PLAIN, 16));
        lblSubtitulo.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel panelTextos = new JPanel();
        panelTextos.setLayout(new BoxLayout(panelTextos, BoxLayout.Y_AXIS));
        panelTextos.add(lblTitulo);
        panelTextos.add(lblSubtitulo);

        JPanel pnlEste = new JPanel();
        pnlEste.setLayout(new BoxLayout(pnlEste, BoxLayout.Y_AXIS));
        
        JPanel pnlCerrarSesion = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblNombre = new JLabel("Nombre perfil");
        lblNombre.setFont(new Font("Calibri", Font.BOLD, 14));       
        btnCerrarSesion = new JButton("Cerrar sesion");
        btnCerrarSesion.setFont(new Font("Calibri", Font.BOLD, 14));       
        pnlCerrarSesion.add(lblNombre);
        pnlCerrarSesion.add(btnCerrarSesion);
        
        String[] opcionesOrden = {"Ordenar por...", "Titulo (Descendente)", "Titulo (Ascendente)", "Genero (Descendente)", "Genero (Ascendente)"};        
        cmbOrden = new JComboBox<>(opcionesOrden);
        cmbOrden.setPreferredSize(new Dimension(150, 30));
        
        JPanel pnlBusqueda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        campoBusqueda.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Calibri", Font.BOLD, 14));
        pnlBusqueda.add(cmbOrden);
        pnlBusqueda.add(Box.createHorizontalStrut(10));
        pnlBusqueda.add(campoBusqueda);
        pnlBusqueda.add(btnBuscar);
        
        pnlEste.add(pnlCerrarSesion);
        pnlEste.add(pnlBusqueda);
        
        panelSuperior.add(panelTextos, BorderLayout.CENTER);
        panelSuperior.add(pnlEste, BorderLayout.EAST);

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
    
    public void addCerrarSesionListener(ActionListener l) {
    	btnCerrarSesion.addActionListener(l);
    }
    
    public void addOrdenListener(ActionListener l) {
    	cmbOrden.addActionListener(l);
    }
    
    public void actualizarPerfil(Perfil p) {
    	if (p != null) {
    		lblNombre.setText(p.getNombre() != null ? p.getNombre() : "Nombre no disponible");
    	}
    }

    public String getTextoBusqueda() {
        return campoBusqueda.getText().trim();
    }
    
    public void setTextoBusqueda(String texto) {
    	this.campoBusqueda.setText(texto);
    }

    public JComboBox<String> getCmbOrden() {
    	return cmbOrden;
    }
    
    public List<JButton> getBotonesCalificar() {
        return botonesCalificar;
    }
    
    public JButton getBtnBuscar() {
		return btnBuscar;
	}

    public JButton getBtnCerrarSesion() {
    	return btnCerrarSesion;
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
            lblImagen.setText("Imagen no disponible");
            lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            lblImagen.setFont(new Font("Arial", Font.PLAIN, 12));

            //Datos de la película
            JPanel panelDatos = new JPanel();
            panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
            panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel lblTitulo = new JLabel(p.getTitulo());
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
        
        SwingUtilities.invokeLater(() -> {
        	if (scrollPeliculas != null) {
        		scrollPeliculas.getVerticalScrollBar().setValue(0);
        	}
        });
    }

    public void mostrarMensajeError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }  
}
