package com.urreadiego.poo.facturacion;

import java.util.Locale;

/**
 * Producto que aparece en una factura.
 */
public class Producto {

    private final double cantidad;
    private final String descripcion;
    private final double precioUnitario;
    private final int codigo;

    /**
     * @param cantidad        cantidad de piezas
     * @param descripcion     descripción del producto
     * @param precioUnitario  precio por pieza
     * @param codigo          código del producto
     */
    public Producto(double cantidad, String descripcion, double precioUnitario, int codigo) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.codigo = codigo;
    }

    /** @return el importe total del producto (cantidad × precio unitario) */
    public double importe() {
        return cantidad * precioUnitario;
    }

    /** @return la línea del producto formateada como tabla */
    public String imprimir() {
        return String.format(Locale.US, "%-8d %-12s %6.2f %8.2f %10.2f",
                codigo, descripcion, cantidad, precioUnitario, importe());
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Producto{codigo=" + codigo + ", descripcion='" + descripcion + "'}";
    }
}
