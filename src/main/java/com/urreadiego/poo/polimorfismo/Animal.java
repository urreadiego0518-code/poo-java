package com.urreadiego.poo.polimorfismo;

/**
 * Clase base abstracta de los animales.
 *
 * <p>La clase declara {@link #comer()} como abstracto: cada especie define
 * su propio comportamiento. {@link #desplazarse()} es concreto y se hereda
 * tal cual.
 */
public abstract class Animal {

    private int tamaño;
    private String color;
    protected String nombre;

    public Animal(int tamaño, String color, String nombre) {
        this.tamaño = tamaño;
        this.color = color;
        this.nombre = nombre;
    }

    /** Comportamiento específico de cada especie. */
    public abstract void comer();

    /** Comportamiento común a todos los animales. */
    public void desplazarse() {
        System.out.println("Soy " + nombre + ", estoy desplazándome");
    }

    public int getTamaño() {
        return tamaño;
    }

    public String getColor() {
        return color;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{nombre='" + nombre + "'}";
    }
}
