package view;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.Perfil;

public class VentanaPerfiles extends JPanel {
    private JLabel lblTitulo = new JLabel("¿Quién está viendo ahora?");
    private JPanel pnlPerfiles = new JPanel(new GridLayout(0, 3, 30, 30));
    private List<JButton> botonesSeleccionar = new ArrayList<>();
    private JButton btnAgregarPerfil = new JButton("Agregar perfil");
    private JButton btnCerrarSesion = new JButton("Cerrar sesión");

    private Color colorFondo = Color.WHITE;
    private Color colorBoton = Color.BLUE;
    private Color colorTextoBoton = Color.WHITE;
    private Font fuentePrincipal = new Font("Arial", Font.BOLD, 14);
    
    public VentanaPerfiles() {
        this(new ArrayList<Perfil>());
    }

    public VentanaPerfiles(ArrayList<Perfil> perfiles) {
        setLayout(new BorderLayout());
        setBackground(colorFondo);

        JPanel pnlNorte = new JPanel(new BorderLayout());
        pnlNorte.setBackground(colorFondo);
        pnlNorte.setBorder(new EmptyBorder(15, 20, 15, 20));
        
        btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 12)); 
        btnCerrarSesion.setForeground(Color.GRAY);
        btnCerrarSesion.setBackground(colorFondo);
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
        
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24)); 
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        pnlNorte.add(btnCerrarSesion, BorderLayout.WEST);
        pnlNorte.add(lblTitulo, BorderLayout.CENTER);
        pnlNorte.add(Box.createHorizontalStrut(100), BorderLayout.EAST);
        
        add(pnlNorte, BorderLayout.NORTH);
        
        JPanel contenedorCentral = new JPanel(new GridBagLayout());
        contenedorCentral.setBackground(colorFondo);
        
        pnlPerfiles.setBackground(colorFondo);
        
        actualizarPerfiles(perfiles);
        
        contenedorCentral.add(pnlPerfiles);
        add(contenedorCentral, BorderLayout.CENTER);
        
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setBackground(colorFondo);
        panelInferior.setBorder(new EmptyBorder(20, 0, 40, 0));
        
        btnAgregarPerfil.setFont(fuentePrincipal);
        btnAgregarPerfil.setBackground(colorBoton);
        btnAgregarPerfil.setForeground(colorTextoBoton);
        btnAgregarPerfil.setFocusPainted(false);
        btnAgregarPerfil.setBorder(BorderFactory.createEmptyBorder(12, 30, 12, 30));
        btnAgregarPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAgregarPerfil.setPreferredSize(new Dimension(220, 50));      
     
        panelInferior.add(btnAgregarPerfil);
        add(panelInferior, BorderLayout.SOUTH);
    }

	public void actualizarPerfiles(ArrayList<Perfil> perfiles) {
		pnlPerfiles.removeAll();
		botonesSeleccionar.clear();
		
		if (perfiles != null) {
			for (Perfil p : perfiles) {
				JPanel pnlPerfil = new JPanel(new BorderLayout());
                Color colorPerfil = obtenerColor(p.getColor());
                pnlPerfil.setBackground(colorPerfil);
                pnlPerfil.setPreferredSize(new Dimension(180, 180));
                
                pnlPerfil.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(230,230,230), 1),
                    BorderFactory.createEmptyBorder(20, 10, 20, 10)
                ));

                JLabel lblNombre = new JLabel(p.getNombre());
                lblNombre.setForeground(Color.WHITE); 
                lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
                lblNombre.setHorizontalAlignment(SwingConstants.CENTER);

                JButton btnSeleccion = new JButton("Entrar");
                btnSeleccion.setBackground(Color.WHITE);
                btnSeleccion.setForeground(colorPerfil);
                btnSeleccion.setFont(new Font("Arial", Font.BOLD, 12));
                btnSeleccion.setFocusPainted(false);
                btnSeleccion.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
                btnSeleccion.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                botonesSeleccionar.add(btnSeleccion);
                
                pnlPerfil.add(lblNombre, BorderLayout.CENTER);
                
                JPanel pnlBotonHolder = new JPanel(new FlowLayout(FlowLayout.CENTER));
                pnlBotonHolder.setOpaque(false);
                pnlBotonHolder.add(btnSeleccion);
                
                pnlPerfil.add(pnlBotonHolder, BorderLayout.SOUTH);
                
                pnlPerfiles.add(pnlPerfil);
			}
		}
		
		pnlPerfiles.revalidate();
		pnlPerfiles.repaint();
	}
	
	private Color obtenerColor(String nombreColor) {
		if (nombreColor == null) return Color.GRAY;
		
		switch (nombreColor) {
			case "Rojo": return Color.RED;
			case "Verde": return Color.GREEN;
			case "Azul": return Color.BLUE;
			default : return Color.GRAY;
		}
	}
    
	public void btnCerrarSesionListener(ActionListener l) {
		btnCerrarSesion.addActionListener(l);
	}
    
	public void addSeleccionarListener(ActionListener l) {
		for (JButton b : botonesSeleccionar) {
			b.addActionListener(l);
		}
	}
	
	public void addAgregarPerfilListener(ActionListener l) {
		btnAgregarPerfil.addActionListener(l);
	}
	
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JPanel getPnlPerfiles() {
		return pnlPerfiles;
	}

	public void setPnlPerfiles(JPanel pnlPerfiles) {
		this.pnlPerfiles = pnlPerfiles;
	}

	 public JButton getBotonCerrarSesion() {
	    return btnCerrarSesion;
	 }
	
	public List<JButton> getBotonesSeleccionar() {
		return botonesSeleccionar;
	}
	
	public JButton getBotonAgregarPerfiles() {
		return btnAgregarPerfil;
	}
	
	public void mostrarMensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}
}