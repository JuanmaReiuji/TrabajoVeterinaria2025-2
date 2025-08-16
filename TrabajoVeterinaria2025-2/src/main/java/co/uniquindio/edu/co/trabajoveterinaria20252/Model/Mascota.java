package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

public class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    private int id;
    private Persona duenio;
    private String codigo;

    public Mascota(String nombre, String especie, int edad, int id, Persona duenio) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.id = id;
        this.duenio = duenio;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getDuenio() {
        return duenio;
    }

    public void setDuenio(Persona duenio) {
        this.duenio = duenio;
    }



    @Override
    public String toString() {
        return "Mascota: " +
                "nombre: " + nombre +
                ", especie: " + especie +
                ", edad: " + edad +
                ", id: " + id +
                ", dueño: " + duenio;
    }
}

