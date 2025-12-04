package view;

import java.awt.CardLayout;
import javax.swing.JFrame;

public class Vista extends JFrame {
	private VentanaPrincipal ventanaMain;
	
    public Vista () {
    	setTitle("VYZYALIZE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1000);
     
        ventanaMain = new VentanaPrincipal ();
    
        add(ventanaMain);
        setVisible(true);
    }

    public VentanaPrincipal getPanelMain() {
		return ventanaMain;
	}
		
	public void cambiarCarta(String nombreCarta) {
		ventanaMain.mostrarCarta(nombreCarta);
	}
	    
	public void cambiarCarta(VentanasEnum ventana) {
		ventanaMain.mostrarCarta(ventana);
	}
}