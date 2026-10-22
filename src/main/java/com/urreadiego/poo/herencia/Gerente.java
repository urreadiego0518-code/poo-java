package com.urreadiego.poo.herencia;

/**
 * Gerente: hereda de {@link Empleado} y añade un departamento a su cargo.
 */
public class Gerente extends Empleado {

    private String departamento;

    public Gerente(String nombre, double salario, String departamento) {
        super(nombre, salario);
        this.departamento = departamento;
    }

    /** Describe la actividad del gerente. */
    public void dirigir() {
        System.out.println(nombre + " dirige el departamento de " + departamento);
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + " está dirigiendo el departamento de " + departamento);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
