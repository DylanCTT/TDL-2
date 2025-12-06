package view;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.Pelicula;
import model.Perfil;

public class VentanaBienvenida extends JPanel {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JPanel panelCargando;
    private JPanel panelPeliculas;
    private JLabel lblNombre = new JLabel("Perfil");
    private JButton btnCerrarSesion = new JButton("Cerrar sesión");
    private JComboBox<String> cmbOrden;
    private JTextField campoBusqueda = new JTextField(20);
    private JButton btnBuscar = new JButton("Buscar");
    private List<JButton> botonesCalificar = new ArrayList<>(); 
    private JScrollPane scrollPeliculas;

    private Color colorFondo = Color.WHITE;
    private Color colorBoton = Color.BLUE;
    private Color colorTextoBoton = Color.WHITE;
    private Font fuenteTitulo = new Font("Arial", Font.BOLD, 24);
    private Font fuenteSubtitulo = new Font("Arial", Font.PLAIN, 14);
    private Font fuenteBotones = new Font("Arial", Font.BOLD, 12);
    private Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);
    
    public VentanaBienvenida() {
        this(new ArrayList<Pelicula>());
    }

    public VentanaBienvenida(List<Pelicula> peliculas) {
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        setLayout(new BorderLayout());
        setBackground(colorFondo);

        panelCargando = new JPanel(new BorderLayout());
        panelCargando.setBackground(colorFondo);

        JPanel panelContenidoGif = new JPanel();
        panelContenidoGif.setLayout(new BoxLayout(panelContenidoGif, BoxLayout.Y_AXIS));
        panelContenidoGif.setBackground(colorFondo);
        panelContenidoGif.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblCargando = new JLabel("Cargando películas...");
        lblCargando.setFont(new Font("Arial", Font.BOLD, 24));
        lblCargando.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblGif = new JLabel();
        try {
            ImageIcon gifIcon = new ImageIcon("src/resources/gifCargando.gif");
            if (gifIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image gifEscalado = gifIcon.getImage().getScaledInstance(364, 205, Image.SCALE_DEFAULT);
                lblGif.setIcon(new ImageIcon(gifEscalado));
            }
        } catch (Exception e) {
            lblGif.setText("...");
        }
        lblGif.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelContenidoGif.add(Box.createVerticalGlue()); 
        panelContenidoGif.add(lblCargando);
        panelContenidoGif.add(Box.createVerticalStrut(20)); 
        panelContenidoGif.add(lblGif);
        panelContenidoGif.add(Box.createVerticalGlue()); 

        panelCargando.add(panelContenidoGif, BorderLayout.CENTER);

        panelPeliculas = new JPanel();
        panelPeliculas.setLayout(new BoxLayout(panelPeliculas, BoxLayout.Y_AXIS));
        panelPeliculas.setBackground(colorFondo);

        scrollPeliculas = new JScrollPane(panelPeliculas);
        scrollPeliculas.setBorder(null);
        scrollPeliculas.getVerticalScrollBar().setUnitIncrement(20);
        
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(colorFondo);
        panelSuperior.setBorder(new EmptyBorder(15, 30, 15, 30));

        JPanel pnlHeaderTop = new JPanel(new BorderLayout());
        pnlHeaderTop.setBackground(colorFondo);
        
        JLabel lblTitulo = new JLabel("Bienvenido a Vizyalize");
        lblTitulo.setFont(fuenteTitulo);
        
        JPanel pnlUsuario = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlUsuario.setBackground(colorFondo);
        
        lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
        
        btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 12));
        btnCerrarSesion.setForeground(Color.GRAY);
        btnCerrarSesion.setBackground(colorFondo);
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        pnlUsuario.add(lblNombre);
        pnlUsuario.add(new JLabel(" | "));
        pnlUsuario.add(btnCerrarSesion);
        
        pnlHeaderTop.add(lblTitulo, BorderLayout.WEST);
        pnlHeaderTop.add(pnlUsuario, BorderLayout.EAST);
        
        JPanel pnlHeaderBottom = new JPanel(new BorderLayout());
        pnlHeaderBottom.setBackground(colorFondo);
        pnlHeaderBottom.setBorder(new EmptyBorder(15, 0, 0, 0));

        JLabel lblSubtitulo = new JLabel("Explora el catálogo y deja tu reseña.");
        lblSubtitulo.setFont(fuenteSubtitulo);
        lblSubtitulo.setForeground(Color.DARK_GRAY);

        JPanel pnlBusqueda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlBusqueda.setBackground(colorFondo);
        
        String[] opcionesOrden = {"Ordenar por...", "Titulo (Descendente)", "Titulo (Ascendente)", "Genero (Descendente)", "Genero (Ascendente)"};        
        cmbOrden = new JComboBox<>(opcionesOrden);
        cmbOrden.setPreferredSize(new Dimension(180, 35));
        cmbOrden.setBackground(Color.WHITE);
        cmbOrden.setFont(new Font("Arial", Font.PLAIN, 12));
        
        campoBusqueda.setFont(fuenteTexto);
        campoBusqueda.setPreferredSize(new Dimension(200, 35));
        
        btnBuscar.setFont(fuenteBotones);
        btnBuscar.setBackground(colorBoton);
        btnBuscar.setForeground(colorTextoBoton);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        btnBuscar.setPreferredSize(new Dimension(100, 35));
        btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pnlBusqueda.add(cmbOrden);
        pnlBusqueda.add(Box.createHorizontalStrut(10));
        pnlBusqueda.add(campoBusqueda);
        pnlBusqueda.add(btnBuscar);
        
        pnlHeaderBottom.add(lblSubtitulo, BorderLayout.WEST);
        pnlHeaderBottom.add(pnlBusqueda, BorderLayout.EAST);

        panelSuperior.add(pnlHeaderTop, BorderLayout.NORTH);
        panelSuperior.add(pnlHeaderBottom, BorderLayout.SOUTH);

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

	private void cargarPosters(JLabel lblImagen, String urlPoster) {
		if ((urlPoster == null) || (urlPoster.isEmpty()) || urlPoster.equals("N/A")) {
			lblImagen.setText("Imagen no disponible");
			return;
		}
		
		Thread threadImagen = new Thread(() -> {
			try {
				java.net.URL url = new java.net.URI(urlPoster.trim()).toURL();
				java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();      		
        		connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        		
        		java.io.InputStream stream = connection.getInputStream();
        		java.awt.image.BufferedImage poster = javax.imageio.ImageIO.read(stream);
        		
        		if (poster != null) {
        			Image posterEscalado = poster.getScaledInstance(100, 140, Image.SCALE_SMOOTH);
        			ImageIcon icono = new ImageIcon(posterEscalado);
        			
        			lblImagen.setIcon(icono);
        			lblImagen.setText("");
        		} 
			}
			catch (Exception e) {
				SwingUtilities.invokeLater(() -> {
					System.out.println("Errr al descargar imagen (" + urlPoster + "): " + e.getMessage());
					lblImagen.setText("Error");
				});
			}
		});
		
		threadImagen.setDaemon(true);
		threadImagen.start();
	}
	
    public void mostrarPeliculas(List<Pelicula> peliculas) {
        panelPeliculas.removeAll();
        botonesCalificar.clear();

        for (Pelicula p : peliculas) {
            JPanel tarjeta = new JPanel(new BorderLayout());
            tarjeta.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            tarjeta.setPreferredSize(new Dimension(850, 150));

            JLabel lblImagen = new JLabel();
            lblImagen.setPreferredSize(new Dimension(100, 140));
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            lblImagen.setFont(new Font("Arial", Font.PLAIN, 12));
            
            cargarPosters(lblImagen, p.getPoster());                  

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
