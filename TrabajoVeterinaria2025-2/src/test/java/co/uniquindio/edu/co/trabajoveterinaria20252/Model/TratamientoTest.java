package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TratamientoTest {

    @Test
    void testEnumToString() {
        Tratamiento tratamiento = Tratamiento.TRATAMIENTO_DE_EPILEPSIA;
        assertEquals("TRATAMIENTO_DE_EPILEPSIA", tratamiento.toString());
    }

    @Test
    void testEnumAsignado() {
        Tratamiento tratAsignado = Tratamiento.CIRUGIA_DE_CATARATAS;
        assertEquals(Tratamiento.CIRUGIA_DE_CATARATAS, tratAsignado);
    }
}
