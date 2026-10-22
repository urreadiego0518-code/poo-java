package com.urreadiego.poo.modelo;

/**
 * Ejemplo de uso de {@link Alumno}.
 */
public class AlumnoMain {

    public static void main(String[] args) {
        Alumno a1 = new Alumno("Diego", 9.5, 9.6);
        System.out.println("Alumno: " + a1.getNombre());
        System.out.println("Promedio Alumno 1: " + a1.promedio());
    }
}
