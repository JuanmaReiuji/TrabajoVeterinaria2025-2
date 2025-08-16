package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

public class Recepcionista extends Persona {


    public Recepcionista(String nombre, int cedula, String direccion, int telefono ,String contrasenia) {
        super(nombre, cedula, direccion, telefono, contrasenia);

    }

    @Override
    public String toString() {
        return "Recepcionsta: " + super.toString();
    }

}
