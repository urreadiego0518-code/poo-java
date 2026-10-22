package com.urreadiego.poo;

import com.urreadiego.poo.polimorfismo.Animal;
import com.urreadiego.poo.polimorfismo.Automovil;
import com.urreadiego.poo.polimorfismo.Deportivo;
import com.urreadiego.poo.polimorfismo.Vaca;
import com.urreadiego.poo.polimorfismo.Vehiculo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@DisplayName("Polimorfismo: animales y vehículos")
class PolimorfismoTest {

    @Test
    @DisplayName("la vaca hereda de animal y conserva sus datos")
    void vacaEsAnimal() {
        Vaca vaca = new Vaca(2, "blanca", "Lola");

        assertInstanceOf(Animal.class, vaca);
        assertEquals("Lola", vaca.getNombre());
        assertEquals(2, vaca.getTamaño());
        assertEquals("blanca", vaca.getColor());
    }

    @Test
    @DisplayName("un arreglo de animales acepta distintas especies")
    void arregloDeAnimales() {
        Animal[] animales = {new Vaca(2, "blanca", "Lola")};

        assertEquals(1, animales.length);
        assertInstanceOf(Vaca.class, animales[0]);
    }

    @Test
    @DisplayName("el deportivo hereda de automóvil y de vehículo")
    void deportivoEsAutomovil() {
        Deportivo deportivo = new Deportivo("Ferrari", 2024);

        assertInstanceOf(Automovil.class, deportivo);
        assertInstanceOf(Vehiculo.class, deportivo);
        assertEquals("Ferrari", deportivo.getMarca());
        assertEquals(2024, deportivo.getAnio());
    }
}
