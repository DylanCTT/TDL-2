package view;

import javax.swing.*;
import java.awt.*;

public class VentanaCalificarPelicula extends JFrame {
    private JLabel[] estrellas = new JLabel[5];
    private int puntuacionSeleccionada = 0;
    private JTextArea campoComentario = new JTextArea(5, 30);
    private JButton botonGuardar = new JButton("Guardar");

    public VentanaCalificarPelicula() {
        setTitle("Calificar Película");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        JLabel titulo = new JLabel("Título de la Película", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        // Panel de estrellas
        JPanel panelEstrellas = new JPanel();
        for (int i = 0; i < estrellas.length; i++) {
            estrellas[i] = new JLabel("☆");
            estrellas[i].setFont(new Font("Arial", Font.PLAIN, 30));
            estrellas[i].setForeground(Color.BLUE);
            panelEstrellas.add(estrellas[i]);
        }
        add(panelEstrellas, BorderLayout.CENTER);

        
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        panelInferior.add(new JLabel("Comentario:"), BorderLayout.NORTH);
        panelInferior.add(new JScrollPane(campoComentario), BorderLayout.CENTER);
        panelInferior.add(botonGuardar, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);
        setVisible(true);
    }

    
    public JLabel[] getEstrellas() {
        return estrellas;
    }

    public int getPuntuacionSeleccionada() {
        return puntuacionSeleccionada;
    }

    public void setPuntuacionSeleccionada(int puntuacion) {
        this.puntuacionSeleccionada = puntuacion;
    }

    public JTextArea getCampoComentario() {
        return campoComentario;
    }

    public JButton getBotonGuardar() {
        return botonGuardar;
    }
}
