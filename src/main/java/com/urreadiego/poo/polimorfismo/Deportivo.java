package com.urreadiego.poo.polimorfismo;

/**
 * Deportivo: hereda de {@link Automovil} y añade el modo turbo.
 */
public class Deportivo extends Automovil {

    public Deportivo(String marca, int anio) {
        super(marca, anio);
    }

    /** Activa el modo turbo. */
    public void activarModoTurbo() {
        System.out.println("Modo turbo activado en el deportivo");
    }

    @Override
    public void mover() {
        System.out.println("El deportivo se mueve a toda velocidad");
    }
}
