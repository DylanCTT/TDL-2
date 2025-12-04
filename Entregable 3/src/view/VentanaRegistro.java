package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistro extends JPanel {

    private JLabel lblNombres = new JLabel("Nombres");
    private JTextField tfNombres = new JTextField(10);
    private JLabel lblApellidos = new JLabel("Apellidos");
    private JTextField tfApellidos = new JTextField(10);
    private JLabel lblDni = new JLabel("DNI");
    private JTextField tfDni = new JTextField(10);
    private JLabel lblEmail = new JLabel("Email");
    private JTextField tfEmail = new JTextField(10);
    private JLabel lblPassword = new JLabel("Contrasenia");
    private JPasswordField tfPassword = new JPasswordField(10);
    private JButton btnRegistrar = new JButton("Registrarse");

    public VentanaRegistro() {
        setLayout(new BorderLayout());

        // Imagen decorativa a la izquierda
        JLabel imagen = new JLabel(new ImageIcon("ruta/a/tu/imagen.png")); // ajustá la ruta
        imagen.setPreferredSize(new Dimension(300, 600));
        imagen.setHorizontalAlignment(SwingConstants.CENTER);
        imagen.setVerticalAlignment(SwingConstants.CENTER);
        add(imagen, BorderLayout.WEST);

        // Estilos
        Font fuenteLabel = new Font("Calibri", Font.BOLD, 18);
        Font fuenteCampo = new Font("Calibri", Font.PLAIN, 16);
        Font fuenteBoton = new Font("Calibri", Font.BOLD, 16);

        lblNombres.setFont(fuenteLabel);
        tfNombres.setFont(fuenteCampo);
        tfNombres.setPreferredSize(new Dimension(300, 35));

        lblApellidos.setFont(fuenteLabel);
        tfApellidos.setFont(fuenteCampo);
        tfApellidos.setPreferredSize(new Dimension(300, 35));

        lblDni.setFont(fuenteLabel);
        tfDni.setFont(fuenteCampo);
        tfDni.setPreferredSize(new Dimension(300, 35));

        lblEmail.setFont(fuenteLabel);
        tfEmail.setFont(fuenteCampo);
        tfEmail.setPreferredSize(new Dimension(300, 35));

        lblPassword.setFont(fuenteLabel);
        tfPassword.setFont(fuenteCampo);
        tfPassword.setPreferredSize(new Dimension(300, 35));

        btnRegistrar.setPreferredSize(new Dimension(120, 30));

        // Panel central con campos
        JPanel panelCentro = new JPanel(new GridBagLayout());
        panelCentro.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        // Fila 0: Nombres
        gbc.gridx = 0; gbc.gridy = 0;
        panelCentro.add(lblNombres, gbc);
        gbc.gridx = 1;
        panelCentro.add(tfNombres, gbc);

        // Fila 1: Apellidos
        gbc.gridx = 0; gbc.gridy = 1;
        panelCentro.add(lblApellidos, gbc);
        gbc.gridx = 1;
        panelCentro.add(tfApellidos, gbc);

        // Fila 2: DNI
        gbc.gridx = 0; gbc.gridy = 2;
        panelCentro.add(lblDni, gbc);
        gbc.gridx = 1;
        panelCentro.add(tfDni, gbc);

        // Fila 3: Email
        gbc.gridx = 0; gbc.gridy = 3;
        panelCentro.add(lblEmail, gbc);
        gbc.gridx = 1;
        panelCentro.add(tfEmail, gbc);

        // Fila 4: Contraseña
        gbc.gridx = 0; gbc.gridy = 4;
        panelCentro.add(lblPassword, gbc);
        gbc.gridx = 1;
        panelCentro.add(tfPassword, gbc);

        // Fila 5: Botón de registro
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentro.add(btnRegistrar, gbc);

        add(panelCentro, BorderLayout.CENTER);
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
	
	public void mostrarMensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj);
	}
	
	public void mostarMensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String args[]) {
		VentanaRegistro vr = new VentanaRegistro();
	}
}
