package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecepcionistaTest {
    private Recepcionista recepcionistaPrueba;

    @BeforeEach
    void setUp() {
        recepcionistaPrueba = new Recepcionista("Lina", 3212, "Calle X", 3321, "xyz321");
    }

    @Test
    void testGetYSetContraseniaUnica() {
        String esperado = "abc123";
        recepcionistaPrueba.setContraseniaUnica(esperado);

        assertEquals(esperado, recepcionistaPrueba.getContraseniaUnica());
    }

    @Test
    void testToString() {
        String esperado = "Recepcionista: " + "nombre: " + recepcionistaPrueba.getNombre() +
                ", cedula: " + recepcionistaPrueba.getCedula() +
                ", telefono: " + recepcionistaPrueba.toString() +
                ", direccion:" + recepcionistaPrueba.getDireccion();
    }
}