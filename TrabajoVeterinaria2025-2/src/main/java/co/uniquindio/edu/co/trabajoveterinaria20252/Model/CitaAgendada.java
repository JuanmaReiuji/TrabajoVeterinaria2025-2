package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import java.time.LocalDate;


public class CitaAgendada {
    private LocalDate fecha;
    private String motivo;
    private Mascota mascotaAtendida;
    private Persona veterinarioAsignado;

    public CitaAgendada(LocalDate fecha, String motivo, Mascota mascotaAtendida, Persona veterinarioAsignado) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.mascotaAtendida = mascotaAtendida;
        this.veterinarioAsignado = veterinarioAsignado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Mascota getMascotaAtendida() {
        return mascotaAtendida;
    }

    public void setMascotaAtendida(Mascota mascotaAtendida) {
        this.mascotaAtendida = mascotaAtendida;
    }

    public Persona getVeterinarioAsignado() {
        return veterinarioAsignado;
    }

    public void setVeterinarioAsignado(Persona veterinarioAsignado) {
        this.veterinarioAsignado = veterinarioAsignado;
    }

    @Override
    public String toString() {
        return "fecha: " + fecha +
                ", motivo: " + motivo +
                ", mascota atendida: " + mascotaAtendida;
    }
}