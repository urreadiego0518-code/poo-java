package com.urreadiego.poo.banco;

import java.util.Locale;
import java.util.Random;

/**
 * Modelo de una cuenta bancaria.
 *
 * <p><b>Mejora frente a la versión de clase:</b> la clase no dibuja nada.
 * Toda la lógica de negocio vive aquí y los mensajes los muestra la interfaz
 * ({@link Principal}). Eso permite escribir pruebas unitarias sobre el modelo
 * sin necesidad de una ventana gráfica, y respeta el principio de
 * <i>separación de responsabilidades</i>.
 */
public class CuentaBancaria {

    private final int numeroCuenta;
    private final String nombreCliente;
    private double totalDepositado;
    private double totalRetirado;

    /**
     * @param nombreCliente titular de la cuenta
     */
    public CuentaBancaria(String nombreCliente) {
        this.numeroCuenta = 1000 + new Random().nextInt(9000);
        this.nombreCliente = nombreCliente;
        this.totalDepositado = 0;
        this.totalRetirado = 0;
    }

    /**
     * @return el número de cuenta generado
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Deposita dinero en la cuenta.
     *
     * @param cantidad importe a depositar, debe ser mayor que cero
     * @throws IllegalArgumentException si la cantidad no es positiva
     */
    public void depositar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a depositar debe ser positiva");
        }
        totalDepositado += cantidad;
    }

    /**
     * Retira dinero de la cuenta.
     *
     * @param cantidad importe a retirar, debe ser positivo y no exceder el saldo
     * @throws IllegalArgumentException si la cantidad no es positiva
     * @throws IllegalStateException si el saldo es insuficiente
     */
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva");
        }
        if (cantidad > getSaldo()) {
            throw new IllegalStateException("Saldo insuficiente para ese retiro");
        }
        totalRetirado += cantidad;
    }

    /** @return el saldo actual de la cuenta */
    public double getSaldo() {
        return totalDepositado - totalRetirado;
    }

    public double getTotalDepositado() {
        return totalDepositado;
    }

    public double getTotalRetirado() {
        return totalRetirado;
    }

    /**
     * @return el estado de cuenta listo para mostrar
     */
    public String mostrarEstadoCuenta() {
        return String.format(
                Locale.US,
                "--- Estado de Cuenta ---\n"
                        + "Número de cuenta: %d\n"
                        + "Cliente: %s\n"
                        + "Total depositado: $%.2f\n"
                        + "Total retirado: $%.2f\n"
                        + "Saldo actual: $%.2f",
                numeroCuenta, nombreCliente, totalDepositado, totalRetirado, getSaldo());
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + numeroCuenta + " - " + nombreCliente + "}";
    }
}
