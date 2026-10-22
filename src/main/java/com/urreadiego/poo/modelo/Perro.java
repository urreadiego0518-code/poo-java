package com.urreadiego.poo.modelo;

/**
 * Perro: modelo simple de un animal con nombre, edad y raza.
 */
public class Perro {

    private final String nombre;
    private final int edad;
    private final String raza;

    public Perro(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    /** El perro ladra. */
    public void ladrar() {
        System.out.println("yo soy " + nombre + ", voy a ladrar");
        System.out.println("guau......guau.....grrr");
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getRaza() {
        return raza;
    }

    @Override
    public String toString() {
        return "Perro{nombre='" + nombre + "', edad=" + edad + ", raza='" + raza + "'}";
    }
}
