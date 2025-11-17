package util;

import java.awt.*;

public class pruebaGUI extends Frame {
	private Label lblContador;
	private TextField tfContador;
	private Button btnContador;
	private int Contador = 0;
	
	public pruebaGUI() {	
		setLayout(new FlowLayout());
		lblContador = new Label("Contador");
		add(lblContador);
		setTitle("Contador AWT");
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		pruebaGUI app = new pruebaGUI();
	}
}
