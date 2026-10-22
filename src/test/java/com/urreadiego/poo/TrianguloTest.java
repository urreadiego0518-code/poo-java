package com.urreadiego.poo;

import com.urreadiego.poo.geometria.Triangulo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Triángulo: área y perímetro")
class TrianguloTest {

    @Test
    @DisplayName("el área de la base 3 y altura 4 es 6")
    void areaDelTriangulo() {
        Triangulo t = new Triangulo(3, 4);
        assertEquals(6.0, t.area());
    }

    @Test
    @DisplayName("el perímetro de la base 3 y altura 4 es 12")
    void perimetroDelTriangulo() {
        Triangulo t = new Triangulo(3, 4);
        // lado = sqrt((3/2)^2 + 4^2) = 4.272001872658765  ->  perimetro = 3 + 2*4.272 = 11.544
        assertEquals(11.54400374531753, t.perimetro(), 1e-9);
    }

    @Test
    @DisplayName("un triángulo de base 0 no tiene área")
    void trianguloDegradado() {
        Triangulo t = new Triangulo(0, 5);

        assertEquals(0.0, t.area());
        assertEquals(10.0, t.perimetro());
    }

    @Test
    @DisplayName("no acepta medidas negativas")
    void rechazaMedidasNegativas() {
        assertThrows(IllegalArgumentException.class, () -> new Triangulo(-1, 4));
        assertThrows(IllegalArgumentException.class, () -> new Triangulo(3, -4));
    }
}
