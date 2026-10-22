package com.urreadiego.poo;

import com.urreadiego.poo.herencia.Cubo;
import com.urreadiego.poo.herencia.Cuadrado;
import com.urreadiego.poo.herencia.Empleado;
import com.urreadiego.poo.herencia.FiguraGeometrica;
import com.urreadiego.poo.herencia.Gerente;
import com.urreadiego.poo.herencia.GerenteRegional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Herencia y polimorfismo")
class HerenciaTest {

    @Test
    @DisplayName("el cuadrado calcula su área")
    void areaDelCuadrado() {
        Cuadrado cuadrado = new Cuadrado(4);
        assertEquals(16.0, cuadrado.calcularArea());
    }

    @Test
    @DisplayName("el cubo hereda el área y añade el volumen")
    void volumenDelCubo() {
        Cubo cubo = new Cubo(3);

        assertEquals(9.0, cubo.calcularArea());
        assertEquals(27.0, cubo.calcularVolumen());
        assertInstanceOf(Cuadrado.class, cubo);
        assertInstanceOf(FiguraGeometrica.class, cubo);
    }

    @Test
    @DisplayName("el color se hereda y es accesible por accessor")
    void colorHeredado() {
        Cuadrado cuadrado = new Cuadrado(2, "rojo");

        assertEquals("rojo", cuadrado.getColor());
        assertTrue(cuadrado.dibujar().contains("rojo"));
    }

    @Test
    @DisplayName("el polimorfismo permite tratar a todos como FiguraGeometrica")
    void polimorfismoDeFiguras() {
        FiguraGeometrica[] figuras = {new Cuadrado(2), new Cubo(3)};

        double sumaAreas = 0;
        for (FiguraGeometrica figura : figuras) {
            sumaAreas += figura.calcularArea();
        }

        assertEquals(13.0, sumaAreas);
    }

    @Test
    @DisplayName("el gerente es un empleado con departamento")
    void gerenteEsEmpleado() {
        Gerente gerente = new Gerente("Ana", 25000, "Ventas");

        assertInstanceOf(Empleado.class, gerente);
        assertEquals("Ana", gerente.getNombre());
        assertEquals(25000.0, gerente.getSalario());
        assertEquals("Ventas", gerente.getDepartamento());
    }

    @Test
    @DisplayName("el gerente regional hereda de gerente y de empleado")
    void gerenteRegional() {
        GerenteRegional gerente = new GerenteRegional("Luis", 40000, "Norte", "Chiapas");

        assertInstanceOf(Gerente.class, gerente);
        assertInstanceOf(Empleado.class, gerente);
        assertEquals("Norte", gerente.getDepartamento());
        assertEquals("Chiapas", gerente.getRegion());
    }
}
