package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoTest {
    private Medicamento medicamentoPrueba;

    @BeforeEach
    void setUp() {
        medicamentoPrueba = new Medicamento("Acetaminofen", "Fabrica X", "2 pastas", 432);
    }

    @Test
    void testGetYSetCantidad() {
        String esperado = "5 pastas";
        medicamentoPrueba.setCantidad(esperado);

        assertEquals(esperado, medicamentoPrueba.getCantidad());
    }

    @Test
    void testToString() {
        String esperado = "nombre: " + medicamentoPrueba.getNombre() +
                ", cantidad: " + medicamentoPrueba.getCantidad() +
                ", fabricante: " + medicamentoPrueba.getFabricante() +
                ", codigo: " + medicamentoPrueba.getCodigo();

        assertEquals(esperado, medicamentoPrueba.toString());
    }
}