package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class VentanaLogin extends JPanel {
    private JLabel lblEmail = new JLabel("E-mail: ");
    private JTextField tfEmail = new JTextField();
    private JLabel lblPassword = new JLabel("Contrasenia: ");
    private JPasswordField tfPassword = new JPasswordField();
    private JButton btnIngresar = new JButton("Ingresar");
    private JButton btnRegistrarte = new JButton("Registrarse");

    private Color colorFondo = Color.WHITE;
    private Color colorBoton = Color.BLUE;
    private Color colorTextoBoton = Color.WHITE;
    private Font fuentePrincipal = new Font("Arial", Font.BOLD, 14);
    private Font fuenteCampos = new Font("Calibri", Font.PLAIN, 14);   		
    
    public VentanaLogin() {
    	setLayout(new BorderLayout());
    	setBackground(colorFondo);

    	JPanel pnlImagen = new JPanel(new BorderLayout());
    	pnlImagen.setBackground(new Color(245, 245, 245));
    	pnlImagen.setPreferredSize(new Dimension(350, 0));
    	
    	ImageIcon imagen = new ImageIcon("src/resources/Logo Popcorn Caricatura.png");
    	Image imagenEscalada = imagen.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
    	JLabel lblImagen = new JLabel(new ImageIcon(imagenEscalada));
    	lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	pnlImagen.add(lblImagen, BorderLayout.CENTER);
    	add(pnlImagen, BorderLayout.WEST);

    	JPanel pnlCentro = new JPanel(new GridBagLayout());
    	pnlCentro.setBackground(colorFondo);
        pnlCentro.setBorder(new EmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;  
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        lblEmail.setFont(fuentePrincipal);
        lblPassword.setFont(fuentePrincipal);
        
        tfEmail.setFont(fuenteCampos);
        tfEmail.setPreferredSize(new Dimension(200, 30));
        
        tfPassword.setFont(fuenteCampos);
        tfPassword.setPreferredSize(new Dimension(200, 30));
        
        JLabel lblTitulo = new JLabel("Iniciar Sesión");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        pnlCentro.add(lblTitulo, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        pnlCentro.add(lblEmail, gbc);

        gbc.gridx = 1; 
        gbc.weightx = 1.0;
        pnlCentro.add(tfEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        pnlCentro.add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        pnlCentro.add(tfPassword, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.setBackground(colorFondo);
        panelBotones.setBorder(new EmptyBorder(20, 0, 0, 0));

        btnIngresar.setFont(fuentePrincipal);
        btnIngresar.setBackground(colorBoton);
        btnIngresar.setForeground(colorTextoBoton);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnRegistrarte.setFont(fuentePrincipal);
        btnRegistrarte.setBackground(Color.WHITE);
        btnRegistrarte.setForeground(colorBoton);
        btnRegistrarte.setBorder(BorderFactory.createLineBorder(colorBoton, 1));
        btnRegistrarte.setFocusPainted(false);
        btnRegistrarte.setPreferredSize(new Dimension(120, 40));
        btnRegistrarte.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelBotones.add(btnIngresar);
        panelBotones.add(btnRegistrarte);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        pnlCentro.add(panelBotones, gbc);

        add(pnlCentro, BorderLayout.CENTER);
    }

	public void addIngresarListener(ActionListener l) {
		btnIngresar.addActionListener(l);
	}
	
	public void addRegistrateListener(ActionListener l) {
		btnRegistrarte.addActionListener(l);
	}
	
	public String getEmail() {
		return tfEmail.getText();
	}
	
	public void setEmail(String email) {
		this.tfEmail.setText(email);
	}

	public String getPassword() {
		return String.valueOf(tfPassword.getPassword());
	}
	
	public void setPassword(String password) {
	 this.tfPassword.setText(password);
	}

	public JButton getBotonIngresar() {
		return btnIngresar;
	}

	public JButton getBotonRegistrate() {
		return btnRegistrarte;
	}
	
	public void mostrarMensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}
	
	public void mostrarMensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new VentanaLogin());
	}
}