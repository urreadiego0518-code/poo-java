package com.urreadiego.poo;

import com.urreadiego.poo.facturacion.Factura;
import com.urreadiego.poo.facturacion.Producto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Facturación: productos, importes y total")
class FacturaTest {

    @Test
    @DisplayName("el importe es cantidad por precio unitario")
    void importeDelProducto() {
        Producto producto = new Producto(3, "leche", 30.0, 47);

        assertEquals(90.0, producto.importe());
        assertEquals(3, producto.getCantidad());
        assertEquals(47, producto.getCodigo());
    }

    @Test
    @DisplayName("el total es la suma de los importes")
    void totalDeLaFactura() {
        Producto[] productos = {
                new Producto(3, "leche", 30.0, 47),
                new Producto(1, "galleta", 35.0, 528),
                new Producto(0.25, "jamon", 120.0, 304)
        };

        Factura factura = new Factura("Tienda de Diego", productos);

        assertEquals(90.0 + 35.0 + 30.0, factura.getTotal(), 0.0001);
    }

    @Test
    @DisplayName("una factura sin productos vale cero")
    void facturaVacia() {
        Factura factura = new Factura("Tienda", new Producto[0]);

        assertEquals(0.0, factura.getTotal());
    }

    @Test
    @DisplayName("la factura impresa contiene el total y la empresa")
    void facturaImpresa() {
        Producto[] productos = {new Producto(2, "pan", 25.0, 1)};
        Factura factura = new Factura("Tienda de Diego", productos);

        String impresa = factura.imprimirFactura();

        assertTrue(impresa.contains("Tienda de Diego"));
        assertTrue(impresa.contains("TOTAL"));
        assertTrue(impresa.contains("50.00"));
    }
}
