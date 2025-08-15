package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import java.util.List;
import java.util.ArrayList;

public class Propietario extends Persona {
    private List<Mascota> listaMascotas;

    public Propietario(String nombre, int cedula, String direccion, int telefono) {
        super(nombre, cedula, direccion, telefono);
        this.listaMascotas = new ArrayList<>();
    }

    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    @Override
    public String toString() {
        return "Propietario: " +  super.toString() +
                ". Lista de mascotas: " + listaMascotas;
    }

}
