package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.uniquindio.edu.co.trabajoveterinaria20252.Model.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CitaAgendadaTest {
    private Persona propietario;
    private Mascota mascotaAtendida;
    private Persona veterinarioAsignado;
    private CitaAgendada citaAgendada;

    @BeforeEach
    void setUp() {
        propietario = new Propietario("Juan Pérez", 123, "Calle 1", 300111222,"123");
        mascotaAtendida = new Mascota("Firulais", "Perro", 3, 1, propietario , "123");
        veterinarioAsignado = new Veterinario("Dra. López", 456, "Calle 2", 300333444, Especialidad.NEUROLOGÍA,"123");

        citaAgendada = new CitaAgendada(LocalDate.now(),  "Control anual", mascotaAtendida, veterinarioAsignado);

    }

    @Test
    void testGetMotivo() {
        String esperado = "Control anual";
        assertEquals(esperado, citaAgendada.getMotivo());
    }

    @Test
    void testSetMotivo() {
        String motivoNuevo = "Pelaje grasoso sin motivo aparente";
        citaAgendada.setMotivo(motivoNuevo);

        assertEquals(motivoNuevo, citaAgendada.getMotivo());

    }

}