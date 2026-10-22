package com.urreadiego.poo.biblioteca;

import javax.swing.JOptionPane;

/**
 * Interfaz gráfica para registrar libros en el catálogo.
 */
public class Principal {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        String valor = JOptionPane.showInputDialog("Cantidad de libros a registrar:");
        if (valor == null) {
            return;
        }

        int n;
        try {
            n = Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un número válido.");
            return;
        }

        for (int i = 1; i <= n; i++) {
            String titulo = JOptionPane.showInputDialog("Título de la obra");
            if (titulo == null) {
                return;
            }
            String autor = JOptionPane.showInputDialog("Autor");
            if (autor == null) {
                return;
            }
            biblioteca.agregarLibro(new Libro(titulo, autor));
        }

        JOptionPane.showMessageDialog(null, biblioteca.mostrarLibrosDisponibles());
    }
}
