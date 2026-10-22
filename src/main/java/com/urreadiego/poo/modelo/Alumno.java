package com.urreadiego.poo.modelo;

/**
 * Alumno con sus calificaciones y su promedio.
 */
public class Alumno {

    private String nombre;
    private double calificacionU1;
    private double calificacionU2;

    public Alumno(String nombre, double calificacionU1, double calificacionU2) {
        this.nombre = nombre;
        this.calificacionU1 = calificacionU1;
        this.calificacionU2 = calificacionU2;
    }

    /** @return el promedio de las dos unidades */
    public double promedio() {
        return (calificacionU1 + calificacionU2) / 2;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacionU1() {
        return calificacionU1;
    }

    public double getCalificacionU2() {
        return calificacionU2;
    }

    @Override
    public String toString() {
        return "Alumno{nombre='" + nombre + "', promedio=" + promedio() + "}";
    }
}
