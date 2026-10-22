package com.urreadiego.poo.facturacion;

/**
 * Ejemplo de uso del modelo de facturación.
 */
public class Principal {

    public static void main(String[] args) {
        Producto p1 = new Producto(3, "leche", 30.0, 47);
        Producto p2 = new Producto(1, "galleta", 35.0, 528);
        Producto p3 = new Producto(0.25, "jamon", 120.0, 304);

        Producto[] lista = {p1, p2, p3};

        Factura factura = new Factura("Tienda de Diego", lista);
        System.out.println(factura.imprimirFactura());
    }
}
