package model.comparadores;

import java.util.Comparator;

import model.Pelicula;

public class ComparadorDuracion implements Comparator<Pelicula> {
	public int compare(Pelicula p1, Pelicula p2) {
		return Float.compare(p1.getDuracionR(), p2.getDuracionR());
	}
}
