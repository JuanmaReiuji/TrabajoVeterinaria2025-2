package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VeterinarioTest {
    private CitaAgendada citaAgendada;
    private Propietario propietario;
    private Mascota mascotaAtendida;
    private  Veterinario veterinario;

    @BeforeEach
    void setUp() {
        citaAgendada = new CitaAgendada(LocalDate.now(), "Fiebre alta", mascotaAtendida, veterinario);

        propietario = new Propietario("Juan Pérez", 123, "Calle 1", 300111222,"123");
        mascotaAtendida = new Mascota("Firulais", "Perro", 3, 1, propietario);
        veterinario = new  Veterinario("Dra. López", 456, "Calle 2", 300333444, Especialidad.NEUROLOGÍA,"123");

    }


    @Test
    void getEspecialidad() {
        Especialidad esperado = Especialidad.NEUROLOGÍA;
        assertEquals(esperado, veterinario.getEspecialidad());
    }

    @Test
    void setEspecialidad() {
        Especialidad esperado = Especialidad.ORTOPEDIA;
        veterinario.setEspecialidad(Especialidad.ORTOPEDIA);

        assertEquals(esperado, veterinario.getEspecialidad());
    }

    @Test
    void getCitaAgendadas() {
        int esperado = 0;
        assertEquals(esperado, veterinario.getCitaAgendadas().size());
    }

    @Test
    void setCitaAgendadas() {
        List<CitaAgendada> listaPrueba = new ArrayList<>();
        listaPrueba.add(citaAgendada);
        veterinario.setCitaAgendadas(listaPrueba);
        assertEquals(listaPrueba, veterinario.getCitaAgendadas());
    }


}