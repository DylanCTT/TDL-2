import javax.swing.*;
import java.awt.*;

public class MeoInterface extends JFrame {

    public MeoInterface() {
        setTitle("MEO");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Panel principal con fondo blanco
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.WHITE);

                // Dibujar texto "MEO" con estilo irregular
                Graphics2D g2d = (Graphics2D) g;
                g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 48)); // Estilo informal
                g2d.setColor(Color.BLACK);
                g2d.drawString("MEO", 130, 80); // Posición aproximada
            }
        };
        panel.setLayout(null); // Layout manual para posicionar el botón

        // Botón "Inicio" dentro de un rectángulo
        JButton inicioBtn = new JButton("Inicio");
        inicioBtn.setBounds(140, 150, 120, 40); // Posición y tamaño
        inicioBtn.setFocusPainted(false);
        inicioBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(inicioBtn);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MeoInterface::new);
    }
}