package com.urreadiego.poo.herencia;

/**
 * Clase base de los empleados de una empresa.
 *
 * <p>El atributo {@code nombre} es {@code protected} para que las subclases
 * puedan reutilizarlo, y {@code salario} permanece privado con su accessor.
 */
public class Empleado {

    protected String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    /** Describe la actividad del empleado. */
    public void trabajar() {
        System.out.println(nombre + " estoy trabajando");
    }

    /** @return una descripción del empleado */
    public String mostrarInfo() {
        return "Empleado: " + nombre + ", Salario: $" + salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salaryValido(salario) ? salario : this.salario;
    }

    private static boolean salaryValido(double salario) {
        return salario >= 0;
    }

    @Override
    public String toString() {
        return mostrarInfo();
    }
}
