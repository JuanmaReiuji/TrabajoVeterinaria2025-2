package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitaReporteTest {
    private Persona veterinarioAsignado;
    private Propietario propietario;
    private Mascota mascotaAtendida;
    private CitaAgendada detallesCitaPrueba;
    private Tratamiento tipoTratamiento;
    private Medicamento medicamento;
    private CitaReporte reporteCita;

    @BeforeEach
    void setUp() {
        propietario = new Propietario("Juan Pérez", 123, "Calle 1", 300111222);
        mascotaAtendida = new Mascota("Firulais", "Perro", 3, 1, propietario, detallesCitaPrueba);
        veterinarioAsignado = new Veterinario("Dra. López", 456, "Calle 2", 300333444, Especialidad.NEUROLOGÍA);
        medicamento = new Medicamento("Acetaminofen", "Fabrica X", "2 pastas", 432);

        detallesCitaPrueba = new CitaAgendada(LocalDate.now(), "Control anual", mascotaAtendida, veterinarioAsignado);

        reporteCita = new CitaReporte(true, veterinarioAsignado, detallesCitaPrueba, Tratamiento.TRATAMIENTO_DE_EPILEPSIA);
    }

    @Test
    void testIsAsistencia() {
        boolean esperado = false;
        assertNotEquals(esperado, reporteCita.isAsistencia());
    }

    @Test
    void testSetAsistencia() {
        boolean esperado = false;
        reporteCita.setAsistencia(esperado);
        assertEquals(esperado, reporteCita.isAsistencia());
    }

    @Test
    void testGetDetallesCita() {
        String esperado = detallesCitaPrueba.toString();
        assertEquals(esperado, reporteCita.getDetallesCita().toString());
    }

    @Test
    void testSetDetallesCita() {
        CitaAgendada citaEsperada = new CitaAgendada(LocalDate.now(), "Motivo x", null,  null);

        reporteCita.setDetallesCita(citaEsperada);

        assertEquals(citaEsperada, reporteCita.getDetallesCita());

    }

    @Test
    void testGetMedicamentos() {
        int esperado = 0;
        assertEquals(esperado, reporteCita.getMedicamentos().size());
    }

    @Test
    void testSetMedicamentos() {
        List<Medicamento> medicamentosPrueba = new ArrayList<>();
        medicamentosPrueba.add(medicamento);

        reporteCita.setMedicamentos(medicamentosPrueba);

        assertEquals(medicamentosPrueba, reporteCita.getMedicamentos());
    }

    @Test
    void testToString() {
        String esperado = "Reporte de la cita: " +
                "Asistencia: " + reporteCita.isAsistencia() +
                ", veterinario asignado: " + reporteCita.getVeterinarioAsignado().toString() +
                ", detalles de la cita: " + reporteCita.getDetallesCita().toString() +
                ", tipo de tratamiento: " + reporteCita.getTipoTratamiento().toString() +
                ", medicamentos usados para la cita: " + reporteCita.getMedicamentos();

        assertEquals(esperado, reporteCita.toString());
    }
}