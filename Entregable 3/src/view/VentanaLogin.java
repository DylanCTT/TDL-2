package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaLogin extends JPanel {
    private JLabel lblEmail = new JLabel("E-mail: ");
    private JTextField tfEmail = new JTextField(20);
    private JLabel lblPassword = new JLabel("Contrasenia: ");
    private JPasswordField tfPassword = new JPasswordField(20);
    private JButton btnIngresar = new JButton("Ingresar");
    private JButton btnRegistrarte = new JButton("Registrarte");

        public VentanaLogin() {
            setLayout(new BorderLayout());

            // Imagen a la izquierda
            JLabel imagen = new JLabel(new ImageIcon("src/resources/Logo Popcorn Caticatura.png"));
            imagen.setPreferredSize(new Dimension(500, 500)); 
            add(imagen, BorderLayout.WEST);

            // anel central con campos
            JPanel panelCentro = new JPanel();
            panelCentro.setLayout(new GridBagLayout());
            panelCentro.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // margen interno

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // espacio entre componentes
            gbc.anchor = GridBagConstraints.WEST;   // alinear a la izquierda
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0; gbc.gridy = 0;
            panelCentro.add(lblEmail, gbc);

            gbc.gridx = 1;
            panelCentro.add(tfEmail, gbc);

            gbc.gridx = 0; gbc.gridy = 1;
            panelCentro.add(lblPassword, gbc);

            gbc.gridx = 1;
            panelCentro.add(tfPassword, gbc);

            gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;

            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

            btnIngresar.setPreferredSize(new Dimension(120, 30));
            btnRegistrarte.setPreferredSize(new Dimension(120, 30));

            panelBotones.add(btnIngresar);
            panelBotones.add(btnRegistrarte);
            panelCentro.add(panelBotones, gbc);

            add(panelCentro, BorderLayout.CENTER);
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

	public String getPassword() {
		return String.valueOf(tfPassword.getPassword());
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