package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

public abstract class Persona {
    private String nombre;
    private int cedula;
    private int telefono;
    private String direccion;


    public Persona(String nombre, int cedula, String direccion, int telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre +
                ", cedula: " + cedula +
                ", telefono: " + telefono +
                ", direccion:" + direccion;
    }
}
