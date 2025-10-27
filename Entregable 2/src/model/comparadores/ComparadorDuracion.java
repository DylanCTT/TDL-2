package model.comparadores;

import java.util.Comparator;

import model.Pelicula;

public class ComparadorDuracion {
	public float compare(Pelicula p1, Pelicula p2) {
		return p1.getDuracionR() - p2.getDuracionR();
	}
}
