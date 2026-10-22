package com.urreadiego.poo.polimorfismo;

/**
 * Vaca: implementa el comportamiento de {@link #comer()} propio de su especie.
 */
public class Vaca extends Animal {

    public Vaca(int tamaño, String color, String nombre) {
        super(tamaño, color, nombre);
    }

    /** Comportamiento específico de la vaca. */
    public void mugir() {
        System.out.println("Soy " + getNombre() + ", estoy mugiendo");
    }

    /** Sobrescribe el comportamiento heredado. */
    @Override
    public void comer() {
        System.out.println("Soy " + getNombre() + ", estoy comiendo como VACA");
    }
}
