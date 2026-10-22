package com.urreadiego.poo.geometria;

import javax.swing.JOptionPane;

/**
 * Versión con ventana gráfica del cálculo del triángulo.
 */
public class TrianguloPane {

    public static void main(String[] args) {
        try {
            String baseStr = JOptionPane.showInputDialog("Ingresa la base del triángulo: ");
            String alturaStr = JOptionPane.showInputDialog("Ingresa la altura del triángulo: ");

            double base = Double.parseDouble(baseStr);
            double altura = Double.parseDouble(alturaStr);

            Triangulo t = new Triangulo(base, altura);

            JOptionPane.showMessageDialog(null,
                    String.format("Área: %.2f\nPerímetro: %.2f", t.area(), t.perimetro()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa valores numéricos válidos");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
