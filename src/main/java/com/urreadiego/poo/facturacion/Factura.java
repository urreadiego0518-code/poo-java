package com.urreadiego.poo.facturacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Factura con sus productos y el total calculado.
 *
 * <p><b>Mejora frente a la versión de clase:</b> el cálculo del total está
 * separado de la impresión ({@link #getTotal()}), de modo que se puede
 * comprobar con una prueba unitaria sin imprimir nada.
 */
public class Factura {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");

    private final String empresa;
    private final Producto[] productos;
    private final LocalDateTime fechaHora;

    /**
     * @param empresa  nombre de la empresa emisora
     * @param productos productos facturados
     */
    public Factura(String empresa, Producto[] productos) {
        this.empresa = empresa;
        this.productos = productos.clone();
        this.fechaHora = LocalDateTime.now();
    }

    /** @return la suma de los importes de todos los productos */
    public double getTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.importe();
        }
        return total;
    }

    /** @return la factura completa, lista para mostrar por consola */
    public String imprimirFactura() {
        StringBuilder sb = new StringBuilder();
        sb.append(empresa).append('\n');
        sb.append("Fecha y Hora: ").append(fechaHora.format(FORMATO)).append('\n');
        sb.append('\n');
        sb.append(String.format(Locale.US, "%-8s %-12s %6s %8s %10s%n",
                "codigo", "Descripcion", "Cant.", "P/u", "Importe"));

        for (Producto producto : productos) {
            sb.append(producto.imprimir()).append('\n');
        }

        sb.append(String.format(Locale.US, "%-8s %-12s %6s %8s %10.2f%n", "", "", "", "TOTAL: ", getTotal()));
        return sb.toString();
    }

    public String getEmpresa() {
        return empresa;
    }

    public Producto[] getProductos() {
        return productos.clone();
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
