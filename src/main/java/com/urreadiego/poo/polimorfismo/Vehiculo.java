package com.urreadiego.poo.polimorfismo;

/**
 * Clase base abstracta de los vehículos.
 */
public abstract class Vehiculo {

    private String marca;
    private int anio;

    public Vehiculo(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }

    /** Comportamiento específico de cada tipo de vehículo. */
    public abstract void mover();

    public String getMarca() {
        return marca;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{marca='" + marca + "', anio=" + anio + "}";
    }
}
