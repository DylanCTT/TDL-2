package service;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Pelicula;
import util.Conexion;


public class PeliculaService {
	public static List<Pelicula> cargarPeliculas(String rutaCSV) {
        List<Pelicula> lista = new ArrayList<>();

        try (FileReader fr = new FileReader(rutaCSV);
             Connection conn = Conexion.getConnection()) {

            StringBuilder linea = new StringBuilder();
            int c;
            boolean primera = true;

            while ((c = fr.read()) != -1) {
                if ((char) c == '\n') {
                    if (primera) {
                        primera = false; // saltar encabezado
                    } else {
                        Pelicula p = leerLinea(linea.toString());
                        lista.add(p);
                        insertarEnBD(conn, p);
                    }
                    linea.setLength(0);
                } else {
                    linea.append((char) c);
                }
            }
            // última línea si no termina en salto
            if (linea.length() > 0) {
                Pelicula p = leerLinea(linea.toString());
                lista.add(p);
                insertarEnBD(conn, p);
            }

        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

    private static Pelicula leerLinea(String linea) {
        // acá parseás la línea CSV en campos
        // ejemplo simplificado (usar parser robusto si hay comillas)
        String[] campos = linea.split(",", -1);

        Pelicula p = new Pelicula();
        p.setTitulo(campos[1]);
        p.setGenero(campos[7]);  //a chequear
        p.setSinopsis(campos[2]);
        p.setDirector("N/A"); 
        p.setDuracionR(0);    
        p.setReleaseDate(campos[0]);
        p.setPopularity(Double.parseDouble(campos[3]));
        p.setVoteCount(Integer.parseInt(campos[4]));
        p.setVoteAverage(Double.parseDouble(campos[5]));
        p.setOriginalLanguage(campos[6]);
        p.setPoster(campos[8]);
        p.setStatus(campos[9]);
        p.setUrl(campos[10]);

        return p;
    }

    private static void insertarEnBD(Connection conn, Pelicula p) throws SQLException {
        String sql = "INSERT INTO PELICULA (" +
                     "GENERO, TITULO, RESUMEN, DIRECTOR, DURACION, " +
                     "RELEASE_DATE, POPULARITY, VOTE_COUNT, VOTE_AVERAGE, " +
                     "ORIGINAL_LANGUAGE, POSTER, STATUS, URL) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getGenero()); //a chequear
            ps.setString(2, p.getTitulo());
            ps.setString(3, p.getSinopsis());
            ps.setString(4, p.getDirector());
            ps.setFloat(5, p.getDuracionR());
            ps.setString(6, p.getReleaseDate());
            ps.setDouble(7, p.getPopularity());
            ps.setInt(8, p.getVoteCount());
            ps.setDouble(9, p.getVoteAverage());
            ps.setString(10, p.getOriginalLanguage());
            ps.setString(11, p.getPoster());
            ps.setString(12, p.getStatus());
            ps.setString(13, p.getUrl());

            ps.executeUpdate();
        }
    }
}
