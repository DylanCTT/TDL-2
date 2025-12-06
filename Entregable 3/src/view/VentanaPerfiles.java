package view;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Perfil;

public class VentanaPerfiles extends JPanel {
    private JLabel lblTitulo = new JLabel("¿Quién está viendo ahora?");
    private JPanel pnlPerfiles = new JPanel(new GridLayout(0, 3, 20, 20));
    private List<JButton> botonesSeleccionar = new ArrayList<>();
    private JButton btnAgregarPerfil = new JButton("Agregar perfil");
    private JButton btnCerrarSesion;

    public VentanaPerfiles() {
        this(new ArrayList<Perfil>());
    }

    public VentanaPerfiles(ArrayList<Perfil> perfiles) {
        setLayout(new BorderLayout());

        btnCerrarSesion = new JButton("Cerrar sesion");      
        JPanel pnlVolver = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlVolver.add(btnCerrarSesion);
        
        JPanel pnlTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 0));
        pnlTitulo.add(lblTitulo);

        JPanel pnlNorte = new JPanel();
        pnlNorte.setLayout(new BoxLayout(pnlNorte, BoxLayout.Y_AXIS));
        pnlNorte.add(pnlVolver);
        pnlNorte.add(pnlTitulo);
        add(pnlNorte, BorderLayout.NORTH);
        
 
        JPanel contenedorCentral = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contenedorCentral.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        pnlPerfiles.setPreferredSize(new Dimension(700, 500));
        pnlPerfiles.setOpaque(false);

        for (Perfil p : perfiles) {
            JPanel pnlPerfil = new JPanel(new BorderLayout());
            pnlPerfil.setBackground(new Color(0, 153, 0));
            pnlPerfil.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            pnlPerfil.setPreferredSize(new Dimension(200, 200));

            JLabel lblNombre = new JLabel(p.getNombre());
            lblNombre.setForeground(Color.WHITE);
            lblNombre.setFont(new Font("Calibri", Font.BOLD, 16));
            lblNombre.setHorizontalAlignment(SwingConstants.CENTER);

            JButton btnSeleccion = new JButton("Seleccionar");
            botonesSeleccionar.add(btnSeleccion);

            pnlPerfil.add(lblNombre, BorderLayout.CENTER);
            pnlPerfil.add(btnSeleccion, BorderLayout.SOUTH);

            pnlPerfiles.add(pnlPerfil);
        }

        contenedorCentral.add(pnlPerfiles);
        add(contenedorCentral, BorderLayout.CENTER);

        
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAgregarPerfil.setFont(new Font("Calibri", Font.BOLD, 16));
        btnAgregarPerfil.setPreferredSize(new Dimension(180, 40));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        panelInferior.add(btnAgregarPerfil);

        add(panelInferior, BorderLayout.SOUTH);
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
	
	private Color obtenerColor(String nombreColor) {
		if (nombreColor == null) return Color.GRAY;
		
		switch (nombreColor) {
			case "Rojo": return Color.RED;
			case "Verde": return Color.GREEN;
			case "Azul": return Color.BLUE;
			default : return Color.GRAY;
		}
	}
	
	public void actualizarPerfiles(ArrayList<Perfil> perfiles) {
		pnlPerfiles.removeAll();
		botonesSeleccionar.clear();
		
		if (perfiles != null) {
			for (Perfil p : perfiles) {
				JPanel pnlPerfil = new JPanel(new BorderLayout());
				pnlPerfil.setBackground(obtenerColor(p.getColor()));
				
				JLabel lblNombre = new JLabel(p.getNombre());
				lblNombre.setForeground(Color.WHITE);
				lblNombre.setFont(new Font("Calibri", Font.BOLD, 14));
				lblNombre.setHorizontalAlignment(SwingConstants.CENTER);

				JButton btnSeleccion = new JButton("Seleccionar");
				botonesSeleccionar.add(btnSeleccion);
				
				pnlPerfil.add(lblNombre, BorderLayout.CENTER);
				pnlPerfil.add(btnSeleccion, BorderLayout.SOUTH);
				
				pnlPerfiles.add(pnlPerfil);
			}
		}
		
		pnlPerfiles.revalidate();
		pnlPerfiles.repaint();
	}
}