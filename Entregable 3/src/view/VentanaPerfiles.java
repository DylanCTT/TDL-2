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

			JButton btnSeleccion = new JButton("Seleccionar");
			botonesSeleccionar.add(btnSeleccion);
			
			pnlPerfil.add(lblNombre, BorderLayout.CENTER);
			pnlPerfil.add(btnSeleccion, BorderLayout.SOUTH);
			
			pnlPerfiles.add(pnlPerfil);
		}
		
		add(pnlPerfiles, BorderLayout.CENTER);

		setVisible(true);
	}
	
	public void addSeleccionarListener(ActionListener l) {
		for (JButton b : botonesSeleccionar) {
			b.addActionListener(l);
		}
	}
	
	public List<JButton> getBotonesSeleccionar() {
		return botonesSeleccionar;
	}
	
	public void mostrarMensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}
}