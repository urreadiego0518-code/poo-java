package com.urreadiego.poo.modelo;

/**
 * Mesero con la mesa que atiende.
 */
public class Mesero {

    private final String nombre;
    private final int edad;
    private final String sexo;
    private final int mesa;

    public Mesero(String nombre, int edad, String sexo, int mesa) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.mesa = mesa;
    }

    /** El mesero atiende la mesa. */
    public void atenderMesas() {
        System.out.println("Hola soy " + nombre + ".");
        System.out.println("Atenderé su mesa");
    }

    /** El mesero lleva los platos a la mesa. */
    public void llevarPlatos() {
        System.out.println("Llevaré estos platos a la mesa " + mesa);
    }

    /** El mesero limpia la mesa. */
    public void limpiar() {
        System.out.println("Limpiaré la mesa " + mesa);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public int getMesa() {
        return mesa;
    }
}
