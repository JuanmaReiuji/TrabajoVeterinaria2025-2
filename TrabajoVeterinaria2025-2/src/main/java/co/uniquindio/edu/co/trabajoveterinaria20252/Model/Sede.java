package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

public class Sede {
    private String nombre;
    private int nit;
    private Veterinaria veterinariaAsignada;

    public Sede(String nombre, int nit, Veterinaria veterinariaAsignada) {
        this.nombre = nombre;
        this.nit = nit;
        this.veterinariaAsignada = veterinariaAsignada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public Veterinaria getVeterinariaAsignada() {
        return veterinariaAsignada;
    }

    public void setVeterinariaAsignada(Veterinaria veterinariaAsignada) {
        this.veterinariaAsignada = veterinariaAsignada;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + '\'' +
                ", nit:" + nit +
                ", veterinaria asignada: " + veterinariaAsignada;
    }
}
