package com.urreadiego.poo.polimorfismo;

/**
 * Automóvil: primer nivel de herencia sobre {@link Vehiculo}.
 */
public class Automovil extends Vehiculo {

    public Automovil(String marca, int anio) {
        super(marca, anio);
    }

    /** Enciende el motor del automóvil. */
    public void encenderMotor() {
        System.out.println("Motor del automóvil encendido");
    }

    @Override
    public void mover() {
        System.out.println("El automóvil se mueve");
    }
}
