package com.urreadiego.poo.geometria;

/**
 * Versión de consola del cálculo del triángulo.
 */
public class TrianguloCMD {

    public static void main(String[] args) {
        Triangulo t = new Triangulo(3, 4);
        System.out.println("Área del triángulo: " + t.area());
        System.out.println("Perímetro del triángulo: " + t.perimetro());
    }
}
