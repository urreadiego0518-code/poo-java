package com.urreadiego.poo.herencia;

/**
 * Gerente regional: segundo nivel de herencia, a partir de {@link Gerente}.
 */
public class GerenteRegional extends Gerente {

    private String region;

    public GerenteRegional(String nombre, double salario, String departamento, String region) {
        super(nombre, salario, departamento);
        this.region = region;
    }

    /** Describe la actividad del gerente regional. */
    public void supervisar() {
        System.out.println(nombre + " supervisará la región de " + region);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
