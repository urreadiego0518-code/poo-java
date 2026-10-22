package com.urreadiego.poo.geometria;

/**
 * Triángulo isósceles definido por su base y su altura.
 */
public class Triangulo {

    private double base;
    private double altura;

    /**
     * @param base   longitud de la base
     * @param altura altura del triángulo
     * @throws IllegalArgumentException si alguna medida es negativa
     */
    public Triangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    /** @return el área del triángulo */
    public double area() {
        return base * altura / 2;
    }

    /** @return el perímetro del triángulo */
    public double perimetro() {
        double ladoIgual = Math.sqrt(Math.pow(base / 2, 2) + Math.pow(altura, 2));
        return base + 2 * ladoIgual;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if (base < 0) {
            throw new IllegalArgumentException("La base no puede ser negativa");
        }
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura < 0) {
            throw new IllegalArgumentException("La altura no puede ser negativa");
        }
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Triangulo{base=" + base + ", altura=" + altura + ", area=" + area() + "}";
    }
}
