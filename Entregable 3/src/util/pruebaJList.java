package util;

import java.awt.*;
import javax.swing.*;

public class pruebaJList extends JFrame {
	JList lista;
	JButton imprimir;
	
	public void init() {
		String [] items = {"Mercurio", "Venus", "Tierra", "Marte"};
		lista = new JList(items);
		lista.setVisibleRowCount(4);
		imprimir = new JButton("Imprimir Seleccion");
		this.setLayout(new FlowLayout());
		this.add(new JScrollPane(lista));
		this.add(imprimir);
	}
	
	public static void main(String args[]) {
		pruebaJList planetas = new pruebaJList();
		planetas.init();
		planetas.setVisible(true);
	}
}
