package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaNuevoPerfil extends JPanel {
    private JLabel lblNombre = new JLabel("Nombre perfil");
    private JTextField tfNombre = new JTextField(50);
    private JLabel lblColores = new JLabel("Color");
    String[] colores = {"Rojo", "Verde", "Azul"};
    private JComboBox<String> color = new JComboBox<>(colores);
    private JButton btnCrearPerfil = new JButton("Crear perfil");
    private JButton btnVolver;
    private JPanel panelColor = new JPanel(new BorderLayout());
    private JLabel lblColorNombre = new JLabel("Ejemplo", SwingConstants.CENTER);

    public VentanaNuevoPerfil() {
        setLayout(new BorderLayout());

        btnVolver = new JButton("Volver");
        
        JPanel pnlSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlSuperior.add(btnVolver);        
        add(pnlSuperior, BorderLayout.NORTH);
        
        panelColor.setPreferredSize(new Dimension(350, 950));
        panelColor.setBackground(Color.RED);
        lblColorNombre.setFont(new Font("Calibri", Font.BOLD, 24));
        lblColorNombre.setForeground(Color.WHITE);
        panelColor.add(lblColorNombre, BorderLayout.CENTER);
        add(panelColor, BorderLayout.WEST);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));

        lblNombre.setFont(new Font("Calibri", Font.BOLD, 18));
        
        tfNombre.setPreferredSize(new Dimension(300, 35));

        lblColores.setFont(new Font("Calibri", Font.BOLD, 18));
        color.setFont(new Font("Calibri", Font.PLAIN, 16));
        color.setPreferredSize(new Dimension(300, 35));

        btnCrearPerfil.setPreferredSize(new Dimension(150, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 10, 20, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        panelCentral.add(lblNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panelCentral.add(tfNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelCentral.add(lblColores, gbc);
        gbc.gridx = 1;
        panelCentral.add(color, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(btnCrearPerfil, gbc);

        add(panelCentral, BorderLayout.CENTER);

        color.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		actualizarColor();
        	}
        });
        
        actualizarColor();
        
        tfNombre.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { actualizarColor(); }
            public void removeUpdate(DocumentEvent e) { actualizarColor(); }
            public void changedUpdate(DocumentEvent e) { actualizarColor(); }
        });
    }

    private void actualizarColor() {
        String nombre = tfNombre.getText().trim();
        lblColorNombre.setText(nombre.isEmpty() ? "Ejemplo" : nombre);

        String colorSeleccionado = (String) color.getSelectedItem();
        switch (colorSeleccionado) {
            case "Rojo":  panelColor.setBackground(Color.RED); break;
            case "Verde": panelColor.setBackground(Color.GREEN); break;
            case "Azul":  panelColor.setBackground(Color.BLUE); break;
        }
        panelColor.repaint();
    }

    public void addVolverListener(ActionListener l) {
    	btnVolver.addActionListener(l);
    }
    
    public void removerListenersVolver() {
    	for (ActionListener l : btnVolver.getActionListeners()) {
    		btnVolver.removeActionListener(l);
    	}
    }
    
    public void addColorListener(ActionListener l) {
    	color.addActionListener(l);
    }
    
    public void addCrearPerfilListener(ActionListener l) {
        btnCrearPerfil.addActionListener(l);
    }
    
    public void removerListenersCrearPerfil() {
    	for (ActionListener l : btnCrearPerfil.getActionListeners()) {
    		btnCrearPerfil.removeActionListener(l);
    	}
    }
    
    public String getNombre() {
        return tfNombre.getText();
    }
    
    public void setNombre(String nombre) {
    	this.tfNombre.setText(nombre);
    }
    
    public String getColorSeleccionado() {
    	return (String) color.getSelectedItem();
    }
    
    public JButton getBotonVolver() {
    	return btnVolver;
    }
    
    public JButton getBotonCrearPerfil() {
        return btnCrearPerfil;
    }
    
    public void mostrarMensaje(String msj) {
        JOptionPane.showMessageDialog(this, msj);
    }
    
    public void mostrarMensajeError(String msj) {
        JOptionPane.showMessageDialog(this, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
