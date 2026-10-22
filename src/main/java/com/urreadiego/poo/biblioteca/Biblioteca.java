package com.urreadiego.poo.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Catálogo de libros.
 */
public class Biblioteca {

    private final List<Libro> libros = new ArrayList<>();

    /**
     * @param libro libro a registrar en el catálogo
     * @return {@code true} si se agregó
     */
    public boolean agregarLibro(Libro libro) {
        return libros.add(libro);
    }

    /** @return el número de libros registrados */
    public int getTotalLibros() {
        return libros.size();
    }

    /** @return los libros registrados */
    public List<Libro> getLibros() {
        return new ArrayList<>(libros);
    }

    /**
     * Busca un libro por título (sin distinguir mayúsculas).
     *
     * @param titulo título buscado
     * @return el libro encontrado o {@code null}
     */
    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    /** @return el catálogo completo listo para mostrar */
    public String mostrarLibrosDisponibles() {
        StringBuilder sb = new StringBuilder();
        for (Libro libro : libros) {
            sb.append(libro.mostrarInfo()).append('\n');
        }
        sb.append("total de libros: ").append(libros.size());
        return sb.toString();
    }
}
