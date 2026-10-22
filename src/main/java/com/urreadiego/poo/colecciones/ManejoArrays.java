package com.urreadiego.poo.colecciones;

import java.util.ArrayList;
import java.util.List;

/**
 * Demostración del manejo de arreglos y de {@link ArrayList}.
 */
public class ManejoArrays {

    public static void main(String[] args) {
        String[] nombres = {"Ana", "Luis", "Sofía"};
        System.out.println("Arreglo: " + String.join(", ", nombres));

        List<String> lista = new ArrayList<>();
        lista.add("Ana");
        lista.add("Luis");
        lista.add("Sofía");
        lista.add(2, "Carmen");

        System.out.println("Lista: " + lista);
        System.out.println("La lista tiene: " + lista.size() + " elementos");

        lista.remove(0);
        System.out.println("Tras quitar el índice 0: " + lista);
        System.out.println("La lista tiene: " + lista.size() + " elementos");
    }
}
