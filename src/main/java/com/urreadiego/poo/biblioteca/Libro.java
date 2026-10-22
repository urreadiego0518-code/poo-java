package com.urreadiego.poo.biblioteca;

/**
 * Libro del catálogo de la biblioteca.
 */
public class Libro {

    private final String titulo;
    private final String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    /** @return la línea del libro formateada */
    public String mostrarInfo() {
        return titulo + " -------------- " + autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro{titulo='" + titulo + "', autor='" + autor + "'}";
    }
}
