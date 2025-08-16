package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MascotaTest {
    private Persona propietario;
    private Mascota mascotaPrueba;
    private Persona veterinarioAsignado;
    private CitaAgendada citaAgendada;

    @BeforeEach
    void setUp() {
        propietario = new Propietario("Juan Pérez", 123, "Calle 1", 300111222,"123");
        mascotaPrueba = new Mascota("Firulais", "Perro", 3, 1, propietario);
        veterinarioAsignado = new Veterinario("Dra. López", 456, "Calle 2", 300333444, Especialidad.NEUROLOGÍA,"123");

        citaAgendada = new CitaAgendada(LocalDate.now(),  "Control anual", mascotaPrueba, veterinarioAsignado);

    }


    @Test
    void testGetYSetNombre() {
        String esperado = "Max";
        mascotaPrueba.setNombre(esperado);

        assertEquals(esperado, mascotaPrueba.getNombre());
    }

    @Test
    void getDuenio() {
        String esperado = mascotaPrueba.getDuenio().toString();
        assertEquals(esperado, mascotaPrueba.getDuenio().toString());
    }

    @Test
    void testGetYSetDuenio() {
        Persona esperado = null;
        mascotaPrueba.setDuenio(esperado);

        assertNull(mascotaPrueba.getDuenio());
    }



}