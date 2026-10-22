package com.urreadiego.poo.herencia;

/**
 * Cubo: hereda de {@link Cuadrado} y añade el volumen.
 *
 * <p>Ejemplo de <b>herencia de dos niveles</b>: el cubo es un caso particular
 * de cuadrado del mismo modo que un cuadrado es un caso particular de figura.
 */
public class Cubo extends Cuadrado {

    public Cubo(double lado) {
        super(lado);
    }

    public Cubo(double lado, String color) {
        super(lado, color);
    }

    /**
     * @return el volumen del cubo
     */
    public double calcularVolumen() {
        return getLado() * getLado() * getLado();
    }
}
