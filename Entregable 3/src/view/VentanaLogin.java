package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaLogin extends JPanel {
	private JLabel lblEmail = new JLabel("E-mail");
	private JTextField tfEmail = new JTextField(50);
	private JLabel lblPassword = new JLabel("Contrasenia");
	private JPasswordField tfPassword = new JPasswordField(50);
	private JButton btnIngresar = new JButton("Ingresar");
	private JButton btnRegistrate = new JButton("Registrarte");
	
	public VentanaLogin() {
		        setLayout(new BorderLayout());
		        
		        JLabel imagen = new JLabel(new ImageIcon("C:\\Users\\clatd\\OneDrive\\Escritorio\\Informatica\\TDL-2\\Entregable 3\\Logo Popcorn Caricatura.png"));
		        imagen.setPreferredSize(new Dimension(500, 500)); // ajustá según tu imagen
		        add(imagen, BorderLayout.WEST);
		            setLayout(new BorderLayout());

		            // Imagen decorativa a la izquierda
		            JLabel imagenDecorativa = new JLabel(new ImageIcon("assets/login_banner.png")); // ajustá la ruta
		            imagenDecorativa.setPreferredSize(new Dimension(300, 600));
		            add(imagenDecorativa, BorderLayout.WEST);

		            // Panel central con campos y botones
		            JPanel panelCentro = new JPanel(new GridBagLayout());
		            panelCentro.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // margen interno

		            GridBagConstraints gbc = new GridBagConstraints();
		            gbc.insets = new Insets(10, 10, 10, 10);
		            gbc.anchor = GridBagConstraints.WEST;
		            gbc.fill = GridBagConstraints.HORIZONTAL;

		            // Email
		            gbc.gridx = 0; gbc.gridy = 0;
		            panelCentro.add(lblEmail, gbc);

		            gbc.gridx = 1;
		            panelCentro.add(tfEmail, gbc);

		            // Contraseña
		            gbc.gridx = 0; gbc.gridy = 1;
		            panelCentro.add(lblPassword, gbc);

		            gbc.gridx = 1;
		            panelCentro.add(tfPassword, gbc);

		         // Panel para los botones
		            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		            btnIngresar.setPreferredSize(new Dimension(120, 30));
		            btnRegistrate.setPreferredSize(new Dimension(120, 30));

		            // Agregar ambos botones al panel
		            panelBotones.add(btnIngresar);
		            panelBotones.add(btnRegistrate);

		            // Agregar el panel de botones al panel principal
		            gbc.gridx = 0;
		            gbc.gridy = 2;
		            gbc.gridwidth = 2;
		            gbc.anchor = GridBagConstraints.CENTER;
		            panelCentro.add(panelBotones, gbc);

		            add(panelCentro, BorderLayout.CENTER);
		    }

	public void addIngresarListener(ActionListener l) {
		btnIngresar.addActionListener(l);
	}
	
	public void addRegistrateListener(ActionListener l) {
		btnRegistrate.addActionListener(l);
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
		return btnRegistrate;
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
