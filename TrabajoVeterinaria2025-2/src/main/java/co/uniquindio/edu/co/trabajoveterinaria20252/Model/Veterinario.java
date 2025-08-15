package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import java.util.List;
import java.util.ArrayList;

public class Veterinario extends Persona {
    private Especialidad especialidad;
    private List<CitaAgendada> citaAgendadas;
    private List<CitaReporte> listaCitasReportadas;


    public Veterinario(String nombre, int cedula, String direccion, int telefono, Especialidad especialidad) {
        super(nombre, cedula, direccion, telefono);
        this.especialidad = especialidad;
        this.citaAgendadas = new ArrayList<>();
        this.listaCitasReportadas = new ArrayList<>();
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<CitaAgendada> getCitaAgendadas() {
        return citaAgendadas;
    }

    public void setCitaAgendadas(List<CitaAgendada> citaAgendadas) {
        this.citaAgendadas = citaAgendadas;
    }

    public List<CitaReporte> getListaCitasReportadas() {
        return listaCitasReportadas;
    }

    public void setListaCitasReportadas(List<CitaReporte> listaCitasReportadas) {
        this.listaCitasReportadas = listaCitasReportadas;
    }

    @Override
    public String toString() {
        return "Veterinario: " + super.toString() +
         ". Especialidad: " + especialidad +
         ".\nCitas agendadas: " + citaAgendadas +
         ".\nLista de citas reportadas: " + listaCitasReportadas;
    }

}
