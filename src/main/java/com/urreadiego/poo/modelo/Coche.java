package com.urreadiego.poo.modelo;

/**
 * Coche con su marca, año de fabricación y color.
 */
public class Coche {

    private final String marca;
    private final int anio;
    private final String color;

    public Coche(String marca, int anio, String color) {
        this.marca = marca;
        this.anio = anio;
        this.color = color;
    }

    /** El coche arranca. */
    public void arrancar() {
        System.out.println("el coche está arrancando.... ¡Vrooooom!");
    }

    /** @return los datos del coche en varias líneas */
    public String detallesCoche() {
        return "Marca: " + marca + ".\n"
                + "Año de fabricación: " + anio + ".\n"
                + "Color del coche: " + color + ".";
    }

    public String getMarca() {
        return marca;
    }

    public int getAnio() {
        return anio;
    }

    public String getColor() {
        return color;
    }
}
