package com.urreadiego.poo;

import com.urreadiego.poo.colecciones.MiArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("MiArrayList: colección propia con capacidad máxima")
class MiArrayListTest {

    @Test
    @DisplayName("agrega elementos mientras haya espacio")
    void agregaElementosDentroDelLimite() {
        MiArrayList<String> lista = new MiArrayList<>(3);

        assertTrue(lista.add("uno"));
        assertTrue(lista.add("dos"));
        assertTrue(lista.add("tres"));

        assertEquals(3, lista.size());
        assertEquals("dos", lista.get(1));
        assertTrue(lista.estaLlena());
    }

    @Test
    @DisplayName("rechaza el elemento que excede la capacidad")
    void rechazaElementoCuandoEstaLlena() {
        MiArrayList<String> lista = new MiArrayList<>(2);
        lista.add("uno");
        lista.add("dos");

        assertFalse(lista.add("tres"), "no debe aceptar un tercer elemento");
        assertEquals(2, lista.size());
        assertEquals(0, lista.getEspaciosDisponibles(), "la lista está llena");
    }

    @Test
    @DisplayName("el límite puede cambiarse en tiempo de ejecución")
    void cambiaElLimite() {
        MiArrayList<Integer> lista = new MiArrayList<>(1);
        lista.add(1);

        lista.setNuevoLimite(3);

        assertEquals(3, lista.getMaxSize());
        assertTrue(lista.add(2));
        assertTrue(lista.add(3));
        assertEquals(3, lista.size());
    }

    @Test
    @DisplayName("no acepta un tamaño máximo negativo")
    void rechazaTamanoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new MiArrayList<String>(-1));
    }
}
