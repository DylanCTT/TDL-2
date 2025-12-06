package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaNuevoPerfil extends JPanel {
    private JLabel lblNombre = new JLabel("Nombre del perfil: ");
    private JTextField tfNombre = new JTextField();
    private JLabel lblColores = new JLabel("Color de foto de peril");
    String[] colores = {"Rojo", "Verde", "Azul"};
    private JComboBox<String> cmbColor = new JComboBox<>(colores);
    private JButton btnCrearPerfil = new JButton("Crear perfil");
    private JButton btnVolver = new JButton("← Volver");
    private JPanel panelColor = new JPanel(new GridBagLayout());
    private JLabel lblColorNombre = new JLabel("Ejemplo");
    
    private Color colorFondo = Color.WHITE;
    private Color colorBoton = Color.BLUE;
    private Color colorTextoBoton = Color.WHITE;
    private Font fuentePrincipal = new Font("Arial", Font.BOLD, 14);
    private Font fuenteCampos = new Font("Arial", Font.PLAIN, 14); 
    private Font fuenteTitulo = new Font("Arial", Font.BOLD, 24);
    
    public VentanaNuevoPerfil() {
        setLayout(new BorderLayout());
        setBackground(colorFondo);

        panelColor.setPreferredSize(new Dimension(350, 0));
        panelColor.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(230,230,230)));
        
        lblColorNombre.setFont(new Font("Arial", Font.BOLD, 28));
        lblColorNombre.setForeground(Color.WHITE);
        panelColor.add(lblColorNombre);
        
        add(panelColor, BorderLayout.WEST);
        
        JPanel pnlCentro = new JPanel(new GridBagLayout());
        pnlCentro.setBackground(colorFondo);
        pnlCentro.setBorder(new EmptyBorder(20, 40, 20, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 12));
        btnVolver.setForeground(Color.GRAY);
        btnVolver.setBackground(colorFondo);
        btnVolver.setBorder(null);
        btnVolver.setFocusPainted(false);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        pnlCentro.add(btnVolver, gbc);
        
        JLabel lblTitulo = new JLabel("Nuevo Perfil");
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 30, 0);
        pnlCentro.add(lblTitulo, gbc);
        
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        lblNombre.setFont(fuentePrincipal);
        tfNombre.setFont(fuenteCampos);
        tfNombre.setPreferredSize(new Dimension(250, 35));
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        pnlCentro.add(lblNombre, gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        pnlCentro.add(tfNombre, gbc);
        
        lblColores.setFont(fuentePrincipal);
        cmbColor.setFont(fuenteCampos);
        cmbColor.setPreferredSize(new Dimension(250, 35));
        cmbColor.setBackground(Color.WHITE);

        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        pnlCentro.add(lblColores, gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        pnlCentro.add(cmbColor, gbc);
        
        btnCrearPerfil.setFont(fuentePrincipal);
        btnCrearPerfil.setBackground(colorBoton);
        btnCrearPerfil.setForeground(colorTextoBoton);
        btnCrearPerfil.setFocusPainted(false);
        btnCrearPerfil.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 0));
        btnCrearPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.insets = new Insets(40, 20, 0, 20);
        pnlCentro.add(btnCrearPerfil, gbc);

        add(pnlCentro, BorderLayout.CENTER);
                      
        cmbColor.addActionListener(new ActionListener() {
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
        if (nombre.length() > 10) {
            nombre = nombre.substring(0, 10) + "...";
        }
        lblColorNombre.setText(nombre.isEmpty() ? "Ejemplo" : nombre);

        String colorSeleccionado = (String) cmbColor.getSelectedItem();
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
    	cmbColor.addActionListener(l);
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
    	return (String) cmbColor.getSelectedItem();
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
