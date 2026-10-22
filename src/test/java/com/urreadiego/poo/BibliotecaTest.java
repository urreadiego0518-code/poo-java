package com.urreadiego.poo;

import com.urreadiego.poo.biblioteca.Biblioteca;
import com.urreadiego.poo.biblioteca.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Biblioteca: catálogo de libros")
class BibliotecaTest {

    private Biblioteca biblioteca;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    @DisplayName("registra libros y cuenta el total")
    void registraLibros() {
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "García Márquez"));
        biblioteca.agregarLibro(new Libro("Ficciones", "Borges"));

        assertEquals(2, biblioteca.getTotalLibros());
    }

    @Test
    @DisplayName("busca por título sin distinguir mayúsculas")
    void buscaPorTitulo() {
        biblioteca.agregarLibro(new Libro("El principito", "Saint-Exupéry"));

        assertNotNull(biblioteca.buscarPorTitulo("el principito"));
        assertNull(biblioteca.buscarPorTitulo("libro inexistente"));
    }

    @Test
    @DisplayName("el catálogo muestra el total de libros")
    void muestraCatalogo() {
        biblioteca.agregarLibro(new Libro("Dune", "Herbert"));

        String catalogo = biblioteca.mostrarLibrosDisponibles();

        assertEquals(true, catalogo.contains("Dune"));
        assertEquals(true, catalogo.contains("total de libros: 1"));
    }
}
