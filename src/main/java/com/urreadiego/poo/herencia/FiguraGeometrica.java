package com.urreadiego.poo.herencia;

/**
 * Clase base abstracta para las figuras geométricas.
 *
 * <p>Demuestra <b>abstracción</b>: toda figura que herede de esta clase
 * <em>debe</em> saber calcular su área, pero cada una lo hace a su manera.
 * También muestra <b>encapsulamiento</b> con el atributo {@code color}
 * privado y su par de métodos accesores.
 */
public abstract class FiguraGeometrica {

    private String color;

    /** Constructor por defecto con color blanco. */
    public FiguraGeometrica() {
        this("blanco");
    }

    /**
     * @param color color de la figura
     */
    public FiguraGeometrica(String color) {
        this.color = color;
    }

    /**
     * Calcula el área de la figura.
     *
     * @return el área en unidades cuadradas
     */
    public abstract double calcularArea();

    /**
     * Dibuja la figura describiendo su color.
     *
     * @return una descripción de la figura
     */
    public String dibujar() {
        return "Figura de color " + color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{color='" + color + "', area=" + calcularArea() + "}";
    }
}
