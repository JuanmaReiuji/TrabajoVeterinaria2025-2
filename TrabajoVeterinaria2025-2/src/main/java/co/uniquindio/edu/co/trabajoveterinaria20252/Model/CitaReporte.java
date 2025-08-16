package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import java.util.List;
import java.util.ArrayList;

public class CitaReporte {
    private boolean asistencia;
    private Persona veterinarioAsignado;
    private CitaAgendada detallesCita;
    private Tratamiento tipoTratamiento;
    private List<Medicamento>  medicamentos;


    public CitaReporte(boolean asistencia, Persona veterinarioAsignado, CitaAgendada detallesCita, Tratamiento tipoTratamiento) {
        this.asistencia = asistencia;
        this.veterinarioAsignado = veterinarioAsignado;
        this.detallesCita = detallesCita;
        this.tipoTratamiento = tipoTratamiento;
        this.medicamentos = new ArrayList<>();
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Persona getVeterinarioAsignado() {
        return veterinarioAsignado;
    }

    public void setVeterinarioAsignado(Persona veterinarioAsignado) {
        this.veterinarioAsignado = veterinarioAsignado;
    }

    public CitaAgendada getDetallesCita() {
        return detallesCita;
    }

    public void setDetallesCita(CitaAgendada detallesCita) {
        this.detallesCita = detallesCita;
    }

    public Tratamiento getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(Tratamiento tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    @Override
    public String toString() {
        return "Reporte de la cita: " +
                "Asistencia: " + asistencia +
                ", veterinario asignado: " + veterinarioAsignado +
                ", detalles de la cita: " + detallesCita +
                ", tipo de tratamiento: " + tipoTratamiento +
                ", medicamentos usados para la cita: " + medicamentos;
    }
}

