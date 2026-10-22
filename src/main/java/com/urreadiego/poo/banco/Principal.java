package com.urreadiego.poo.banco;

import javax.swing.JOptionPane;

/**
 * Interfaz gráfica del banco. Solo se ocupa de preguntar y de mostrar
 * mensajes: la lógica vive en {@link CuentaBancaria}.
 */
public class Principal {

    private Principal() {
    }

    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Hola, ¿cuál es tu nombre?");
        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }

        CuentaBancaria cuenta = new CuentaBancaria(nombre.trim());
        JOptionPane.showMessageDialog(null,
                "Bienvenido/a " + nombre + "\nTu número de cuenta es: " + cuenta.getNumeroCuenta(),
                "Bienvenida", JOptionPane.INFORMATION_MESSAGE);

        int opcion;
        do {
            String menu = """
                    Bienvenido a nuestro banco
                    Selecciona una de las siguientes opciones
                    1. Consultar estado de cuenta
                    2. Depositar dinero
                    3. Retirar dinero
                    4. Salir""";

            String input = JOptionPane.showInputDialog(menu);

            if (input == null) {
                opcion = 4;
            } else if (input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa una opción.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                opcion = 0;
            } else {
                try {
                    opcion = Integer.parseInt(input.trim());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo números del 1 al 4 son válidos.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    opcion = 0;
                }
            }

            switch (opcion) {
                case 1 -> JOptionPane.showMessageDialog(null, cuenta.mostrarEstadoCuenta(),
                        "Estado de Cuenta", JOptionPane.INFORMATION_MESSAGE);
                case 2 -> depositar(cuenta);
                case 3 -> retirar(cuenta);
                case 4 -> JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                default -> {
                    if (opcion != 0) {
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                    }
                }
            }
        } while (opcion != 4);
    }

    private static void depositar(CuentaBancaria cuenta) {
        String entrada = JOptionPane.showInputDialog("¿Cuánto desea depositar?");
        if (entrada == null) {
            return;
        }
        try {
            double cantidad = Double.parseDouble(entrada);
            cuenta.depositar(cantidad);
            JOptionPane.showMessageDialog(null, "Depósito realizado con éxito.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo números válidos, por favor.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void retirar(CuentaBancaria cuenta) {
        String entrada = JOptionPane.showInputDialog("¿Cuánto desea retirar?");
        if (entrada == null) {
            return;
        }
        try {
            double cantidad = Double.parseDouble(entrada);
            cuenta.retirar(cantidad);
            JOptionPane.showMessageDialog(null, "Retiro realizado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo números válidos, por favor.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException | IllegalStateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
