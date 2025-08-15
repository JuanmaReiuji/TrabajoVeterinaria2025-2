package co.uniquindio.edu.co.trabajoveterinaria20252.Controller;

import co.uniquindio.edu.co.trabajoveterinaria20252.Model.*;

import java.time.LocalDate;
import java.util.Optional;

public class VeterinariaController {
    private final Veterinaria veterinaria;

    public VeterinariaController(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    public Optional<Mascota> buscarMascota(int id){
        if (id <= 0) {
            System.out.println("Ingrese una ID valida (mayor a 0)");
            return Optional.empty();
        }
        return veterinaria.buscarMascota(id);
    }

    public boolean registrarMascota(Mascota nuevaMascota) {
        if (nuevaMascota == null) {
            System.out.println("Porfavor, ingrese una mascota valida");
            return false;
        }
        if (nuevaMascota.getId() <= 0) {
            System.out.println("Las mascota debe tener una ID valida (mayor a 0)");
            return false;
        }
        if (nuevaMascota.getNombre() == null || nuevaMascota.getNombre().isBlank()) {
            System.out.println("El nombre de la mascota no puede estar vacío");
            return false;
        }
            return veterinaria.registrarMascota(nuevaMascota);
    }

    public Optional<Persona> buscarPropietario(int cedula) {
        if (cedula <= 0) {
            System.out.println("Ingrese una cedula valida (mayor a 0)");
            return Optional.empty();
        }
        return veterinaria.buscarPropietario(cedula);
    }

    public boolean registrarPropietario(Persona nuevoPropietario) {
        if (nuevoPropietario == null) {
            System.out.println("Por favor, ingrese un propietario válido");
            return false;
        }
        if (nuevoPropietario.getCedula() <= 0) {
            System.out.println("El propietario debe tener una cédula válida (mayor a 0)");
            return false;
        }
        if (nuevoPropietario.getNombre() == null || nuevoPropietario.getNombre().isBlank()) {
            System.out.println("El nombre del propietario no puede estar vacío");
            return false;
        }
        return veterinaria.registrarPropietario(nuevoPropietario);
    }

    public Optional<Persona> buscarVeterinario(int cedula) {
        if (cedula <= 0) {
            System.out.println("Ingrese una cédula válida (mayor a 0)");
            return Optional.empty();
        }
        return veterinaria.buscarVeterinario(cedula);
    }

    public boolean registrarVeterinario(Persona nuevoVeterinario) {
        if (nuevoVeterinario == null) {
            System.out.println("Por favor, ingrese un veterinario válido");
            return false;
        }
        if (nuevoVeterinario.getCedula() <= 0) {
            System.out.println("El veterinario debe tener una cédula válida (mayor a 0)");
            return false;
        }
        if (nuevoVeterinario.getNombre() == null || nuevoVeterinario.getNombre().isBlank()) {
            System.out.println("El nombre del veterinario no puede estar vacío");
            return false;
        }
        return veterinaria.registrarVeterinario(nuevoVeterinario);
    }

    public boolean agendarCita(CitaAgendada nuevaCita){
        if(nuevaCita == null){
            System.out.println("La cita a agendar no debe estar vacia");
            return false;
        }
        if (nuevaCita.getFecha().isBefore(LocalDate.now())) {
            System.out.println("La cita debe estar agendada para una fecha futura");
            return false;
        }
        return veterinaria.agendarCita(nuevaCita);
    }

    public boolean buscarCitaMascota(Mascota mascotaABuscar){
        if (mascotaABuscar == null){
            System.out.println("Se debe buscar una mascota registrada");
            return false;
        }
        return veterinaria.buscarCitasMascota(mascotaABuscar);
    }

    public boolean buscarCitasPorFecha(LocalDate fechaABuscar){
        if(fechaABuscar == null){
            System.out.println("La cita a agendar no debe estar vacia");
            return false;
        }
        if (fechaABuscar.isAfter(LocalDate.now())) {
            System.out.println("No se pueden buscar citas en fechas futuras");
            return false;
        }
        return veterinaria.buscarCitasPorFecha(fechaABuscar);
    }
}