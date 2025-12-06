package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistro extends JPanel {

    private JLabel lblNombres = new JLabel("Nombres: ");
    private JTextField tfNombres = new JTextField();
    private JLabel lblApellidos = new JLabel("Apellidos: ");
    private JTextField tfApellidos = new JTextField();
    private JLabel lblDni = new JLabel("DNI: ");
    private JTextField tfDni = new JTextField();
    private JLabel lblEmail = new JLabel("Email: ");
    private JTextField tfEmail = new JTextField();
    private JLabel lblPassword = new JLabel("Contraseña: ");
    private JPasswordField tfPassword = new JPasswordField();
    private JButton btnRegistrar = new JButton("Registrarse");
    private JButton btnRetroceso = new JButton("← Volver");

    private Color colorFondo = Color.WHITE;
    private Color colorBoton = Color.BLUE;
    private Color colorTextoBoton = Color.WHITE;
    private Font fuentePrincipal = new Font("Arial", Font.BOLD, 14);
    private Font fuenteCampos = new Font("Arial", Font.PLAIN, 14); 
    
    public VentanaRegistro() {
        setLayout(new BorderLayout());
        setBackground(colorFondo);     

        JPanel pnlCentro = new JPanel(new GridBagLayout());
        pnlCentro.setBackground(colorFondo);
        pnlCentro.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        btnRetroceso.setFont(new Font("Arial", Font.PLAIN, 12));
        btnRetroceso.setForeground(Color.GRAY);
        btnRetroceso.setBackground(colorFondo);
        btnRetroceso.setBorder(null);
        btnRetroceso.setFocusPainted(false);
        btnRetroceso.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRetroceso.setHorizontalAlignment(SwingConstants.LEFT);
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 10, 20, 10);
        pnlCentro.add(btnRetroceso, gbc);
        
        tfNombres.setFont(fuenteCampos);
        tfNombres.setPreferredSize(new Dimension(250, 35));
        tfApellidos.setFont(fuenteCampos);
        tfApellidos.setPreferredSize(new Dimension(250, 35));
        tfDni.setFont(fuenteCampos);
        tfDni.setPreferredSize(new Dimension(250, 35));
        tfEmail.setFont(fuenteCampos);
        tfEmail.setPreferredSize(new Dimension(250, 35));
        tfPassword.setFont(fuenteCampos);
        tfPassword.setPreferredSize(new Dimension(250, 35));
        
        lblNombres.setFont(fuentePrincipal);
        lblApellidos.setFont(fuentePrincipal);
        lblDni.setFont(fuentePrincipal);
        lblEmail.setFont(fuentePrincipal);
        lblPassword.setFont(fuentePrincipal);
        
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        agregarFila(pnlCentro, lblNombres, tfNombres, gbc, 1);
        agregarFila(pnlCentro, lblApellidos, tfApellidos, gbc, 2);
        agregarFila(pnlCentro, lblDni, tfDni, gbc, 3);
        agregarFila(pnlCentro, lblEmail, tfEmail, gbc, 4);
        agregarFila(pnlCentro, lblPassword, tfPassword, gbc, 5);
        
        btnRegistrar.setFont(fuentePrincipal);
        btnRegistrar.setBackground(colorBoton);
        btnRegistrar.setForeground(colorTextoBoton);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding vertical
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegistrar.setPreferredSize(new Dimension(150, 45));
        
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 20, 0, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        pnlCentro.add(btnRegistrar, gbc);            

        add(pnlCentro, BorderLayout.CENTER);
    }

    private void agregarFila(JPanel pnl, JLabel lbl, JComponent campo, GridBagConstraints gbc, int fila) {
        gbc.gridy = fila;
        
        gbc.gridx = 0; 
        gbc.weightx = 0;
        pnl.add(lbl, gbc);
        
        gbc.gridx = 1; 
        gbc.weightx = 1.0;
        pnl.add(campo, gbc);
    }
	
	public void addRegistrarListener(ActionListener l) {
		btnRegistrar.addActionListener(l);
	}
	
	public String getNombres() {
		return tfNombres.getText();
	}
	
	public String getApellidos() {
		return tfApellidos.getText();
	}
	
	public int getDni() {
		return Integer.parseInt(tfDni.getText());
	}
	
	public String getEmail() {
		return tfEmail.getText();
	}
	
	public String getPassword() {
		return String.valueOf(tfPassword.getPassword());
	}
	
	public JButton getBotonRegistro() {
		return btnRegistrar;
	}
	
	public JButton getBotonRetroceso() {
        return btnRetroceso;
    }
	
	public void mostrarMensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}
	
	public void mostarMensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}	
}
