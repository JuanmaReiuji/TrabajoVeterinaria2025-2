package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SedeTest {
    private Veterinaria veterinaria;
    private Recepcionista recepcionista;
    private Propietario propietario;
    private Veterinario veterinario;
    private Mascota mascota;
    private Sede sedePrueba;

    @BeforeEach
    void setUp() {
        recepcionista = new Recepcionista("Ana", 999, "Cra 1 #2-3", 300000000, "abc123");

        veterinaria = new Veterinaria("Vet UQ", 12345);

        propietario = new Propietario("Juan Pérez", 123, "Calle 1", 300111222,"123");
        veterinario = new Veterinario("Dra. López", 456, "Calle 2", 300333444, Especialidad.NEUROLOGÍA,"123");

        // La mascota se crea sin cita inicialmente (null)
        mascota = new Mascota("Firulais", "Perro", 3, 1, propietario);

        sedePrueba = new Sede("Sede X", 3213123, null);
    }

    @Test
    void testGetYSetNit() {
        int esperado = 987987;
        sedePrueba.setNit(esperado);

        assertEquals(esperado, sedePrueba.getNit());
    }

    @Test
    void testGetYSetVeterinariaAsignada() {
        Veterinaria esperado =  veterinaria;
        sedePrueba.setVeterinariaAsignada(esperado);

        assertEquals(esperado, sedePrueba.getVeterinariaAsignada());

    }

    @Test
    void testToString() {
        String esperado = "nombre: " + sedePrueba.getNombre() +
                ", nit:" + sedePrueba.getNit() +
                ", veterinaria asignada: " + sedePrueba.getVeterinariaAsignada();

        assertEquals(esperado, sedePrueba.toString());
    }
}