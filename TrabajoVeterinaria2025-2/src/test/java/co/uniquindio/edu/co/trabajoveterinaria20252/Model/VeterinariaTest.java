package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VeterinariaTest {

    private Veterinaria veterinaria;
    private Recepcionista recepcionista;
    private Propietario propietario;
    private Veterinario veterinario;
    private Mascota mascota;

    @BeforeEach
    void setUp() {
        // Recepcionista requerido por el constructor de Veterinaria
        recepcionista = new Recepcionista("Ana", 999, "Cra 1 #2-3", 300000000, "abc123");

        veterinaria = new Veterinaria("Vet UQ", 12345);

        propietario = new Propietario("Juan Pérez", 123, "Calle 1", 300111222,"123");
        veterinario = new Veterinario("Dra. López", 456, "Calle 2", 300333444, Especialidad.NEUROLOGÍA,"123");

        // La mascota se crea sin cita inicialmente (null)
        mascota = new Mascota("Firulais", "Perro", 3, 1, propietario);
    }


    // ---------- GETTERS Y SETTERS ----------

    @Test
    void testGetNombre() {
        assertEquals("Vet UQ", veterinaria.getNombre());
    }

    @Test
    void testSetNombre(){
        veterinaria.setNombre("UQ Vet");
        assertEquals("UQ Vet", veterinaria.getNombre());
    }

    @Test
    void testGetListaMascotas(){
        assertEquals(0, veterinaria.getListaMascotas().size());
    }

    @Test
    void testSetListaMascotas(){
        List<Mascota> mascotasListTest = new ArrayList<>();
        veterinaria.setListaMascotas(mascotasListTest);

        assertEquals(mascotasListTest,  veterinaria.getListaMascotas());
    }

    // ---------- PROPIETARIOS ----------
    @Test
    void testRegistrarPropietario_valido_devuelveTrue_y_sePuedeBuscar() {
        assertTrue(veterinaria.registrarPropietario(propietario));
        assertEquals(Optional.of(propietario), veterinaria.buscarPropietario(123));
    }

    @Test
    void testRegistrarPropietario_duplicado_devuelveFalse() {
        veterinaria.registrarPropietario(propietario);
        assertFalse(veterinaria.registrarPropietario(propietario));
    }

    @Test
    void testBuscarPropietario_inexistente_devuelveEmpty() {
        assertEquals(Optional.empty(), veterinaria.buscarPropietario(9999));
    }

    // ---------- VETERINARIOS ----------
    @Test
    void testRegistrarVeterinario_valido_devuelveTrue_y_sePuedeBuscar() {
        assertTrue(veterinaria.registrarVeterinario(veterinario));
        assertEquals(Optional.of(veterinario), veterinaria.buscarVeterinario(456));
    }

    @Test
    void testRegistrarVeterinario_duplicado_devuelveFalse() {
        veterinaria.registrarVeterinario(veterinario);
        assertFalse(veterinaria.registrarVeterinario(veterinario));
    }

    // ---------- MASCOTAS ----------
    @Test
    void testRegistrarMascota_valida_devuelveTrue_y_sePuedeBuscar() {
        assertTrue(veterinaria.registrarMascota(mascota));
        assertEquals(Optional.of(mascota), veterinaria.buscarMascota(1));
    }

    @Test
    void testRegistrarMascota_duplicada_devuelveFalse() {
        veterinaria.registrarMascota(mascota);
        assertFalse(veterinaria.registrarMascota(mascota));
    }

    // ---------- CITAS ----------
    @Test
    void testAgendarCita_valida_devuelveTrue() {
        // Deben existir el vet y la mascota
        veterinaria.registrarVeterinario(veterinario);
        veterinaria.registrarMascota(mascota);

        CitaAgendada cita = new CitaAgendada(
                LocalDate.now().plusDays(1),
                "Vacunación",
                mascota,
                veterinario
        );

        assertTrue(veterinaria.agendarCita(cita));
    }

    @Test
    void testAgendarCita_falla_siVeterinarioNoExiste() {
        veterinaria.registrarMascota(mascota);

        CitaAgendada cita = new CitaAgendada(
                LocalDate.now().plusDays(1),
                "Control",
                mascota,
                veterinario // no registrado aún
        );

        assertFalse(veterinaria.agendarCita(cita));
    }

    @Test
    void testAgendarCita_falla_siMascotaNoExiste() {
        veterinaria.registrarVeterinario(veterinario);

        CitaAgendada cita = new CitaAgendada(
                LocalDate.now().plusDays(1),
                "Desparasitación",
                mascota, // no registrada aún
                veterinario
        );

        assertFalse(veterinaria.agendarCita(cita));
    }

    @Test
    void testAgendarCita_duplicada_mismaFechaMismaMascotaMismoVet_devuelveFalse() {
        veterinaria.registrarVeterinario(veterinario);
        veterinaria.registrarMascota(mascota);

        LocalDate fecha = LocalDate.now().plusDays(2);

        CitaAgendada c1 = new CitaAgendada(fecha, "Chequeo", mascota, veterinario);
        CitaAgendada c2 = new CitaAgendada(fecha, "Chequeo", mascota, veterinario);

        assertTrue(veterinaria.agendarCita(c1));
        assertFalse(veterinaria.agendarCita(c2)); // debe detectar duplicado
    }

    // ---------- BUSQUEDAS DE CITAS ----------
    @Test
    void testBuscarCitasPorFecha_conCitaExistente_devuelveTrue() {
        veterinaria.registrarVeterinario(veterinario);
        veterinaria.registrarMascota(mascota);

        LocalDate fecha = LocalDate.now().plusDays(3);
        CitaAgendada cita = new CitaAgendada(fecha, "Control general", mascota, veterinario);
        veterinaria.agendarCita(cita);

        assertTrue(veterinaria.buscarCitasPorFecha(fecha));
    }

    @Test
    void testBuscarCitasPorFecha_sinResultados_devuelveFalse() {
        assertFalse(veterinaria.buscarCitasPorFecha(LocalDate.now().plusDays(10)));
    }

    @Test
    void testBuscarCitasPorMascota_conCitaDevuelveTrue_y_conMascotaSinCitasTambienDevuelveTruePeroListaVacia() {
        veterinaria.registrarVeterinario(veterinario);
        veterinaria.registrarMascota(mascota);

        // Con cita
        LocalDate fecha = LocalDate.now().plusDays(4);
        CitaAgendada cita = new CitaAgendada(fecha, "Vacuna refuerzo", mascota, veterinario);
        veterinaria.agendarCita(cita);
        assertTrue(veterinaria.buscarCitasMascota(mascota));

        // Mascota existe pero sin citas: el método actual imprime lista vacía y retorna true
        Mascota otra = new Mascota("Mishu", "Gato", 2, 2, propietario);
        veterinaria.registrarMascota(otra);
        assertTrue(veterinaria.buscarCitasMascota(otra));
    }


    // ---------- TOSTRING ----------
    @Test
    void testToString(){
        String esperado = "VeterinariaVet UQ" +
                ", nit: 12345" +
                ".\nLista de propietarios: []" +
                ".\nLista de veterinarios: []" +
                ".\nLista de mascotas: []" +
                ".\nCitas agendadas: []" +
                ". Citas reportadas : []";

        assertEquals(esperado, veterinaria.toString());
    }

}
