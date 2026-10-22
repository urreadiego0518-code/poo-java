package com.urreadiego.poo;

import com.urreadiego.poo.banco.CuentaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("CuentaBancaria: depósitos, retiros y saldo")
class CuentaBancariaTest {

    private CuentaBancaria cuenta;

    @BeforeEach
    void setUp() {
        cuenta = new CuentaBancaria("Diego");
    }

    @Test
    @DisplayName("una cuenta nueva arranca en cero")
    void cuentaNuevaEnCero() {
        assertEquals(0.0, cuenta.getSaldo());
        assertEquals(0.0, cuenta.getTotalDepositado());
        assertEquals(0.0, cuenta.getTotalRetirado());
    }

    @Test
    @DisplayName("el número de cuenta tiene cuatro dígitos")
    void numeroDeCuentaDeCuatroDigitos() {
        assertTrue(cuenta.getNumeroCuenta() >= 1000 && cuenta.getNumeroCuenta() <= 9999);
    }

    @Test
    @DisplayName("el saldo es lo depositado menos lo retirado")
    void calculaElSaldo() {
        cuenta.depositar(1000);
        cuenta.retirar(250);

        assertEquals(1000.0, cuenta.getTotalDepositado());
        assertEquals(250.0, cuenta.getTotalRetirado());
        assertEquals(750.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("no permite depósitos ni retiros de cero o negativos")
    void rechazaCantidadesNoPositivas() {
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(0));
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-50));
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(0));
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(-50));
    }

    @Test
    @DisplayName("no permite retirar más que el saldo disponible")
    void rechazaRetiroSinSaldoSuficiente() {
        cuenta.depositar(100);

        assertThrows(IllegalStateException.class, () -> cuenta.retirar(150));
        assertEquals(100.0, cuenta.getSaldo(), "el saldo no debe cambiar tras el fallo");
    }

    @Test
    @DisplayName("el estado de cuenta incluye el nombre del cliente")
    void estadoDeCuentaIncluyeCliente() {
        cuenta.depositar(500);
        String estado = cuenta.mostrarEstadoCuenta();

        assertTrue(estado.contains("Diego"));
        assertTrue(estado.contains("500.00"));
    }
}
