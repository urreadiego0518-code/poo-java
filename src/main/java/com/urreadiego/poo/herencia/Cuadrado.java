package com.urreadiego.poo.herencia;

/**
 * Cuadrado: hereda de {@link FiguraGeometrica} e implementa su área.
 */
public class Cuadrado extends FiguraGeometrica {

    private double lado;

    public Cuadrado(double lado) {
        super();
        this.lado = lado;
    }

    public Cuadrado(double lado, String color) {
        super(color);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    /** @return la longitud de un lado */
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
