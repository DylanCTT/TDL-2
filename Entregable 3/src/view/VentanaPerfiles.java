package view;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Perfil;

public class VentanaPerfiles extends JFrame {
	private JLabel lblTitulo = new JLabel("Quien esta viendo ahora?");
	private JPanel pnlPerfiles = new JPanel(new GridLayout(0, 3, 10, 10));
	private List<JButton> botonesSeleccionar = new ArrayList<>();
	private JButton btnAgregarPerfil = new JButton("Agregar perfil");
	
	public VentanaPerfiles(ArrayList<Perfil> perfiles) {
		setTitle("Seleccion de perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); //centra en el centro je
		add(lblTitulo, BorderLayout.NORTH);
		
		for (Perfil p : perfiles) {
			JPanel pnlPerfil = new JPanel(new BorderLayout());
			pnlPerfil.setBackground(Color.GREEN);
			
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
		
		add(pnlPerfiles, BorderLayout.CENTER);
		
		add(btnAgregarPerfil, BorderLayout.SOUTH);

		setVisible(true);
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