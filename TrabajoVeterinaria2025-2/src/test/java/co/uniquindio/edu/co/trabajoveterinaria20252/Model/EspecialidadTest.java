package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    void testEnumToString() {
        Especialidad especialidad = Especialidad.NEUROLOGÍA;
        assertEquals("NEUROLOGÍA", especialidad.toString());
    }

    @Test
    void testEnumAsignado() {
        Especialidad espAsignada = Especialidad.CARDIOLOGÍA;

        assertEquals(Especialidad.CARDIOLOGÍA, espAsignada);
    }
}